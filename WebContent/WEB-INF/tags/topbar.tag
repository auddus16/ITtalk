<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header style="margin-top:0;"class="site-navbar bg-white js-sticky-header site-navbar-target" role="banner">
	
      <div class="container">
        <div class="row align-items-center">
          
          <div class="col-11 col-xl-2">
            <h1 class="mb-0 site-logo"><a href="main.main" class="text-black h2 mb-0">ITtalk<span class="text-primary">.</span> </a></h1>
          </div>
          <div class="col-12 col-md-10 d-none d-xl-block">
            <nav class="site-navigation position-relative text-right" role="navigation">

              <ul class="site-menu main-menu js-clone-nav mr-auto d-none d-lg-block">
                <li><a href="Board.do" class="nav-link">게시판</a></li>
                <c:if test="${mb_id != null}">
                <li>
                	<a href="UpdateMsg.do?b_no=0" class="nav-link">글쓰기</a>
                	<input type="hidden" name="mb_no" value="${mb_no}">
                </li>
                </c:if>
                <!-- 커스텀 태그 : 로그인/로그아웃, 마이페이지/관리자메뉴 -->

	<c:choose>
		<c:when test="${mb_nick != null}">
		<li>${mb_nick}님,환영합니다!</li>&nbsp;&nbsp;
			<!-- 로그아웃 -->
			<input type="hidden" name="action" value="logout">
			<li><a href="logout.main" class="nav-link">로그아웃</a></li>
		</c:when>
		<c:when test="${ad_nick != null }">
			<li>${ad_nick} 관리자님,환영합니다!</li>&nbsp;&nbsp;
			<input type="hidden" name="action" value="logout">
			<li><a href="logout.main" class="nav-link">로그아웃</a></li>
		</c:when>
		
		<c:otherwise>
			<!-- 로그인 -->
			<input type="hidden" name="action" value="login">
			<li><a class="nav-link" href="hmy_login.jsp">로그인</a></li>
		</c:otherwise>
	</c:choose>
	<c:if test="${mb_id == null && ad_id==null }" >
	<li><a class="nav-link" href="regform.jsp">회원가입</a><li>
	</c:if>
	
	<!-- ****관리자인지 회원인지 먼저 구별해야함.. 관리자아이콘도 추가 -->
	<c:choose>
	<c:when test="${mb_job == false}"><!-- 개발자/예비개발자 아이콘 -->
			<!-- 예비 -->
			<li><a href="info.mem" class="nav-link"><img src="images/user1.png" width="40" height="40" alt="예비"></a></li>
		</c:when>
		<c:when test="${mb_job == true}">
			<!-- 개발자 -->
			<li><a href="info.mem" class="nav-link"><img src="images/user2.png" width="40" height="40" alt="개발자"></a></li>
		</c:when>
		<c:when test="${ad_id != null }">
			<!-- 관리자 -->
			<li><a href="adpost.ad" class="nav-link"><img src="images/ad.png" width="40" height="40" alt="관리자"></a></li>
		</c:when>
		<c:otherwise>
			<!-- null -->
			
		</c:otherwise>
	</c:choose>
              </ul>
            </nav>
          </div>

          <div class="d-inline-block d-xl-none ml-md-0 mr-auto py-3" style="position: relative; top: 3px;"><a href="#" class="site-menu-toggle js-menu-toggle text-black"><span class="icon-menu h3"></span></a></div>

        </div>
      </div>
      
    </header>