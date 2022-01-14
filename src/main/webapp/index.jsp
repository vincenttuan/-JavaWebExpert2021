<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Web首頁</title>
</head>
<body>
	Web首頁
	<ul>
		<li>
			<a href="./servlet/hellotime">
				HelloTimeServlet
			</a>
		</li>
		
		<li>
			<a href="./servlet/sayhi?name=John">
				SayHiServlet (有帶參數 name=John)
			</a>
		</li>
		
		<li>
			<a href="./servlet/bmi?h=170&w=60">
				BMIServlet (有帶參數 h=170&w=60)
			</a>
		</li>
		
		<li>
			<a href="./servlet/redenvelope?money=1000&money=2000&money=5000">
				RedEnvelopeServlet (有帶參數 money=1000&money=2000&money=5000)
			</a>
		</li>
		
	</ul>
</body>
</html>