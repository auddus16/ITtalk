<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="test" %>
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
<style type="text/css">
    .home-list {
    	display: flex;
    	flex-wrap: wrap;
    	width:70%;
    	align:center;
	}
	.boardlist{
		width:40%;
		margin-right:20px;
		margin-bottom:20px;
		float:left;
		border: 1px solid grey;
		text-align:left;
	}
	a{
		color:black;
	}
</style>
  </head>
  <body data-spy="scroll" data-target=".site-navbar-target" data-offset="300">
  
    <test:topbar/> <!-- 로그인/로그아웃, 아이콘 커스텀태그 -->
    
    <section class="site-section">
      <div class="container" style="text-align:center;margin-top:5% margin-bottom:0;">
        <div style="display:inline-block">
        <form action="#" method="post">
        <table style="width:1000px;">
        	<tr><td>
        	<span style="float:right;">
        	<label for="pet-select">검색옵션</label>
			<select name="pets" id="pet-select">
    			<option value="1">제목&내용</option>
    			<option value="2">작성자</option>
			</select>
			</span>
        	<input type="text" class="form-control" width="500%"placeholder="검색할 내용을 입력하세요!"></td>
        	<td><input type="submit" class="btn btn-primary btn-md text-white" value="검색"></td></tr>
        </table>
		</form>
		</div>
      </div>
    </section>
 	<section class="site-section">
 	<div align="center" style="margin-top:0px; margin-left:10%">
 	<div class="home-list">
 			
           <!-- foreach로 결과게시글 출력, href링크에 게시글화면으로 이동-->
     		<div class="boardlist">
                <a href="#" style="float:right;color:blue;">더보기&gt;&gt;</a>
                <h3>게시글제목1</h3><!-- 해당게시글화면으로 -->
                <hr>
                <!-- 게시글내용 (원하는만큼) -->
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Neque facere laudantium magnam voluptatum autem. Amet aliquid nesc</p>
                
                <div style="margin:5px;">
                
                <img src="images/eye.png" width="20" height="20" alt="조회수">15&nbsp;&nbsp;<!-- 조회수 -->
                <a href="#"><img src="images/like.png" width="20" height="20" alt="좋아요">좋아요</a>&nbsp;&nbsp;<!-- 저장기능 -->
                <a href="#"><img src="images/reply.png" width="20" height="20" alt="댓글수">30</a><!-- 댓글수 -->
                
                <span style="float:right;">2021-06-22 00:00:00</span><!-- 등록날짜 -->
                
                </div>
				
              </div>
              
           <!-- end -->   
              <div class="boardlist">
                <a href="#" style="float:right;color:blue;">더보기&gt;&gt;</a>
                <h3>게시글제목1</h3><!-- 해당카테고리화면으로 -->
                <hr>
                <!-- foreach로 게시글 최신글 5개 출력, href링크에 게시글화면으로 이동-->
                <!-- 게시글내용 (원하는만큼) -->
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Neque facere laudantium magnam voluptatum autem. Amet aliquid nesc</p>
                
                <div style="margin:5px;">
                
                <img src="images/eye.png" width="20" height="20" alt="조회수">15&nbsp;&nbsp;<!-- 조회수 -->
                <a href="#"><img src="images/like.png" width="20" height="20" alt="좋아요">좋아요</a>&nbsp;&nbsp;<!-- 저장기능 -->
                <a href="#"><img src="images/reply.png" width="20" height="20" alt="댓글수">30</a><!-- 댓글수 -->
                
                <span style="float:right;">2021-06-22 00:00:00</span><!-- 등록날짜 -->
                
                </div>
				
              </div>   
              
              <div class="boardlist">
                <a href="#" style="float:right;color:blue;">더보기&gt;&gt;</a>
                <h3>게시글제목1</h3><!-- 해당카테고리화면으로 -->
                <hr>
                <!-- foreach로 게시글 최신글 5개 출력, href링크에 게시글화면으로 이동-->
                <!-- 게시글내용 (원하는만큼) -->
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Neque facere laudantium magnam voluptatum autem. Amet aliquid nesc</p>
                
                <div style="margin:5px;">
                
                <img src="images/eye.png" width="20" height="20" alt="조회수">15&nbsp;&nbsp;<!-- 조회수 -->
                <a href="#"><img src="images/like.png" width="20" height="20" alt="좋아요">좋아요</a>&nbsp;&nbsp;<!-- 저장기능 -->
                <a href="#"><img src="images/reply.png" width="20" height="20" alt="댓글수">30</a><!-- 댓글수 -->
                
                <span style="float:right;">2021-06-22 00:00:00</span><!-- 등록날짜 -->
                
                </div>
				
              </div>                
             </div>
             </div>
      </section>
    
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