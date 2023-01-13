# 연습문제 MyBatis
MyBatis 공부를 위한 숙제하기 (5단계)

-----------------------------------------------------------------------------------------------------------
## 1단계 (기본 CRUD + JSP)

### View 생성
- 상품등록 페이지
- 상품목록 페이지 (html table 사용)
- 상품상세보기 페이지 (삭제, 수정)
- 상품수정 페이지

### 기능 (ajax 필요 없음) (서비스 만들 필요 없음)
- 상품 등록(post - form태그)  주소 : /product/add
- 상품 목록보기(get) 주소 : /product
- 상품 상세보기(get) 주소 : /product/{id}
- 상품 삭제하기(post - form태그) : /product/{id}/delete
- 상품 수정하기(post - form태그) : /product/{id}/edit

### 테이블 생성
```sql
create table product(
    product_id int primary KEY auto_increment,
    product_name varchar(20) NOT null,
    product_price INT NOT null,
    product_qty INT NOT null,
    created_at TIMESTAMP NOT null
);
```

### 더미데이터
```sql
INSERT INTO product(product_name, product_price, product_qty, created_at) VALUES('바나나', 3000, 98, NOW());
INSERT INTO product(product_name, product_price, product_qty, created_at) VALUES('딸기', 2000, 100, NOW());
```

-----------------------------------------------------------------------------------------------------------
## 2단계 (AJAX)

### 고급 기능
- 상품 등록시 동일한 상품명 못들어가게 하기 (상품명 중복확인하기)
- 값 변경되는 거 감지해야 함 (이벤트)

-----------------------------------------------------------------------------------------------------------
## 3단계 (로그인+세션+연관관계)

서버1 (판매자 서버) / 서버2 (구매자 서버) : DB 를 공유

- (구매 테이블 필요)
- (유저 테이블 필요) : 구매자

### 기능 추가사항
- 회원가입
- 로그인
- 상품목록 보기 (기존과 동일)
- 상품상세 보기 (기존과 다름 : 구매하기 버튼)
- 구매 후 상품 재고 수정
+ 구매취소 후 상품 재고 복원
- 구매목록 보기

### 테이블, 더미데이터
```sql
DROP TABLE product;

create table product(
    product_id int primary KEY auto_increment,
    product_name varchar(20) NOT null UNIQUE,
    product_price INT NOT null,
    product_qty INT NOT null,
    created_at TIMESTAMP NOT null
);

INSERT INTO product(product_name, product_price, product_qty, created_at) VALUES('바나나', 3000, 98, NOW());
INSERT INTO product(product_name, product_price, product_qty, created_at) VALUES('딸기', 2000, 100, NOW());
/*--------------------------------------------------------------*/
create table user(
    user_id int primary KEY auto_increment,
    user_name varchar(20) NOT null UNIQUE,
    user_password varchar(20) NOT null,
    user_email varchar(20) NOT null,
    created_at TIMESTAMP NOT null
);

INSERT INTO user(user_name, user_password, user_email, created_at) VALUES('user', '0000', 'user@email.com', NOW());
/*--------------------------------------------------------------*/
create table orders(
    order_id int primary KEY auto_increment,
    user_id int NOT null,
    order_user_name varchar(20) NOT null,
    product_id int NOT null,
    order_product_name varchar(20) NOT null,
    order_product_price int NOT null,
    order_product_qty int NOT null,
    created_at TIMESTAMP NOT null
);
```

-----------------------------------------------------------------------------------------------------------
## 4단계 (판매자/구매자 role구분하기)

- admin : 판매자(관리자)
- customer : 구매자

### 테이블, 더미데이터
```sql
DROP TABLE user;

create table user(
    user_id int primary KEY auto_increment,
    user_name varchar(20) NOT NULL UNIQUE,
    user_password varchar(20) NOT null,
    user_email varchar(20) NOT null,
    user_role VARCHAR(20) NOT null DEFAULT('customer'),
    /* user_role에 해당되는 값이 없으면 null값 대신 DEFAULT인 'customer'가 넣어짐!*/
    created_at TIMESTAMP NOT null
);

INSERT INTO user(user_name, user_password, user_email, user_role, created_at) VALUES('admin', '0000', 'admin@email.com', 'admin', NOW());
INSERT INTO user(user_name, user_password, user_email, user_role, created_at) VALUES('customer', '0000', 'customer@email.com', 'customer', NOW());
```

-----------------------------------------------------------------------------------------------------------
## 5단계 (관리자-회원목록보기/주문목록보기)

