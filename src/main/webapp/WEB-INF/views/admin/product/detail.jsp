<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ include file="../layout/header.jsp" %>

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
							<div>남은재고</div>
							<div>${detail.productQty}</div>
						</div>
					</li>
					<li>
						<div class="page_edit_delete">
							<form action="/admin/product/${productId}/edit" method="get">
								<div class="page_edit">
									<button type="submit">수정</button>
								</div>
							</form>
							<form action="/admin/product/${productId}/delete" method="post">
								<div class="page_delete">
									<button type="submit">삭제</button>
								</div>
							</form>
						</div>
					</li>
				</ul>
			</div>
		</section>
		<!------.detail끝------>

		<%@ include file="../layout/footer.jsp" %>