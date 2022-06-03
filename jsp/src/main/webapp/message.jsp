<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	#show {
		width: 500px;
		height: 300px;
		border: 1px solid blue;
	}
</style>

</head>
<body>
<%
	String user = request.getParameter("user");
%>

	<div id="show">
	<div class="row">user1> test</div>
	</div>
	<input type="text" name="content">
	<input type="hidden" name="writer" value="<%=user%>">	<!-- <%=user%> 파라미터 값을 가져온다 -->
	
	<script>
		let lastMeg = -1;
	
		document.querySelector('input[name="content"]').addEventListener('change', changeCall);
		function changeCall(e){		//e 이벤트(input[name="content"])가 실행되는 정보
			let content = document.querySelector('input[name="content"]').value;
			let writer = document.querySelector('input[name="writer"]').value;
			
			fetch('message', {
				method: 'post',
				headers: {'Content-type': 'application/x-www-form-urlencoded'},
				body: 'writer=' + writer + '&content=' + content
			})
			//.then(result => console.log(result))
			.then(result => {
				console.log(result)
				e.target.value = '';	//e.target => input
			})
			.catch(err => console.log(err));
		}
		
		setInterval(e => {
			fetch('message')	//get방식 호출
				.then(result => result.json())	//가지고온 결과 값을 String -> json 타입으로
				//.then(json => console.log(json))
				//.then(json => createRow(json))
				
				.then(json => {
					// 기존화면의 메세지를 지우기
					//let divs = document.querySelectorAll('#show div');
					let divs = document.querySelectorAll('.row');
					divs.forEach(elem => elem.remove());
					
					/*let fitAry = json.filter(elem => {
						return elem.msgId > lastMsg - 10;
					})*/
					
					let fitAry = json.filter((val,idx,arr)=>(arr.length-idx)<10);
					
					// 조회된 메세지를 새로 그려주기
					//let show = document.getElementById('show').append(div);
					let show = document.getElementById('show');
					fitAry.forEach(row => {
						lastMeg = row.msg_id;
						let div = createRow(row);
						show.append(div);
					});
				})
				.catch(error => console.log(error));
		}, 3000);	//3초마다 실행
		
		function createRow(message) {
			let div = document.createElement('div');
			div.setAttribute('class', 'row');
			//div.innerText = `${message.writer}> ${message.content}`;	//jsp에서는 ``안먹히는것 같음
			//div.innerText = message.writer+'>'+ message.content;		//밑에 선생님이 해주신 것도 되는데 이렇게 해도 실행됨ㄴ
			// T
			let txt = document.createTextNode(message.writer + '>' + message.content);
			div.append(txt);
			
			return div;
		}
	</script>

</body>
</html>