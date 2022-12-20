<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ include file="../layout/header.jsp" %>

		<!------.button시작------>
		<section class="button">
			<div class="button_box">
				<button type="button" onclick="location.href='/admin/user'">전체회원목록</button>
				<button type="button" onclick="location.href='/admin/user/customer'">손님회원목록</button>
			</div>
		</section>
		<!------.button끝------>

		<!------.list시작------>
		<section class="list">
			<div class="list_box">
				<table class="box_table">
					<thead>
						<tr>
							<th colspan="8">회원목록</th>
						</tr>
					</thead>
					<tbody>
						<tr class="table_item">

							<td>No.</td>
							<td>구분</td>
							<td>아이디</td>
							<td>이메일</td>
							<td>회원가입일</td>

							<td>회원정보수정</td>
							<td>회원정보삭제</td>

						</tr>
						<c:forEach var="userList" items="${userList}">
							<tr>

								<td>${userList.userId}</td>
								<td>${userList.userRole}</td>
								<td>${userList.userName}</td>
								<td>${userList.userEmail}</td>
								<td>${userList.createdAt}</td>

								<td>
									<button type="button" onclick="location.href='/admin/product/${userList.userId}'">
										수정
									</button>
								</td>
								<td>
									<form action="/admin/account/${userList.userId}/delete" method="post">
										<button type="submit">삭제</button>
									</form>
								</td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</section>
		<!------.list끝------>

		<%@ include file="../layout/footer.jsp" %>