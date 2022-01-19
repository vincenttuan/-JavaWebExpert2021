package web.mvc.course.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/******************************
 * Post /mvc/course/add
 * Get  /mvc/course/delete
 * Get  /mvc/course/form
 * Get  /mvc/course/get
 * Get  /mvc/course/queryall
 * Post /mvc/course/update
******************************/
@WebServlet(urlPatterns = "/mvc/course/*")
public class CourseController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandle(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandle(req, resp);
	}
	
	private void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.print(req.getMethod() + " /mvc/course" + req.getPathInfo());
		out.print("\n");
		out.print("req.getMethod() = " + req.getMethod());
		out.print("\n");
		out.print("req.getPathInfo() = " + req.getPathInfo());
	}
	
}
