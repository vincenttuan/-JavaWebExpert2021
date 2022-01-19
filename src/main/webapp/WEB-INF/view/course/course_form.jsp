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
<title>Course From JSP page</title>
</head>
<body style="padding: 10px">
	<form class="pure-form" method="post" action="/web/mvc/course/${ action }">
		<fieldset>
			<legend>課程表單 - Course From</legend>
			<label>課程編號：</label><input type="number" id="id" name="id" value="${ course.id }" ${ (course.id != null)?'readonly':'' } placeholder="請輸入編號" />
			<br />
			<label>課程名稱：</label><input type="text" id="name" name="name" value="${ course.name }" placeholder="請輸入名稱" />
			<br />
			<label>課程學分：</label><input type="number" id="credit" name="credit" value="${ course.credit }" placeholder="請輸入學分" />
			<p />
			<input class="pure-button pure-button-primary" type="submit" value="${ action }" />
			<input class="pure-button pure-button-primary" type="button" value="查詢" onclick="window.location.href='/web/mvc/course/queryall';" />
		</fieldset>
	</form>
</body>
</html>