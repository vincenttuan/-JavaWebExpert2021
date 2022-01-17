<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Person form</title>
</head>
<body>
	
	<form method="post" action="../servlet/post/person">
		<fieldset>
			<legend>Personal details</legend>
			<label>姓名：</label><input type="text" id="username" name="username" placeholder="請輸入姓名" />
			<br />
			<label>年齡：</label><input type="number" id="age" name="age" placeholder="請輸入年齡" />
			<br />
			<label>生日：</label><input type="date" id="birth" name="birth" value="2022-01-01"/>
			<br />
			<label>語言：</label>
			<input type="radio" id="lan" name="lan" value="Java" /> Java
			<input type="radio" id="lan" name="lan" value="VB" /> VB
			<input type="radio" id="lan" name="lan" value="Python" /> Python
			<br />
			<label>交通：</label>
			<input type="checkbox" id="vehicle" name="vehicle" value="Bike" /> Bike
			<input type="checkbox" id="vehicle" name="vehicle" value="Car" /> Car
			<input type="checkbox" id="vehicle" name="vehicle" value="Boat" /> Boat
			<br />
			<label>學歷：</label>
			<select id="edu" name="edu">
				<option value="小學">小學</option>
				<option value="國中">國中</option>
				<option value="高中職">高中職</option>
				<option value="專科/大學" selected>專科/大學</option>
				<option value="研究所">研究所</option>
				<option value="博士">博士</option>
				<option value="無">無</option>
			</select>
			<br />
			<label style="position: relative; top: -62px;">興趣：</label>
			<select id="interest" name="interest" multiple>
				<option value="看電影">看電影</option>
				<option value="打籃球">打籃球</option>
				<option value="打電玩">打電玩</option>
				<option value="寫程式" selected>寫程式</option>
				<option value="做模型">做模型</option>
				<option value="玩遙控">玩遙控</option>
				<option value="做餐飲">做餐飲</option>
			</select>
			<br />
			<label>等級：</label>
			<progress id="level" value="32" max="100"> 32% </progress>
			<input type="hidden" name="level" value="32" />
			<br />
			<label style="position: relative; top: -70px;">備註：</label>
			<textarea rows="5" cols="20" id="memo" name="memo" placeholder="請輸入備註資料"></textarea>
			<p />
			<input type="submit" value="傳送" />
		</fieldset>
	</form>

</body>
</html>