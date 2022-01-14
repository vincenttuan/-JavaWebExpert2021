package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
		// clone() 單獨複製一份資料
		formDatas.add(formData.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));

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
		out.print("<table border=1 cellspacing=0 cellpadding=4>");
		out.print("<tr><th>username</th><th>subject</th><th>fee</th><th>pay</th><th>examdate</th><th>period</th></tr>");
		for (Map<String, String[]> fd : formDatas) {
			String row = String.format("<tr><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td></tr>",
					Arrays.toString(fd.get("username")), 
					Arrays.toString(fd.get("subject")),
					Arrays.toString(fd.get("fee")), 
					Arrays.toString(fd.get("pay")), 
					Arrays.toString(fd.get("examdate")),
					Arrays.toString(fd.get("period")));
			out.print(row);

		}
		out.print("</table>");
	}

}
