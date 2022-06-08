<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member</title>
</head>
<body>

<h1>회원목록</h1>
<c:forEach items="${students }" var="s">
	${s.studentId } : ${s.name } : ${s.address }<br>
</c:forEach>
<!-- EL표식? -->
<h3>${name} : ${id} : ${password}</h3>

</body>
</html>