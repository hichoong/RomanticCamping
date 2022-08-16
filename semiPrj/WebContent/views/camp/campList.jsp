<%@page import="com.kh.camplist.theme.vo.ThemeVo"%>
<%@page import="java.util.List"%>
<%@page import="com.kh.camplist.hashtag.vo.HashTagVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	
	List<HashTagVo> hashTagList = (List<HashTagVo>) request.getAttribute("hashTagList");
	List<String> checkedHashCodes = (List<String>) request.getAttribute("checkedHashCodes");
	List<ThemeVo> themeList = (List<ThemeVo>) request.getAttribute("themeList");

%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>낭만캠핑</title>
	<link rel="stylesheet" href="/semiPrj/resource/css/campList.css">
</head>
<body>
	
	<%@include file="/views/common/header.jsp" %>
	
    <div class="container">
        <section>
            <div id="search-box">
              
              <!-- 새로고침,서브밋 했을 때 검색내용 유지기능 필요  -->
              <form class="search-form" action="<%=contextPath %>/camp/campList" method="get">
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
	                        <%for(ThemeVo vo : themeList) { %>
                         		<input type="radio" name="theme" value="<%=vo.getThemeCode()%>" id="<%=vo.getThemeCode()%>"><label for="<%=vo.getThemeCode()%>"><%=vo.getThemeName()%></label><br>
							<%} %>
                        </td>
                      </tr>
                    </table>
                  </div>
                

                    <div class="hashtag">
                      <button type="button" class="btn btn-warning">+해시태그</button>
                    </div>
                    
                    <div class="hashtag-list hide">
                      <ul class="tag-ul">
						<%for(HashTagVo vo : hashTagList) { %>
							<li>
								<input hashTagKey="<%=vo.getHtCode()%>" type="hidden" name="hashTag" disabled="disabled" value="<%=vo.getHtCode()%>">
								<button hashTagKey="<%=vo.getHtCode()%>" type="button" class="tag-btn" ><%=vo.getHtName()%></button>
							</li>
						<%} %>
						
                      </ul>
                    </div>
                    <input type="submit" value="search" class="btn btn-warning">
              </form>
                
            </div>

            <div class="camp-list">
               
                

                  <div class="card mb-3" style="max-width: 800px;" onclick="location.href='<%=contextPath %>/views/camp/campZoneList.jsp'">
                    <div class="row no-gutters">
                      <div class="col-md-4">
                        <img src="<%=contextPath %>/resource/img/test.jpg" class="card-img" alt="캠핑장 대표이미지">
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
                        <img src="<%=contextPath %>/resource/img/test.jpg" class="card-img" alt="캠핑장 대표이미지">
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
                        <img src="<%=contextPath %>/resource/img/test.jpg" class="card-img" alt="캠핑장 대표이미지">
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
                        <img src="<%=contextPath %>/resource/img/test.jpg" class="card-img" alt="캠핑장 대표이미지">
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
                        <img src="<%=contextPath %>/resource/img/test.jpg" class="card-img" alt="캠핑장 대표이미지">
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

  	<script src="<%=contextPath %>/resource/js/campList.js"></script>
</body>
</html>