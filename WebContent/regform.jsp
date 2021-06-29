<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="test"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<title>ITtalk</title>
<script type="text/javascript">
function createFrom(obj){
	if(joinform.mb_id.value ==""){
		alert("아이디를 반드시 입력하세요.");
		obj.id.focus();
		return false;
	}
	if(joinform.idDuplication.value != "idCheck"){
        alert("아이디 중복체크를 해주세요.");
        return false;
    }

	if(joinform.mb_pw.value ==""){
		alert("비밀번호를 반드시 입력하세요.");
		obj.password.focus();
		return false;
	}
	
	if(joinform.mb_pw_check.value ==""){
		alert("비밀번호 확인란에 입력해주세요.");
		obj.passwordCheck.focus();	
		return false;
	}
	
	if(joinform.mb_pw.value != joinform.mb_pw_check.value){
		alert("입력하신 비밀번호가 같지 않습니다.");
		obj.passwordCheck.focus();
		return false;
	}
	
	if(joinform.mb_nick.value ==""){
		alert("닉네임을 반드시 입력하세요.");
		obj.name.focus();
		return false;
	}
	if(joinform.nickDuplication.value != "nickCheck"){
        alert("닉네임 중복체크를 해주세요.");
        return false;
    }
	
	if(joinform.mb_email.value ==""){
		alert("이메일을 입력하세요.");
		obj.mb_email.focus();
		return false;
	}
	if(joinform.mb_certify.value != 0){
        alert("이메일 인증을 해주세요.");
        return false;
    }


	if(joinform.mb_job.value ==""){
		alert("예비/개발자를 선택하세요.");
		obj.job.focus();
		return false;
	}
	function inputIdChk(){
        document.joinform.idDuplication.value ="idUncheck";
    }
	function inputNickChk(){
        document.joinform.nickDuplication.value ="nickUncheck";
    }
	function inputEmailChk(){
        document.joinform.mb_certify.value = 1;
    }
	
}
	
	function openCheckId(){
		window.name="regform";
		openWin = window.open("idCheck.jsp","idcheck","width=600 height=350","menubar=no","toolbar=no","resizable=no")
	}
	function openCheckEmail(){
		window.name="regform";
		window.open("emailCheck.jsp","emailcheck","width=600 height=350","menubar=no","toolbar=no","resizable=no")
	}
	function openCheckAuth(){
		window.name="regform";
		window.open("CheckAuth.jsp","emailcheck","width=600 height=350","menubar=no","toolbar=no","resizable=no")
	}
	function openCheckNick(){
		window.name="regform";
		window.open("NickCheck.jsp","emailcheck","width=600 height=350","menubar=no","toolbar=no","resizable=no")
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

#button{
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
			<div style="display: inline-block; text-align:left">
				<form id="joinform" name="joinform" action="newmem.main" method="post" 
		onsubmit="return createFrom(this)">

		<h4 style="text-align: center;">회원가입(*필수입력사항입니다.)</h4>
					<div class="menu" style="border-bottom-width: 0px;">


		<div id="menu">아이디*</div>
			<span> 
				<input type="text" class="checkInfo" name="mb_id" size="12" onkeydown="inputIdChk()" /> 
				<button type="button" onClick="openCheckId();">ID중복확인</button>
				<input type="hidden" name="idDuplication" >
			</span>
		</div>

		<div class="menu " style="border-bottom-width: 0px;">
			<div id="id">비밀번호*</div>
			<span> <input type="password" class="checkInfo" name="mb_pw" size="12" />
			</span>
		</div>

		<div class="menu " style="border-bottom-width: 0px;">
			<div id="id">비밀번호확인*</div>
			<span><input type="password" class="checkInfo" name="mb_pw_check" size="12" />
			</span>
		</div>
		
		
		<div class="menu " style="border-bottom-width: 0px;">
			<div id="id">닉네임*</div>
			<span> 
				<input type="text" class="checkInfo" name="mb_nick" size="12" onkeydown="inputNickChk()"/>
				<button type="button" onClick="openCheckNick();">닉네임중복확인</button>
				<input type="hidden" name="nickDuplication">
			</span>
		</div>

		<div class="menu" style="border-bottom-width: 0px;">
			<div id="id" style="margin-left: 10px,">이메일*</div>
			<span> 
				<input type="email" name="mb_email" size="25" onkeydown="inputEmailChk()">
				<button type="button" onclick="openCheckEmail()">이메일인증</button>
				<input type="hidden" name="mb_certify" >
			</span>
		</div>
		<div class="menu" style="border-bottom-width: 0px;">
			<div id="id">구분*</div>
			<span> 
			<select name="mb_job" >
					<option value='false' selected>예비</option>
					<option value='true'>개발자</option>
			</select>
			</span>
		</div>
		<br>
		<div class="menu" style="text-align: center;">
			<span> 
				<button type="submit" >가입</button>
			 	<button onclick="location.href='hmy_main.jsp'" >취소</button>
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