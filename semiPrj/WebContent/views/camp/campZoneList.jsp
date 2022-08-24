<%@page import="com.kh.campzonelist.campzone.vo.CampZoneVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    List<CampZoneVo> zoneList = (List<CampZoneVo>)request.getAttribute("zoneList");    
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>낭만캠핑</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/campZoneList.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/memberCommon.css">
</head>
<body>

	<%@ include file = "/views/common/header.jsp" %>
	
    <div class="container">
        <section>
            <div id="info-box">
              <div class="camp-name">${campInfoVo.campName}</div>
              <img id="camp-zone-img" src="<%=contextPath%>/resource/img/test.jpg" alt="캠핑장 대표 이미지">
              <div id="camp-addr">${campInfoVo.city} ${campInfoVo.district} ${campInfoVo.campAddress}</div>  
              <div id="camp-phone">${campInfoVo.campPhone}</div>
	          <c:if test="${not empty loginMember}">
	          	<div align="center">       		
		          	<button id="doFav" class="basic-btn" onclick="setFav();">찜하기</button>
	          		<button id="cancleFav" class="basic-btn" onclick="deleteFav();">찜취소</button>
		         </div>
	          </c:if>
            </div>

            <div class="camp-list">
            
            	<c:choose>
            		<c:when test="${not empty zoneList}">
            			<%for(CampZoneVo z : zoneList){ %>
		                 <div class="card mb-3" style="max-width: 800px;" onclick="location.href='<%=contextPath %>/camp/detail?campCode=${campInfoVo.campCode}&zoneNo=<%=z.getZoneNo()%>'">
		                    <div class="row no-gutters">
		                      <div class="col-md-4">
		                        <img src="<%=contextPath %>/resource/img/test.jpg" class="card-img" alt="캠핑장 구역이미지">
		                      </div>
		                      <div class="col-md-8">
		                        <div class="card-body">
		                          <div class="zone-info">
		                            <h5 class="card-title"><%=z.getZoneName() %></h5>
		                            <p class="card-text">최대인원 <%=z.getZoneNor() %></p>
		                            <p class="card-text"><small class="text-muted"></small></p>
		                          </div>
		                          <div class="zone-price">\<%=z.getZonePrice() %></div>
		                        </div>
		                      </div>
		                    </div>
		                </div>
		                <%} %>
            		</c:when>
            		
            		<c:when test="${empty zoneList}">
						<div id="none-zone">구역 정보가 존재하지 않습니다.</div>            			
            		</c:when>
            	</c:choose>
            	 
            </div>
        </section>

    </div>
    
    <%@include file="/views/common/footer.jsp" %>
    
    <script>
    
	    function setFav() {
			var code = ${campInfoVo.campCode};
			
			$.ajax({
				url : "<%=contextPath%>/member/setFavorite",
				method : "GET",
				data : {campCode : code},
				success : function(data){ 
					if(data == 'T'){
						$("#doFav").css('display','none');
						$("#cancleFav").css('display','block');
					} else {
						alert("오류가 발생했습니다. 나중에 다시 시도해주세요.")
					}
				},
				error : function(eee){
					alert("오류가 발생했습니다. 나중에 다시 시도해주세요.");
				}
			});
		}
    
	    function deleteFav() {
	    	var code = ${campInfoVo.campCode};
	    	
	    	$.ajax({
				url : "<%=contextPath%>/member/deleteFavorite",
				method : "POST",
				data : {campCode : code},
				success : function(data){ 
					if(data == 'T'){
						$("#cancleFav").css('display','none');
						$("#doFav").css('display','block');
					} else {
						alert("오류가 발생했습니다. 나중에 다시 시도해주세요.")
					}
				},
				error : function(eee){
					alert("오류가 발생했습니다. 나중에 다시 시도해주세요.");
				}
			});
		}
	    
	    $(function(){
	    	var check = ${check};
	    	
	    	if(check == 0) {
	    		$("#doFav").css('display','block');
				$("#cancleFav").css('display','none');
	    	} else if(check == 1) {
				$("#doFav").css('display','none');
	    		$("#cancleFav").css('display','block');
	    	} else {
	    		$("#doFav").css('display','none');
				$("#cancleFav").css('display','none');
	    	}
	    });
    </script>
    
</body>
</html>