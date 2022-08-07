<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의글 작성</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">

<style>

.modal {
  position: absolute;
  top: 0;
  left: 0;

  width: 100%;
  height: 100%;

  display: none;

  background-color: rgba(0, 0, 0, 0.4);
}

.modal.show {
  display: block;
}

.modal_body {
  position: absolute;
  top: 50%;
  left: 50%;

  width: 500px;
  height: 600px;

  padding: 40px;

  text-align: center;

  background-color: rgb(255, 255, 255);
  border-radius: 10px;
  box-shadow: 0 2px 3px 0 rgba(34, 36, 38, 0.15);

  transform: translateX(-50%) translateY(-50%);
}
.btn btn-warning{
	margin: auto;
	margin-top: 100px;
}

</style>
</head>
<body>
	<%@ include file="/views/common/header.jsp" %>

	<div class="modal">
		<div class="modal_body">

			<!-- 분류 선택 -->
			<select class="form-select" aria-label="Default select example">
				<option selected>문의 카테고리 선택</option>
				<option value="1">예약</option>
				<option value="2">회원</option>
				<option value="3">결제</option>
				<option value="3">기타</option>
			</select>

			<!-- 글 제목 / 글 내용 입력-->
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">제목 : </label>
				<input type="email" class="form-control" id="exampleFormControlInput1" placeholder="문의합니다.">
			  </div>
			  <div class="mb-3">
				<label for="exampleFormControlTextarea1" class="form-label">내용 : </label>
				<textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
			  </div>

			<!-- 파일 첨부 -->
			  <div class="mb-3">
				<label for="formFile" class="form-label"></label>
				<input class="form-control" type="file" id="formFile">
			  </div>

			<!-- 비밀번호 입력 -->
			<!-- <div class="row g-3 align-items-center">
				<div class="col-auto">
				  <label for="inputPassword6" class="col-form-label">Password : </label>
				</div>
				<div class="col-auto">
				  <input type="password" id="inputPassword6" class="form-control" aria-describedby="passwordHelpInline">
				</div>
				<div class="col-auto">
				  <span id="passwordHelpInline" class="form-text">
					게시글 비밀번호를 입력하세요
				  </span>
				</div>
			  </div> -->

			<button type="submit" class="btn btn-warning">작성하기</button>
		</div>
	</div>
	<button class="btn-open-popup">나는 나중에 작성하기가 될거야^^</button>



	<script>
		const modal = document.querySelector('.modal');
		const btnOpenPopup = document.querySelector('.btn-open-popup');

		btnOpenPopup.addEventListener('click', () => {
		  modal.style.display = 'block';
		});

		// modal.classList.toggle('show');

	</script>

	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">

	<%@ include file="/views/common/footer.jsp" %>
</body>
</html>