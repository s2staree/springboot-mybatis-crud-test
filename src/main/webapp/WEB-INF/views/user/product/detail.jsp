<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ include file="../layout/header.jsp" %>

		<!------.detail시작------>
		<section class="detail">
			<div class="detail_page">
				<div class="page_thumbnail">대표이미지</div>
				<form action="/product/${detail.productId}/buy" method="post">
					<ul>
						<!-- name(키)="카드" / value(밸류)="＄{통장.현금}" -->
						<li>
							<div class="page_name">
								<div>상품명</div>
								<div>${detail.productName}</div>
								<input type="hidden" name="orderProductName" value="${detail.productName}">
							</div>
						</li>
						<li>
							<div class="page_price">
								<div>판매가</div>
								<div>${detail.productPrice}</div>
								<input type="hidden" name="orderProductPrice" value="${detail.productPrice}">
							</div>
						</li>
						<li>
							<div class="page_qty">
								<div>남은재고</div>
								<div>${detail.productQty}</div>
							</div>
						</li>
						<li>
							<div class="page_qty_order">
								<div>구매수량</div>
								<input type="text" name="orderProductQty">
							</div>
						</li>
						<li>
							<div class="page_buy">
								<div class="page_buy_btn">
									<button type="submit">구매하기</button>
								</div>
							</div>
						</li>
					</ul>
				</form>
			</div>
		</section>
		<!------.detail끝------>

		<%@ include file="../layout/footer.jsp" %>