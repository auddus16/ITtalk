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

<script src="jquery-3.6.0.min.js"></script>
<script type="text/javascript">//스크롤내리면 자동으로 이벤트 발생
    var tag="";
	var list= JSON.parse('${json}');
	var addList=list.slice(10);//10번 인덱스부터 끝까지
	console.log("ready");
    
	for(var i=0; i<addList.length; i++){
		
		tag+='<div class="boardlist"><a href="post.do?b_no='+addList[i].b_no+'"><h3>&nbsp;'+addList[i].b_title+'</h3></a><hr>';
		tag+='<p>'+addList[i].b_write+'</p><div style="margin:5px;">';
		tag+='<img src="images/eye.png" width="20" height="20" alt="조회수">'+addList[i].b_hits+'&nbsp;&nbsp;';
		tag+='<a href="favorite.do?b_no='+addList[i].b_no+'"><img src="images/like.png" width="20" height="20" alt="좋아요">좋아요</a>&nbsp;&nbsp;' ;           
        tag+='<a href="#"><img src="images/reply.png" width="20" height="20" alt="댓글수">'+addList[i].b_cnt+'</a>';
        tag+='<span style="float:right;">'+addList[i].b_date+'</span></div></div>';
            
	}

	document.addEventListener('scroll', function() {
	
    var currentScrollValue = document.documentElement.scrollTop; //스크롤 위치 구하기
    
    if(currentScrollValue>200){
    	//document.getElementById("postTable").insertRow(-1).innerHTML = tag;
    	//$('#height').append(tag);//table의 tbody요소 앞에 append
    	$('.home-list').append(tag);
    	tag=null;
    }
    });
</script>

  </head>
  <body data-spy="scroll" data-target=".site-navbar-target" data-offset="300">
  
    <test:topbar/> <!-- 로그인/로그아웃, 아이콘 커스텀태그 -->
    
    <section class="site-section">
      <div class="container" style="text-align:center;margin-top:5%">
        <div style="display:inline-block">
        <form action="Search.do" method="post">
        <table style="width:1000px;">
        	<tr><td>
        	<span style="float:right;">
        	<label for="pet-select">검색옵션</label>
			<select name="pets" id="pet-select">
    			<option value="1">제목&내용</option>
    			<option value="2">작성자</option>
			</select>
			</span>
        	<input type="text" class="form-control" name="searchinfo" width="500%"placeholder="검색할 내용을 입력하세요!"></td>
        	<td><br><input type="submit" class="btn btn-primary btn-md text-white" value="검색"></td></tr>
        </table>
		</form>
		</div>
      </div>
    </section>
 	<section class="site-section">
 	<div align="center" style="margin-top:0px; margin-left:10%">
 	<div class="home-list">
 			
           <!-- foreach로 결과게시글 출력, href링크에 게시글화면으로 이동-->
		<c:forEach var ="v" items="${searchB}" begin="0" end="5" > <!-- 게시글목록 출력 -->
     		<div class="boardlist">
                <a href="post.do?b_no=${v.b_no}"><h3>&nbsp;${v.b_title}</h3></a><!-- 해당게시글화면으로 -->
                <hr>
                <!-- 게시글내용 (원하는만큼) -->
                <p>${v.b_write}</p>
                
                <div style="margin:5px;">
                
                <img src="images/eye.png" width="20" height="20" alt="조회수">${v.b_hits}&nbsp;&nbsp;<!-- 조회수 -->
                <a href="favorite.do?b_no=${v.b_no}"><img src="images/like.png" width="20" height="20" alt="좋아요">좋아요</a>&nbsp;&nbsp;<!-- 저장기능 -->
                <a href="hmy_write.jsp"><img src="images/reply.png" width="20" height="20" alt="댓글수">${v.b_cnt}</a><!-- 댓글수 -->
                
                <span style="float:right;">${v.b_date}</span><!-- 등록날짜 -->
                
                </div>
				
              </div>
            
		</c:forEach>
              
           <!-- end -->   
              
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