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
<title>Course JSP page</title>
</head>
<body style="padding: 10px">
	<h1>Course List</h1>
	<table class="pure-table pure-table-bordered">
		<thead>
			<tr>
				<th>id</th>
				<th>name</th>
				<th>credit 
					<a href="?sort=0">▲</a>
					<a href="?sort=1">▼</a>
				</th>
				<th>delete</th>
				<th>update</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="course" items="${ courses }">
				<tr>
					<td>${ course.id }</td>
					<td>${ course.name }</td>
					<td>${ course.credit }</td>
					<td>
						<input type="button" 
							   class="pure-button pure-button-primary"
							   value="delete" 
							   onclick="window.location.href='/web/mvc/course/delete?id=${ course.id }';">
					</td>
					<td>
						<input type="button" 
							   class="pure-button pure-button-primary"
							   value="update" 
							   onclick="window.location.href='/web/mvc/course/get?id=${ course.id }';">
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p />
	<input type="button" value="返回" 
		   class="pure-button pure-button-primary"
		   onclick="window.location.href='/web/mvc/course/form';">
</body>
</html>