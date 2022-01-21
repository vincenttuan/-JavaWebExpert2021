<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Web首頁</title>
</head>
<body>
	Web Servlet
	<ul>
		<li>
			<a href="./servlet/hellotime">
				(GET) HelloTimeServlet
			</a>
		</li>
		
		<li>
			<a href="./servlet/sayhi?name=John">
				(GET) SayHiServlet (有帶參數 name=John)
			</a>
		</li>
		
		<li>
			<a href="./servlet/bmi?h=170&w=60">
				(GET) BMIServlet (有帶參數 h=170&w=60)
			</a>
		</li>
		
		<li>
			<a href="./servlet/redenvelope?money=1000&money=2000&money=5000">
				(GET) RedEnvelopeServlet (有帶參數 money=1000&money=2000&money=5000)
			</a>
		</li>
		
		<li>
			<a href="./form/person_form.jsp">
				(POST) /form/person_form.jsp
			</a>
		</li>
		
		<li>
			<a href="./form/exam_form.jsp">
				(POST) /form/exam_form.jsp
			</a>
		</li>
		
	</ul>
	
	MVC - In Memory
	<ul>
		<li>
			<a href="./mvc/student/form">
				學生表單 - Student From
			</a>
		</li>
		<li>
			<a href="./mvc/course/form">
				課程表單 - Course From
			</a>
		</li>
		<li>
			<a href="./mvc/selection/form">
				選課表單 - Course Selection Form
			</a>
		</li>
	</ul>
	
</body>
</html>