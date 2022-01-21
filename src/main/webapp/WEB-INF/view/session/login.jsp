<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
<meta charset="UTF-8">
<title>Login Form</title>
</head>
<body style="padding: 20px">
	<form class="pure-form" method="post">
    <fieldset>
        <legend>Login Form</legend>
        帳號：<input type="text" id="username" name="username" />
        <p />
        密碼：<input type="password" id="password" name="password" />
        <p />
        <button type="submit" class="pure-button pure-button-primary">登入</button>
        <button type="reset" class="pure-button pure-button-primary">清除</button>	
    </fieldset>
	</form>
</body>
</html>