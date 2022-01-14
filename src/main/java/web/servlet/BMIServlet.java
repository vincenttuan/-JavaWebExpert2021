package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "BMIServlet", urlPatterns = "/servlet/bmi")
public class BMIServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 處理中文問題
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");

		// 1.收到請求
		String height = req.getParameter("h");
		String weight = req.getParameter("w");
		
		// 2.處理請求
		// String 轉 Double
		Double h = Double.parseDouble(height);
		Double w = Double.parseDouble(weight);
		Double bmi = w / Math.pow(h/100, 2);
		
		// 3.回應請求
		PrintWriter out = resp.getWriter(); // 回應物件(將資料回應給瀏覽器)
		out.print(String.format("身高：%.1f", h));
		out.print("<p />"); // <p /> 是 HTML 的斷行符號，<br /> 換行符號
		out.print(String.format("體重：%.1f", w));
		out.print("<p />");
		out.print(String.format("ＢＭＩ：%.2f", bmi));
	}

}
