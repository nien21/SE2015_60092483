<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>성적 부여</title>
	</head>
	
	<body>
		<h1>성적 부여 화면 메인</h1>
    	<table>
    		<thead>
    			<tr>
    				<th>강좌번호</th>
              		<th>과목명</th>
              		<th>개설년도</th>
              		<th>학년</th>
              		<th>정원</th>
              		<th>학점</th>
            	</tr>
         	</thead>
         	<tbody>
         		
          		<c:forEach items="${lectureArray}" var="item">
                  	<tr>
                  		<td><c:out value ="${item.id}"/></td>
                  		<td><c:out value ="${item.name}"/></td>
                    	<td><c:out value ="${item.year}"/></td>
                    	<td><c:out value ="${item.grade}"/></td>
                    	<td><c:out value ="${item.maxNum}"/></td>
                    	<td><c:out value ="${item.credit}"/></td>
          		 	</tr>
           		</c:forEach>
           		
         </tbody>   
      </table>
      <form action="${pageContext.request.contextPath}/sugangController/getSugangList" method="post">
      	성적을 부여할 과목의 강좌번호를 입력해주세요<br>
      	<input type="text" name="lectureID">
      	<input type="submit" value="성적 부여하기">
      </form>
      <a href="${pageContext.request.contextPath}/loginController/logout">로그아웃</a>
      <script language="JavaScript">
			var error = "${msg}";
     		if(error != ""){
    			alert("${msg}");
    			location.href = '${pageContext.request.contextPath}/loginController/login.do';
    	 	}
   		</script>
	</body>
</html>