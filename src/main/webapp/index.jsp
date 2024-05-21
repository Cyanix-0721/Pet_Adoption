<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <base href="${basePath}">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="author" content="Webpixels">
    <title>宠物领养系统</title>
    <!-- Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Nunito:400,600,700,800|Roboto:400,500,700" rel="stylesheet">
    <!-- Theme CSS -->
    <link type="text/css" href="${basePath}/bs/css/theme.css" rel="stylesheet">
    <!-- Demo CSS - No need to use these in your project -->
    <link type="text/css" href="${basePath}/bs/css/demo.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-transparent navbar-dark bg-dark py-4">
    <div class="container">
        <button class="navbar-toggler" type="button" data-action="offcanvas-open" data-target="#navbar_main"
                aria-controls="navbar_main" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="navbar-collapse offcanvas-collapse" id="navbar_main">
            <ul class="navbar-nav ml-auto align-items-lg-center">
                <li class="nav-item">
                    <a class="nav-link" href="${basePath}/admin/login.jsp"
                       id="navbar_main_dropdown_1" role="button"
                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">主页</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${basePath}/user/login.jsp"
                       id="navbar_main_dropdown_2" role="button"
                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">登录 / 注册</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<main class="main">
    <section class="spotlight parallax bg-cover bg-size--cover" data-spotlight="fullscreen"
             style="background-image: url('${basePath}/assets/images/bg.jpg')">
        <span class="bg-primary alpha-7"></span>
        <div class="spotlight-holder py-lg pt-lg-xl">
            <div class="container d-flex align-items-center no-padding">
                <div class="col">
                    <div
                            class="row cols-xs-space align-items-center text-center text-md-left justify-content-center">
                        <div class="col-7">
                            <div class="text-center mt-5">
                                <img src="${basePath}/bs/images/brand/icon.png"
                                     style="width: 200px;"
                                     class="img-fluid animated" data-animation-in="jackInTheBox"
                                     data-animation-delay="1000" alt="logo">
                                <h2 class="heading display-4 font-weight-400 text-white mt-5 animated"
                                    data-animation-in="fadeInUp" data-animation-delay="2000">
                                    <span class="font-weight-700">宠物领养系统</span>
                                </h2>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</main>
</body>
</html>