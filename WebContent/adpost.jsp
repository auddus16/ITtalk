<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<jsp:useBean id="adDAO" class="itTalkDAO.AdminMenu"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자페이지1-신고게시글 확인</title>
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
  width: 60px;
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
		var n= parseInt(addList[i].rctg_no);
		console.log(n);
		var s= "<c:out value='${adDAO.getReportCategory(n)}' />";
		tag+='<tr><th scope="row">'+addList[i].b_no+'</th><td>'+addList[i].mb_no+'</td><td>'+s+'</td><td>'+addList[i].rb_write+'</td><td>';
		tag+=addList[i].rb_date+'</td>';
		tag+='<td><a href="post.do?b_no='+addList[i].b_no+'">조회</a></td>';
		tag+='<td><a href="removeblind.ad?b_no='+addList[i].b_no+'">blind해제</a></td>';
		tag+='<td><a href="addelpost.ad?b_no='+addList[i].b_no+'">삭제</a></td></tr>';
	}
	document.addEventListener('scroll', function() {
	
    var currentScrollValue = document.documentElement.scrollTop; //스크롤 위치 구하기
    
    if(currentScrollValue>200){
    	//document.getElementById("postTable").insertRow(-1).innerHTML = tag;
    	//$('#height').append(tag);//table의 tbody요소 앞에 append
    	$('#adpostTable').append(tag);
    	tag=null;
    }
    });
</script>
</head>

<body>

<div id="adpost" align="center">
<h4>신고 게시글</h4>
<hr>
<div align="right">
	<h6>총 ${fn:length(adpostList)}개</h6>
</div>
<div align="center">
		<table class="type09" id="adpostTable">
  <thead>
  <tr>
    <th scope="cols">NO</th>
    <th scope="cols">제목</th>
    <th scope="cols">신고유형</th>
    <th scope="cols">신고내용</th>
    <th scope="cols">신고일자</th>
    <th scope="cols">조회</th>
    <th scope="cols">블라인드해제</th>
    <th scope="cols">삭제</th>
  </tr>
  </thead>
  <tbody>

  <!-- 신고게시글 출력 forEach 
  private int rb_no;
	private int b_no;
	private int mb_no;
	private int rctg_no;
	private String rb_write;
	private String rb_date;
  -->

  <c:forEach var="v" items="${adpostList}" end="9" varStatus="status">
	  
	  <tr>
	    <th scope="row">${v.b_no}</th>
	    <td>${v.mb_no}</td>
	    <td>${adDAO.getReportCategory(v.rctg_no)}</td>
	    <td>${v.rb_write}</td>
	    <td>${v.rb_date}</td>
	    <td><a href="post.do?b_no=${v.b_no}">조회</a></td><!-- 게시판 컨롤 -->
	    <td><a href="removeblind.ad?b_no=${v.b_no}">blind해제</a></td>
	    <td><a href="addelpost.ad?b_no=${v.b_no}">삭제</a></td>
	  </tr>
  
  </c:forEach>
	
  </tbody>
</table>
</div>
<br>
<div align="center"><a id="load-more" href="adpost.ad?cnt=${cnt+3}">더보려면 스크롤을 움직이세요.&gt;&gt;</a></div>
</div>
<br>

</body>
</html>