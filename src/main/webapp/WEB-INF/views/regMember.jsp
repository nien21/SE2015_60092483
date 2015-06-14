<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입 페이지</title>
</head>
<body>
	<h1>회원가입 페이지</h1>
	<form action="joinController/regMember.do" method="post">
			<table>
				<tr align ="left">
					<td>id</td>
					<td><input type="text" name="userID"></td>
				</tr>
				<tr align ="left">
					<td>이름</td>
					<td><input type="text" name= "name"></td>
				</tr>
				<tr align ="left">
					<td>password</td>
					<td><input type="password" name= "userPassword"></td>
				</tr>
				<tr align ="left">
					<td>분류</td>
					<td>
						<input type = "radio" name = "type" value="학생" >학생
						<input type = "radio" name = "type" value="교수" >교수
						<input type = "radio" name = "type" value="관리자" >관리자
					</td>
				</tr>
					<td><input type="submit" value="가입 신청하기"></td>
				<tr>
					<td>
					<br>
				<a href="${pageContext.request.contextPath}/loginController/logout">돌아가기</a>
				</td>
				</tr>
			</table>
			
			<input type="hidden" name="msg" value="${msg}"/>
		</form>
		<script language="JavaScript">
	      var error = "${msg}";
	
	      if (error) {
	         alert("${msg}");
	         if(error =="회원 가입되었습니다."){
					location.href = '${pageContext.request.contextPath}/loginController/login.do';
			 	} 
	      }
	   </script>

</body>
</html>