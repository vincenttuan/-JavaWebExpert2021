package web.mvc.student.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/mvc/student/form")
public class StudentFormController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 處理中文問題
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		// 1.收到請求
		// 2.處理請求
		// 3.回應請求
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/student/student_form.jsp"); // 分派器
		rd.forward(req, resp); // 傳送到指定目標
	}

}
