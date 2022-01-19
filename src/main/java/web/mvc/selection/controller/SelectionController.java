package web.mvc.selection.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.mvc.course.model.Course;
import web.mvc.course.service.CourseService;
import web.mvc.student.model.Student;
import web.mvc.student.service.StudentService;

/******************************
 * Get /mvc/selection/form 
 ******************************/
@WebServlet(urlPatterns = "/mvc/selection/*")
public class SelectionController extends HttpServlet {
	
	private StudentService studentService = new StudentService();
	private CourseService courseService = new CourseService();

	
	private void form(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1.收到請求
		// 2.處理請求
		// 3.回應請求
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/selection/selection_form.jsp"); // 分派器
		rd.forward(req, resp); // 傳送到指定目標
	}
	
	private void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1.收到請求
		Integer student_id = Integer.parseInt(req.getParameter("student.id"));
		// 2.處理請求
		Optional<Student> optStudent = studentService.getById(student_id);
		// 3.回應請求
		if(optStudent.isPresent()) {
			Student student = optStudent.get();
			List<Course> courses = courseService.queryAll();
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/selection/selection_result.jsp"); // 分派器
			req.setAttribute("student", student);
			req.setAttribute("courses", courses);
			rd.forward(req, resp); // 傳送到指定目標
		} else {
			resp.sendError(500, "無此學號：" + student_id);
		}
	}

	

	private void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 處理中文問題
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");

		String httpMethod = req.getMethod();
		String pathInfo = req.getPathInfo();
		System.out.println(httpMethod + " /mvc/selection" + pathInfo);
		if (httpMethod.equalsIgnoreCase("GET")) {
			switch (pathInfo) {
				case "/form":
					form(req, resp);
					break;
				default:
					resp.sendError(500, "網路連結路徑錯誤");
			}
		} else if (httpMethod.equalsIgnoreCase("POST")) {
			switch (pathInfo) {
				case "/search":
					search(req, resp);
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
