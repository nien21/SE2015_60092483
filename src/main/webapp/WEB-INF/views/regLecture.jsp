<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>강좌 개설</title>
</head>
<body>
	<h1>강좌 개설 화면</h1>
	<form action="${pageContext.request.contextPath}/lectureController/register.do" method="post">
		
			강좌번호 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 과목명
			&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 연도
			&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 학년
			&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 정원
			&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 학점
			<br>
			<input type="text" name= "id">&nbsp;
			<input type="text" name= "name">&nbsp;
			<input type="text" name= "year">&nbsp;
			<input type="text" name= "grade">&nbsp;
			<input type="text" name= "maxNum">&nbsp;
			<input type="text" name= "credit">&nbsp;
			<input type="submit" value="과목 개설">
		
		
		
	</form>
		<a href="${pageContext.request.contextPath}/loginController/logout">로그아웃</a>
</body>
</html>