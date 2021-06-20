<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>
        <h3>마이페이지</h3>
    </title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>

    <style>
        ul {
            background-color: #ccc;
            width: 15%;
            padding: 0;
            margin-right: 0;
            margin-top:40px;
            position: fixed;
            height: 25%;
            overflow: auto;

        }

        li a {
            text-decoration: none;
            display:block;
            color: #000;
            padding: 8px 10px;
            font-weight: bold;
        }

        li a.info {
            font-size:15px;
            background-color:lightgray;
            color:black;
        
        }

        button{
            border:2px solid;
            outline:0;
        }

        li a:hover:not(.info) {
            background-color: #333;
            color: #fff;
        }

        title {
            text-align: center;
        }

        header {
            color: white;
            background-color: black;
            padding: 60px;
        }
    </style>
    </main>
    <br><br>
    <header>
        <center><h1>마이페이지</h1></center>
        <section class="site-section">
            <form action="mypage.mem" method="post">
                <div class="categories" style="float:left; margin-left:0; height:100%;">
                    <span style="font-size:20px"><i class="fas fa-search"></i></span>
                    <hr>
                    <ul>
                        <li><button type="submit"><a href="?action=info"><span style="font-size:15px">관리자페이지</span></a></button></li>
                        <li><a href="?action=post">신고게시글</a></li>
                        <li><a href="?action=reply">신고댓글</a></li>
                        <li><a href="?action=alarm">전체 게시글 조회 및 삭제</a></li>
                        <li><a href="?action=store">게시판카테고리 수정</a></li>
                    </ul>
                </div>
            </form>
        </section>
    </header>
</body>

</html>
    