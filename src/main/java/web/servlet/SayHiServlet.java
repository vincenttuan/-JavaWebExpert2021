package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SayHiServlet", urlPatterns = "/servlet/sayhi")
public class SayHiServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 處理中文問題
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		// 1.收到請求
		// Ex: http://localhost:8080/web/servlet/sayhi?name=John
		// user_name 變數的內容就會得到 John
		String userName = req.getParameter("name"); // 收到網址列上的 name 參數的內容
		
		// 2.處理請求
		String result = "Hi " + userName;
		
		// 3.回應請求
		PrintWriter out = resp.getWriter(); // 回應物件(將資料回應給瀏覽器)
		out.print(result);
	}

}
