<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>회원가입</title>
	</head>
	<body>
<!-- 		http://127.0.0.1/member/join.do -->
		<h1>회원가입</h1>
		<h3>회원정보를 입력하세요</h3>
		<form action="/member/join.do" method="post">
		<fieldset>
			<legend>회원가입</legend>
				아이디 : <input type="text" name="member-id"> <br>
				비밀번호 : <input type="password" name="memberPw"> <br>
				이름 : <input type="text" name="member-name"> <br>
				성별 : 남 <input type="radio" name="gender" value="M"> 여 <input type="radio" name="gender" value="F"> <br>
				나이 : <input type="number" name="age"> <br>
				이메일 : <input type="text" name="email"> <br>
				전화번호 : <input type="text" name="phone"> <br>
				주소 : <input type="text" name="address"> <br>
				취미 : <input type="text" name="hobby"> <br>
				<input type="submit" value="회원가입">
		</fieldset>
		</form>
	</body>
</html>