### 기능 추가사항
- 회원 목록 보기
- 회원 주문목록 보기
+ 회원 정보 수정
+ 회원 정보 삭제
+ 회원 가입시 아이디 중복확인

-----------------------------------------------------------------------------------------------------------
## 기타 사항

### 테마 색상
- #F9F5EB
- #EAE3D2
- #91A7C8
- #607EAA
- #1C3879

-----------------------------------------------------------------------------------------------------------
## 페이지, 기능 구현

### 메인페이지
<img src="https://user-images.githubusercontent.com/112357299/212027137-47ef48fe-15f4-4d3e-b200-9eacdb120673.jpg" width="1000"/>
<img src="https://user-images.githubusercontent.com/112357299/212026068-e4c7b74f-69b9-4664-a1aa-a8bd56b0ae17.jpg" width="1000"/>

### 회원가입페이지
<img src="https://user-images.githubusercontent.com/112357299/212026303-1f0d1746-cf09-4b9b-bbcb-a6d155955e42.jpg" width="1000"/>

### 회원가입-아이디중복확인
<img src="https://user-images.githubusercontent.com/112357299/212026313-e7e9dfbf-724d-4172-9587-c0813a995a23.jpg" width="1000"/>
<img src="https://user-images.githubusercontent.com/112357299/212026316-fde57951-881d-49a4-951c-243b29d2e6da.jpg" width="1000"/>

### 회원가입-구매자가입
<img src="https://user-images.githubusercontent.com/112357299/212026320-2fc86029-3f3a-40c1-9cf5-af899be4d83c.jpg" width="1000"/>

### 로그인페이지
<img src="https://user-images.githubusercontent.com/112357299/212026480-20d6a0ab-7fd5-4daa-9446-d56fcc3fa36a.jpg" width="1000"/>

### 로그인-구매자로그인
<img src="https://user-images.githubusercontent.com/112357299/212026573-24af4bdc-be0c-49b8-b1ef-cdc850a6f59a.jpg" width="1000"/>

### 구매자) 메인페이지(상품목록페이지)
<img src="https://user-images.githubusercontent.com/112357299/212027092-89ff1a91-2000-45e7-84e1-282792ef4eba.jpg" width="1000"/>
<img src="https://user-images.githubusercontent.com/112357299/212026925-92b9db71-fe9c-4933-8a18-6b57e2c6b8b9.jpg" width="1000"/>

### 구매자) 메인페이지>구매페이지 이동
<img src="https://user-images.githubusercontent.com/112357299/212027257-24d71be3-f55d-43e7-af0a-a849efd32d7f.jpg" width="1000"/>

### 구매자) 구매페이지(상품상세페이지)
<img src="https://user-images.githubusercontent.com/112357299/212027329-ead43602-a7d6-4812-9604-50836138c4bd.jpg" width="1000"/>

### 구매자) 구매하기
<img src="https://user-images.githubusercontent.com/112357299/212027336-ae8c4fd8-2659-4862-8487-2896f85ece59.jpg" width="1000"/>

### 구매자) 구매후 상품목록
<img src="https://user-images.githubusercontent.com/112357299/212027497-fc8803b5-dae4-4760-acf8-023de88cbe80.jpg" width="1000"/>

### 구매자) 구매후 상품구매목록
<img src="https://user-images.githubusercontent.com/112357299/212027624-5ee837fb-2be1-4617-86ac-46a59b34c285.jpg" width="1000"/>

### 로그인-관리자로그인
<img src="https://user-images.githubusercontent.com/112357299/212027738-fd273cee-c0c4-4e19-bf4a-db00c94a26e6.jpg" width="1000"/>

### 관리자) 메인페이지(상품목록페이지)
<img src="https://user-images.githubusercontent.com/112357299/212027906-1d3638bd-7510-45cb-aa2b-2339e1b4cac6.jpg" width="1000"/>
<img src="https://user-images.githubusercontent.com/112357299/212027919-48cecc67-84c5-4ad3-a847-21cb6705c365.jpg" width="1000"/>

### 관리자) 메인페이지>상품관리페이지 이동
<img src="https://user-images.githubusercontent.com/112357299/212028168-d0850cae-a828-4cf6-982d-925bc1369c2e.jpg" width="1000"/>

### 관리자) 상품관리페이지(상품상세페이지)
<img src="https://user-images.githubusercontent.com/112357299/212028855-09f073e0-32bc-4ee9-87b5-d39534a890bc.jpg" width="1000"/>

