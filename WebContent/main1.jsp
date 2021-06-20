<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>ITtalk</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="https://fonts.googleapis.com/css?family=Quicksand:300,400,500,700,900" rel="stylesheet">
    <link rel="stylesheet" href="fonts/icomoon/style.css">

    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/jquery-ui.css">
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">

    <link rel="stylesheet" href="css/jquery.fancybox.min.css">

    <link rel="stylesheet" href="css/bootstrap-datepicker.css">

    <link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">

    <link rel="stylesheet" href="css/aos.css">

    <link rel="stylesheet" href="css/style.css">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    
  </head>
  <body data-spy="scroll" data-target=".site-navbar-target" data-offset="300">
  
    <header style="margin-top:0;"class="site-navbar bg-white js-sticky-header site-navbar-target" role="banner">

      <div class="container">
        <div class="row align-items-center">
          
          <div class="col-11 col-xl-2">
            <h1 class="mb-0 site-logo"><a href="hmy_main.jsp" class="text-black h2 mb-0"><span style="color:white">ITtalk</span><span class="text-primary">.</span></a></h1>
          </div>
          <div class="col-12 col-md-10 d-none d-xl-block">
            <nav class="site-navigation position-relative text-right" role="navigation">

              <ul class="site-menu main-menu js-clone-nav mr-auto d-none d-lg-block">
                <li><a href="#work-section" class="nav-link"><span style="color:white">게시판</span></a></li>
                <li>
                  <a href="#services-section" class="nav-link"><span style="color:white">글쓰기</span></a>
                </li>
                <!-- 커스텀 태그 : 로그인/로그아웃, 마이페이지/관리자메뉴 -->
                <li><a href="#work-section" class="nav-link"><span style="color:white">로그인/로그아웃</span></a></li>
                <li><a href="#work-section" class="nav-link"><span style="color:white"><i class="fab fa-users"></i></span>
              </ul>
            </nav>
          </div>


          <div class="d-inline-block d-xl-none ml-md-0 mr-auto py-3" style="position: relative; top: 3px;"><a href="#" class="site-menu-toggle js-menu-toggle text-black"><span class="icon-menu h3"></span></a></div>

        </div>
        </div>
         <style>


        .nav-link{
            background:dodgerblue;
            width:70px;
            height:20px;
            font-size:16px;
            font-family:'Nanum Gothic';
            text-align:center;
            border-radius: 6px;
            text-shadow:2px 2px 8px blue;
            margin-top:40px;
        }   
        
        button{
            background:dodgerblue;border:1px solid white;
            width:70px;
            height:20px;
            font-size:20px;
            font-family:'Nanum Gothic';
            text-align:center;
            border-radius: 5px;
        }
        
        button1{
            background:gray;border:1px solid;
            width:70px;
            height:20px;
            font-size:15px;
            font-family:'Nanum Gothic';
            text-align:center;
            border-radius: 5px;
            
        }   

        .search{
            position:relative;
            width:400px;
            margin:0 auto;
        }

        header{
            color:white;
            background-color:black;
            padding:20px;
        }
        
        ul{
                margin: 0;
                padding: 0;
                list-style-type: none;
                float: right;
            }
            li{
                display: inline;
                margin: 40px 0;
            }
        
        table{
            width: 300px;
            height:100px;
            border:1px solid #444444;
            border-collapse: collapse;
            text-align:center;
        }

        th,td{
            border:1px solid #444444;
        }

        thead{
            background-color:lightgray;
        }

        footer{
            border:4px solid whitesmoke;
            color:whitesmoke;
            position:fixed;
            width:100%;
            height:250px;
            background-color:black;
            text-align:center;
            line-height:65%;
            padding:0 auto;
            margin-top:30px;

        }

        </style>
      
    </header>
   <section class="site-section">
      <div class="container" style="text-align:center;">
        <div style="display:inline-block">
        <form action="#" method="post">
            <h1>ITtalk</h1>
            <i class="fas fa-search"></i>
           <tr><td><input type="text" class="form-control" size="26" placeholder="검색할 내용을 입력하세요!"></td>
           <td><input type="submit" class="btn btn-primary btn-md text-white" value="검색"></td></tr>
        </table>
      </form>
      </div>
      </div>
    </section>

    <br>
    <hr>
    <br>

    <section class="site-section">
        <div class="p-4 mb-3 bg-white" style="text-align:center;">
           <div style="display:inline-block">
           <dl>
                <dt><h1>실시간 인기글<h1></dt>
                <table border="1">
                    <dd>
                        <ol>
                            <thead>
                                <tr>
                                    <th>No.</th> <th>Name</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>1</td> <td><a href="#">1 게시물</a></td>
                                </tr>
                                <tr>
                                    <td>2</td> <td><a href="#">2 게시물</a></td>
                                </tr>
                                <tr>
                                    <td>3</td> <td><a href="#">3 게시물</a></td>
                                </tr>
                                <tr>
                                    <td>4</td> <td><a href="#">4 게시물</a></td>
                                </tr>
                                <tr>
                                    <td>5</td> <td><a href="#">5 게시물</a></td>
                                </tr>
                                <tr>
                                    <td>6</td> <td><a href="#">6 게시물</a></td>
                                </tr>
                                <tr>
                                    <td>7</td> <td><a href="#">7 게시물</a></td>
                                </tr>
                                <tr>
                                    <td>8</td> <td><a href="#">8 게시물</a></td>
                                </tr>
                                <tr>
                                    <td>9</td> <td><a href="#">9 게시물</a></td>
                                </tr>
                                <tr>
                                    <td>10</td> <td><a href="#">10 게시물</a></td>
                                </tr>
                            </tbody>
                        </ol>
                    </dd>
                </table>
            </dl>
            </div>   
        </div>
     </section>
        
    
    <footer class="site-footer">
      <div class="container">
        <div class="row">
          <div class="col-md-9">
            <div class="row">
              <div class="col-md-5">
                <h3 class="footer-heading mb-4">About Us</h3>
                <!--Lorem ipsum dolor sit amet consectetur adipisicing elit. Neque facere laudantium magnam voluptatum autem. Amet aliquid nesciunt veritatis aliquam.-->
              </div>
              <div class="col-md-3 ml-auto">
                <h3 class="footer-heading mb-4">Features</h3>
                <ul class="list-unstyled">
                  <!--<li><a href="#">About Us</a></li>
                  <li><a href="#">Services</a></li>
                  <li><a href="#">Testimonials</a></li>
                  <li><a href="#">Contact Us</a></li>-->
                  
                </ul>
              </div>
              <div class="col-md-3">
                <h3 class="footer-heading mb-4">Follow Us</h3>
                <a href="#" class="pl-0 pr-3"><span style="color:blue"><i class="fab fa-twitter fa-2x"></i></span>
                <a href="#" class="pl-3 pr-3"><span style="color:blue"><i class="fab fa-facebook fa-2x"></i></span>
                <a href="#" class="pl-3 pr-3"><span style="color:blue"><i class="fab fa-instagram fa-2x"></i></span>
                <a href="#" class="pl-3 pr-3"><span style="color:blue"><i class="fab fa-linkedin-in fa-2x"></i></span>
              </div>
            </div>
          </div>
          <div class="col-md-3">
            <h3 class="footer-heading mb-4">Subscribe Newsletter</h3>
            <form action="#" method="post">
              <div class="input-group mb-3">
                <input type="text" class="form-control border-secondary text-white bg-transparent" placeholder="Enter Email" aria-label="Enter Email" aria-describedby="button-addon2">
                <div class="input-group-append">
                  <button class="btn btn-primary text-white" type="button" id="button-addon2">Send</button>
                </div>
              </div>
            </form>
          </div>
        </div>
        <div class="row pt-5 mt-5 text-center">
          <div class="col-md-12">
            <div class="border-top pt-5">
            <p>
            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
            Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="icon-heart text-danger" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank" >Colorlib</a>
            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
            </p>
            </div>
          </div>
          
        </div>
      </div>
    </footer>

  </div> <!-- .site-wrap -->

  <script src="js/jquery-3.3.1.min.js"></script>
  <script src="js/jquery-migrate-3.0.1.min.js"></script>
  <script src="js/jquery-ui.js"></script>
  <script src="js/popper.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/owl.carousel.min.js"></script>
  <script src="js/jquery.stellar.min.js"></script>
  <script src="js/jquery.countdown.min.js"></script>
  <script src="js/bootstrap-datepicker.min.js"></script>
  <script src="js/jquery.easing.1.3.js"></script>
  <script src="js/aos.js"></script>
  <script src="js/jquery.fancybox.min.js"></script>
  <script src="js/jquery.sticky.js"></script>

  <script src="js/typed.js"></script>
            <script>
            var typed = new Typed('.typed-words', {
            strings: ["Web Apps"," WordPress"," Mobile Apps"],
            typeSpeed: 80,
            backSpeed: 80,
            backDelay: 4000,
            startDelay: 1000,
            loop: true,
            showCursor: true
            });
            </script>

  <script src="js/main.js"></script>
  


  </body>
</html>