<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Services</title>
    <!-- Meta tag Keywords -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="UTF-8"/>
    <meta name="keywords" content=""
    />
    <script>
        addEventListener("load", function () {
            setTimeout(hideURLbar, 0);
        }, false);

        function hideURLbar() {
            window.scrollTo(0, 1);
        }
    </script>
    <!--// Meta tag Keywords -->
    <!-- css files -->
    <link rel="stylesheet" href="${path}/static/bootstrap/css/bootstrap.css" type="text/css" media="all">
    <!-- Owl-Carousel-CSS -->
    <link rel="stylesheet" href="${path}/static/css/user/style.css" type="text/css" media="all"/>

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
<!-- //sticky navigation -->

<!-- services -->
<div class="services" id="services">
    <div class="container">
        <h3 class="agile-title">领养中心</h3>
        <div class="w3_agile_services_grids">
            <div class="col-md-4 col-sm-4 col-xs-4 w3_agile_services_grid " data-aos="zoom-in">
                <div class="ih-item circle effect1 agile_services_grid">
                    <div class="spinner"></div>
                    <div class="img">
                        <a href="${path}/user/show.jsp">
                            <img src="${path}/static/img/cat6_1.jpg" alt=" " class="img-responsive"/>
                        </a>
                    </div>
                </div>
                <fieldset>
                    <legend>顿顿</legend>
                    顿顿是一种温和、友善和亲人的狸花猫。
                </fieldset>
            </div>
            <div class="col-md-4 col-sm-4 col-xs-4 w3_agile_services_grid" data-aos="zoom-in">
                <div class="ih-item circle effect1 agile_services_grid">
                    <div class="spinner"></div>
                    <div class="img">
                        <a href="${path}/user/show1.jsp">
                            <img src="${path}/static/img/dog1_1.jpg" alt=" " class="img-responsive"/>
                        </a>
                    </div>
                </div>
                <fieldset>
                    <legend>yy</legend>
                    yy是一只精力充沛的狗，比其他的狗更加好动。
                </fieldset>
            </div>
            <div class="col-md-4 col-sm-4 col-xs-4 w3_agile_services_grid" data-aos="zoom-in">
                <div class="ih-item circle effect1 agile_services_grid">
                    <div class="spinner"></div>
                    <div class="img">
                        <a href="${path}/user/show2.jsp">
                            <img src="${path}/static/img/cat7_1.jpg" alt=" " class="img-responsive"/>
                        </a>
                    </div>
                </div>
                <fieldset>
                    <legend>偶偶</legend>
                    偶偶是一只非常特别的猫，它天生具有异瞳。
                </fieldset>
            </div>
            <div class="col-md-4 col-sm-4 col-xs-4 w3_agile_services_grid" data-aos="zoom-in">
                <div class="ih-item circle effect1 agile_services_grid">
                    <div class="spinner"></div>
                    <div class="img">
                        <a href="${path}/user/show3.jsp">
                            <img src="${path}/static/img/dog5_2.jpg" alt=" " class="img-responsive"/>
                        </a>
                    </div>
                </div>
                <fieldset>
                    <legend>紧紧</legend>
                    紧紧是一只安静的狗狗，时常喜欢自己单独呆在某个地方。
                </fieldset>
            </div>
            <div class="col-md-4 col-sm-4 col-xs-4 w3_agile_services_grid" data-aos="zoom-in">
                <div class="ih-item circle effect1 agile_services_grid">
                    <div class="spinner"></div>
                    <div class="img">
                        <a href="${path}/user/show4.jsp">
                            <img src="${path}/static/img/dog4_3.jpg" alt=" " class="img-responsive"/>
                        </a>
                    </div>
                </div>
                <fieldset>
                    <legend>霍霍</legend>
                    霍霍是一只安静且亲人的狗狗，喜欢和主人互动。
                </fieldset>
            </div>
            <div class="col-md-4 col-sm-4 col-xs-4 w3_agile_services_grid" data-aos="zoom-in">
                <div class="ih-item circle effect1 agile_services_grid">
                    <div class="spinner"></div>
                    <div class="img">
                        <a href="${path}/user/show5.jsp">
                            <img src="${path}/static/img/cat2_3.jpg" alt=" " class="img-responsive"/>
                        </a>
                    </div>
                </div>
                <fieldset>
                    <legend>哼哼</legend>
                    哼哼是一只猫龄非常小的猫猫，性格亲人，偶尔比较调皮。
                </fieldset>
            </div>
        </div>

    </div>
    <div class="w3l-img-side">
        <img src="${path}/static/img/cat7_2.png" alt=""/>
    </div>
    <div class="w3l-img-side w3l-img-side2">
        <img src="${path}/static/img/cat1_2.png" alt=""/>
    </div>
</div>
<!-- //services -->
<!-- js -->
<script src="${path}/static/js/jquery-3.4.1.js"></script>
<script src="${path}/static/js/admin/bootstrap.min.js"></script>
<!-- Necessary-JavaScript-File-For-Bootstrap -->
<!-- //js -->

<!-- start-smooth-scrolling 上去-->
<script src="${path}/static/js/user/move-top.js"></script>
<script src="${path}/static/js/user/easing.js"></script>
<script>
    jQuery(document).ready(function ($) {
        $(".scroll").click(function (event) {
            event.preventDefault();

            $('html,body').animate({
                scrollTop: $(this.hash).offset().top
            }, 1000);
        });
    });
</script>
<!-- //end-smooth-scrolling -->

<!-- smooth-scrolling-of-move-up 这是service.html页面反到底层上去的功能 -->
<script>
    $(document).ready(function () {
        $().UItoTop({
            easingType: 'easeOutQuart'
        });

    });
</script>
<!-- //smooth-scrolling-of-move-up -->


</body>

</html>