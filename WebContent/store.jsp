<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지3-좋아요 게시글</title>
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

<script src="jquery-3.6.0.min.js"></script>
<script type="text/javascript">//스크롤내리면 자동으로 이벤트 발생
    var tag="";
	var list= JSON.parse('${json}');
	var addList=list.slice(10);//10번 인덱스부터 끝까지
    
	for(var i=0; i<addList.length; i++){
		tag+='<tr><th scope="row">'+(11+i)+'</th><td><a href="post.do?b_no='+addList[i].b_no+'">';
		tag+=addList[i].b_no+'</a></td><td>'+addList[i].bs_date+'</td></tr>';
	}

	document.addEventListener('scroll', function() {
	
    var currentScrollValue = document.documentElement.scrollTop; //스크롤 위치 구하기
    
    if(currentScrollValue>200){
    	//document.getElementById("postTable").insertRow(-1).innerHTML = tag;
    	//$('#height').append(tag);//table의 tbody요소 앞에 append
    	$('#storeTable').append(tag);
    	tag=null;
    }
    });
</script>

</head>
<body>
<!-- 게시글제목 누르면 해당 게시글로 이동(추후 수정 **게시글컨트롤러에게 요청) -->
<div id="mystore" align="center">
<h4>좋아요 게시글</h4>
<hr>
<div align="right">
	<h6>총 ${fn:length(mystoreList)}개</h6>
</div>
<div id="mystoretable" align="center">
		<table class="type09" id="storeTable">
  <thead>
  <tr>
    <th scope="cols">No</th>
    <th scope="cols">게시글번호</th>
    <th scope="cols">등록일자</th>
  </tr>
  </thead>
  <tbody>

  <!-- 내가 쓴 게시글 출력 forEach -->

  <c:forEach var="v" items="${mystoreList}" varStatus="status">
	  
	  <tr>
	    <th scope="row">${status.count}</th>
	    <td><a href="post.do?b_no=${v.b_no}">${v.b_no}</a></td>
	    <td>${v.bs_date}</td>
	  </tr>
  
  </c:forEach>
	
  </tbody>
</table>
</div>
<br>
<div align="center"><a id="load-more" href="myreply.mem?cnt=${cnt+3}">더보려면 스크롤을 움직이세요.&gt;&gt;</a></div>
</div>
<br>

</body>
</html>