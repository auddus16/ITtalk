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
<style type="text/css">
    .home-list {
    	display: flex;
    	flex-wrap: wrap;
    	width:70%;
    	align:center;
	}
	.categories{
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
      <div class="container" style="text-align:center;margin-top:5%">
        <div style="display:inline-block">
        <form action="Board.do" method="post">
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
	<!-- 코드도움, 프로그램이슈, 개발자회사생활, 자유 -->
	<!-- 카테고리가 수정될 때 어떻게 해야할지 고민 -->
 	<section class="site-section">
 	<div align="center" style="margin-left:10%;">
 	<div class="home-list">
 	<!-- foreach 게시판카테고리개수만큼-->
 	<c:forEach var="c" items="${bcwrite}"> <!-- 카테고리 개수 4개 -->
     		<div class="categories">
                <a href="Board.do?bc_no=${c.bc_no}" style="float:right;color:blue;">더보기&gt;&gt;</a>
                
                <h3>코드 도움</h3><!-- 해당카테고리화면으로 -->
                <hr>
                <!-- foreach로 게시글 최신글 5개 출력, href링크에 게시글화면으로 이동-->
                <c:forEach var="v" items="${write}">
                <li><a href="Board.do?b_title=${v.b_title}&b_hits=${v.b_hits}">${v.b_title}<span>${v.b_hits}</span></a></li>
				</c:forEach>
				
              </div>     
               
    </c:forEach>          
              
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