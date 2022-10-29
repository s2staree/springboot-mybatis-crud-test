<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<!------.list시작------>
<section class="list">
	<div class="list_box">
		<table class="box_table">
			<thead>
				<tr>
					<th colspan="8">상품목록</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach var="KonggPatg" items="${KongG}">
					<tr>
						<td>${KonggPatg.productId}</td>
						<td>${KonggPatg.productName}</td>
						<td>${KonggPatg.productPrice}</td>
						<td>${KonggPatg.productQty}</td>
						<td>${KonggPatg.createdAt}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</section>
<!------.list끝------>

<%@ include file="../layout/footer.jsp"%>