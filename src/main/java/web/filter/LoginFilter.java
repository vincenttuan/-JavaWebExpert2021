package web.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
	
	private static List<String> userNames;
	private static List<String> userPasswords;
	static {
		userNames     = Arrays.asList("A01",  "B02",  "C03");
		userPasswords = Arrays.asList("1234", "5678", "1111");
	}
	
	private boolean loginCheck(String username, String password) {
		for(int i=0;i<userNames.size();i++) {
			if(userNames.get(i).equals(username) && userPasswords.get(i).equals(password)) {
				return true;
			}
		}
		return false;
	}
	
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
			// 判斷是否登入成功 ?
			if(loginCheck(username, password)) {
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
