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
		<div><h1>공지사항 등록</h1></div>
		<div>
			<form id="frm" action="noticeInput.do" method="post" enctype="multipart/form-data">	<!-- 파일은 2진법이라 multipart 필요하다 -->
				<div>
					<table border="1">
						<tr>
							<th width="150">작성자</th>
							<td width="150">
								<input type="text" id="writer" name="writer" required="required"> <!-- required 필수사항 -->
							</td>
							<th width="150">작성일자</th>
							<td width="150">
								<input type="date" id="wdate" name="wdate" required="required">
							</td>
						</tr>
						<tr>
							<th>제목</th>
							<td colspan="3">
								<input type="text" size="66" id="title" name="title" required="required">
							</td>
						</tr>
						<tr>
							<th>내용</th>
							<td colspan="3">
								<textarea rows="10" cols="63" id="subject" name="subject"></textarea>
							</td>
						</tr>
						<tr>
							<th>첨부파일</th>
							<td colspan="3">
								<input type="file" id="file" name="file">		<!-- vo 이름과 틀리게 입력 -->
							</td>
						</tr>
					</table>
				</div><br>
				<div>
					<input type="submit" value="저장">&nbsp;&nbsp;
					<input type="reset" value="취소">&nbsp;&nbsp;
					<input type="button" value="목록" onclick="location.href='noticeList.do'">
				</div>	
			</form>
		</div>
	</div>

</body>
</html>