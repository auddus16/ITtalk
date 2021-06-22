<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#b{
	padding:10px 20px;
}
</style>

</head>
<body>
<!-- 닉네임, 아이디, 비밀번호, 이메일 -->
<div style="text-align:left; layout:fixed;margin-right:45%">
<form class="p-5 bg-white">
              
              <h2 class="h4 text-black mb-5">게시판카테고리 수정 및 삭제</h2>

			<!-- 게시판카테고리 출력부분 foreach -->
              <div class="row form-group">
                <div class="col-md-12"> 
                  <input type="text" name="cate" value="${myInfo.mb_pw}" style="width:500px;height:40px;font-size:20px;" required>
                  <button id="b" class="btn btn-primary btn-md text-white" formaction="">수정</button>
                  <button id="b" class="btn btn-primary btn-md text-white" formaction="">삭제</button>
                </div>
              </div>
			<!-- 게시판카테고리 출력부분 foreach -->

              <div class="row form-group">
                <div class="col-md-6">
                <button type="submit" class="btn btn-primary btn-md text-white" formaction="">수정완료</button>
                </div> 
                </div> 
            </form>
</div>
</body>
</html>