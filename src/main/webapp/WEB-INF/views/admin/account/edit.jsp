<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ include file="../layout/header.jsp" %>

		<!------.edit시작------>
		<form action="/admin/account/${userId}/edit" method="post">
			<section class="edit">
				<h1>회원정보수정</h1>
				<div class="edit_username">
					<h2>아이디</h2>
					<input type="text" name="userName" value="${accountEdit.userName}">
				</div>
				<div class="edit_password">
					<h2>패스워드</h2>
					<input type="text" name="userPassword" value="${accountEdit.userPassword}">
				</div>
				<div class="edit_email">
					<h2>이메일</h2>
					<input type="text" name="userEmail" value="${accountEdit.userEmail}">
				</div>
				<div class="edit_role">
					<h2>구분</h2>
					<input type="text" name="userRole" value="${accountEdit.userRole}">
				</div>
				<button type="submit">저장하기</button>
			</section>
		</form>
		<!------.edit끝------>

		<%@ include file="../layout/footer.jsp" %>