<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지2-내가 쓴 게시글/댓글</title>
<style type="text/css">
table.type09 {
  border-collapse: collapse;
  text-align: left;
  line-height: 1.5;

}
table.type09 thead th {
  padding: 10px;
  font-weight: bold;
  vertical-align: top;
  color: #369;
  border-bottom: 3px solid #036;
}
table.type09 tbody th {
  width: 50px;
  padding: 10px;
  font-weight: bold;
  vertical-align: top;
  border-bottom: 1px solid #ccc;
  background: #f3f6f7;
}
table.type09 td {
  width: 200px;
  padding: 10px;
  vertical-align: top;
  border-bottom: 1px solid #ccc;
}

</style>

</head>

<script type="text/javascript">//스크롤내리면 자동으로 이벤트 발생
/*
document.addEventListener('scroll', function(){
	var more = document.getElementById('load-more');
	var event = document.createEvent("MouseEvents"); 
	event.initEvent("click", false, true); 
	more.dispatchEvent(event);
});
*/
</script>

<body>
<!-- 게시글제목 누르면 해당 게시글로 이동(추후 수정 **게시글컨트롤러에게 요청) -->
<div id="mypost">
<h4>내가 쓴 게시글</h4>
<hr>
<div align="right">
	<h6>총 ${total}개</h6>
</div>
<div align="center">
	<table class="type09">
  <thead>
  <tr>
    <th scope="cols">No</th>
    <th scope="cols">제목</th>
    <th scope="cols">등록일자</th>
  </tr>
  </thead>
  <tbody>

  <!-- 내가 쓴 게시글 출력 forEach -->

  <c:forEach var="v" items="${mypostList}" varStatus="status">
	  
	  <tr>
	    <th scope="row">${status.count}</th>
	    <td><a href="ff.jsp">${v.b_title}</a></td>
	    <td>${v.b_date}</td>
	  </tr>
  
  </c:forEach>

  </tbody>
</table>
</div>
<br>
<div align="center"><a id="load-more" href="mypost.mem?cnt=${cnt+1}">더보려면 스크롤을 움직이세요.&gt;&gt;</a></div>
</div>
<br>

</body>
</html>