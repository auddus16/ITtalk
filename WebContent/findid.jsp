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
            margin:0 170px;
        }

        .right {
            margin-left: 200px;
            margin-top: 50px;
        }

        header{
            margin:100px 200px;
        }

    </style>
</head>

<body>
    <header>
        <h1>아이디찾기</h1>
    </header>
    <form>
        <div class="address right">
            <label for="emailad"></label>
            <input type="text" id="emailad" name="emailad" size="20" placeholder="이메일을 입력해주세요" input style="font-size:20px;" type="text"/>
        </div>
        <div class="btnfd1 right">
            <button type=submit id="btnfd1" button name="button" input style="font-size:20px;" type="text"><a href="">찾기</a></button>
        </div>
    </form>
</body>

</html>