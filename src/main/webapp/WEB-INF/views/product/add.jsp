<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<!------.add시작------>
<form action="/product/add" method="post">
<section class="add">
	<h1>상품등록</h1>
	<div class="add_name">
		<h2>상품명</h2>
		<input type="text" name="productName">
	</div>
    <div class="add_price">
		<h2>판매가</h2>
		<input type="text" name="productPrice">
	</div>
	<div class="add_qty">
		<h2>재고수량</h2>
		<input type="text" name="productQty">
	</div>
	<div class="add_thumbnail">
		<h2>대표이미지</h2>
		<button type="button">업로드</button>
	</div>
	<button type="submit">등록하기</button>
</section>
</form>
<!------.add끝------>

<%@ include file="../layout/footer.jsp"%>