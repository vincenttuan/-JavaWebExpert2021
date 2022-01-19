package web.mvc.course.controller;

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

/******************************
 * Post /mvc/course/add Get /mvc/course/delete Get /mvc/course/form Get
 * /mvc/course/get Get /mvc/course/queryall Post /mvc/course/update
 ******************************/
@WebServlet(urlPatterns = "/mvc/course/*")
public class CourseController extends HttpServlet {
	private CourseService courseService = new CourseService();

	private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	private void form(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1.收到請求
		// 2.處理請求
		// 3.回應請求
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/course/course_form.jsp"); // 分派器
		req.setAttribute("action", "add");
		rd.forward(req, resp); // 傳送到指定目標
	}

	private void get(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1.收到請求
		// 直接將參數 id String 轉變數 id Integer
		Integer id = Integer.parseInt(req.getParameter("id"));

		// 2.處理請求
		Optional<Course> optCourse = courseService.getById(id);

		// 3.回應請求
		if (optCourse.isPresent()) {
			Course course = optCourse.get();
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/course/course_form.jsp");
			req.setAttribute("course", course);
			req.setAttribute("action", "update");
			rd.forward(req, resp);
		} else {
			PrintWriter out = resp.getWriter();
			out.print("Not found!");
		}
	}

	private void queryall(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1.收到請求
		String sort = req.getParameter("sort");
		// 2.處理請求
		List<Course> courses = courseService.queryAll();
		// 是否有排序參數 ?
		if (sort != null) {
			switch (sort) {
			case "0": // 正序(小->大)
				courses = courses.stream().sorted(Comparator.comparing(Course::getCredit)) // 正序(小->大)
						.collect(Collectors.toList());
				break;
			case "1": // 反序(大->小)
				courses = courses.stream().sorted(Comparator.comparing(Course::getCredit).reversed()) // 反序(大->小)
						.collect(Collectors.toList());
				break;
			}
		}
		// 3.回應請求
		// 內部傳導(好處是可以傳送資料)
		// 將 courses 列表資料轉發給 /WEB-INF/view/course_list.jsp
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/course/course_list.jsp"); // 分派器
		req.setAttribute("courses", courses); // 設定傳給 jsp 的資料
		rd.forward(req, resp); // 傳送到指定目標 (例如目標是 jsp -> course_list.jsp)
	}

	private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1.收到請求
		String form_id = req.getParameter("id");
		String form_name = req.getParameter("name");
		String form_credit = req.getParameter("credit");

		// 2.處理請求
		Integer id = Integer.parseInt(form_id);
		String name = form_name;
		Integer credit = Integer.parseInt(form_credit);

		Course course = new Course(id, name, credit);
		courseService.add(course);

		// 3.回應請求
		// 外部傳導(無法透過 setAttribute() 傳送傳送資料)
		// sendRedirect 是將要傳導的網址丟給瀏覽器，瀏覽器接到訊息後，會自動跳轉到該頁面
		resp.sendRedirect("/web/mvc/course/queryall");
	}

	private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	private void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 處理中文問題
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");

		String httpMethod = req.getMethod();
		String pathInfo = req.getPathInfo();
		System.out.println(httpMethod + " /mvc/course" + pathInfo);
		if (httpMethod.equalsIgnoreCase("GET")) {
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
		} else if (httpMethod.equalsIgnoreCase("POST")) {
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
