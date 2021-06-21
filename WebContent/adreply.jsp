<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자페이지-1신고게시글</title>
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
  width: 300px;
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
<!-- 게시글제목 누르면 해당 게시글로 이동(추후 수정 **게시글컨트롤러에게 요청) -->
<!-- 삭제액션 -->
<div>
<h4>신고댓글</h4>
<hr>
	<table class="type09">
  <thead>
  <tr>
    <th scope="cols">신고댓글번호</th>
    <th scope="cols">신고자</th>
    <th scope="cols">신고유형</th>
    <th scope="cols">신고내용</th>
    <th scope="cols">신고일자</th>
    <th scope="cols">삭제</th>
  </tr>
  </thead>
  <tbody>
  <!-- 신고받은 게시글forEach -->
  <tr>
    <th scope="row">댓글번호1</th>
    <td>신고자1</td>
    <td>신고유형1</td>
    <td>신고내용1</td>
    <td>신고일자</td>
    <td><button class="btn btn-primary btn-md text-white">삭제</button></td>
  </tr>
  
  </tbody>
</table>
</div>
<br>

</body>
</html>