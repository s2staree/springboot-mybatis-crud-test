<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<!------.detail시작------>
<section class="detail">
	<div class="detail_page">
		<div class="page_thumbnail">대표이미지</div>
		<ul>
			<li>
				<div class="page_name">
					<div>상품명</div>
					<div>${detail.productName}</div>
				</div>
			</li>
			<li>
				<div class="page_price">
					<div>판매가</div>
					<div>${detail.productPrice}</div>
				</div>
			</li>
			<li>
				<div class="page_qty">
					수량 <select>
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
						<option>6</option>
						<option>7</option>
						<option>8</option>
						<option>9</option>
						<option>10</option>
					</select>
				</div>
			</li>
			<li>
				<div class="page_edit_delete">
					<form action="/product/${productId}/edit" method="get">
						<div class="page_edit">
							<button type="submit">수정</button>
						</div>
					</form>
					<div class="page_delete">
						<button type="button">삭제</button>
					</div>
				</div>
			</li>
		</ul>
	</div>
</section>
<!------.detail끝------>

<%@ include file="../layout/footer.jsp"%>