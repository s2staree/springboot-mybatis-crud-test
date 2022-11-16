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
		<button type="button" id="btnAdd">등록하기</button>
		<!-- button type - submit은 동기 방식으로 form 태그를 쓸 때 사용하고, button은 비동기 방식으로 ajax 쓸 때 사용한다! -->
	</section>
</form>
<!------.add끝------>

<script>

$("#btnAdd").click(()=>{
	
	let data = { // 1, 보낼 데이터를 가져오자
			productName: $("#productName").val(), // 변수명: $("#id에 적은 내용").val()
			productPrice: $("#productPrice").val(),
			productQty: $("#productQty").val()
		};

	$.ajax("/product/add", { // 데이터 보낼 주소
			type: "POST", // 주소의 Mapping 타입
			dataType: "json",  // 데이터 타입 알려주기
			data: JSON.stringify(data), // 2. 위에 3개의 데이터를 담아서 보내자
			headers: { 
				"Content-Type": "application/json; charset=utf-8" // 한글아 깨지지마
			}
		}).done((res) => { // 위에 데이터를 잘 보냈으면 그 이후에 뭐할거야? 응답해야지 res = 응답받은 코드, 우리가 컨트롤러에서 1이면 상품등록성공이라고 약속함
			if (res.code == 1) { // 위의 주소대로 컨트롤러로 가면 잘 갔으면 1, 안갔으면 else로 이동
				location.href = "/"; // 3. 여기엔 안나왔는데 / = 메인페이지로 이동함
			} else {
				history.back(); // 잘 안보내졌으니 돌아가라
			}
		});
	
});

</script>

<%@ include file="../layout/footer.jsp"%>