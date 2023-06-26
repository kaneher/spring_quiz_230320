<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기상청 날씨정보</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
</head>
<body>
	<div id="wrap" class="container">
		<section class="contents d-flex">
			<nav class="bg-primary col-2">
				<ul class="nav flex-column">
					<li class="nav-item">
						<img src="/image/KMA.jpg" alt="기상청 로고" width="100">
					</li>
					<li>
						<a class="nav-link text-info" href="#">날씨</a>
					</li>
					<li>
						<a class="nav-link text-info" href="#">날씨입력</a>
					</li>
					<li class="text-info">
						테마날씨
					</li>
					<li class="text-info">
						관측기후
					</li>
				</ul>
			</nav>
			<article class="col-10">
				<h1>과거 날씨</h1>
				<table class="table text-center">
					<thead>
						<tr>
							<th>날짜</th>
							<th>날씨</th>
							<th>기온</th>
							<th>강수량</th>
							<th>미세먼지</th>
							<th>풍속</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${weatherHistory}" var="wh">
						<tr>
							<td>${wh.date}</td>
							<td>${wh.weather}</td>
							<td>${wh.temperatures}</td>
							<td>${wh.precipitation}</td>
							<td>${wh.microDust}</td>
							<td>${wh.windSpeed}</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</article>
		</section>
		<footer class="d-flex">
			<img src="/image/KMA.jpg" alt="기상청 로고" width="100">
		</footer>
	</div>
</body>
</html>