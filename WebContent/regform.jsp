<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="test"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<title>ITtalk</title>
<script type="text/javascript">
function createFrom(obj){
	if(obj.mb_id.value ==""){
		alert("아이디를 반드시 입력하세요.");
		obj.id.focus();
		return false;
	}
	
	if(obj.mb_pw.value ==""){
		alert("비밀번호를 반드시 입력하세요.");
		obj.password.focus();
		return false;
	}
	
	if(obj.mb_pw_check.value ==""){
		alert("비밀번호 확인란에 입력해주세요.");
		obj.passwordCheck.focus();
		return false;
	}
	
	if(obj.mb_pw.value != obj.mb_pw_check.value){
		alert("입력하신 비밀번호가 같지 않습니다.");
		obj.passwordCheck.focus();
		return false;
	}
	
	if(obj.mb_nick.value ==""){
		alert("닉네임을 반드시 입력하세요.");
		obj.name.focus();
		return false;
	}
	
	if(obj.email.value ==""){
		alert("이메일을 입력하세요.");
		obj.email.focus();
		return false;
	}


	if(obj.mb_job.value ==""){
		alert("예비/개발자를 선택하세요.");
		obj.job.focus();
		return false;
	}
	check = false;
	var str="";
	for(var i=0; i<obj.interest.length; i++){
		if(obj.interest[i].checked==true){
			str+=obj.interest[i].value + ",";
		}
		
	}	
	obj.resultInterest.value=str;
	
	
}
function idCheck(obj, root){
	if(obj.mb_id.value ==""){
		alert("아이디를 반드시 입력하세요.");
		obj.mb_id.focus();
		return false;
	}else{
		var url = root + "checkid.main?mb_id=" + obj.mb_id.value;
		//alert(url);
		window.open(url, "", "width=400, height=200");
	}
}
</script>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link
	href="https://fonts.googleapis.com/css?family=Quicksand:300,400,500,700,900"
	rel="stylesheet">
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

<style>
.labelfd {
	float: left;
	width: 120px;
	text-align: right;
	padding-right: 10px;
}

#gender {
	display: inline-block;
	width: 15%;
}

button {
	color: linen;
	background: lightseagreen;
	border: 2px solid white;
	font-size: 19px;
	border-radius: 6px;
	box-shadow: 0 4px 6px -1px rgba(0, 0, 0, 0.1), 0 2px 4px -1px
		rgba(0, 0, 0, 0.06);
	cursor: pointer;
	transition: 0.5s;
}

.right {
	margin-left: 450px;
	margin-top: 30px;
}
</style>
</head>

<body data-spy="scroll" data-target=".site-navbar-target"
	data-offset="300">

	<test:topbar />
	<!-- 로그인/로그아웃, 아이콘 커스텀태그 -->


	<section class="site-section">
		<div class="container" style="text-align: center;">
			<div style="display: inline-block">
				<form id="joinform" name="joinform" action="newmem.main" method="post" 
		onsubmit="return createFrom(this)">

		<h4 style="text-align: center;">회원가입(*필수입력사항입니다.)</h4>
					<div class="menu" style="border-bottom-width: 0px;">


		<div id="menu">아이디</div>
			<span>* 
				<input type="text" class="checkInfo" name="mb_id" size="12" /> 
				<button type="button" onclick="idCheck(joinform, '${root}')">아이디 중복</button>
			</span>
		</div>

		<div class="menu " style="border-bottom-width: 0px;">
			<div id="id">비밀번호</div>
			<span>* <input type="password" class="checkInfo" name="mb_pw" size="12" />
			</span>
		</div>

		<div class="menu " style="border-bottom-width: 0px;">
			<div id="id">비밀번호확인</div>
			<span>* <input type="password" class="checkInfo" name="mb_pw_check" size="12" />
			</span>
		</div>
		
		
		<div class="menu " style="border-bottom-width: 0px;">
			<div id="id">닉네임</div>
			<span>* <input type="text" class="checkInfo" name="mb_nick" size="12" />
			</span>
		</div>

		<div class="menu" style="border-bottom-width: 0px;">
			<div id="id" style="margin-left: 10px,">이메일</div>
			<span> 
				<input type="text" name="mb_email" size="25" />
				<button type="button" onclick="idCheck(joinform, '${root}')">이메일인증</button>
			</span>
		</div>
		
		<div class="menu" style="border-bottom-width: 0px;">
			<div id="id">구분</div>
			<span> 
			<select name="mb_certify">
					<option value='0' selected>인증</option>
					<option value='1'>비인증</option>
			</select>
			</span>
		</div>
		<div class="menu" style="border-bottom-width: 0px;">
			<div id="id">구분</div>
			<span> 
			<select name="mb_job">
					<option value='0' selected>예비</option>
					<option value='1'>개발자</option>
			</select>
			</span>
		</div>
		<div class="menu" style="text-align: center;">
			<span> 
				<input type="submit" value="가입" />
			 	<input type="reset" value="취소" />
			</span>
		</div>
				</form>
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
							<p>Lorem ipsum dolor sit amet consectetur adipisicing elit.
								Neque facere laudantium magnam voluptatum autem. Amet aliquid
								nesciunt veritatis aliquam.</p>
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
							<input type="text"
								class="form-control border-secondary text-white bg-transparent"
								placeholder="Enter Email" aria-label="Enter Email"
								aria-describedby="button-addon2">
							<div class="input-group-append">
								<button class="btn btn-primary text-white" type="button"
									id="button-addon2">Send</button>
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
							Copyright &copy;
							<script>
								document.write(new Date().getFullYear());
							</script>
							All rights reserved | This template is made with <i
								class="icon-heart text-danger" aria-hidden="true"></i> by <a
								href="https://colorlib.com" target="_blank">Colorlib</a>
							<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
						</p>
					</div>
				</div>

			</div>
		</div>
	</footer>

	</div>
	<!-- .site-wrap -->

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
			strings : [ "Web Apps", " WordPress", " Mobile Apps" ],
			typeSpeed : 80,
			backSpeed : 80,
			backDelay : 4000,
			startDelay : 1000,
			loop : true,
			showCursor : true
		});
		
	</script>

	<script src="js/main.js"></script>
</body>

</html>