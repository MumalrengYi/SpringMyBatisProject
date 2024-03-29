
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>employeeList.jsp / 직원등록페이지</title>
</head>
<body>
직원 리스트 페이지입니다.<br />
<c:if test="${!empty empList }">
<table border="1px" >
	<tr><td>사원번호</td><td>이름</td><td>직무</td><td>입사일</td><td>사무실번호</td></tr>
<c:forEach items="${empList }" var="dto">
	<tr><td><a href="empInfo?empId=${dto.employeeId}">
			${dto.employeeId}</a></td>
		<td>${dto.empName}</td>
	<td>${dto.jobId}</td>
	<td><fmt:formatDate value="${dto.hireDate}" type="date" pattern="yyyy-MM-dd"/></td>
	<td>${dto.officeNumber}</td></tr>
</c:forEach>
</table>
</c:if>
<c:if test="${empty empList }">
등록된 직원 없습니.
</c:if>
<a href="empRegist">직원등록</a>
</body>
</html>