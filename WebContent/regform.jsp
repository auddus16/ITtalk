<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        .labelfd {
            float:left;width:120px;text-align:right;padding-right:10px;
        }

        #gender {
            display:inline-block;width:15%;
        }

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

        .right {
            margin-left:450px; margin-top:30px;
        }

        body {
            font-size:20px;
            font-weight:bold;
            margin-top:10px;
            float: left;
            position:absolute;
        }

    </style>
</head>

<body>
    <h1>&nbsp;&nbsp;&nbsp;회원가입</h1>
    <form name="registerform" method="post" enctype="multipart/form-data" action="./register">
        <div class="btnfd">
            <img src="" width="150" height="150"></div>
        <div class="labelfd">
            <label for="profile">회원이미지</label></div>
        <div class="formfd">
            <input type="file" id="profile" name="profile" required input style="font-size:20px;" type="text"/>
        </div>
        <div class="labelfd">
            <label for="username">이름</label>
        </div>
        <div class="formfd">
            <input type="text" id="username" name="username" size="30" placeholder="이름을 입력해주세요" input style="font-size:20px;" type="text"/>&nbsp;&nbsp;<button
                type="submit">중복확인</button>
        </div>
        <!-- DB와 중복확인-->
        <div class="labelfd"><label for="nickname">닉네임</label></div>
            <div class=" formfd">
                <input type=" text" id="nickname" name="Nickname" size="30" placeholder="닉네임을 입력해주세요" input style="font-size:20px;" type="text"/>
        </div>
        <div class="labelfd"><label for="gender">성별</label></div>
        <div class="formfd">
            <select id="gender" name="gender" input style="font-size:20px;" type="text">
                <option value="M" selected>남자</option>
                <option value="F">여자</option>
            </select>
        </div>
        <div class="labelfd"><label for="userid">아이디</label></div>
        <div class="formfd">
            <input type="text" id="userid" name="userid" size="30" placeholder="아이디를 입력해주세요" input style="font-size:20px;" type="text"/>
        </div>
        <div class="labelfd"><label for="userpw">비밀번호</label></div>
        <div class="formfd">
            <input type="text" id="userpw" name="password" size="40" maxlength="8" placeholder="비밀번호 입력(영어소문자 + 숫자8~12자리)" input style="font-size:20px;" type="text"/>
        </div>
        <div class="labelfd"><label for="Re_pw">재입력</label></div>
        <div class="formfd">
            <input type="text" name="Re_pw" size="30" placeholder="비밀번호를 재입력해주세요" input style="font-size:20px;" type="text"/>
        </div><br>
        <div class="labelfd"><label for="email">이메일주소</label></div>
        <div class="formfd">
            <input type="text" id="email" name="email" size="30" maxlength="20" autocomplete="off" input style="font-size:20px;" type="text"/><span>@</span>
            <input type="text" id="email01" list="domains" placeholder="도메인선택" input style="font-size:20px;" type="text"/>&nbsp;&nbsp;<button
            type="submit">이메일인증</button>
        </div>
        <datalist id="domains">
            <option value="naver.com">
            <option value="daum.net">
            <option value="gmail.com">
        </datalist>
        <!-- 이메일인증 확인-->
        <div class="btnfd right"><button name="button">예비개발자</button> <button name="button">개발자</button>
        <button type="submit">가입하기</button></div>
        </div>

    </form>

</body>

</html>