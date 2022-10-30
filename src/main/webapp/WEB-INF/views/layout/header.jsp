<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>상품관리</title>
    <link href="/css/reset.css" rel="stylesheet">
    <link href="/css/header.css" rel="stylesheet">
    <link href="/css/footer.css" rel="stylesheet">
    <link href="/css/add.css" rel="stylesheet">
	<link href="/css/detail.css" rel="stylesheet">
	<link href="/css/edit.css" rel="stylesheet">
	<link href="/css/list.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<!------.header시작------>
	<header class="header">
		<div class="header_menu">
			<a href="/product/add">상품등록</a>
			<a href="/product/list">상품목록</a>
		</div>
	</header>
	<!------.header끝------>