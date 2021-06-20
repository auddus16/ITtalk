<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        body {
            font-size:20px;
            font-weight:bold;
            margin:30px 30px;
            float: left;
            position:absolute;
        }

        .span{
            margin-top:50px;
        }
        
    </style>
<body>

    <h2>로그인</h2>
    <form>
        <div class="form-group">
            <label for="loginId">아이디</label>
            <input type="text" id="loginId" name="loginId" size="12" placeholder="Username" class="form-control" input style="font-size:20px;" type="text"/><br>
            <label for="loginpw">비밀번호</label>
            <input type="password" id="loginpw" name="password" size="12" placeholder="****" class="form-control" input style="font-size:20px;" type="text"/><br>
        </div>
        <div>
            <span class="find">
                <a href="/member/find/loginId" class="link_find">아이디찾기</a>
                |
                <a href="/member/find/password" class="link_find">비밀번호찾기</a>
                |
                <a href="/registerform.html" class="link_find">회원가입</a>
            </span>
            <button type="submit" disabled input style="font-size:20px;" type="text"/>로그인</button>
        </div>

    </form>


</body>
</head>

</html>