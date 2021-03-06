package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.jms.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import JavaBean.Student;
import service.studentAct;

public class loginServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public loginServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

/*		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		String type = request.getParameter("idType");
		out.print("String:"+type);
		out.flush();
		out.close();*/
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String type = request.getParameter("idType");
		String validate = request.getParameter("validateCode");
		String codeSession = (String)request.getSession().getAttribute("validation_code");
		
		System.out.println(codeSession);
		
		studentAct sa = new studentAct();
		if(type.equals("student")){
			try {
				if(sa.studentLogin(id,password) && validate.equals(codeSession)){
					//登录成功，实现界面跳转
					//使用session记录登录状态，当窗口关闭后需要重新登录
					String turnpath = "/loginSuccess.jsp?name=" + sa.getStuName(id)  ;
					
					Student user = new Student();
					user.setStudentID(id);
					user.init();
					//request.setAttribute("User", user);
					HttpSession session = request.getSession();
					session.setMaxInactiveInterval(60*60);
					session.setAttribute("User", user);
					
					RequestDispatcher dispatcher = request.getRequestDispatcher(turnpath);
					dispatcher.forward(request, response);
					return;
				}
				else if(!validate.equals(codeSession)){
					response.setContentType("text/html;charset=utf-8");
					PrintWriter out = response.getWriter();
					out.write("验证码错误，请重新输入！");
				}
				else if(sa.isExists(id)){
					//用户存在但是密码不正确
					response.setContentType("text/html;charset=utf-8");
					PrintWriter out = response.getWriter();
					out.write("密码错误，登录失败！");
				}else{
					//用户不存在
					response.setContentType("text/html;charset=utf-8"); 
					PrintWriter out = response.getWriter();
					out.write("用户不存在！");
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(type.equals("teacher")){
			//老师的登录功能
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
