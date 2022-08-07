<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에약하기</title>
<style>
	#container{
		margin: auto;
		margin-top: 50px;
		border: 1px solid black;
		width: 80%;
		height: 100%;
		background-color: lightgrey;
		
	}
	#camp-notice{
		display: flex;
		justify-content: space-between;;
		margin-top: 100px; 
		margin-left: auto;
		margin-right: auto;
		border: 1px solid white;
		width: 80%;
		height: 300px;
	}
	#camp-notice div{
		text-align: center;
		margin-top: 50px;
		display: inline-block;
		border: 1px solid black;
		width: 200px;
		height: 200px;
	}
	#user-notice{
		border: 1px solid white;
		text-align: center;
		margin-left: auto;
		margin-right: auto;
		width: 80%;
		margin-top: 50px;
	}
	#notice-table{
		margin-top: 50px;
		margin-left: auto;
		margin-right: auto;
		width: 500px;
		height: 200px;
		
	}
	#cancle-notice{
		border: 1px solid white;
		width: 80%;
		text-align: center;
		margin-top: 50px;
		margin-left: auto;
		margin-right: auto;
	}
	#cancle-table{
		border: 1px solid white;
		margin-top: 50px;
		margin-left: auto;
		margin-right: auto;
		font-size: 25px;
	}
	#order-notice{
		border: 1px solid white;
		margin-top: 50px;
		margin-left: auto;
		margin-right: auto;
		width: 80%;
		text-align: center;
		
	}
	#order-notice2{
		margin-top: 50px;
	}
	#order-notice3{
		margin-top: 50px;
	}
</style>
</head>

<body>
	<%@ include file="/views/common/header.jsp" %>

​​​	<h1 align="center">결제하기</h1>
	
	<form action="" method="post">
	<div  id="container">
		<div id="camp-notice">
			<div>이미지</div>
			<div>상품내용</div>
			<div>상품가격</div>
		</div>
		<!--예약자 정보  -->
		<div id="user-notice">
			<h1>예약자 정보</h1>
			<table id="notice-table">
				<tr>
					<td>이름</td>
					<td><input type="text" maxlength="10" width="200px" ></td> 
				</tr>
				<tr>
					<td>연락처</td>
					<td><input type="tel" > </td>
				</tr>
				<tr>
					<td>배송주소</td>
					<td><input type="text" > </td>
				</tr>
				<tr>
					<td>이메일 </td>
					<td><input type="email"> </td>
				</tr>
				<tr>
					<td>요청사항</td>
					<td><input type="text"> </td>
				</tr>
			</table>
		</div>
		<!--취소환불  -->
		<div id="cancle-notice">
			<h1>취소/환불 규정에 대한 동의</h1>
			<table id="cancle-table">
				<tr>
					<td>이용 4일 전까지</td> 
					<td>취소 수수료 없음</td> 
				</tr>
				<tr>
					<td>이용 3일 전</td>
					<td>총결제금액의 10% 차감</td>
				</tr>
				<tr>
					<td>이용 2일 전</td>
					<td>총결제금액의 20% 차감</td>
				</tr>
				<tr>
					<td>이용 1일 전</td>
					<td>총결제금액의 50% 차감</td>
				</tr>
				<tr>
					<td>이용 당일</td>
					<td>환불 불가능</td>
				</tr>
				<tr>
					<td colspan="2">동의합니다.<input type="checkbox" value="" required></td>
				</tr>
			</table>
		</div>
		
		
		<!--결제수단  -->
		<div id="order-notice">
				<div id="order-notice2">
					결제방법
					<select name="option">
			   			<option value="transper">계좌이체</option>
			    		<option value="card">카드결제</option>
					</select>
				</div>
					
				<div id="order-notice3">
					<input type="submit" value="결제하기">
				</div>
		
		</div>
	</form> <!--결제에 대한 post  -->
	</div>	<!--#container div-->
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	<%@ include file="/views/common/footer.jsp" %>
</body>
</html>