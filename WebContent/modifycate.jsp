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
<br><br>
<div style="text-align:left; layout:fixed; margin-right:40%; margin-left:10%; margin:0;">
              
              <h2 class="h4 text-black mb-5">게시판카테고리 수정 및 삭제</h2>

			<!-- 게시판카테고리 출력부분 foreach -->
			<c:forEach var="v" items="${adcateList}" varStatus="status">
			<form  style="margin:0; padding:0;">
              <div class="row form-group">
                <div class="col-md-12"> 
                	<input type="hidden" name="bc_no" value="${v.bc_no}"/>
                  <input type="text" name="cate" value="${v.bc_name}" style="width:500px;height:40px;font-size:20px;" required>
                  <button id="b" class="btn btn-primary btn-md text-white" formaction="admodifycate.ad">수정</button>
                  <button id="b" class="btn btn-primary btn-md text-white" formaction="addelcate.ad">삭제</button>
                </div>
              </div>
            </form>
              </c:forEach>
			<!-- 게시판카테고리 출력부분 foreach -->
            <br>
            <form>
              
              <h2 class="h4 text-black mb-5">게시판카테고리 추가</h2>

              <div class="row form-group">
                <div class="col-md-12"> 
                  <input type="text" name="new" style="width:500px;height:40px;font-size:20px;" required>
                  <button id="b" class="btn btn-primary btn-md text-white" formaction="adaddcate.ad">추가</button>
                </div>
              </div>
            </form>
            
            
</div>
</body>
</html>