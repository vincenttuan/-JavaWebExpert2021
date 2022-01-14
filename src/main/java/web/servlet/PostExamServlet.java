package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PostExamServlet", urlPatterns = "/servlet/post/exam")
public class PostExamServlet extends HttpServlet {
	
	// 蒐集所有 formData
	private static List<Map<String, String[]>> formDatas = new ArrayList<>();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 處理中文問題
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");

		// 1.收到請求
		Map<String, String[]> formData = req.getParameterMap();
		
		// 2.處理請求
		formDatas.add(formData);
		
		// 3.回應請求
		PrintWriter out = resp.getWriter();
		// 顯示當下單筆資料
		out.print(String.format("%s\n", formData));
		out.print("<br />");
		out.print(String.format("%s\n", formData.get("username")));
		out.print("<br />");
		out.print(String.format("%s\n", formData.get("subject")));
		out.print("<br />");
		out.print(String.format("%s\n", formData.get("fee")));
		out.print("<br />");
		out.print(String.format("%s\n", formData.get("pay")));
		out.print("<br />");
		out.print(String.format("%s\n", formData.get("examdate")));
		out.print("<br />");
		out.print(String.format("%s\n", Arrays.toString(formData.get("period"))));
		out.print("<hr />");
		// 顯示歷史資料紀錄 (formDatas)
		out.print(String.format("歷史資料紀錄筆數：%d\n", formDatas.size()));
		out.print("<p />");
	}

}
