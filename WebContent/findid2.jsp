<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <style>
        .btnfd2 {
            margin-left: 300px;
        }

        .btnfd3 {
            margin-left: 220px;
            margin-top: 50px;
        }

        button {
            color: linen;
            background: lightseagreen;
            border: 2px solid white;
            font-size: 17px;
            border-radius: 6px;
            box-shadow: 0 4px 6px -1px rgba(0, 0, 0, 0.1), 0 2px 4px -1px rgba(0, 0, 0, 0.06);
            cursor: pointer;
            transition: 0.5s;
        }

        header{
            margin:70px 100px;
        }
    </style>

</head>

<body>
    <form>
        <header>
            <h1>회원님의 아이디는 다음과 같습니다.</h1>
            <h1>ab*****</h1>
        </header>
        <div class="btnfd2">
            <button type=submit id="btnfd2" button name="button"><a href="">로그인</a></button>
        </div>

        <div class="btnfd3">
            <strong>비밀번호를 잃어버리셨나요?</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button type="submit" id="btnfd3" button
                name="button"><a href="">비밀번호 재설정</a></button>
        </div>
    </form>
</body>

</html>