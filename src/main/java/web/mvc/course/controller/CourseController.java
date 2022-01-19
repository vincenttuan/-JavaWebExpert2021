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
	
	private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	private void form(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}
	
	private void get(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	private void queryall(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}
	
	private void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String httpMethod = req.getMethod();
		String pathInfo = req.getPathInfo();
		System.out.println(httpMethod + " /mvc/course" + pathInfo);
		if(httpMethod.equalsIgnoreCase("GET")) {
			switch (pathInfo) {
				case "/delete":
					delete(req, resp);
					break;
				case "/form":
					form(req, resp);
					break;
				case "/get":
					get(req, resp);
					break;
				case "/queryall":
					queryall(req, resp);
					break;	
				default:
					resp.sendError(500, "網路連結路徑錯誤");
			}
		} else if(httpMethod.equalsIgnoreCase("POST")) {
			switch (pathInfo) {
				case "/add":
					add(req, resp);
					break;
				case "/update":
					update(req, resp);
					break;	
				default:
					resp.sendError(500, "網路連結路徑錯誤");
			}
		} else {
			resp.sendError(500, "HTTP 方法錯誤 (本站只支援 GET 或 POST)");
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandle(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandle(req, resp);
	}
	
	
}
