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
<title>Selection From JSP page</title>
</head>
<body style="padding: 10px">
	<form class="pure-form" method="post" action="/web/mvc/selection/search">
		<fieldset>
			<legend>選課表單 - Selection From</legend>
			<label>學生學號：</label><input type="number" id="student.id" name="student.id" placeholder="請輸入學生學號" />
			<input class="pure-button pure-button-primary" type="submit" value="查詢" />
			<input class="pure-button pure-button-primary" type="button" value="全部查詢" onclick="window.location.href='/web/mvc/selection/queryall';" />
		</fieldset>
	</form>
</body>
</html>