<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Exam form</title>
</head>
<body>
	
	<form method="post" action="../servlet/post/exam">
		<fieldset>
			<legend>Exam details</legend>
			<label>受測姓名：</label><input type="text" id="username" name="username" placeholder="請輸入姓名" />
			<br />
			<label>受測科目：</label>
			<select id="subject" name="subject">
				<option value="1z0-808" selected>1z0-808 Java 8 I</option>
				<option value="1z0-809">1z0-809 Java 8 II</option>
				<option value="1z0-819">1z0-819 Java 11</option>
				<option value="1z0-900">1z0-900 Java Web</option>
			</select>
			<br />
			<label>考試費用：</label><input type="number" id="fee" name="fee" value="5000"/>
			<br />
			<label>是否繳費：</label>
			<input type="radio" id="pay" name="pay" value="true" /> 是
			<input type="radio" id="pay" name="pay" value="false" /> 否
			<br />
			<label>受測日期：</label><input type="date" id="examdate" name="examdate" value="2022-01-01"/>
			<br />
			<label>可受測時段：</label>
			<input type="checkbox" id="period" name="period" value="上午" /> 上午
			<input type="checkbox" id="period" name="period" value="下午" /> 下午
			<input type="checkbox" id="period" name="period" value="晚上" /> 晚上
			<br />
			<p />
			<input type="submit" value="傳送" />
		</fieldset>
	</form>

</body>
</html>