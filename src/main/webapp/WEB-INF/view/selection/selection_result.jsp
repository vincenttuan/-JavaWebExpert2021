<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
<meta charset="UTF-8">
<title>Selection Result JSP page</title>
</head>
<body style="padding: 10px">
	<form class="pure-form" method="post" action="/web/mvc/selection/add_or_update">
		<fieldset>
			<legend>選課表單 - Selection Result</legend>
			<label>學生學號：</label>${ student.id }
			<input type="hidden" id="student.id" name="student.id" value="${ student.id }" />
			<br />
			<label>學生姓名：</label>${ student.name }
			<br />
			<label>選課資訊：</label>
			<c:forEach var="course" items="${ courses }">
				<input type="checkbox" id="course.id" name="course.id" value="${ course.id }" /> ${ course.name }（${ course.credit }）、 
			</c:forEach>
			<p />
			<input class="pure-button pure-button-primary" type="submit" value="變更選課" />
		</fieldset>
	</form>
</body>
</html>