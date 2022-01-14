package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RedEnvelopeServlet", urlPatterns = "/servlet/redenvelope")
public class RedEnvelopeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 處理中文問題
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");

		// 1.收到請求
		String[] values = req.getParameterValues("money");
		
		// 2.處理請求
		// mapToInt 轉換
		
		int sum = Arrays.stream(values) // 先進行陣列資料 stream 串流化
				.mapToInt(value -> Integer.parseInt(value)) // map轉換, 將 value 字串透過 Integer.parseInt() 轉成 int
				.sum(); // 計算總和
		
		// 3.回應請求
		PrintWriter out = resp.getWriter(); // 回應物件(將資料回應給瀏覽器)
		out.print(String.format("每一個紅包有多少錢：$%s", Arrays.toString(values)));
		out.print("<p />");
		out.print(String.format("總金額：$%,d", sum));
	}

}
