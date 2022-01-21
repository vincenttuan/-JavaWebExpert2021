<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
<meta charset="UTF-8">
<title>Order From</title>
</head>
<body style="padding: 20px">
	<form class="pure-form" method="post">
    <fieldset>
        <legend>${ sessionScope['username'] } Order From</legend>
        品名：<select id="name" name="name">
        		<option value="拿鐵">拿鐵</option>
        		<option value="美式">美式</option>
        		<option value="綠茶">綠茶</option>
        	</select>
        <p />	
        數量：<input type="number" id="amount" name="amount" value="1" />
        <p />
        價格：<input type="number" id="price" name="price" value="50" />
        <p />
        <button type="submit" class="pure-button pure-button-primary">傳送</button>
        <button type="button" 
        		onclick="window.location.href='/web/session/cart'"
        		class="pure-button pure-button-primary">購物車</button>
        <button type="button" 
        		onclick="window.location.href='/web/session_logout'"
        		class="pure-button pure-button-primary">登出</button>		
    </fieldset>
	</form>
</body>
</html>