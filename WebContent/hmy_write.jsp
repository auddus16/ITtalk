<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="test" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
function report(){
	window.open("report.jsp","_blank","titlebar=no,location=no,scrollbars=no,resizeable=no,menubar=no,toolbar=no,width=400,height=350"
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
            <div>&gt;&gt;${write.bc_name}</div><!-- 카테고리명 넣어주세요 -->
            <h3>${write.b_title}</h3>
            <div>${write.mb_name} &nbsp; ${write.b_date} &nbsp; <img src="images/eye.png" width="20" height="20" alt="조회수">${write.b_hits}&nbsp;&nbsp;</div><!-- 작성자닉네임, 등록날짜, 조회수 넣어주세요 -->
              <hr>
                  <div class="form-group">
                    <label for="message"></label>
<<<<<<< HEAD
                    <textarea name="" id="message" cols="90" rows="20" class="form-control" required></textarea>
=======
                    <textarea name="b_write" id="message" cols="30" rows="10" class="form-control" required></textarea>
>>>>>>> branch 'master' of https://github.com/auddus16/ITtalk.git
                  </div>
                  <div style="float:right;">
                  <!-- 본인게시글이라면, 삭제, 수정 버튼 보임(활성화) -->
                  <!-- session에 저장된 id와 해당게시글의 id가 같은지-->
					<!-- jstl로 test해주세요 + 컨롤링크 -->
                  	<a href="#">삭제</a> <!-- 위 테스트에서 해당될 때 a태그 넣어주세요 -->
               &nbsp;<a href="#">수정</a> <!-- 위 테스트에서 해당될 때 a태그 넣어주세요 (복붙)-->
              &nbsp;<a href="#"><img src="images/like.png" width="27" height="27" alt="좋아요">좋아요</a><!-- 좋아요 기능 컨롤 링크 연결 -->
              &nbsp;<a href="javascript:report();"><img src="images/siren.png" width="25" height="25" alt="신고">신고</a><!-- 신고 기능->report.jsp로 연결됨. -->
                  </div>
               &nbsp;<a href="#"><img src="images/reply.png" width="25" height="25" alt="댓글수">30</a><!-- 댓글수 -->
                </div>
 	
 	<!-- 댓글 작성 폼 시작 -->
        <div class="comment-form-wrap pt-5"style="margin:25%; margin-top:0; margin-bottom:0;">
              <hr>
              <div style="">
                <form action="Newreply.do" class=""><!-- 컨롤링크 연결 -> 신고버튼 때문-->
                
                <input type="hidden" name="c_no" value="c_no"> <!-- 신고시, 댓글 번호 넘겨줘야함.값 추가해야함. -->
                    
                    <label for="message">댓글작성자닉네임11</label><!--닉네임 적어주세요-->
                    <textarea name="" id="message" cols="2" rows="2" class="form-control" required></textarea>
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
              <div>
                <form action="#" class=""><!-- 컨롤링크 연결 -->
                    <label for="message">댓글작성자닉네임11</label>
                    <textarea name="" id="message" cols="1" rows="1" class="form-control" disabled>여기에 댓글내용 넣어주세요!</textarea>
                    <!-- 삭제 버튼도 위와 동일하게 처리해야함 ->본인댓글 삭제-->
                    <!--  (본인댓글이 아닌)비밀댓글을 만났을때 블라인드처리
                    <input type="submit" value="삭제" class="btn btn-primary btn-md text-white" style="float:right;"> -->
                </form>
                  </div>
                  <br>
                  <!-- forEach 끝 -->
              
              <!-- 비밀댓글 출력 형태 -->
              <div style="margin-top:10px;margin-bottom:4px; background:lightgrey; height:40px; text-algin:center;">
               <div>비밀댓글입니다.</div> 
               </div>
                 <br>
               <!-- 비밀댓글 출력 끝 -->
              
              
              <div>
                <form action="#" class=""><!-- 컨롤링크 연결 -->
                    <label for="message">댓글작성자닉네임11</label>
                    <textarea name="" id="message" cols="1" rows="1" class="form-control" disabled>여기에 댓글내용 넣어주세요!</textarea>
                    <!-- 삭제 버튼도 위와 동일하게 처리해야함 ->본인댓글 삭제-->
                    <!--  
                    <input type="submit" value="삭제" class="btn btn-primary btn-md text-white" style="float:right;"> -->
                </form>
                  </div>
                  <br>
              <div style="">
                <form action="#" class=""><!-- 컨롤링크 연결 -->
                    <label for="message">댓글작성자닉네임11</label>
                    <textarea name="" id="message" cols="1" rows="1" class="form-control" disabled>여기에 댓글내용 넣어주세요!</textarea>
                    <!-- 삭제 버튼도 위와 동일하게 처리해야함 ->본인댓글 삭제-->
                    <!--  
                    <input type="submit" value="삭제" class="btn btn-primary btn-md text-white" style="float:right;"> -->
                </form>
                  </div>
                  
               
                  <div align="center"><a id="load-more" href="mypost.mem?cnt=${cnt+1}">더보기&gt;&gt;</a></div>
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