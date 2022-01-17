<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student JSP page</title>
</head>
<body>
	<h1>Student List</h1>
	<table border="1" cellspacing="0" cellpadding="3">
		<thead>
			<tr>
				<th>id</th><th>name</th><th>score</th><th>sex</th><th>createtime</th>
				<th>delete</th><th>update</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="student" items="${ students }">
				<tr>
					<td>${ student.id }</td>
					<td>${ student.name }</td>
					<td>${ student.score }</td>
					<td>${ student.sex }</td>
					<td>${ student.createtime }</td>
					<td>
						<input type="button" 
							   value="delete" 
							   onclick="window.location.href='/web/mvc/student/delete?id=${ student.id }';">
					</td>
					<td>
						<input type="button" 
							   value="update" 
							   onclick="window.location.href='/web/mvc/student/get?id=${ student.id }';">
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p />
	<input type="button" value="返回" 
		   onclick="window.location.href='/web/mvc/student/form';">
</body>
</html>