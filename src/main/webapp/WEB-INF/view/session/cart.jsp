<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
<meta charset="UTF-8">
<title>Cart</title>
</head>
<body style="padding: 20px">
	<form class="pure-form">
		<fieldset>
			<legend>${ sessionScope['username'] } Cart List</legend>
			<table class="pure-table pure-table-bordered">
				<thead>
					<tr>
						<th>#</th>
						<th>品名</th>
						<th>數量</th>
						<th>價格</th>
						<th>小計</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="formData" varStatus="status" items="${ sessionScope['list'] }">
						<tr>
							<td>${ (status.index + 1) }</td>
							<td>${ formData['name'] }</td>
							<td>${ formData['amount'] }</td>
							<td>${ formData['price'] }</td>
							<td>${ formData['amount'] * formData['price'] }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<p />
			<button type="button"
				onclick="window.location.href='/web/session/order'"
				class="pure-button pure-button-primary">繼續購物</button>
			<button type="button"
				onclick="window.location.href='/web/session_logout'"
				class="pure-button pure-button-primary">登出</button>
		</fieldset>
	</form>
</body>
</html>