<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<!------.add시작------>
<form>
	<section class="add">
		<h1>상품등록</h1>
		<div class="add_name">
			<h2>상품명</h2>
			<input type="text" name="productName" id="productName">
			<button type="button" id="btnProductNameSameCheck">중복확인</button>
		</div>
		<div class="add_price">
			<h2>판매가</h2>
			<input type="text" name="productPrice" id="productPrice">
		</div>
		<div class="add_qty">
			<h2>재고수량</h2>
			<input type="text" name="productQty" id="productQty">
		</div>
		<div class="add_thumbnail">
			<h2>대표이미지</h2>
			<button type="button">업로드</button>
		</div>
		<button type="button" id="btnProductAdd">등록하기</button>
		<!-- button type - submit은 동기 방식으로 form 태그를 쓸 때 사용하고, button은 비동기 방식으로 ajax 쓸 때 사용한다! -->
	</section>
</form>
<!------.add끝------>

<script src="/js/product.js">
</script>

<%@ include file="../layout/footer.jsp"%>