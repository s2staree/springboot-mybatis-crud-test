<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ include file="../layout/header.jsp" %>

		<!------.login시작------>
		<form action="/login" method="post">
			<section class="login">
				<h1>회원로그인</h1>
				<div class="login_name">
					<h2>아이디</h2>
					<input type="text" name="userName" value="${login.userName}">
				</div>
				<div class="login_password">
					<h2>패스워드</h2>
					<input type="text" name="userPassword" value="${login.userPassword}">
				</div>
				<button type="submit">로그인</button>
				<button type="button" onclick="location.href='join'">회원가입</button>
			</section>
		</form>
		<!------.login끝------>

		<%@ include file="../layout/footer.jsp" %>