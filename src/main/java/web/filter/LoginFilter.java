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
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		HttpSession session = req.getSession();
		
		// 判斷是否已經有登入過(判斷 session 的屬性資料 username 是否存在)
		if(session.getAttribute("username") == null) {
			// 是否有帶入 username 的參數資料
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			if(username == null) {
				RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/session/login.jsp");
				rd.forward(req, res);
				return;
			}
			if(username.equals("admin") && password.equals("1234")) {
				// 成功登入時會加入一個 session 的屬性資料 username
				session.setAttribute("username", username);
				chain.doFilter(req, res);
				return;
			} else {
				RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/session/login.jsp");
				rd.forward(req, res);
				return;
			}
		} else {
			chain.doFilter(req, res);
		}
	}

	
	
}
