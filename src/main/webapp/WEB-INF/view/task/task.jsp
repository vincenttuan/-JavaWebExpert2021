<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
	<meta charset="UTF-8">
	<title>Task CRUD</title>
	<script type="text/javascript">
		function checkSubtotal() {
			var check = calcSubtotal() == 24;
			if(!check) {
				alert('時數必須滿足 24H');
			}
			return check;
		}
		function calcSubtotal() {
			var work = document.getElementById('work').value * 1;
			var eat = document.getElementById('eat').value * 1;
			var commute = document.getElementById('commute').value * 1;
			var entertainment = document.getElementById('entertainment').value * 1;
			var sleep = document.getElementById('sleep').value * 1;
			var sum = work + eat + commute + entertainment + sleep;
			return sum;
		}
		function updateSubtotal(tag) {
			if(tag.value < 0) {
				tag.value = 0;
			}
			document.getElementById('subtotal').innerText = calcSubtotal();
		}
	</script>
</head>
<body style="padding: 20px">

	<form class="pure-form" method="post" onsubmit="return checkSubtotal()" action="/web/mvc/task/add">
		<fieldset>
			<table>
				<tr>
					<td>id：</td>
					<td><input type="text" id="id" name="id" value="0" readonly /></td>
				</tr>
				<tr>
					<td>name：</td>
					<td><input type="text" id="name" name="name" value="" /></td>
				</tr>
				<tr>
					<td>work：</td>
					<td><input type="number" id="work" name="work" value="8" onchange="updateSubtotal(this);" /></td>
				</tr>
				<tr>
					<td>eat：</td>
					<td><input type="number" id="eat" name="eat" value="3" onchange="updateSubtotal(this);" /></td>
				</tr>
				<tr>
					<td>commute：</td>
					<td><input type="number" id="commute" name="commute" value="3" onchange="updateSubtotal(this);" /></td>
				</tr>
				<tr>
					<td>entertainment：</td>
					<td><input type="number" id="entertainment" name="entertainment" value="3" onchange="updateSubtotal(this);" /></td>
				</tr>
				<tr>
					<td>sleep：</td>
					<td><input type="number" id="sleep" name="sleep" value="7" onchange="updateSubtotal(this);" /></td>
				</tr>
				<tr>
					<td>24H：</td>
					<td><span id="subtotal">24</span>H</td>
				</tr>
				<tr>
					<td colspan="2">
						<input class="pure-button pure-button-primary" type="submit" value="add" />
						<input class="pure-button pure-button-primary" type="reset" value="reset" />
						<input class="pure-button pure-button-primary" type="button" 
							   onclick="window.location.href='/web/mvc/task/query';"	
							   value="query" />
					</td>
				</tr>
			</table>
		</fieldset>
	</form>
	
	<p />

	<table class="pure-table pure-table-bordered">
		<thead>
			<tr>
				<th>id</th><th>name</th><th>work</th><th>eat</th>
				<th>commute</th><th>entertainment</th><th>sleep</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="task" items="${ tasks }">
				<tr>
					<td>${ task.id }</td>
					<td>${ task.name }</td>
					<td>${ task.work }</td>
					<td>${ task.eat }</td>
					<td>${ task.commute }</td>
					<td>${ task.entertainment }</td>
					<td>${ task.sleep }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>