<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 닉네임, 아이디, 비밀번호, 이메일 -->

<div style="text-align:left;">
<form action="setInfo.mem" class="p-5 bg-white">
              
              <h2 class="h4 text-black mb-5">개인정보</h2> 

              <div class="row form-group">
                <div class="col-md-6 mb-3 mb-md-0">
                  <label class="text-black" for="job">회원구분</label>
                  <input type="text" id="job" class="form-control"><!-- 회원구분 ${mem.job}-->
                </div>
                <br>
                <div class="col-md-6">
                  <label class="text-black" for="nick">닉네임</label>
                  <input type="text" id="nick" class="form-control"><!-- 닉네임 ${mem.nick}-->
                  <button class="btn btn-primary btn-md text-white">중복확인</button>
                </div>
              </div>

              <div class="row form-group">
                
                <div class="col-md-12">
                  <label class="text-black" for="id">아이디</label> 
                  <input type="text" id="id" class="form-control">
                </div>
              </div>

              <div class="row form-group">
                
                <div class="col-md-12">
                  <label class="text-black" for="pw">비밀번호</label> 
                  <input type="password" id="pw" class="form-control">
                  <button class="btn btn-primary btn-md text-white">변경</button>
                </div>
              </div>

              <div class="row form-group">
                <div class="col-md-6">
                  <input type="submit" value="회원탈퇴" class="btn btn-primary btn-md text-white">
                  <input type="submit" value="수정완료" class="btn btn-primary btn-md text-white">
                </div> 
                </div> 
            </form>
</div>
</body>
</html>