<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<!DOCTYPE html>
		<html lang="ko">

		<head>
			<meta charset="UTF-8">
			<meta http-equiv="X-UA-Compatible" content="IE=edge">
			<meta name="viewport" content="width=device-width, initial-scale=1.0">
			<title>쇼핑몰</title>
			<!------ user - layout ------>
			<link href="/css/user/layout/reset.css" rel="stylesheet">
			<link href="/css/user/layout/header.css" rel="stylesheet">
			<link href="/css/user/layout/footer.css" rel="stylesheet">
			<!------ user - product ------>
			<link href="/css/user/product/list.css" rel="stylesheet">
			<link href="/css/user/product/detail.css" rel="stylesheet">
			<!------ user - orders ------>
			<link href="/css/user/orders/list.css" rel="stylesheet">
			<!------ user - account ------>
			<link href="/css/user/account/login.css" rel="stylesheet">
			<link href="/css/user/account/join.css" rel="stylesheet">
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
		</head>

		<body>
			<!------.header시작------>
			<header class="header">
				<div class="header_menu">
					<c:choose>
						<c:when test="${empty principal}">
							<a href="/">홈</a>
							<a href="/join">회원가입</a>
							<a href="/login">로그인</a>
						</c:when>
						<c:otherwise>
							<span>《손님모드》</span>
							<a href="/product">상품목록</a>
							<a href="/product/order">구매목록</a>
							<a href="/logout">로그아웃</a>
						</c:otherwise>
					</c:choose>
				</div>
			</header>
			<!------.header끝------>