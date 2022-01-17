<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student From JSP page</title>
</head>
<body>
	<form method="post" action="#">
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
			<input type="submit" value="新增" />
			<input type="button" value="查詢" onclick="window.location.href='/web/mvc/student/queryall';" />
		</fieldset>
	</form>
</body>
</html>