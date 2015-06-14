<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>성적 열람</title>
	</head>
	
	<body>
		<h1>성적 열람 화면</h1>
    	<c:set var="userName" value="${userSession.getName()}"/>
    	<table>
    		<thead>
    			<tr>
    				<th>강좌번호</th>
              		<th>과목명</th>
              		<th>담당교수</th>
              		<th>개설년도</th>
              		<th>학년</th>
              		<th>정원</th>
              		<th>학점</th>
              		<th>평점</th>
            	</tr>
         	</thead>
         	<tbody>
         		
          		<c:forEach items="${lectureArray}" var="item">
                  	<tr>
                  		<td><c:out value ="${item.id}"/></td>
                  		<td><c:out value ="${item.name}"/></td>
                  		<td><c:out value ="${item.professorName}"/></td>
                    	<td><c:out value ="${item.year}"/></td>
                    	<td><c:out value ="${item.grade}"/></td>
                    	<td><c:out value ="${item.maxNum}"/></td>
                    	<td><c:out value ="${item.credit}"/></td>
                    	<td><c:out value ="${item.avg}"/></td>
          		 	</tr>
           		</c:forEach>
           		
         </tbody>   
      </table>
      <a href="${pageContext.request.contextPath}/loginController/logout">로그아웃</a>
	</body>
</html>