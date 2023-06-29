<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>북마크 추가</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<%-- AJAX를 사용하려면 jquery 원본 필요 --%>
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1 class="text-center my-3">즐겨찾기 추가하기</h1>
		
		<div class="form-group">
			<label for="subject"><b>제목</b></label>
			<input type="text" id="subject" class="form-control mb-3" placeholder="제목을 입력하세요.">
			
			<label for="address"><b>주소</b></label>
			<div class="d-flex justify-content-center align-items-center mb-3">
				<input type="text" id="address" class="form-control col-11 mr-3" placeholder="주소를 입력하세요.">
				<button type="button" id="addressCheckBtn" class="btn btn-info col-1 px-0">중복확인</button>
			</div>
			
			<input type="button" id="addSitesBtn" class="btn btn-success mt-3 w-100" value="추가">
		</div>
	</div>
	
<script>
	$(document).ready(function() {
		$('#addSitesBtn').on('click', function() {
			// alert("클릭");
			
			// validation
			let subject = $('#subject').val().trim();
			let address = $('#address').val().trim();
			
			if (!subject) {
				alert("제목을 입력하세요.");
				return;
			}
			if (!address) {
				alert("주소를 입력하세요.");
				return;
			}
			if (address.startsWith('http://') == false && address.startsWith('https://') == false) {
				alert("주소 형식이 잘못 되었습니다.");
				return;
			}
			
			// AJAX 통신 => 서버 요청
			$.ajax({
				// request
				type:"post"
				, url:"/lesson06/quiz01/add_sites"
				, data:{"subject":subject, "address":address}
				
				// response
				, success:function(data) { // String, JSON => 자바스크립트의 객체 변환
					/* alert(data.code);
					alert(data.result); */
					
					if (data.result == "성공") {
						location.href = "/lesson06/quiz01/after_add_sites_view"; // GET method
					} else {
						alert("즐겨찾기 추가에 실패했습니다.");
					}
				}
				, error:function(request, status, error) {
					alert("즐겨찾기 추가하는데 실패했습니다.");
				}
			});
		});
	});
</script>
</body>
</html>