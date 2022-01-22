package web.mvc.task.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.mvc.task.service.TaskService;
import web.mvc.task.service.TaskServiceImpl;

@WebServlet(urlPatterns = "/mvc/task/*")
public class TaskController extends HttpServlet {
	
	private TaskService taskService = new TaskServiceImpl();
	
	private void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/task/task.jsp");
		req.setAttribute("tasks", taskService.queryAll());
		rd.forward(req, resp);
	}
	
	private void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch (req.getMethod()) {
			case "GET":
				switch(req.getPathInfo()) {
					case "/query":
						query(req, resp);
						break;
				}
				break;
	
			case "POST":
				
				break;
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
