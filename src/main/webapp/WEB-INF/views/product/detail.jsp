<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<!------.detail시작------>
<section class="detail">
    <div class="detail_page">
		<div class="page_cont1">
			<div class="page_thumbnail">
				대표이미지
			</div>
			<ul>
				<li>
					<div class="page_name">
						상품명
					</div>
				</li>
				<li>
					<div class="page_price">
						판매가
					</div>
				</li>
				<li>
					<div class="page_shipping">
						배송비
					</div>
				</li>
				<li>
					<div class="page_qty">
						수량
						<select>
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
					<div class="page_buy">
						<button type="button">
							구매하기
						</button>
					</div>
				</li>
			</ul>
		</div>
		<div class="page_info page_cont2">
			상세정보
		</div>
    </div>
</section>
<!------.detail끝------>

<%@ include file="../layout/footer.jsp"%>