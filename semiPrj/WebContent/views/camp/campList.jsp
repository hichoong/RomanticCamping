<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	 <!-- Latest compiled and minified CSS -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<!-- Latest compiled JavaScript -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="../../resource/css/campList.css">
</head>
<body>
	
	<%@ include file = "/views/common/header.jsp" %>
	
    <div class="container">
        <section>
            <div id="search-box">
                
              <form class="form-inline my-2 my-lg-0" action="" method="get">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="keyword" >
                <div id="search-addr">
                  <select name="sido1" id="sido1"></select>
                  <select name="gugun1" id="gugun1"></select>
                </div>
                
              
                <div class="check-theme">
                  
                  <table>
                    <tr>
                      <td><h4>테마</h4></td>
                    </tr>
                    <tr>
                      <td>
                        <input type="checkbox" name="theme" value="beach" id="beach"><label for="beach">해변</label><br>
                        <input type="checkbox" name="theme" value="island" id="island"><label for="island">섬</label><br>
                        <input type="checkbox" name="theme" value="downtown" id="downtown"><label for="downtown">도심</label><br>
                        <input type="checkbox" name="theme" value="mountain" id="mountain"><label for="mountain">산</label>
                      </td>
                      <td>
                        <input type="checkbox" name="theme" value="forest" id="forest"><label for="forest">숲</label><br>
                        <input type="checkbox" name="theme" value="lake" id="lake"><label for="lake">호수</label><br>
                        <input type="checkbox" name="theme" value="valley" id="valley"><label for="valley">계곡</label><br> 
                        <input type="checkbox" name="theme" value="river" id="river"><label for="river">강</label>
                      </td>
                    </tr>
                  </table>
                </div>
              
                <div class="hashtag">
                  <button type="button" class="btn btn-warning">+해시태그</button>
                </div>
                
                <!-- 해시태그 노출 진행중 -->
                

                <div class="hashtag-list">
                  <ul class="tag-ul">
                    <li><input type="button" value="#반려견동반"></li>
                    <li><input type="button" value="#둘레길"></li>
                    <li><input type="button" value="#여유있는"></li>
                    <li><input type="button" value="#봄"></li>
                    <li><input type="button" value="#겨울"></li>
                    <li><input type="button" value="#여름"></li>
                    <li><input type="button" value="#가을"></li>
                    <li><input type="button" value="#가족"></li>
                    <li><input type="button" value="#연인"></li>
                    <li><input type="button" value="#익스트림"></li>
                    <li><input type="button" value="#힐링"></li>
                    <li><input type="button" value="#편한"></li>
                    <li><input type="button" value="#별"></li>
                    <li><input type="button" value="#물"></li>
                    <li><input type="button" value="#문화"></li>
                    <li><input type="button" value="#캠핑카"></li>
                    <li><input type="button" value="#물놀이"></li>
                    <li><input type="button" value="#그늘"></li>
                    <li><input type="button" value="#생태교육"></li>
                    <li><input type="button" value="#바다가"></li>
                    <li><input type="button" value="#축제"></li>
                    <li><input type="button" value="#수영장"></li>
                    <li><input type="button" value="#자전거"></li>
                    <li><input type="button" value="#산책"></li>
                  </ul>

                </div>

                <!-- <script>
                  $(function(){
                    $('input').click(function(){$(this).css('background',rgb(255, 218, 153))});
                  });
                </script> -->
                


                <input type="submit" value="search" class="btn btn-warning">
              
              
              </form>

                
            </div>

            <div class="camp-list">
               
                

                  <div class="card mb-3" style="max-width: 800px;">
                    <div class="row no-gutters">
                      <div class="col-md-4">
                        <img src="../../resource/img/test.jpg" class="card-img" alt="캠핑장 대표이미지">
                      </div>
                      <div class="col-md-8">
                        <div class="card-body">
                          <h5 class="card-title">캠핑장1</h5>
                          <p class="card-text">여유로움을 즐길 수 있는 캠핑장1 입니다</p>
                          <p class="card-text"><small class="text-muted">#여유 #힐링</small></p>
                        </div>
                      </div>
                    </div>
                </div>

                <div class="card mb-3" style="max-width: 800px;">
                    <div class="row no-gutters">
                      <div class="col-md-4">
                        <img src="logo.png" class="card-img" alt="캠핑장 대표이미지">
                      </div>
                      <div class="col-md-8">
                        <div class="card-body">
                          <h5 class="card-title">캠핑장1</h5>
                          <p class="card-text">여유로움을 즐길 수 있는 캠핑장1 입니다</p>
                          <p class="card-text"><small class="text-muted">#여유 #힐링</small></p>
                        </div>
                      </div>
                    </div>
                </div>

                <div class="card mb-3" style="max-width: 800px;">
                    <div class="row no-gutters">
                      <div class="col-md-4">
                        <img src="logo.png" class="card-img" alt="캠핑장 대표이미지">
                      </div>
                      <div class="col-md-8">
                        <div class="card-body">
                          <h5 class="card-title">캠핑장1</h5>
                          <p class="card-text">여유로움을 즐길 수 있는 캠핑장1 입니다</p>
                          <p class="card-text"><small class="text-muted">#여유 #힐링</small></p>
                        </div>
                      </div>
                    </div>
                </div>

                <div class="card mb-3" style="max-width: 800px;">
                    <div class="row no-gutters">
                      <div class="col-md-4">
                        <img src="logo.png" class="card-img" alt="캠핑장 대표이미지">
                      </div>
                      <div class="col-md-8">
                        <div class="card-body">
                          <h5 class="card-title">캠핑장1</h5>
                          <p class="card-text">여유로움을 즐길 수 있는 캠핑장1 입니다</p>
                          <p class="card-text"><small class="text-muted">#여유 #힐링</small></p>
                        </div>
                      </div>
                    </div>
                </div>

                <div class="card mb-3" style="max-width: 800px;">
                    <div class="row no-gutters">
                      <div class="col-md-4">
                        <img src="logo.png" class="card-img" alt="캠핑장 대표이미지">
                      </div>
                      <div class="col-md-8">
                        <div class="card-body">
                          <h5 class="card-title">캠핑장1</h5>
                          <p class="card-text">여유로움을 즐길 수 있는 캠핑장1 입니다</p>
                          <p class="card-text"><small class="text-muted">#여유 #힐링</small></p>
                        </div>
                      </div>
                    </div>
                </div>
            </div>
        </section>

    </div>

   <script src="../../resource/js/campList.js"></script>
</body>
</html>