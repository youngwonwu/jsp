<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
	tr.row:hover{
		background-color: black;
		color: white;
	}
</style>

</head>
<body>

	<div align="center">
		<div>
			<h1>공지사항 목록</h1>
		</div>
		<div>
			<table border="1">
				<thead>
					<tr>
						<th width="100">글번호</th>
						<th width="150">작성자</th>
						<th width="250">제 목</th>
						<th width="150">작성일자</th>
						<th width="100">조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${notices }" var="notice">	<!-- items="${notices }" 서버에서 request에 담은 변수	var="notice" 테이블 한줄을 notice라고 할꺼야 -->
						<tr class="row" onclick="noticeSelect(${notice.id})">
							<td align="center">${notice.id }</td>	<!-- .id  vo객체에 있는 변수 -->
							<td align="center">${notice.writer }</td>
							<td>${notice.title }</td>
							<td align="center">${notice.wdate }</td>
							<td align="center">${notice.hit }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div><br>
		<div>
			<form id="frm" action="noticeSelect.do" method="post">	<!-- id="" javascript가 사용하는 변수 -->
				<input type="hidden" id="id" name="id">		<!-- name="" java가 이용하는 변수 -->
			</form>
		</div>
		<div>
			<button type="button" onclick="location.href='home.do'">홈가기</button>
		</div>
	</div>
	
	<script type="text/javascript">
		function noticeSelect(id){
			//location.href = "noticeSelect.do?id=" + id;
			frm.id.value = id;
			frm.submit();
		}
	</script>

</body>
</html>