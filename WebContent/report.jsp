<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신고하기</title>
</head>
<body>
	<form method="post" action="#" class="p-5 bg-white">
              
          <h2 class="h4 text-black mb-5">신고하기</h2> 

             <div class="row form-group">
               <div class="col-md-6 mb-3 mb-md-0">
                  <label for="pet-select">신고유형 *</label><!-- 이부분 카테고리table에서 카테고리가져와서 출력 -->
						<select name="pets" id="category">
    						<option value="1">비방</option>
    						<option value="2">욕설</option>
    						<option value="3">음담패설</option>
    						<option value="4">기타</option>
						</select>
                </div>
                    <label for="message">내용 *</label>
                <div class="form-group">
                    <textarea name="" id="message" cols="25" rows="10" required>신고내용적어요!</textarea>
                  </div>
                </div>
                <br>
              
               <button type="submit"style="float:center;">완료</button>
                 
            </form>
</body>
</html>