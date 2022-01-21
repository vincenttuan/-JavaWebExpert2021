package web.servlet.session;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/session/order")
public class OrderServlet extends HttpServlet {
	
	private void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		//session.setMaxInactiveInterval(10); // 秒為單位, session 最大閒置存活時間
		//resp.getWriter().println("session id: " + session.getId());
		//resp.getWriter().println("form data: " + req.getParameterMap().size());
		
		String name = req.getParameter("name");
		String amount = req.getParameter("amount");
		String price = req.getParameter("price");
		if(name != null) {
			List<Map<String, Object>> list = null;
			if(session.getAttribute("list") == null) {
				list = new ArrayList<>();
			} else {
				list = (List)session.getAttribute("list");
			}
			Map<String, Object> formData = new LinkedHashMap<>();
			formData.put("name", name);
			formData.put("amount", Integer.parseInt(amount));
			formData.put("price", Integer.parseInt(price));
			list.add(formData);
			session.setAttribute("list", list);
			System.out.println(session.getAttribute("list"));
			// 到購物車呈現資料
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/session/cart.jsp");
			rd.forward(req, resp);
			return;
		}
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/session/order.jsp");
		rd.forward(req, resp);
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
