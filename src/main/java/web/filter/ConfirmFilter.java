package web.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebFilter(urlPatterns = "/servlet/report/a") // 欲過濾/攔截的路徑
//@WebFilter(urlPatterns = {"/servlet/report/a", "/servlet/report/b"}) // 欲過濾/攔截的路徑
@WebFilter(urlPatterns = "/servlet/report/*") // 欲過濾/攔截的路徑
public class ConfirmFilter extends HttpFilter {

	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("ConfirmFilter 1: Request");
		
		// 透過 pass 參數來決定是否放行
		String pass = req.getParameter("pass");
		if(pass != null && pass.equals("1")) {
			// 直接放行往下執行
			System.out.println("pass...");
			chain.doFilter(req, resp);
		} else {
			System.out.println("Stop");
			
		}
		
		System.out.println("ConfirmFilter 2: Response");
	}
	
}
