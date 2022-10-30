<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<!------.edit시작------>
<form action="/test/product/edit/${YeonG.productId}" method="post">
<section class="edit">
	<h1>상품정보수정</h1>
	<div class="edit_name">
		<h2>상품명</h2>
		<input type="text" name="productName" value="${YeonG.productName}">
	</div>
	<div class="edit_qty">
		<h2>판매가</h2>
		<input type="text" name="productPrice" value="${YeonG.productPrice}">
	</div>
	<div class="edit_price">
		<h2>재고수량</h2>
		<input type="text" name="productQty" value="${YeonG.productQty}">
	</div>
    <div class="edit_thumbnail">
		<h2>대표이미지</h2>
		<button type="button">업로드</button>
	</div>
	<button type="submit">저장하기</button>
</section>
</form>
<!------.edit끝------>

<%@ include file="../layout/footer.jsp"%>