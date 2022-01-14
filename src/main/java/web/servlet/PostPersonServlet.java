package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PostPersonServlet", urlPatterns = "/servlet/post/person")
public class PostPersonServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 處理中文問題
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");

		// 1.收到請求
		String username = req.getParameter("username");
		String ageStr = req.getParameter("age");
		String birth = req.getParameter("birth");
		String language = req.getParameter("lan");
		String[] vehicles = req.getParameterValues("vehicle");
		String education = req.getParameter("edu");
		String[] interests = req.getParameterValues("interest");
		String level = req.getParameter("level");
		String memo = req.getParameter("memo");
		
		// 2.處理請求
		List<Throwable> errors = new ArrayList<>(); // 錯誤訊息集合
		Integer age = 0;
		try {
			age = Integer.parseInt(ageStr); // 字串轉數字
		} catch (Exception e) {
			errors.add(e); // 字串轉數字失敗 
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date birthday = null;
		try {
			birthday = sdf.parse(birth); // 字串轉日期
		} catch (Exception e) {
			errors.add(e); // 字串轉日期失敗
		}
		
		// 3.回應請求
		PrintWriter out = resp.getWriter(); // 回應物件(將資料回應給瀏覽器)
		out.print("收到的資料如下：");
		out.print("<hr />");
		out.print(String.format("姓名：%s", username));
		out.print("<br />");
		out.print(String.format("年齡：%d", age));
		out.print("<br />");
		out.print(String.format("生日：%s", sdf.format(birthday)));
		out.print("<br />");
		out.print(String.format("語言：%s", language));
		out.print("<br />");
		out.print(String.format("交通：%s", Arrays.toString(vehicles)));
		out.print("<br />");
		out.print(String.format("學歷：%s", education));
		out.print("<br />");
		out.print(String.format("興趣：%s", Arrays.toString(interests)));
		out.print("<br />");
		out.print(String.format("等級：%s", level));
		out.print("<br />");
		out.print(String.format("備註：%s", memo));
		out.print("<br />");
		out.print(String.format("錯誤：%s", errors));
		out.print("<br />");
	}

}
