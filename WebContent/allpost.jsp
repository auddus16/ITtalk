<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<jsp:useBean id="adDAO" class="itTalkDAO.AdminMenu"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자페이지3-전체게시글 확인</title>
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
		tag+='<tr><th scope="row">'+addList[i].b_no+'</th><td>'+addList[i].b_title+'</td><td>'+addList[i].mb_no+'</td><td>'+addList[i].b_hits+'</td><td>';
		tag+=addList[i].b_cnt+'</td><td>'+addList[i].b_report+'</td><td>'+addList[i].b_date+'</td>';
		tag+='<td><a href="post.do?b_no='+addList[i].b_no+'">조회</a></td>';
		tag+='<td><a href="addelpost2.ad?b_no='+addList[i].b_no+'">삭제</a></td></tr>';
	}
	
	
	document.addEventListener('scroll', function() {
	
    var currentScrollValue = document.documentElement.scrollTop; //스크롤 위치 구하기
    
    if(currentScrollValue>200){
    	//document.getElementById("postTable").insertRow(-1).innerHTML = tag;
    	//$('#height').append(tag);//table의 tbody요소 앞에 append
    	$('#adallpostTable').append(tag);
    	tag=null;
    }
    });
</script>
</head>
<body>

<div id="adpost" align="center">
<h4>전체 게시글 조회 및 삭제</h4>
<hr>
<div align="right">
	<h6>총 ${fn:length(adallpostList)}개</h6>
</div>
<div align="center">
		<table class="type09" id="adallpostTable" >
  <thead>
  <tr>
    <th scope="cols">NO</th>
    <th scope="cols">제목</th>
    <th scope="cols">작성자</th>
    <th scope="cols">조회수</th>
    <th scope="cols">댓글수</th>
    <th scope="cols">신고수</th>
    <th scope="cols">등록일자</th>
    <th scope="cols">조회</th>
    <th scope="cols">삭제</th>
  </tr>
  </thead>
  <tbody>

<!-- 

private int b_no;
	private int mb_no;
	private int bc_no;
	private String b_title;
	private String b_write;
	private String b_file;
	private String b_date;
	private int b_hits;
	private boolean b_deleted;
	private int b_report;
	private int b_cnt;
 -->

  <c:forEach var="v" items="${adallpostList}" end="9" varStatus="status">
	  
	  <tr>
	    <th scope="row">${v.b_no}</th>
	    <td>${v.b_title}</td>
	    <td>${v.mb_no}</td>
	    <td>${v.b_hits}</td>
	    <td>${v.b_cnt}</td>
	    <td>${v.b_report}</td>
	    <td>${v.b_date}</td>
	    <td><a href="post.do?b_no=${v.b_no}">조회</a></td><!-- 게시판 컨롤 -->
	    <td><a href="addelpost2.ad?b_no=${v.b_no}">삭제</a></td>
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