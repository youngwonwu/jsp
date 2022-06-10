<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="js/jquery-3.6.0.min.js"></script>
</head>
<body>

	<div align="center">
		<div><h1>공지사항 목록</h1></div>
		<div>
			<form id="frm" action="" method="post">
				<select id="key" name="key">
				  <option value="1">전체</option>
				  <option value="2">작성자</option>
				  <option value="3">제목</option>
				  <option value="4">내용</option>
				</select>&nbsp;
				<input type="text" id="val" name="val">&nbsp;
				<input type="button" onclick="search2()" value="검색">
			</form>
		</div><br>
		<div>
			<table border="1" id="ta">
				<thead>
					<tr>
						<th width="100">글번호</th>
						<th width="150">작성자</th>
						<th width="250">제목</th>
						<th width="150">작성일자</th>
						<th width="100">조회수</th>
						<th width="200">첨부파일</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="notice">
						<tr>
							<td align="center">${notice.id }</td>
							<td align="center">${notice.writer }</td>
							<td>${notice.title }</td>
							<td align="center">${notice.wdate }</td>
							<td align="center">${notice.hit }</td>
							<td>${notice.fileName }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div><br>
		<div>
			<button type="button" onclick="location.href='noticeInputForm.do'">글쓰기</button>
		</div>
	</div>
	
	<script type="text/javascript">
	
		//ajax
		function search(){
			//alert("검색 할까요?")
			let fields = ['id', 'writer', 'title', 'wdate', 'hit', 'fileName'];
			let allTr = document.querySelectorAll('tbody>tr');
			
			/* let k = frm.key.value;	//key 값
			let v = frm.val.value;	//val 값 	이렇게 써도 되지만*/
			/* let k = document.......
			allTr.forEach(function (tr) => {
				tr.remove();
			}); */
			
			allTr.forEach((tr) => {
				tr.remove();
			});
			let param = "key=" + frm.key.value + "&val=" + frm.val.value;		
			
			let list = document.querySelector("tbody");
			
			fetch('ajaxSearchList.do', {
				method: 'POST',
				headers: {'Content-Type':'application/x-www-form-urlencoded'},
				body : param
				/* body : 'key=' + k + '&val' + v */
				/* body: 'key="${key.value}".......다 못 적음' */
			})
			.then(response => response.json())	//json type으로 결과 받음
			.then(data => {
				console.log(data);
				data.forEach(d => {	//json data를 한행식 읽음
					let tr = document.createElement('tr');	//<tr> 태그 생성
					fields.forEach(f => {	//한행의 데이터에서
						let td = document.createElement('td');	//<td>를 만들면서
						td.innerHTML = d[f];	//필드값과 일치 키값에서 데이터를 가져와서 td에 넣고
						tr.appendChild(td);	//tr에 td를 추가
					})
						list.appendChild(tr);	//그리고 tobody에 tr을 추가한다
				})
			})
		}
		
		//jquery
		function search2(){
			//ajax 기본형
			$.ajax({
				url : "ajaxSearchList.do",
				type : "post",
				data : {"key":$("#key").val(), "val":$("#val").val()},
				dataType : "json",
				success : function(data){
					htmlConvert(data);
					},
				error : function(){
					//실패시 구현
				}
			});
		}
		
		function htmlConvert(data){
			$("tbody").remove();	//tbody제거
			let tb = $("<tbody />");
			$.each(data, function(index, item){
				let tr = $("<tr />").append(
						$("<td align='center' />").text(item.id),
						$("<td align='center' />").text(item.writer),
						$("<td/>").text(item.title),
						$("<td align='center' />").text(item.wdate),
						$("<td align='center' />").text(item.hit),
						$("<td/>").text(item.fileName)
				);
				tb.append(tr);
			});
			$("#ta").append(tb);
		}
	</script>

</body>
</html>