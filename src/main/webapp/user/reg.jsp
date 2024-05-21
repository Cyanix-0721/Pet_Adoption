<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <base href="${basePath}">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>宠物领养系统-用户注册</title>
    <!-- Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Nunito:400,600,700,800|Roboto:400,500,700" rel="stylesheet">
    <!-- Theme CSS -->
    <link type="text/css" href="${basePath}/bs/css/theme.css" rel="stylesheet">
    <!-- Demo CSS - No need to use these in your project -->
    <link type="text/css" href="${basePath}/bs/css/demo.css" rel="stylesheet">
    <script type="text/javascript">
        function checkForm() {
            var userName = document.getElementById("userName");
            var userPwd = document.getElementById("userPwd");
            var userPwdTwice = document.getElementById("userPwdTwice");
            var verifyCodeActual = document.getElementById("verifyCodeActual");
            if (userName.value.length <= 0) {
                alert("请输入用户名！");
                userName.focus();
                return false;
            } else if (userPwd.value.length <= 0) {
                alert("请输入密码！");
                userPwd.focus();
                return false;
            } else if (userPwdTwice.value.length <= 0 || userPwdTwice.value !== userPwd.value) {
                alert("第二次输入密码必须和第一次相同！");
                userPwd.focus();
                return false;
            } else if (verifyCodeActual.value.length <= 0) {
                alert("请输入验证码！");
                return false;
            }
            return true;
        }
    </script>
    <style>
        .btn-float {
            position: fixed;
            bottom: 20px;
            right: 20px;
            z-index: 1050;
            height: 60px;
            width: 60px;
            border-radius: 50%;
            text-align: center;
            line-height: 60px;
            background-color: #17a2b8;
            color: #fff;
            font-size: 24px;
            box-shadow: 0 0 5px rgba(0, 0, 0, 0.2);
        }

        .btn-float:hover {
            background-color: #007bff;
        }
    </style>
</head>
<body>

<main class="main">
    <section class="py-xl bg-cover bg-size--cover"
             style="background-image: url('${basePath}/assets/images/bg.jpg')">
        <span class="bg-primary alpha-6"></span>
        <div class="container d-flex align-items-center no-padding">
            <div class="col">
                <div class="row justify-content-center">
                    <div class="col-lg-4">

                        <%--跳转登录按钮--%>
                        <div class="text-center mt-5">
                            <a href="${basePath}/user/login.jsp" class="btn btn-primary btn-float btn-lg">
                                <i class="fas fa-sign-in-alt"></i>
                            </a>
                        </div>

                        <div class="card bg-primary text-white">
                            <div class="card-body">
                                <button type="button" onclick="window.location='${basePath}/index.jsp'"
                                        class="btn btn-primary btn-nobg btn-zoom--hover mb-5">
                                    <span class="btn-inner--icon"><i class="fas fa-arrow-left"></i></span>
                                </button>
                                <span class="clearfix"></span>
                                <h4 class="heading h3 text-white pt-3 pb-5">Welcome ,<br>
                                    register an account .</h4>
                                <%--登录表单--%>
                                <form class="form-primary" action="${basePath}/user/register.action" method="post"
                                      onsubmit="return checkForm()"><%--调用checkFrom函数检测是否输入用户名密码--%>
                                    <div class="form-group">
                                        <input type="text" class="form-control" id="userName" name="userName"
                                               placeholder="Your username">
                                    </div>
                                    <div class="form-group">
                                        <input type="password" class="form-control" id="userPwd" name="userPwd"
                                               placeholder="Password">
                                    </div>
                                    <div class="form-group">
                                        <input type="password" class="form-control" id="userPwdTwice"
                                               name="userPwdTwice"
                                               placeholder="userPwdTwice">
                                    </div>
                                    <div class="form-group"><%--验证码大小写敏感--%>
                                        <input type="text" class="form-control" id="verifyCodeActual"
                                               name="verifyCodeActual"
                                               placeholder="verifyCode">
                                        <div class="col-md-4">
                                            <img id="captcha_img"
                                                 src="/kaptcha.jpg"
                                                 onclick="refresh()" alt="点击更换"><%--点击验证码进行更换--%>
                                        </div>
                                    </div>

                                    <button type="submit" class="btn btn-block btn-lg bg-white mt-4" id="submit">
                                        Register
                                    </button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</main>
<%--点击验证码进行更换--%>
<script type="text/javascript">
    function refresh() {
        document.getElementById('captcha_img').src = "/kaptcha.jpg?" + Math.random();
    }
</script>
<!-- Core -->
<script src="${basePath}/bs/vendor/jquery/jquery.min.js"></script>
<script src="${basePath}/bs/vendor/popper/popper.min.js"></script>
<script src="${basePath}/bs/js/bootstrap/bootstrap.min.js"></script>
<!-- FontAwesome 5 -->
<script src="${basePath}/bs/vendor/fontawesome/js/fontawesome-all.min.js" defer></script>
<!-- Page plugins -->
<script src="${basePath}/bs/vendor/bootstrap-select/js/bootstrap-select.min.js"></script>
<script src="${basePath}/bs/vendor/bootstrap-tagsinput/bootstrap-tagsinput.min.js"></script>
<script src="${basePath}/bs/vendor/input-mask/input-mask.min.js"></script>
<script src="${basePath}/bs/vendor/nouislider/js/nouislider.min.js"></script>
<script src="${basePath}/bs/vendor/textarea-autosize/textarea-autosize.min.js"></script>
<!-- Theme JS -->
<script src="${basePath}/bs/js/theme.js"></script>
</body>
</html>
