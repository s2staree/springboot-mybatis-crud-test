<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ include file="../layout/header.jsp" %>

		<!------.orders시작------>
		<section class="orders">
			<div class="orders_box">
				<table class="box_table">
					<thead>
						<tr>
							<th colspan="8">구매목록</th>
						</tr>
					</thead>
					<tbody>
						<tr class="table_item">
							<td>No.</td>
							<td>상품명</td>
							<td>구매가</td>
							<td>수량</td>
							<td>구매취소</td>
						</tr>
						<c:forEach var="orders" items="${orderList}">
							<!-- items는 컨트롤러의 model의 값과 동일하게 해야 함! -->
							<!-- var는 .뒤의 변수의 타입을 모를 때 어떤 변수가 와도 사용할 수 있게끔 items의 이름을 임의적으로 만들어줌! -->
							<tr>
								<td>${orders.orderId}</td>
								<td>${orders.orderProductName}</td>
								<td>${orders.orderProductPrice}</td>
								<td>${orders.orderProductQty}</td>
								<td>
									<form action="/order/${orders.orderId}/cancel" method="post">
										<button type="submit">구매취소</button>
									</form>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</section>
		<!------.orders끝------>

		<%@ include file="../layout/footer.jsp" %>