<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 설정</title>
</head>
<body>
<form class="p-5 bg-white">
              
          <h2 class="h4 text-black mb-5">새로운 비밀번호 설정</h2> 

             <div class="row form-group">
               <div class="col-md-6 mb-3 mb-md-0">
                  <label class="text-black" for="pw">비밀번호</label>
                  <input type="password" name="pw" class="form-control">
                </div>
                </div>
             <div class="row form-group">
               <div class="col-md-6 mb-3 mb-md-0">
                  <label class="text-black" for="pw">비밀번호 확인</label>
                  <input type="password" name="checkpw" class="form-control">
                </div>
                </div>
                <br>
              
               <button type="submit" class="btn btn-primary btn-md text-white" formaction="modifypw.mem">확인</button>
               <button type="submit" class="btn btn-primary btn-md text-white" onclick="javascript:window.open('','_self').close();">취소</button>
                 
            </form>
</body>
</html>