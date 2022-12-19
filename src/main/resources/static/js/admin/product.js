
let isProductNameSameCheck = false;	// let = var
let isProductNameState = "";

$("#btnProductAdd").click(() => {
	productAdd();
});

$("#btnProductNameSameCheck").click(() => {
	productNameSameCheck();
});

function productAdd() {

	if (isProductNameSameCheck == false) {
		alert("상품명 중복확인 후 다시 시도해 주세요.");
		return;
	}

	if (!(isProductNameState == $("#productName").val())) {
		alert("상품명 중복확인 후 다시 시도해 주세요.");
		return;
	}

	let data = { // 1) 보낼 데이터를 가져오자
		productName: $("#productName").val(), // 변수명: $("#id에 적은 내용").val()
		productPrice: $("#productPrice").val(),
		productQty: $("#productQty").val()
	};

	$.ajax("/admin/product/add", { // 데이터 보낼 주소
		type: "POST", // 주소의 Mapping 타입
		dataType: "json",  // 응답 데이터. 데이터 타입 알려주기
		data: JSON.stringify(data), // 2) http body에 들고갈 요청 데이터. 위에 3개의 데이터를 담아서 보내자
		headers: { // http header에 들고갈 요청 데이터
			"Content-Type": "application/json; charset=utf-8" // 한글아 깨지지마
		}
	}).done((res) => { // 위에 데이터를 잘 보냈으면 그 이후에 뭐할거야? 응답해야지 res = 응답받은 코드, 우리가 컨트롤러에서 1이면 상품등록성공이라고 약속함
		if (res.code == 1) { // 위의 주소대로 컨트롤러로 가면 잘 갔으면 1, 안갔으면 else로 이동
			location.href = "/admin"; // 3) 여기엔 안나왔는데 / = 메인페이지로 이동함
		} else {
			history.back(); // 잘 안보내졌으니 돌아가라
		}
	});

}

function productNameSameCheck() {

	let productName = $("#productName").val();

	$.ajax(`/api/admin/product/isProductNameSameCheck?productName=${productName}`, {
		type: "GET",
		dataType: "json",
		async: true
	}).done((res) => {
		if (res.code == 1) { // 통신 성공
			if (res.data == false) {
				alert("사용 가능한 상품명입니다.");
				isProductNameSameCheck = true;
				isProductNameState = productName;
			} else {
				alert("이미 사용 중인 상품명입니다.");
				isProductNameSameCheck = false;
				$("#productName").val("");
			}
		}
	});

}
