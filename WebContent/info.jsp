<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function newpw(){
	window.open("newpw.jsp","_blank","titlebar=no,location=no,scrollbars=no,resizeable=no,menubar=no,toolbar=no,width=400,height=300"
	//어떤 페이지를 어떻게 띄울지 옵션
);
}

function newpw2(){
	window.open("newpw.jsp?c=withdraw","_blank","titlebar=no,location=no,scrollbars=no,resizeable=no,menubar=no,toolbar=no,width=400,height=300"
	//어떤 페이지를 어떻게 띄울지 옵션
);
}
</script>
</head>
<body>
<!-- 닉네임, 아이디, 비밀번호, 이메일 -->
<div style="text-align:left;">
<form class="p-5 bg-white">
              
              <h2 class="h4 text-black mb-5">개인정보</h2> 

              <div class="row form-group">
                <div class="col-md-6 mb-3 mb-md-0">
                  <label class="text-black" for="job">회원구분</label>
                  <c:choose>
	<c:when test="${myInfo.mb_job == true}"><!-- 개발자/예비개발자 구분하는 부분 -->
			<!-- 예비 -->
			<input type="text" name="job" class="form-control" value="개발자" required><!-- 회원구분 ${mem.job}-->
		</c:when>
		<c:otherwise>
			<!-- 개발자 -->
			<input type="text" name="job" class="form-control" value="예비개발자" required>
		</c:otherwise>
	</c:choose>
                </div>
                <br>
                <div class="col-md-6">
                  <label class="text-black" for="nick">닉네임</label>
                  <%
                  String n = request.getParameter("nick");
                  if(n!=null){
                	  
					%>
                  <input type="text" name="nick" class="form-control" value='<%=n %>' required><!-- 닉네임 ${mem.nick}-->
					<%
                  }
					else {
					%>
                  <input type="text" name="nick" class="form-control" value="${myInfo.mb_nick}" required><!-- 닉네임 ${mem.nick}-->
					<%	
						
					}
                  %>
                  <button type="submit" name="action" value="checknick" class="btn btn-primary btn-md text-white" formaction="checknick.mem">중복확인</button>
                </div>
              </div>

              <div class="row form-group">
                
                <div class="col-md-12">
                  <label class="text-black" for="id">아이디</label> 
                  <input type="text" name="id" class="form-control"  value="${myInfo.mb_id}"  disabled>
                </div>
              </div>

              <div class="row form-group">
                
                <div class="col-md-12">
                  <label class="text-black" for="pw">비밀번호</label> 
                  <input type="password" name="pw" class="form-control" value="${myInfo.mb_pw}" disabled>
                  <button class="btn btn-primary btn-md text-white" onclick="javascript:newpw();">변경</button>
                </div>
              </div>

              <div class="row form-group">
                <div class="col-md-6">
                <button type="submit" class="btn btn-primary btn-md text-white" onclick="javascript:newpw2();">회원탈퇴</button>
                
                <c:choose>
	<c:when test="${flag == true}">
			<button type="submit" class="btn btn-primary btn-md text-white" formaction="modify.mem">수정완료</button>
		</c:when>
		<c:otherwise>
			<button type="submit" class="btn btn-primary btn-md text-white" formaction="modify.mem" onmouseover="<div>닉네임 중복확인하세요.</div>"disabled>수정완료</button>
		</c:otherwise>
	</c:choose>
                </div> 
                </div> 
            </form>
          <div>${flag}</div>
</div>
</body>
</html>