<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<!DOCTYPE html>
		<html lang="ko">

		<head>
			<meta charset="UTF-8">
			<meta http-equiv="X-UA-Compatible" content="IE=edge">
			<meta name="viewport" content="width=device-width, initial-scale=1.0">
			<title>쇼핑몰 관리</title>
			<!------ admin - layout ------>
			<link href="/css/admin/layout/reset.css" rel="stylesheet">
			<link href="/css/admin/layout/header.css" rel="stylesheet">
			<link href="/css/admin/layout/footer.css" rel="stylesheet">
			<!------ admin - product ------>
			<link href="/css/admin/product/add.css" rel="stylesheet">
			<link href="/css/admin/product/detail.css" rel="stylesheet">
			<link href="/css/admin/product/list.css" rel="stylesheet">
			<link href="/css/admin/product/edit.css" rel="stylesheet">
			<!------ admin - orders ------>
			<link href="/css/admin/orders/all.css" rel="stylesheet">
			<link href="/css/admin/orders/today.css" rel="stylesheet">
			<!------ admin - account ------>
			<link href="/css/admin/account/users.css" rel="stylesheet">
			<link href="/css/admin/account/customers.css" rel="stylesheet">
			<link href="/css/admin/account/edit.css" rel="stylesheet">
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
		</head>

		<body>
			<!------.header시작------>
			<header class="header">
				<div class="header_menu">
					<span>《관리자모드》</span>
					<a href="/admin/product/add">상품등록</a>
					<a href="/admin/product">상품목록</a>
					<a href="/admin/order/all">주문목록</a>
					<a href="/admin/user">회원목록</a>
					<a href="/logout">로그아웃</a>
				</div>
			</header>
			<!------.header끝------>