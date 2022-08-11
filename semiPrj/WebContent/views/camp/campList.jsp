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
	<title>낭만캠핑</title>
	<link rel="stylesheet" href="../../resource/css/campList.css">
</head>
<body>
	
	<%@include file="/views/common/header.jsp" %>
	
    <div class="container">
        <section>
            <div id="search-box">
              
              <form class="search-form" action="" method="get">
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
                          <input type="checkbox" name="theme" value="island" id="island"><label for="island">섬</label><br>
                          <input type="checkbox" name="theme" value="beach" id="beach"><label for="beach">해변</label><br>
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
                    
                    <div class="hashtag-list hide">
                      <ul class="tag-ul">

                        <li><input id="pet" type="hidden" name="hashtag" disabled value="반려견동반"></li>
                        <li><input id="trail" type="hidden" name="hashtag" disabled value="둘레길"></li>
                        <li><input id="relax" type="hidden" name="hashtag" disabled value="여유있는"></li>
                        <li><input id="spring" type="hidden" name="hashtag" disabled value="봄"></li>
                        <li><input id="winter" type="hidden" name="hashtag" disabled value="겨울"></li>
                        <li><input id="summer" type="hidden" name="hashtag" disabled value="여름"></li>
                        <li><input id="fall" type="hidden" name="hashtag" disabled value="가을"></li>
                        <li><input id="family" type="hidden" name="hashtag" disabled value="가족"></li>
                        <li><input id="couple" type="hidden" name="hashtag" disabled value="연인"></li>
                        <li><input id="extreme" type="hidden" name="hashtag" disabled value="익스트림"></li>
                        <li><input id="healing" type="hidden" name="hashtag" disabled value="힐링"></li>
                        <li><input id="comfy" type="hidden" name="hashtag" disabled value="편한"></li>
                        <li><input id="star" type="hidden" name="hashtag" disabled value="별"></li>
                        <li><input id="water" type="hidden" name="hashtag" disabled value="물"></li>
                        <li><input id="culture" type="hidden" name="hashtag" disabled value="문화"></li>
                        <li><input id="camper" type="hidden" name="hashtag" disabled value="캠핑카"></li>
                        <li><input id="waterplay" type="hidden" name="hashtag" disabled value="물놀이"></li>
                        <li><input id="shade" type="hidden" name="hashtag" disabled value="그늘"></li>
                        <li><input id="ecology" type="hidden" name="hashtag" disabled value="생태교육"></li>
                        <li><input id="beach" type="hidden" name="hashtag" disabled value="바닷가"></li>
                        <li><input id="festival" type="hidden" name="hashtag" disabled value="축제"></li>
                        <li><input id="pool" type="hidden" name="hashtag" disabled value="수영장"></li>
                        <li><input id="bicycle" type="hidden" name="hashtag" disabled value="자전거"></li>
                        <li><input id="walk" type="hidden" name="hashtag" disabled value="산책"></li>

                        <li><button type="button" class="tag-btn" id="pet">#반려견동반</button></li>
                        <li><button type="button" class="tag-btn" id="trail">#둘레길</button></li>
                        <li><button type="button" class="tag-btn" id="relax">#여유있는</button></li>
                        <li><button type="button" class="tag-btn" id="spring">#봄</button></li>
                        <li><button type="button" class="tag-btn" id="winter">#겨울</button></li>
                        <li><button type="button" class="tag-btn" id="summer">#여름</button></li>
                        <li><button type="button" class="tag-btn" id="fall">#가을</button></li>
                        <li><button type="button" class="tag-btn" id="family">#가족</button></li>
                        <li><button type="button" class="tag-btn" id="couple">#연인</button></li>
                        <li><button type="button" class="tag-btn" id="extreme">#익스트림</button></li>
                        <li><button type="button" class="tag-btn" id="healing">#힐링</button></li>
                        <li><button type="button" class="tag-btn" id="comfy">#편한</button></li>
                        <li><button type="button" class="tag-btn" id="star">#별</button></li>
                        <li><button type="button" class="tag-btn" id="water">#물</button></li>
                        <li><button type="button" class="tag-btn" id="culture">#문화</button></li>
                        <li><button type="button" class="tag-btn" id="camper">#캠핑카</button></li>
                        <li><button type="button" class="tag-btn" id="waterplay">#물놀이</button></li>
                        <li><button type="button" class="tag-btn" id="shade">#그늘</button></li>
                        <li><button type="button" class="tag-btn" id="ecology">#생태교육</button></li>
                        <li><button type="button" class="tag-btn" id="beach">#바닷가</button></li>
                        <li><button type="button" class="tag-btn" id="festival">#축제</button></li>
                        <li><button type="button" class="tag-btn" id="pool">#수영장</button></li>
                        <li><button type="button" class="tag-btn" id="bicycle">#자전거</button></li>
                        <li><button type="button" class="tag-btn" id="walk">#산책</button></li>

                      </ul>
                    </div>
  
                    <input type="submit" value="search" class="btn btn-warning">
              
              </form>
                
            </div>

            <div class="camp-list">
               
                

                  <div class="card mb-3" style="max-width: 800px;" onclick="location.href='campZoneList.jsp'">
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
                
                <ul class="pagination mt-4">
	                <li class="page-item"><a class="page-link" href="#">Previous</a></li>
	                <li class="page-item"><a class="page-link" href="#">1</a></li>
	                <li class="page-item"><a class="page-link" href="#">2</a></li>
	                <li class="page-item"><a class="page-link" href="#">3</a></li>
	                <li class="page-item"><a class="page-link" href="#">Next</a></li>
                </ul>
	           	  
            </div>
        </section>

    </div>
    
    <%@include file="/views/common/footer.jsp" %>

  	<script src="../../resource/js/campList.js"></script>
</body>
</html>