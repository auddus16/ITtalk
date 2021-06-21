<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
</head>
<body>

<div id="adpost" align="center">
<h4>신고 게시글</h4>
<hr>
<div align="right">
	<h6>총 ${fn:length(adpostList)}개</h6>
</div>
<div id="adposttable" align="center">
		<table class="type09">
  <thead>
  <tr>
    <th scope="cols">게시글번호</th>
    <th scope="cols">신고회원번호</th>
    <th scope="cols">신고내용</th>
    <th scope="cols">신고일자</th>
    <th scope="cols">조회</th>
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

  <c:forEach var="v" items="${adpostList}" varStatus="status">
	  
	  <tr>
	    <th scope="row">${v.b_no}</th>
	    <td>${v.mb_no}</td>
	    <td>${v.rctg_no}</td>
	    <td>${v.rb_write}</td>
	    <td>${v.rb_date}</td>
	    <td><a href="ff.jsp">${v.rb_date}</a></td><!-- 게시판 컨롤 -->
	    <td><a href="ff.jsp">${v.rb_date}</a></td>
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