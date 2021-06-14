<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header style="margin-top:0;"class="site-navbar bg-white js-sticky-header site-navbar-target" role="banner">

      <div class="container">
        <div class="row align-items-center">
          
          <div class="col-11 col-xl-2">
            <h1 class="mb-0 site-logo"><a href="hmy_main.jsp" class="text-black h2 mb-0">ITtalk<span class="text-primary">.</span> </a></h1>
          </div>
          <div class="col-12 col-md-10 d-none d-xl-block">
            <nav class="site-navigation position-relative text-right" role="navigation">

              <ul class="site-menu main-menu js-clone-nav mr-auto d-none d-lg-block">
                <li><a href="#work-section" class="nav-link">게시판</a></li>
                <li>
                  <a href="#services-section" class="nav-link">글쓰기</a>
                </li>
                <!-- 커스텀 태그 : 로그인/로그아웃, 마이페이지/관리자메뉴 -->
                
                <c:choose>
		<c:when test="${uid != null}">
			<!-- 로그아웃 -->
			<li><a href="#work-section" class="nav-link">로그아웃</a></li>
		</c:when>
		<c:otherwise>
			<!-- 로그인 -->
			<li><a href="#work-section" class="nav-link">로그인</a></li>
		</c:otherwise>
	</c:choose>
	
	<c:choose>
	<c:when test="${ujob == null}"><!-- 개발자/예비개발자 아이콘 -->
			<!-- 예비 -->
			<li><a href="#work-section" class="nav-link"><img src="images/user1.png" width="40" height="40" alt="예비"></a></li>
		</c:when>
		<c:otherwise>
			<!-- 개발자 -->
			<li><a href="#work-section" class="nav-link"><img src="images/user2.png" alt="예비"></a></li>
		</c:otherwise>
	</c:choose>
              </ul>
            </nav>
          </div>

          <div class="d-inline-block d-xl-none ml-md-0 mr-auto py-3" style="position: relative; top: 3px;"><a href="#" class="site-menu-toggle js-menu-toggle text-black"><span class="icon-menu h3"></span></a></div>

        </div>
      </div>
      
    </header>