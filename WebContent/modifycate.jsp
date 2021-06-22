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
<div style="text-align:left; layout:fixed;margin-right:45%">
<form class="p-5 bg-white">
              
              <h2 class="h4 text-black mb-5">게시판카테고리 수정 및 삭제</h2>

			<!-- 게시판카테고리 출력부분 foreach -->
			<c:forEach var="v" items="${adcateList}" varStatus="status">
              <div class="row form-group">
                <div class="col-md-12"> 
                	<input type="hidden" name="bc_no" value="${v.bc_no}"/>
                  <input type="text" name="cate" value="${v.bc_name}" style="width:500px;height:40px;font-size:20px;" required>
                  <button id="b" class="btn btn-primary btn-md text-white" formaction="admodifycate.ad">수정</button>
                  <button id="b" class="btn btn-primary btn-md text-white" formaction="addelcate.ad">삭제</button>
                </div>
              </div>
              </c:forEach>
			<!-- 게시판카테고리 출력부분 foreach -->
            </form>
</div>
</body>
</html>