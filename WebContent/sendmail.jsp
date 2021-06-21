<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        button {
            color: linen;
            background: lightseagreen;
            border: 2px solid white;
            font-size: 19px;
            border-radius: 6px;
            box-shadow: 0 4px 6px -1px rgba(0, 0, 0, 0.1), 0 2px 4px -1px rgba(0, 0, 0, 0.06);
            cursor: pointer;
            transition: 0.5s;
        }

        #h1 {
            text-align: center;
        }

        #h2 {
            text-align: center
        }

        .wrapper{
            display:flex;
            justify-content:center;
            align-items:center;
            min-height:100vh;
        }
    </style>
</head>

<body>
    <form>
        <div class="wrapper">
            <div class="content">
                <center>
                    <h1>이메일이 전송되었습니다!!</h1>
                    <span style="color:lightseagreen">
                        <h2>abc1234@naver.com로</h2>
                    </span>
                    <span style="color:lightseagreen">
                        <h2>비밀번호 안내 메일을 보내드렸습니다.</h2>
                    </span>

                    <div class="btnfd5">
                        <button type=submit id="btnfd5" button name="button"><a href="">홈으로</a></button>
                    </div>
                </center>
            </div>
        </div>
    </form>
</body>

</html>