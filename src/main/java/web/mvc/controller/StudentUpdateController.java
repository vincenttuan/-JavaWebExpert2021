package web.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.mvc.model.Student;
import web.mvc.service.StudentService;

@WebServlet(urlPatterns = "/mvc/student/update")
public class StudentUpdateController extends HttpServlet {
	private StudentService studentService = new StudentService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 處理中文問題
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");

		// 1.收到請求
		String form_id = req.getParameter("id");
		String form_name = req.getParameter("name");
		String form_score = req.getParameter("score");
		String form_sex = req.getParameter("sex");
		String form_createtime = req.getParameter("createtime");

		// 2.處理請求
		Integer id = Integer.parseInt(form_id);
		String name = form_name;
		Integer score = Integer.parseInt(form_score);
		Integer sex = Integer.parseInt(form_sex);
		// 利用 SimpleDateFormat 將字串轉 Date 物件
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date createtime = null;
		try {
			createtime = sdf.parse(form_createtime);
		} catch (Exception e) {
			// 若轉換失敗則以今天日期為準
			createtime = new Date();
		}
		Student student = new Student(id, name, score, sex, createtime);
		int rowcount = studentService.update(student);
		
		// 3.回應請求
		if(rowcount > 0) {
			resp.sendRedirect("/web/mvc/student/queryall");
		} else {
			PrintWriter out = resp.getWriter();
			out.print("Update fail! student = " + student);
		}
	}

}
