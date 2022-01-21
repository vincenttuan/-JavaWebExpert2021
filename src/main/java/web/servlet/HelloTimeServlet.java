package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloTimeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 處理中文問題
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		// 1.收到請求
		// 顯示目前的時間給使用者
		
		// 2.處理請求
		Date now = new Date(); // 取得現在時間物件
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
		String result = sdf.format(now); // 將要回應的資料放在 result 變數中
		
		// 3.回應請求
		PrintWriter out = resp.getWriter(); // 回應物件(將資料回應給瀏覽器)
		out.print("Hello ");
		out.print(result);
		
		
	}

	
	
}
