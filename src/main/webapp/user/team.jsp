<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<script>console.log(${path})</script>
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
    <!-- Bootstrap-Core-CSS -->
    <link rel="stylesheet" href="${path}/static/css/user/font-awesome.css" type="text/css" media="all">
    <style>        #messageModal {
        display: none; /* 初始状态隐藏modal */
        position: fixed; /* 固定定位 */
        z-index: 1; /* 确保modal在其他元素之上 */
        left: 0;
        top: 0;
        width: 100%;
        height: 100%;
        overflow: auto; /* 在modal内滚动 */
        background-color: rgba(0,0,0,0.4); /* 模糊背景颜色 */
    }

    #messageModalContent {
        display: flex;
        justify-content: center;
        align-items: center;
        font-size: 50px;
        background-color: #fefefe; /* 模态框的背景颜色 */
        margin: 15% auto; /* 居中显示 */
        padding: 20px;
        border: 1px solid #888;
        height: 25%;
        width: 25%; /* 模态框的宽度 */
        text-align: center;
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
<!-- //sticky navigation -->

<!-- team -->
<div class="team" id="team">
    <div class="container">
        <h3 class="agile-title">我们的团队</h3>

        <div class="team-agileinfo">
            <div class="col-md-6 team-grid w3-agileits">
                <div class="team-grid-right">
                    <img src="${path}/static/img/a2.png" alt="" class="img-responsive" />
                </div>
                <div class="team-grid-left">
                    <h4>白白</h4>
                    <p>白白，真实姓名：林北，电话：88888888，邮箱：1111@qq.com，性别：男。</p>
                </div>
                <div class="clearfix"> </div>
            </div>
            <div class="col-md-6 team-grid w3-agileits">
                <div class="team-grid-right aliquam">
                    <img src="${path}/static/img/a11.png" alt=" " class="img-responsive" />
                </div>
                <div class="team-grid-left non">
                    <h4>拜拜</h4>
                    <p>拜拜，真实姓名：吴亦凡，电话：11111111，邮箱：2222@qq.com，性别：男。</p>
                </div>
                <div class="clearfix"> </div>
            </div>
        </div>
        <div class="team-agileinfo">
            <div class="col-md-6 team-grid w3-agileits">
                <div class="team-grid-right">
                    <img src="${path}/static/img/a4.png" alt="" class="img-responsive" />
                </div>
                <div class="team-grid-left">
                    <h4>掰掰</h4>
                    <p>掰掰，真实姓名：蔡徐坤，电话：22222222，邮箱：33332qq.com，性别：男。</p>
                </div>

            </div>
            <div class="col-md-6 team-grid w3-agileits">
                <div class="team-grid-right aliquam">
                    <img src="${basePath}/static/img/a6.png" alt=" " class="img-responsive" />
                </div>
                <div class="team-grid-left non">
                    <h4>摆摆</h4>
                    <p>摆摆，真实姓名：林南，电话：33333333，邮箱：4444@qq.com，性别：男。</p>
                </div>
            </div>
        </div>
    </div>
</div>



<!-- contact -->
<div class="contact" id="contact">
    <div class="container">
        <div class="col-md-9 col-sm-9 contact-right">
            <form action="#" method="post">
                <input type="text" name="name" placeholder="Your name" required="">
                <input type="email" name="email" placeholder="Your email" required="">
                <input type="text" name="subject" placeholder="Your subject" required="">
                <input type="text" name="phone number" placeholder="Phone number" required="">
                <textarea name="message" placeholder="Your message" required=""></textarea>
                <form>
                    <input type="submit" value="Send">
                </form>

                <div id="messageModal">
                    <div id="messageModalContent">
                        <span id="modalMessage"></span>
                        <button id="closeModal">Close</button>
                    </div>
                </div>
            </form>
        </div>
        <div class="col-md-3 col-sm-3 contact-left">
            <div class="address">
                <h4>
                    <i class="fa fa-map-marker" aria-hidden="true"></i>Location</h4>
                <p>345 Setwant natrer,</p>
                <p>Metropolitan, Italy.</p>
            </div>
            <div class="phone">
                <h4>
                    <i class="fa fa-phone" aria-hidden="true"></i>PHONE</h4>
                <p>+1(401) 1234 567.</p>
                <p>+1(804) 4261 150.</p>
            </div>
            <div class="email">
                <h4>
                    <i class="fa fa-envelope-o" aria-hidden="true"></i>E-MAIL</h4>
                <p>
                    <a href="mailto:info@example.com">Example1@gmail.com</a>
                </p>
                <p>
                    <a href="mailto:info@example.com">Example2@gmail.com</a>
                </p>
            </div>
        </div>
    </div>
</div>
<!-- //team -->
<!-- js -->
<script src="${path}/static/js/jquery-3.4.1.min.js"></script>
<script src="${path}/static/bootstrap/js/bootstrap.min.js"></script>
<!-- Necessary-JavaScript-File-For-Bootstrap -->
<!-- //js -->
<script>        const form = document.querySelector('form');
const modalMessage = document.getElementById('modalMessage');
const closeModal = document.getElementById('closeModal');

form.addEventListener('submit', function(event) {
    event.preventDefault(); // 阻止表单提交

    // 执行发送消息的操作
    // ...

    // 显示成功消息
    modalMessage.textContent = "发送成功";
    document.getElementById('messageModal').style.display = "block";

    // 5秒后自动关闭模态框
    setTimeout(function() {
        document.getElementById('messageModal').style.display = "none";
    }, 5000);
});

// 关闭模态框
closeModal.addEventListener('click', function() {
    document.getElementById('messageModal').style.display = "none";
});
</script>
</body>
</html>
