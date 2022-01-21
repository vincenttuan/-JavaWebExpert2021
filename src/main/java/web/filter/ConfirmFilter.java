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

import web.servlet.report.MyResponse;

//@WebFilter(urlPatterns = "/servlet/report/a") // 欲過濾/攔截的路徑
//@WebFilter(urlPatterns = {"/servlet/report/a", "/servlet/report/b"}) // 欲過濾/攔截的路徑
@WebFilter(urlPatterns = "/servlet/report/*") // 欲過濾/攔截的路徑
public class ConfirmFilter extends HttpFilter {

	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// 處理中文問題
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
				
		System.out.println("ConfirmFilter 1: Request");
		
		// 透過 pass 參數來決定是否放行
		String pass = req.getParameter("pass");
		if(pass != null && pass.equals("1")) {
			// 直接放行往下執行
			System.out.println("pass...");
			// 自行創建回應物件
			MyResponse myResp = new MyResponse(resp);
			chain.doFilter(req, myResp);
			// 加入浮水印
			String html = myResp.getHTMLString();
			// <body 改成 <body background='/web/image/watermark.png'  
			html = html.replace("<body", "<body background='/web/image/watermark.png'");
			resp.getWriter().print(html);
			
		} else {
			System.out.println("Stop");
			// 轉跳到 confirm.jsp 頁面
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/report/confirm.jsp");
			rd.forward(req, resp);
		}
		
		System.out.println("ConfirmFilter 2: Response");
	}
	
}
