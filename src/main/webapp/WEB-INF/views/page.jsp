<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>페이지</title>
</head>
<body>
	<c:set var="usertype" value="${userSession.getType()}"/>
		<c:choose>
			<c:when test="${usertype == '교수'}">
				<h1>교수 페이지</h1>
				<a href="${pageContext.request.contextPath}/lectureController/regLecture">1.강좌개설</a><br>
				<a href="${pageContext.request.contextPath}/lectureController/getGradeAssignMain">2.성적부여</a><br>
			</c:when>
			<c:otherwise>
				
				<h1>학생 페이지</h1>
				<a href="${pageContext.request.contextPath}/lectureController/getGradeAssignMain">1.수강신청</a><br>
				<a href="${pageContext.request.contextPath}/sugangController/gradeAssignMain">2.성적열람</a><br>
			</c:otherwise>
		</c:choose>
		<br>
		<a href="${pageContext.request.contextPath}/loginController/logout">로그아웃</a>
		<input type="hidden" name="msg" value="${msg}"/>
		
	
		<script language="JavaScript">
			var error = "${msg}";
     		if(error != ""){
    			alert("${msg}");
    			location.href = '${pageContext.request.contextPath}/loginController/login.do';
    	 	}
   		</script>
	</body>
</html>