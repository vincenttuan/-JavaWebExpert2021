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
	
	<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {

        var data = google.visualization.arrayToDataTable([
          ['Task', 'Hours per Day'],
          ['Work',     ${ task.work }],
          ['Eat',      ${ task.eat }],
          ['Commute',  ${ task.commute }],
          ['Entertainment', ${ task.entertainment }],
          ['Sleep',    ${ task.sleep }]
        ]);

        var options = {
          title: '${ task.name } Daily Activities'
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));
		
        ${ drawchart }
      }
    </script>
	
</head>
<body style="padding: 20px">
	<table>
		<tr>
			<!-- Task Form -->
			<td valign="top">
				<form class="pure-form" method="post" onsubmit="return checkSubtotal()" action="/web/mvc/task/${ action }">
					<fieldset>
						<legend>Task Form</legend>
						<table>
							<tr>
								<td>id：</td>
								<td><input type="text" id="id" name="id" value="${ task.id }" readonly /></td>
							</tr>
							<tr>
								<td>name：</td>
								<td><input type="text" id="name" name="name" value="${ task.name }" /></td>
							</tr>
							<tr>
								<td>work：</td>
								<td><input type="number" id="work" name="work" value="${ task.work }" onchange="updateSubtotal(this);" /></td>
							</tr>
							<tr>
								<td>eat：</td>
								<td><input type="number" id="eat" name="eat" value="${ task.eat }" onchange="updateSubtotal(this);" /></td>
							</tr>
							<tr>
								<td>commute：</td>
								<td><input type="number" id="commute" name="commute" value="${ task.commute }" onchange="updateSubtotal(this);" /></td>
							</tr>
							<tr>
								<td>entertainment：</td>
								<td><input type="number" id="entertainment" name="entertainment" value="${ task.entertainment }" onchange="updateSubtotal(this);" /></td>
							</tr>
							<tr>
								<td>sleep：</td>
								<td><input type="number" id="sleep" name="sleep" value="${ task.sleep }" onchange="updateSubtotal(this);" /></td>
							</tr>
							<tr>
								<td>24H：</td>
								<td><span id="subtotal">24</span>H</td>
							</tr>
							<tr>
								<td colspan="2">
									<input class="pure-button pure-button-primary" type="submit" value="${ action }" />
									<input class="pure-button pure-button-primary" type="reset" value="reset" />
									<input class="pure-button pure-button-primary" type="button" 
										   onclick="window.location.href='/web/mvc/task/query';"	
										   value="query" />
								</td>
							</tr>
						</table>
					</fieldset>
				</form>
			</td>
			<!-- Task Chart -->
			<td valign="top">
				<div id="piechart" style="width: 900px; height: 350px;"></div>
			</td>
		</tr>
	</table>
	
	
	<p />

	<table class="pure-table pure-table-bordered">
		<thead>
			<tr>
				<th>id</th><th>name</th><th>work</th><th>eat</th>
				<th>commute</th><th>entertainment</th><th>sleep</th>
				<th>刪除</th><th>修改</th><th>繪圖</th>
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
					<td>
						<input class="pure-button pure-button-primary" type="button" 
							   onclick="window.location.href='/web/mvc/task/delete?id=${ task.id }';"	
							   value="delete" />
					</td>
					<td>
						<input class="pure-button pure-button-primary" type="button" 
							   onclick="window.location.href='/web/mvc/task/get?id=${ task.id }';"	
							   value="get" />
					</td>
					<td>
						<input class="pure-button pure-button-primary" type="button" 
							   onclick="window.location.href='/web/mvc/task/drawchart?id=${ task.id }';"	
							   value="drawchart" />
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>
