package web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = "/session/*")
public class LoginFilter extends HttpFilter {

	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// 處理中文問題
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
				
		HttpSession session = req.getSession();
		
		// 判斷是否已經有登入過(判斷 session 的屬性資料 username 是否存在)
		if(session.getAttribute("username") == null) {
			// 是否有帶入 username 的參數資料
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			if(username == null) {
				RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/session/login.jsp");
				rd.forward(req, resp);
				return;
			}
			if(username.equals("A01") && password.equals("1234")) {
				// 成功登入時會加入一個 session 的屬性資料 username
				session.setAttribute("username", username);
				chain.doFilter(req, resp);
				return;
			} else {
				RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/session/login.jsp");
				rd.forward(req, resp);
				return;
			}
		} else {
			chain.doFilter(req, resp);
		}
	}

	
	
}
