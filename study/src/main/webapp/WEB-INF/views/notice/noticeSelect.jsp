<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div align="center">
		<div><h1>공지사항 상세보기</h1></div>
		${notice.id } : ${notice.writer } : ${notice.wdate } : ${notice.hit }<p>
		${notice.title } <p>
		${notice.subject }
	</div>

</body>
</html>