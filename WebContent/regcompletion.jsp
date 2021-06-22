<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        body {
            padding: 90px;
            margin: 90px;
        }

        body.center {
            top: 50px;
            left: 50px, padding:5px;
            
        }

        #divPosition {
            background-color:azure;
            border: 1px solid black;
            height: 40px;
            width: 500px;
            top: 50px;
            left: 50px;
            padding: 30px;
            margin:auto;
            margin-top:30px;
            text-align:center;
            font-weight:bold;
        }
        #image{
            text-align:center;
        }

        .right {
            text-align:center;
            margin-top:70px;
            }
    </style>
</head>

<body>
    <div id="image">
        <img src="computer.jpg" width="190" height="150">
    </div>
    <div id="divPosition">
        회원가입이 완료되었습니다.<br>
        회원이 되신 것을 진심으로 축하드립니다.
    </div>
    <div class="btnfd right">
        <button type=submit id="btnfd" name="button"input style="font-size:18px;" type="text"/><a href="main.main">메인화면으로</a></button>
        <button type=submit id="btnfd" name="button"input style="font-size:18px;" type="text"/><a href="hmy_login.jsp">로그인</a></button>
    </div>

</body>

</html>