### 관리자) 상품관리페이지>상품수정페이지 이동
<img src="https://user-images.githubusercontent.com/112357299/212029010-712b62e9-a2e9-4e9b-bbfe-bb20894ed81c.jpg" width="1000"/>

### 관리자) 상품수정페이지
<img src="https://user-images.githubusercontent.com/112357299/212029094-a243b9d9-72cb-423a-b1ae-d5bbeea26dc6.jpg" width="1000"/>
<img src="https://user-images.githubusercontent.com/112357299/212029104-686d94d7-d20c-428f-aaa9-76c81740a2bb.jpg" width="1000"/>

### 관리자) 상품수정후 상품목록
<img src="https://user-images.githubusercontent.com/112357299/212029161-d3b434b2-3888-4c7e-8303-3b6b7cded3a6.jpg" width="1000"/>

### 관리자) 상품등록페이지
<img src="https://user-images.githubusercontent.com/112357299/212029335-e84c62d2-1aeb-44e9-b229-12474534e994.jpg" width="1000"/>

### 관리자) 상품등록-상품명중복확인
<img src="https://user-images.githubusercontent.com/112357299/212029466-45100f02-d141-481f-9420-71ffad062ea5.jpg" width="1000"/>
<img src="https://user-images.githubusercontent.com/112357299/212029472-5f9f8aa2-d9c5-47d3-816f-051c6018a755.jpg" width="1000"/>

### 관리자) 상품등록
<img src="https://user-images.githubusercontent.com/112357299/212029758-66d651db-aca6-4869-9d34-0281a8c9337b.jpg" width="1000"/>

### 관리자) 상품등록후 상품목록
<img src="https://user-images.githubusercontent.com/112357299/212029896-021e521a-f5b4-47d4-b67e-96bbe83f8b13.jpg" width="1000"/>

### 관리자) 회원주문목록페이지(전체주문목록)
<img src="https://user-images.githubusercontent.com/112357299/212029977-444d3552-99c2-4e72-af32-7c02c42d4ad9.jpg" width="1000"/>
<img src="https://user-images.githubusercontent.com/112357299/212029979-690701a3-8fd2-44c7-b6c0-fb6da0a64a69.jpg" width="1000"/>

### 관리자) 회원주문목록페이지(오늘주문목록)
<img src="https://user-images.githubusercontent.com/112357299/212029982-473619c9-859d-4293-90a4-c213b910258c.jpg" width="1000"/>

### 관리자) 회원목록페이지(전체회원목록)
<img src="https://user-images.githubusercontent.com/112357299/212029984-0588de6d-b856-45c0-a9a7-dd74672690a0.jpg" width="1000"/>
<img src="https://user-images.githubusercontent.com/112357299/212029987-d5ac56c5-1e12-4df1-ad1b-cbed0bec1bd5.jpg" width="1000"/>

### 관리자) 회원목록페이지(손님회원목록)
<img src="https://user-images.githubusercontent.com/112357299/212029988-18a7a0fa-e4d6-47f8-ba61-ab826a12e295.jpg" width="1000"/>

### 관리자) 회원목록페이지>회원수정페이지 이동
<img src="https://user-images.githubusercontent.com/112357299/212029990-c1439d21-48fc-48d4-9190-f65dec2500c9.jpg" width="1000"/>

### 관리자) 회원수정페이지
<img src="https://user-images.githubusercontent.com/112357299/212029992-71117d54-98be-4388-a4e3-26ddbaf27f33.jpg" width="1000"/>

### 관리자) 회원수정
<img src="https://user-images.githubusercontent.com/112357299/212029993-e6cf1024-fe80-47ac-9f52-5949c3cd4441.jpg" width="1000"/>

### 관리자) 회원수정후 회원목록
<img src="https://user-images.githubusercontent.com/112357299/212029996-ce0306b3-4c4f-45f7-bdbc-506b72d95235.jpg" width="1000"/>
<img src="https://user-images.githubusercontent.com/112357299/212029998-3b5dd67c-7aad-4c09-b320-40299b0e5d70.jpg" width="1000"/>

### 로그아웃
<img src="https://user-images.githubusercontent.com/112357299/212030000-cb57254f-ee89-484e-a3df-44df78d8b6f2.jpg" width="1000"/>
<img src="https://user-images.githubusercontent.com/112357299/212030002-4e393854-79d5-437b-9de6-2140807f5ecb.jpg" width="1000"/>

-----------------------------------------------------------------------------------------------------------