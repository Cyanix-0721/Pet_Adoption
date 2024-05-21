<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <base href="${path}">
    <title>Home</title>
    <!-- Meta tag Keywords -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="UTF-8"/>
    <meta name="keywords" content=""/>
    <!--// Meta tag Keywords -->
    <!-- css files -->
    <link rel="stylesheet" href="${path}/static/bootstrap/css/bootstrap.min.css" type="text/css" media="all">
    <!-- Bootstrap-Core-CSS -->
    <link rel="stylesheet" href="${path}/static/css/user/font-awesome.css" type="text/css" media="all">
    <!-- Font-Awesome-Icons-CSS -->
    <link rel="stylesheet" href="${path}/static/css/user/owl.carousel.css" type="text/css" media="all"/>
    <!-- Owl-Carousel-CSS -->
    <link rel="stylesheet" href="${path}/static/css/user/style.css" type="text/css" media="all"/>

    <!-- Style-CSS -->
    <!-- //css files -->
    <!-- web fonts -->
    <link href="http://fonts.googleapis.com/css?family=Molle:400i&amp;subset=latin-ext" rel="stylesheet">
    <link href="http://fonts.googleapis.com/css?family=Lato:100,100i,300,300i,400,400i,700,700i,900,900i&amp;subset=latin-ext"
          rel="stylesheet">
    <link href="http://fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&amp;subset=latin-ext"
          rel="stylesheet">
</head>
<body>
<!--导航栏-->
<!-- sticky navigation -->
<div class="nav-links">
    <nav class='navbar navbar-default'>
        <div class='container'>
            <div class='collapse navbar-collapse'>
                <ul>
                    <li>
                        <a href="${path}/user/index.jsp">主页</a>
                    </li>
                    <li>
                        <a href="${path}/user/about.jsp">宠物知识</a>
                    </li>
                    <li>
                        <a href="${path}/user/services.jsp">领养中心</a>
                    </li>
                    <li>
                        <a href="${path}/user/blog.jsp">团队博客</a>
                    </li>
                    <li>
                        <a href="${path}/user/team.jsp">团队展示</a>
                    </li>
                    <li>
                        <a href="${path}/user/personal-info.jsp" class="btn-primary btn-lg">修改</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</div>


<!-- //sticky navigation 首页轮播图 -->
<div class="w3l-main" id="home1">
    <div class="container">
        <!-- header -->
        <div class="header">
            <div class="logo">
                <h1>
                    <a href="${path}/user/index.jsp">
                        <img class="logo-img center-block" src="${path}/static/img/logo.png" alt="" width="200px"
                             height="200px"/> 猫狗生活
                    </a>
                </h1>
            </div>
            <div class="clearfix"></div>
        </div>
        <!-- //header -->
    </div>


    <div>
        <img src="${path}/static/img/pp.jpg" width="100%" height="100%"/>
    </div>
    <!-- footer -->
    <section class="footer-w3">
        <div class="container">
            <div class="col-lg-4 col-md-4 col-sm-4 footer-agile1" data-aos="zoom-in">
                <h3>网站简介</h3>
                <p class="footer-p1">
                    该网站是用于想领养宠物和想成为我们其中一员，那么你将再这里实现你的想法。
                    如果你是领养者，请认真选取想要领养的宠物领养后，请认真负责对待可爱的猫狗！
                    如果你是想成为志愿者，请联系我们，我们欢迎任何爱心认识，加入我们！
                </p>
            </div>
            <div class="col-lg-4 col-md-4 col-sm-4 footer-mid-w3" data-aos="zoom-in">
                <h3>宠物展示</h3>
                <div class="agileinfo_footer_grid1">
                    <a href="#">
                        <img src="${path}/static/img/f1.jpg" alt=" " class="img-responsive">
                    </a>
                </div>
                <div class="agileinfo_footer_grid1">
                    <a href="#">
                        <img src="${path}/static/img/f2.jpg" alt=" " class="img-responsive">
                    </a>
                </div>
                <div class="agileinfo_footer_grid1">
                    <a href="#">
                        <img src="${path}/static/img/f3.jpg" alt=" " class="img-responsive">
                    </a>
                </div>
                <div class="agileinfo_footer_grid1">
                    <a href="#">
                        <img src="${path}/static/img/f4.jpg" alt=" " class="img-responsive">
                    </a>
                </div>
                <div class="agileinfo_footer_grid1">
                    <a href="#">
                        <img src="${path}/static/img/f5.jpg" alt=" " class="img-responsive">
                    </a>
                </div>
                <div class="agileinfo_footer_grid1">
                    <a href="#">
                        <img src="${path}/static/img/f6.jpg" alt=" " class="img-responsive">
                    </a>
                </div>
                <div class="clearfix"></div>
            </div>
            <!--联系方式-->
            <div class="col-lg-4 col-md-4 col-sm-4 footer-agile1" data-aos="zoom-in">
                <h3>联系方式</h3>
                <p>电话&nbsp;&nbsp;<span style="font-size: 22px;color: red">14390872021</span></p>
                <br>
                <p>邮件&nbsp;&nbsp;<span style="font-size: 22px;color: red">CatDog@aliyun.com</span></p>
                <br>
                <p>官网&nbsp;&nbsp;<span style="font-size: 22px;color: red">www.pet.adoption.com</span></p>
                <br>
                <p><a href="${path}/admin/login.jsp">管理员登录</a></p>
            </div>

        </div>

    </section>
</div>
</body>
</html>