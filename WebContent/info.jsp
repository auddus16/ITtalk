<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                  <input type="text" name="job" class="form-control" required><!-- 회원구분 ${mem.job}-->
                </div>
                <br>
                <div class="col-md-6">
                  <label class="text-black" for="nick">닉네임</label>
                  <input type="text" name="nick" class="form-control" required><!-- 닉네임 ${mem.nick}-->
                  <button type="submit" name="action" value="checknick" class="btn btn-primary btn-md text-white" formaction="control_user.jsp">중복확인</button>
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
                  <input type="password" name="pw" class="form-control" required>
                  <button class="btn btn-primary btn-md text-white" onclick="javascript:newpw();">변경</button>
                </div>
              </div>

              <div class="row form-group">
                <div class="col-md-6">
                <button type="submit" class="btn btn-primary btn-md text-white" formaction="withdraw.mem">회원탈퇴</button>
                <button type="submit" class="btn btn-primary btn-md text-white" formaction="modify.mem">수정완료</button>
                </div> 
                </div> 
            </form>
</div>
</body>
</html>