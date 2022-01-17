package web.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.mvc.model.Student;
import web.mvc.service.StudentService;

@WebServlet(urlPatterns = "/mvc/student/get")
public class StudentGetController extends HttpServlet {
	private StudentService studentService = new StudentService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 處理中文問題
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");

		// 1.收到請求
		// 直接將參數 id String 轉變數 id Integer
		Integer id = Integer.parseInt(req.getParameter("id"));
		
		// 2.處理請求
		Optional<Student> optStudent = studentService.getById(id);
		
		// 3.回應請求
		PrintWriter out = resp.getWriter();
		out.print(optStudent.isPresent());
	}

}
