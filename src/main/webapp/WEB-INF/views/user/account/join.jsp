<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ include file="../layout/header.jsp" %>

		<!------.join시작------>
		<form>
			<section class="join">
				<h1>회원가입</h1>
				<div class="join_name">
					<h2>아이디</h2>
					<input type="text" name="userName" id="userName">
					<button type="button" id="btnUserNameSameCheck">중복확인</button>
				</div>
				<div class="join_password">
					<h2>패스워드</h2>
					<input type="text" name="userPassword" id="userPassword">
				</div>
				<div class="join_email">
					<h2>이메일</h2>
					<input type="text" name="userEmail" id="userEmail">
				</div>
				<button type="button" id="btnUserJoin">가입하기</button>
				<!-- button type - submit은 동기 방식으로 form 태그를 쓸 때 사용하고, button은 비동기 방식으로 ajax 쓸 때 사용한다! -->
			</section>
		</form>
		<!------.join끝------>

		<script src="/js/admin/product.js">
		</script>

		<%@ include file="../layout/footer.jsp" %>