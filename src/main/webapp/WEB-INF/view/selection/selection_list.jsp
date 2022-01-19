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
<title>Selection JSP page</title>
</head>
<body style="padding: 10px">
	<h1>Selection List</h1>
	<table class="pure-table pure-table-bordered">
		<thead>
			<tr>
				<th>Student id</th>
				<th>Courses</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="selection" items="${ selections }">
				<tr>
					<td>${ selection.studentId }</td>
					<td>${ selection.courses }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p />
	<input type="button" value="返回" 
		   class="pure-button pure-button-primary"
		   onclick="window.location.href='/web/mvc/selection/form';">
</body>
</html>