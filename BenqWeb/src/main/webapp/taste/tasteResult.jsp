<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>개인 취향 테스트</title>
	</head>
	<body>
		<h1>개인 취향 테스트 결과</h1>
		<p>
<!-- 		requestScope + 마침표 표기법으로 String userName = (String)request.getAttribute("userName"); 라는 코드를 대체하게 됨 -->
			이름? ${requestScope.userName } <br>
			좋아하는 색? <span style="color:black;"><b>${color }</b></span><br>
			좋아하는 동물은? ${pet } <br>
			좋아하는 음식은? ${foodStr } <br>
			
		</p>
	</body>
</html>