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
		<h1>즐겨찾기 추가하기</h1>
		
		<div>
			<label for="subject"><b>제목</b></label>
			<input type="text" id="subject" name="subject" class="form-control col-8 mb-3" placeholder="제목을 입력하세요.">
			<label for="address"><b>주소</b></label>
			<input type="text" id="address" name="address" class="form-control col-8 mb-3" placeholder="주소를 입력하세요.">
			<input type="button" id="addBtn" class="btn btn-success col-8" value="추가">
		</div>
	</div>
	
<script>
	$(document).ready(function() {
		$('#addBtn').on('click', function() {
			// alert("클릭");
			
			// validation
			let subject = $('#subject').val().trim();
			if (!subject) {
				alert("제목을 입력하세요.");
				return;
			}
			
			let address = $('#address').val().trim();
			if (!address) {
				alert("주소를 입력하세요.");
				return;
			}
			if (!(address.startsWith('http') || address.startsWith('https'))) {
				alert("주소는 http나 https로 시작해야 합니다.");
				return;
			}
			
			$.ajax({
				// request
				type:"post"
				, url:"/lesson06/quiz01/add_sites"
				, data:{"subject":subject, "address":address}
				
				// response
				, success:function(data) {
					if (data == "추가 성공!!!") {
						location.href = "/lesson06/quiz01/after_add_sites_view";
					} else {
						alert("즐겨찾기 추가에 실패했습니다.");
					}
				}
			});
		});
	});
</script>
</body>
</html>