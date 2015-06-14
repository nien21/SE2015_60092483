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
		<h1>성적 부여 화면</h1>
    	<table>
    		<thead>
    			<tr>
    				<th>학생</th>
              		<th>성적</th>
              		<th>성적부여</th>
              		<th></th>
            	</tr>
         	</thead>
         	<tbody>
         		
          		<c:forEach items="${sugangArray}" var="item">
          			<form action="${pageContext.request.contextPath}/assignController/gradeAssign" method="post">
          			<input type = "hidden" value ="${item.lectureID}" name = "lectureID">
                  	<tr>
                  		<td>
                  			<c:out value ="${item.studentName}"/>
                  			<input type = "hidden" value ="${item.studentName}" name = "studentName">
                  		</td>
                  		<td><c:out value ="${item.result}"/></td>
                  		<td>
                  			<select name = "result">
				 				<option value = "A+">A+</option>
				 				<option value = "A0">A0</option>
				 				<option value = "B+">B+</option>
				 				<option value = "B0">B0</option>
				 				<option value = "C+">C+</option>
				 				<option value = "C0">C0</option>
				 				<option value = "D+">D+</option>
				 				<option value = "D0">D0</option>
				 				<option value = "F">F</option>
							</select>
							
						</td>
						<td><input type="submit" value="성적 부여"></td>
          		 	</tr>
          		 	 </form>
           		</c:forEach>
           		
         </tbody>   
      </table>
      <a href="${pageContext.request.contextPath}/loginController/logout">로그아웃</a>
      	
      	
     
	</body>
</html>