<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신고하기</title>
</head>
<body>
	<form method="post" action="report2.do" class="p-5 bg-white">
          <input type="hidden" name="c_no" value="${param.c_no}">    
          <h2 class="h4 text-black mb-5">신고하기</h2> 

             <div class="row form-group">
               <div class="col-md-6 mb-3 mb-md-0">
                  <label for="pet-select">신고유형 *</label>
						<select name="cate" id="category">
    						<option value="1">비방</option>
    						<option value="2">욕설</option>
    						<option value="3">음담패설</option>
    						<option value="4">기타</option>
						</select>
                </div>
                    <label for="message">내용 *</label>
                <div class="form-group">
                    <textarea name="r_write" id="message" cols="25" rows="10" placeholder="신고내용을 작성해주세요."required></textarea>
                  </div>
                </div>
                <br>
              
               <button type="submit"style="float:center;">완료</button>
                 
            </form>
</body>
</html>