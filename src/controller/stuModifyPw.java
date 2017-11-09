package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.studentAct;
import JavaBean.Student;

public class stuModifyPw extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public stuModifyPw() {
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

		response.setCharacterEncoding("utf-8");
		PrintWriter pw = response.getWriter();
		studentAct sa = new studentAct();
		HttpSession session = request.getSession();
		
		String new_password = request.getParameter("password");
		System.out.println(new_password);
		if(session.getAttribute("User") != null){
			Student stu = (Student)session.getAttribute("User");
			System.out.println(stu.getStudentID());
			try{
				if(sa.modifyStuPW(stu.getStudentID(), new_password)){
					pw.append("true");
					pw.flush();
					return;
				}
			}catch(SQLException | ClassNotFoundException e){
				e.printStackTrace();
			}
			
		}
		pw.append("false");
		pw.flush();
		
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

		doGet(request,response);
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
