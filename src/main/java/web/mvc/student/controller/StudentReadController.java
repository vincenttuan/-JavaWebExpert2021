package web.mvc.student.controller;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.mvc.student.model.Student;
import web.mvc.student.service.StudentService;

@WebServlet(urlPatterns = "/mvc/student/queryall")
public class StudentReadController extends HttpServlet {
	
	private StudentService studentService = new StudentService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 處理中文問題
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		// 1.收到請求
		String sort = req.getParameter("sort");
		// 2.處理請求
		List<Student> students = studentService.queryAll();
		// 是否有排序參數 ?
		if(sort != null && sort.equals("1")) {
			students = students.stream()
					//.sorted(Comparator.comparing(Student::getScore)) // 正序(小->大)
					.sorted(Comparator.comparing(Student::getScore).reversed()) // 反序(大->小)
					.collect(Collectors.toList());
		}
		// 3.回應請求
		// 內部傳導(好處是可以傳送資料)
		// 將 students 列表資料轉發給 /WEB-INF/view/student_list.jsp
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/student/student_list.jsp"); // 分派器
		req.setAttribute("students", students); // 設定傳給 jsp 的資料
		rd.forward(req, resp); // 傳送到指定目標 (例如目標是 jsp -> student_list.jsp)
	}
	
}
