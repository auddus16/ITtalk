<%@page import="itTalkDO.B"%>
<%@page import="itTalkDAO.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="test" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="DAO" class="itTalkDAO.MyPageDAO"/>
<%
	String mb= (String)session.getAttribute("mb_id");
	String ad= (String)session.getAttribute("ad_id");
%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>ITtalk</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="https://fonts.googleapis.com/css?family=Quicksand:300,400,500,700,900" rel="stylesheet">
    <link rel="stylesheet" href="fonts/icomoon/style.css">

    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/jquery-ui.css">
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">

    <link rel="stylesheet" href="css/jquery.fancybox.min.css">

    <link rel="stylesheet" href="css/bootstrap-datepicker.css">

    <link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">

    <link rel="stylesheet" href="css/aos.css">

    <link rel="stylesheet" href="css/style.css">
 <script type="text/javascript">
function report(v){
	window.open("report.jsp?b_no="+v,"_blank","titlebar=no,location=no,scrollbars=no,resizeable=no,menubar=no,toolbar=no,width=600,height=350"
	//어떤 페이지를 어떻게 띄울지 옵션
);
}
function report2(v){
	window.open("report2.jsp?c_no="+v,"_blank","titlebar=no,location=no,scrollbars=no,resizeable=no,menubar=no,toolbar=no,width=600,height=350"
	//어떤 페이지를 어떻게 띄울지 옵션
);
}
</script>   
  </head>
  <body data-spy="scroll" data-target=".site-navbar-target" data-offset="300">
  
    <test:topbar/> <!-- 로그인/로그아웃, 아이콘 커스텀태그 -->
	<!-- 게시글시작 -->
    <section class="site-section">
        <div class="comment-form-wrap pt-5"  style="margin:25%; margin-top:0; margin-bottom:0;">
            <div><a href="cate.do?bc_no=${write.bc_no}">&gt;&gt;${write_cate}</a></div><!-- 카테고리명 넣어주세요 -->
            <h3>${write.b_title}</h3>
            <div>
            <c:choose>
			<c:when test="${DAO.Info(write.mb_no).mb_job eq true }">
				<img src="images/user2.png" width="20" height="20" alt="개발">
			</c:when>            
            <c:otherwise>
            	<img src="images/user1.png" width="20" height="20" alt="예비">
            </c:otherwise>
            </c:choose>
            ${write_nick} &nbsp; ${write.b_date} &nbsp; <img src="images/eye.png" width="20" height="20" alt="조회수">${write.b_hits}&nbsp;&nbsp;</div><!-- 작성자닉네임, 등록날짜, 조회수 넣어주세요 -->
              <hr>
                  <div class="form-group">
                    <label for="message"></label>
					<c:choose>
						
						<c:when test="${write.b_deleted eq true}">
							<c:choose>
							<c:when test="${sessionScope.ad_id != null }">
							<img src="${write.b_file}"/>	
 	                   <textarea name="b_write" id="message" cols="30" rows="10" class="form-control" disabled>${write.b_write}</textarea>
							</c:when>
							<c:otherwise>
							
 	                   <textarea name="b_write" id="message" cols="30" rows="10" class="form-control" disabled>신고되어 블라인드처리 되었습니다.</textarea>
							</c:otherwise>
							</c:choose>
						</c:when>
						
						<c:when test="${write.b_file == null}">
 	                   <textarea name="b_write" id="message" cols="30" rows="10" class="form-control" disabled>${write.b_write}</textarea>
						</c:when>
						
						<c:otherwise>
						<img src="${write.b_file}"/>	
                    	<textarea name="b_write" id="message" cols="30" rows="10" class="form-control" disabled>${write.b_write}</textarea>
						</c:otherwise>
					
					</c:choose>	
                 
                  </div>
                  
                  <div style="float:right;">
                  <!-- 본인게시글이라면, 삭제, 수정 버튼 보임(활성화) -->
                  <!-- session에 저장된 id와 해당게시글의 id가 같은지-->
                  <% 
                  		int mb_no =((B)(request.getAttribute("write"))).getMb_no();
	                  	
                  		if(mb == null){
	                  		if(ad != null){
		                  		out.println("<a href='delete.do?b_no="+((B)(request.getAttribute("write"))).getB_no()+"'>삭제</a>&nbsp;<a href='UpdateMsg.do?b_no="+((B)(request.getAttribute("write"))).getB_no()+"'>수정</a>");
	                  			
	                  		}
	                  	}
	                  	else{
		                  	if(DAO.getMb_no(mb)==mb_no){
		                  		out.println("<a href='delete.do?b_no="+((B)(request.getAttribute("write"))).getB_no()+"'>삭제</a>&nbsp;<a href='UpdateMsg.do?b_no="+((B)(request.getAttribute("write"))).getB_no()+"'>수정</a>");
		                  	}
	                  		
	                  	}
                  		                  		
                  %>
					
              &nbsp;<a href="favorite.do?b_no=${write.b_no}"><img src="images/like.png" width="27" height="27" alt="좋아요">좋아요</a><!-- 좋아요 기능 컨롤 링크 연결 -->
              &nbsp;<a href="javascript:report(${write.b_no});"><img src="images/siren.png" width="25" height="25" alt="신고">신고</a><!-- 신고 기능->report.jsp로 연결됨. -->
                  </div>
               &nbsp;<a href="#"><img src="images/reply.png" width="25" height="25" alt="댓글수">${write.b_cnt}</a><!-- 댓글수 -->
                </div>
 	
 	<!-- 댓글 작성 폼 시작 -->
        <div class="comment-form-wrap pt-5"style="margin:25%; margin-top:0; margin-bottom:0;">
              <hr>
              <div style="">
                <form action="Newreply.do"><!-- 컨롤링크 연결 -> 신고버튼 때문-->
                    <input type="hidden" name="b_no" value="${write.b_no}">
                    <label for="message">댓글작성</label><!--닉네임 적어주세요-->
                    <textarea name="c_write" id="message" cols="2" rows="2" class="form-control" required></textarea>
                    <label><input type="checkbox" name="secret" value="1">비밀댓글</label>
                    <input type="submit" value="등록" class="btn btn-primary btn-md text-white" style="float:right;">
                    
                </form>
                  </div>
                  </div>
	
 	<!-- 댓글작성 끝 -->
 	
 	 	<!-- 댓글 시작 -->
        <div class="comment-form-wrap pt-5"style="margin:25%; margin-top:0; margin-bottom:0;">
              <hr>
              <!-- forEach 댓글 출력 부분 -->
              <c:forEach var="v" items="${replyList}" varStatus="status">
              <div>
                <form action="#" class=""><!-- 컨롤링크 연결 -->
                    <!-- 삭제 버튼도 위와 동일하게 처리해야함 ->본인댓글 삭제-->
                    <!--  (본인댓글이 아닌)비밀댓글을 만났을때 블라인드처리
                    <input type="submit" value="삭제" class="btn btn-primary btn-md text-white" style="float:right;"> -->
                 <c:choose>
                    <c:when test="${v.c_secret eq true}">
                    
                    <c:choose>
                    	<c:when test="${sessionScope.mb_no eq v.mb_no}">
				                 <c:choose>
							<c:when test="${DAO.Info(v.mb_no).mb_job eq true }">
								<img src="images/user2.png" width="20" height="20" alt="개발">
							</c:when>            
				            <c:otherwise>
				            	<img src="images/user1.png" width="20" height="20" alt="예비">
				            </c:otherwise>
				            </c:choose>
                    	
                    		<label for="message">${DAO.Info(v.mb_no).mb_nick}</label>
	                    <textarea id="message" cols="1" rows="1" class="form-control" disabled>${v.c_write}</textarea>
                    	</c:when>
                    	
                    	<c:when test="${sessionScope.mb_no eq write.mb_no}">
                    	<c:choose>
							<c:when test="${DAO.Info(v.mb_no).mb_job eq true }">
								<img src="images/user2.png" width="20" height="20" alt="개발">
							</c:when>            
				            <c:otherwise>
				            	<img src="images/user1.png" width="20" height="20" alt="예비">
				            </c:otherwise>
				            </c:choose>
                    		<label for="message">${DAO.Info(v.mb_no).mb_nick}</label>
	                    <textarea id="message" cols="1" rows="1" class="form-control" disabled>${v.c_write}</textarea>
                    	</c:when>
                    	
                    	<c:when test="${sessionScope.ad_id != null }">
                    	<c:choose>
							<c:when test="${DAO.Info(v.mb_no).mb_job eq true }">
								<img src="images/user2.png" width="20" height="20" alt="개발">
							</c:when>            
				            <c:otherwise>
				            	<img src="images/user1.png" width="20" height="20" alt="예비">
				            </c:otherwise>
				            </c:choose>
                    	<label for="message">${DAO.Info(v.mb_no).mb_nick}</label>
	                    <textarea id="message" cols="1" rows="1" class="form-control" disabled>${v.c_write}</textarea>
                    		
                    	</c:when>
                    	
                    	<c:otherwise>
                    		<div style="margin-top:10px;margin-bottom:4px; background:lightgrey; height:40px; text-algin:center;">
               			<div>비밀댓글입니다.</div> 
              			</div>
                    	</c:otherwise>
                    </c:choose>
                    	
                    </c:when>
                    
                    
                    <c:when test="${v.c_deleted eq true}">
							<c:choose>
							<c:when test="${sessionScope.ad_id != null }">
							
							<c:choose>
							<c:when test="${DAO.Info(v.mb_no).mb_job eq true }">
								<img src="images/user2.png" width="20" height="20" alt="개발">
							</c:when>            
				            <c:otherwise>
				            	<img src="images/user1.png" width="20" height="20" alt="예비">
				            </c:otherwise>
				            </c:choose>
							
							<label for="message">${DAO.Info(v.mb_no).mb_nick}</label>
	                    <textarea id="message" cols="1" rows="1" class="form-control" disabled>${v.c_write}</textarea>
							</c:when>
							<c:otherwise>
							<c:choose>
							<c:when test="${DAO.Info(v.mb_no).mb_job eq true }">
								<img src="images/user2.png" width="20" height="20" alt="개발">
							</c:when>            
				            <c:otherwise>
				            	<img src="images/user1.png" width="20" height="20" alt="예비">
				            </c:otherwise>
				            </c:choose>
	                    <label for="message">${DAO.Info(v.mb_no).mb_nick}</label>
                    	<div style="margin-top:10px;margin-bottom:4px; background:lightgrey; height:40px; text-algin:center;">
               			<div>신고되어 블라인드 처리되었습니다.</div> 
              			</div>
							</c:otherwise>
							</c:choose>
						</c:when>
                
                    <c:otherwise>
                    <c:choose>
							<c:when test="${DAO.Info(v.mb_no).mb_job eq true }">
								<img src="images/user2.png" width="20" height="20" alt="개발">
							</c:when>            
				            <c:otherwise>
				            	<img src="images/user1.png" width="20" height="20" alt="예비">
				            </c:otherwise>
				            </c:choose>
                    
	                    <label for="message">${DAO.Info(v.mb_no).mb_nick}</label>
	                    <textarea id="message" cols="1" rows="1" class="form-control" disabled>${v.c_write}</textarea>
                    </c:otherwise>
                 </c:choose>
                   
                    <a href="javascript:report2(${v.c_no});"><img src="images/siren.png" width="15" height="15" alt="신고">신고</a><!-- 신고 기능->report.jsp로 연결됨. -->
             		
             		<c:choose>
             			<c:when test="${sessionScope.mb_no == null }">
             			<c:choose>
             				<c:when test="${sessionScope.ad_id != null }">
             					<a href='delete2.do?c_no=${v.c_no}&b_no=${write.b_no}'>삭제</a>
             				</c:when>
             				<c:otherwise>
             				</c:otherwise>
             			</c:choose>
             			</c:when>
             			
             			<c:otherwise>
             				<c:choose>
             				<c:when test="${sessionScope.mb_no eq v.mb_no }">
             					<a href='delete2.do?c_no=${v.c_no}&b_no=${write.b_no}'>삭제</a>
             				</c:when>
             				</c:choose>
             			</c:otherwise>
             		</c:choose>
                </form>
                  </div>
                  <br>
                  </c:forEach>
                  <!-- forEach 끝 -->
                  <div align="center"><a id="load-more" href="post.do?b_no=${write.b_no}&cnt=${cnt+3}">더보기&gt;&gt;</a></div>
        </div>
	
 	<!-- 댓글 끝 -->
    </section>
 	<!-- 게시글 끝 -->
 	
    <footer class="site-footer">
      <div class="container">
        <div class="row">
          <div class="col-md-9">
            <div class="row">
              <div class="col-md-5">
                <h2 class="footer-heading mb-4">About Us</h2>
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Neque facere laudantium magnam voluptatum autem. Amet aliquid nesciunt veritatis aliquam.</p>
              </div>
              <div class="col-md-3 ml-auto">
                <h2 class="footer-heading mb-4">Features</h2>
                <ul class="list-unstyled">
                  <li><a href="#">About Us</a></li>
                  <li><a href="#">Services</a></li>
                  <li><a href="#">Testimonials</a></li>
                  <li><a href="#">Contact Us</a></li>
                </ul>
              </div>
              <div class="col-md-3">
                <h2 class="footer-heading mb-4">Follow Us</h2>
                <a href="#" class="pl-0 pr-3"><span class="icon-facebook"></span></a>
                <a href="#" class="pl-3 pr-3"><span class="icon-twitter"></span></a>
                <a href="#" class="pl-3 pr-3"><span class="icon-instagram"></span></a>
                <a href="#" class="pl-3 pr-3"><span class="icon-linkedin"></span></a>
              </div>
            </div>
          </div>
          <div class="col-md-3">
            <h2 class="footer-heading mb-4">Subscribe Newsletter</h2>
            <form action="#" method="post">
              <div class="input-group mb-3">
                <input type="text" class="form-control border-secondary text-white bg-transparent" placeholder="Enter Email" aria-label="Enter Email" aria-describedby="button-addon2">
                <div class="input-group-append">
                  <button class="btn btn-primary text-white" type="button" id="button-addon2">Send</button>
                </div>
              </div>
            </form>
          </div>
        </div>
        <div class="row pt-5 mt-5 text-center">
          <div class="col-md-12">
            <div class="border-top pt-5">
            <p>
            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
            Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="icon-heart text-danger" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank" >Colorlib</a>
            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
            </p>
            </div>
          </div>
          
        </div>
      </div>
    </footer>

  </div> <!-- .site-wrap -->

  <script src="js/jquery-3.3.1.min.js"></script>
  <script src="js/jquery-migrate-3.0.1.min.js"></script>
  <script src="js/jquery-ui.js"></script>
  <script src="js/popper.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/owl.carousel.min.js"></script>
  <script src="js/jquery.stellar.min.js"></script>
  <script src="js/jquery.countdown.min.js"></script>
  <script src="js/bootstrap-datepicker.min.js"></script>
  <script src="js/jquery.easing.1.3.js"></script>
  <script src="js/aos.js"></script>
  <script src="js/jquery.fancybox.min.js"></script>
  <script src="js/jquery.sticky.js"></script>

  <script src="js/typed.js"></script>
            <script>
            var typed = new Typed('.typed-words', {
            strings: ["Web Apps"," WordPress"," Mobile Apps"],
            typeSpeed: 80,
            backSpeed: 80,
            backDelay: 4000,
            startDelay: 1000,
            loop: true,
            showCursor: true
            });
            </script>

  <script src="js/main.js"></script>
  


  </body>
</html>