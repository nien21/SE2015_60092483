<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>수강 신청</title>
	</head>
	
	<body>
		<h1>수강 신청 화면</h1>
    	<table>
    		<thead>
    			<tr>
    				<th>강좌번호</th>
              		<th>과목명</th>
              		<th>담당교수</th>
              		<th>개설년도</th>
              		<th>학년</th>
              		<th>현재인원</th>
              		<th>정원</th>
              		<th>학점</th>
              		<th></th>
            	</tr>
         	</thead>
         	<tbody>
				
          		<c:forEach items="${lectureArray}" var="item">
          			<form action="${pageContext.request.contextPath}/sugangController/register" method="post">
                  	<tr>
                  		<td>
                  			<c:out value ="${item.id}"/>
                  			<input type = "hidden" value ="${item.id}" name = "lectureID">
                  		</td>
                  		<td><c:out value ="${item.name}"/></td>
						<td>
							<c:out value ="${item.professorName}"/>
							<input type = "hidden" value ="${item.professorName}" name = "professorName">
						</td>
                    	<td><c:out value ="${item.year}"/></td>
                    	<td><c:out value ="${item.grade}"/></td>
                    	<td><c:out value ="${item.currentMaxNum}"/></td>
                    	<td><c:out value ="${item.maxNum}"/></td>
                    	<td><c:out value ="${item.credit}"/></td>
                    	<td>
                    		
                    			<input type="submit" value="신청">
                    	
                    	</td>
          		 	</tr>
     				</form>
           		</c:forEach>
           			
         </tbody>   
      </table>
      <a href="${pageContext.request.contextPath}/loginController/logout">로그아웃</a>
	</body>
</html>