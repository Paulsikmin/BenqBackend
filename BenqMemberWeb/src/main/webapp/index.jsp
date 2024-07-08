<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>MemberWeb Home</title>
	</head>
	<body>
		<h1>환영합니다 MemberWeb Home입니다~</h1>
		<c:if test="${sessionScope.memberId ne null }">
			${sessionScope.memberName }님 환영합니다~! <br>
			<a href="/member/mypage.do">마이페이지</a>
			<a href="/member/remove.do?memberId=${memberId }">회원탈퇴</a><br>
<!-- 			<form action="/member/remove.do" method="get"> -->
<%-- 				<input type="hidden" name="memberId" value="${memberId }"> --%>
<!-- 				<input type="submit" value="회원탈퇴"> -->
<!-- 			</form> -->
			<a href="/member/logout.do">로그아웃</a>
<%-- 		<% if(sessionScope.memberId != null)  { %> --%>
		
<%-- 		<% } else { %> --%>
		</c:if>
		<c:if test="${sessionScope.memberId eq null }">
			<form action="/member/login.do" method="post">
			<fieldset>
				<legend>로그인</legend>
				ID : <input type="text" 	name="memberId"> <br>
				PW : <input type="password" name="memberPw"> <br>
				<input type="submit" value="로그인">
			</fieldset>
			</form>
		</c:if>
<%-- 		<% } %> --%>
	</body>
</html>



