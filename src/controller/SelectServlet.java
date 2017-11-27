package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.studentAct;
import JavaBean.Course;
import JavaBean.PageBean;

public class SelectServlet extends HttpServlet {

	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		String param = request.getParameter("pageNum");
		String contextPath = request.getContextPath();
		String servletPath = request.getServletPath();
		int pageNum = 1;
		int pageSize = 10;
		if(param == null || param.trim().isEmpty()){
	
		}else{
			pageNum = Integer.parseInt(param);
		}
		studentAct sa = new studentAct();
		PageBean<Course> pb = null;
		try {
			pb = sa.findAll(pageNum, pageSize);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		pb.setUrl(contextPath + servletPath);
		System.out.println(pb.getBeanList().get(0).getCourseID());
		request.setAttribute("pb", pb);
		request.getRequestDispatcher("list.jsp").forward(request, response);
		//response.sendRedirect("list.jsp");
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)
					throws ServletException,IOException{
		doGet(request,response);
	}
}
