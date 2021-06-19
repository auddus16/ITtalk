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
<script src="jquery-3.6.0.min.js"></script>
<script type="text/javascript">//스크롤내리면 자동으로 이벤트 발생
//추가될 태그를 문자열로,,
$(document).ready(function(){
	var list='<c:out value="${mypostList}"/>';
	var addList=list.slice(10);//10번 인덱스부터 끝까지
	
	$('#postTable').scroll(function(){
		var scrollT = $(this).scrollTop(); //스크롤바의 상단위치
        var scrollH = $(this).height(); //스크롤바를 갖는 div의 높이
        var contentH = $('#hei').height(); //문서 전체 내용을 갖는 div의 높이
        if(scrollT + scrollH +1 >= contentH) { // 스크롤바가 아래 쪽에 위치할 때
        	for(var i=0; i<addList.size(); i++){
        		var tag='<tr><th scope="row">'+(11+i)+'</th><td><a href="ff.jsp">'
        		tag+=addList[i].b_title+'</a></td><td>'+addList[i].b_date+'</td></tr>';
        	}
        	$('#postTable>tbody').prepend(tag);//table의 tbody요소 앞에 append
        }
	});
});
</script>

<body>
<!-- 게시글제목 누르면 해당 게시글로 이동(추후 수정 **게시글컨트롤러에게 요청) -->
<div id="mypost">
<h4>내가 쓴 게시글</h4>
<hr>
<div align="right">
	<h6>총 ${fn:length(mypostList)}개</h6>
</div>
<div id="postTable" align="center">
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

  <c:forEach var="v" items="${mypostList}" end="9" varStatus="status">
	  
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