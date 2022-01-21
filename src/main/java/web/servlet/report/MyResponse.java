package web.servlet.report;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class MyResponse extends HttpServletResponseWrapper {
	private PrintWriter out;
	private CharArrayWriter charArrayWriter;
	
	public MyResponse(HttpServletResponse response) {
		super(response);
		charArrayWriter = new CharArrayWriter();
		out = new PrintWriter(charArrayWriter);
	}
	
	@Override
	public PrintWriter getWriter() throws IOException {
		return out;
	}
	
	public String getHTMLString() {
		return charArrayWriter.toString();
	}
	
}
