<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>employeeInfoPage/직원상세보기페이지</title>
</head>
<body>
<table border="1px">
<tr><td>사원번호 : ${emp.employeeId }</td></tr>
<tr><td>아이디: ${emp.empUserId }</td></tr>
<tr><td>이름 : ${emp.empName }</td></tr>
<tr><td>입사일: <fmt:formatDate value="${emp.hireDate }" type="date" pattern="yyyy-MM-dd"/></td></tr>
<tr><td>직무 : ${emp.jobId }</td></tr>
<tr><td>연락처 : ${emp.phNumber }</td></tr>
<tr><td>사무실번호 : ${emp.officeNumber }</td></tr>
<tr><td>이메일: ${emp.email }</td></tr>
<tr><td>주소 : ${emp.empAddress }</td></tr>
</table>
<a href="empModify?empId=${emp.employeeId }">수정</a> | 
<a href="empList" >리스트로 가기</a>  
</body>
</html>