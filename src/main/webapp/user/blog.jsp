<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="UTF-8">
    <title>Title</title>
    <!-- Meta tag Keywords -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="UTF-8" />
    <meta name="keywords" content=""/>
    <!--// Meta tag Keywords -->
    <!-- css files -->
    <link rel="stylesheet" href="${path}/static/bootstrap/css/bootstrap.css" type="text/css" media="all">
    <!-- Owl-Carousel-CSS -->
    <link rel="stylesheet" href="${path}/static/css/user/style.css" type="text/css" media="all" />
	<style>        body {
            background-image: url("${path}/static/img/bg3.jpg");
            background-repeat: no-repeat;
            background-size: cover;
        }
    </style>
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
                        <a href="${path}/user/personal-info.jsp" class="btn-primary btn-lg" >修改</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</div>
<!-- blog -->
<div class="blog" id="blog">
    <div class="container">
        <h3 class="agile-title">我们的团队活动</h3>

        <div class="col-md-5 col-xs-6 blog-grids">
            <div class="blog-full-wthree">
                <div class="blog-left-agileits">
                    <p>Jan</p>
                    <span>18</span>
                </div>
                <div class="blog-right-agileits-w3layouts">
                    <h4>
                        <a href="#" data-toggle="modal" data-target="#myModal2">那天我们团体带着所有的狗狗去公园玩耍</a>
                    </h4>
                    <p>
                        <a href="#" data-toggle="modal" data-target="#myModal2">Dog Life</a>
                    </p>
                </div>
                <div class="clearfix"> </div>
            </div>
            <div class="blog-full-wthree">
                <div class="blog-left-agileits">
                    <p>Feb</p>
                    <span>22</span>
                </div>
                <div class="blog-right-agileits-w3layouts">
                    <h4>
                        <a href="#" data-toggle="modal" data-target="#myModal2">那天我们团队邀请路人进店参观</a>
                    </h4>
                    <p>
                        <a href="#" data-toggle="modal" data-target="#myModal2">Dog and Cat Life</a>
                    </p>
                </div>
                <div class="clearfix"> </div>
            </div>
            <div class="blog-full-wthree">
                <div class="blog-left-agileits">
                    <p>Feb</p>
                    <span>15</span>
                </div>
                <div class="blog-right-agileits-w3layouts">
                    <h4>
                        <a href="#" data-toggle="modal" data-target="#myModal2">那天我们邀请一个班级的小朋友进店参观</a>
                    </h4>
                    <p>
                        <a href="#" data-toggle="modal" data-target="#myModal2">Dog and Cat Life</a>
                    </p>
                </div>
                <div class="clearfix"> </div>
            </div>
        </div>


        <div class="col-md-5 col-xs-6 blog-grids">
            <div class="blog-full-wthree">
                <div class="blog-left-agileits">
                    <p>Jan</p>
                    <span>26</span>
                </div>
                <div class="blog-right-agileits-w3layouts">
                    <h4>
                        <a href="#" data-toggle="modal" data-target="#myModal2">那天我们给所有的猫猫洗澡</a>
                    </h4>
                    <p>
                        <a href="#" data-toggle="modal" data-target="#myModal2">Cat Life</a>
                    </p>
                </div>
                <div class="clearfix"> </div>
            </div>
            <div class="blog-full-wthree">
                <div class="blog-left-agileits">
                    <p>Feb</p>
                    <span>06</span>
                </div>
                <div class="blog-right-agileits-w3layouts">
                    <h4>
                        <a href="#" data-toggle="modal" data-target="#myModal2">那天我们给所有的狗狗和猫猫穿上新衣服</a>
                    </h4>
                    <p>
                        <a href="#" data-toggle="modal" data-target="#myModal2">Dog and Cat Life</a>
                    </p>
                </div>
                <div class="clearfix"> </div>
            </div>
            <div class="blog-full-wthree">
                <div class="blog-left-agileits">
                    <p>Feb</p>
                    <span>12</span>
                </div>
                <div class="blog-right-agileits-w3layouts">
                    <h4>
                        <a href="#" data-toggle="modal" data-target="#myModal2">那天我们带上猫猫和狗狗参加展览</a>
                    </h4>
                    <p>
                        <a href="#" data-toggle="modal" data-target="#myModal2">Dog and Cat Life</a>
                    </p>
                </div>
                <div class="clearfix"> </div>
            </div>
        </div>


    </div>
    <div class="blog-grids mid-blog-agile">
        <img src="${path}/static/img/cat4_2.jpg" class="img-responsive" alt="" width="300" height="300" />
    </div>
<!-- Modal5 -->
<div class="modal fade" id="myModal2" tabindex="-1" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <div class="modal-info">
                    <h4>Cat Life</h4>
                    <h5>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</h5>
                    <p class="para-agileits-w3layouts">Duis sit amet nisi quis leo fermentum vestibulum vitae eget augue. Nulla quam nunc, vulputate id urna at, tempor tincidunt
                        metus. Sed feugiat quam nec mauris mattis malesuada.</p>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- //Modal5 -->
<!-- //blog -->
<!-- js -->
<script src="${path}/static/js/jquery-3.4.1.js"></script>
<script src="${path}/static/js/admin/bootstrap.min.js"></script>
<!-- Necessary-JavaScript-File-For-Bootstrap -->
    <!-- //js -->
</div>
</body>
</html>
