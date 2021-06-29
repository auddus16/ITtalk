<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>본인인증</title>
</head>
<body>
	<form method="post" action="checkmem.mem?c=${param.c}" class="p-5 bg-white">
              
          <h2 class="h4 text-black mb-5">본인인증</h2> 

             <div class="row form-group">
               <div class="col-md-6 mb-3 mb-md-0">
                  <label class="text-black" for="pw">비밀번호</label>
                  <input type="password" name="pw" class="form-control"><!-- 회원구분 ${mem.job}-->
                </div>
                </div>
                <br>
              
               <button type="submit"class="btn btn-primary btn-md text-white">확인</button>
                 
            </form>
</body>
</html>