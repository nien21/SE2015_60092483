<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	학사관리 시스템
</h1>

<P>  The time on the server is ${serverTime}. </P>
<br/>
	<form action="loginController/login.do" method="post">
		1. 로그인<br/>
		<input type="text" name="id">
		<input type="password" name="pwd"> <br/>
		<input type="submit" value="로그인">
	</form>
	2.<a href="./regMember">회원가입</a>

	
</body>
</html>
