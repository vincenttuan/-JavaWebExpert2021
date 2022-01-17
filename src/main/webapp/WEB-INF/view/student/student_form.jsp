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
<title>Student From JSP page</title>
</head>
<body style="padding: 10px">
	<form class="pure-form" method="post" action="/web/mvc/student/add">
		<fieldset>
			<legend>學生表單 - Student From</legend>
			<label>學生學號：</label><input type="number" id="id" name="id" placeholder="請輸入學號" />
			<br />
			<label>學生姓名：</label><input type="text" id="name" name="name" placeholder="請輸入姓名" />
			<br />
			<label>學生分數：</label><input type="number" id="score" name="score" placeholder="請輸入分數" />
			<br />
			<label>學生性別：</label>
			<input type="radio" id="sex" name="sex" value="1" checked /> 男
			<input type="radio" id="sex" name="sex" value="2" /> 女
			<br />
			<label>註冊日期：</label><input type="date" id="createtime" name="createtime" value="2022-01-01"/>
			<p />
			<input class="pure-button pure-button-primary" type="submit" value="新增" />
			<input class="pure-button pure-button-primary" type="button" value="查詢" onclick="window.location.href='/web/mvc/student/queryall';" />
		</fieldset>
	</form>
</body>
</html>