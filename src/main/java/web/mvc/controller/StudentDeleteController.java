package web.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.mvc.service.StudentService;

@WebServlet(urlPatterns = "/mvc/student/delete")
public class StudentDeleteController extends HttpServlet {
	private StudentService studentService = new StudentService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 處理中文問題
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		// 1.收到請求
		String delete_id = req.getParameter("id");
		
		// 2.處理請求
		Integer id = Integer.parseInt(delete_id);
		studentService.deleteById(id);
		
		// 3.回應請求
		resp.sendRedirect("/web/mvc/student/queryall");
	}

}
