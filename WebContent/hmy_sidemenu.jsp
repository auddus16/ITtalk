<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<br><br>
<section class="site-section">
	<form action="mypage.mem" method="post">
     <div class="categories" style="float:left; margin-left:50px; height:100%;">
                <h3>마이페이지</h3>
                <hr>
                <li><button type="submit"><a href="?action=info">개인정보</a></button></li>
                <li><a href="?action=post">내가 쓴 게시글</a></li>
                <li><a href="?action=reply">내가 쓴 댓글</a></li>
                <li><a href="?action=alarm">알림</a></li>
                <li><a href="?action=store">좋아요 게시글</a></li>
              </div>
          </form>
      </section>
</body>
</html>