<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>动物的具体信息</title>

    <link rel="stylesheet" href="${path}/static/bootstrap/css/bootstrap.min.css">
    <link href="${path}/static/css/user/jquery.slideBox.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="${path}/static/css/user/show.css">
    <script src="${path}/static/js/user/jquery-2.2.3.min.js"></script>
    <script src="${path}/static/bootstrap/js/bootstrap.js"></script>
    <script src="${path}/static/js/user/jquery.slideBox.min.js" type="text/javascript"></script>
    <script src="${path}/static/js/user/jquery.comment.js"></script>
</head>
<body>
<div>
<div>
    <h2>待领养的动物</h2>
<center>
<div id="demo1" class="slideBox">
<ul class="items">
    <li><a href="" ><img class="my-img" src="${path}/static/img/1.jpg"></a></li>
    <li><a href="" ><img class="my-img" src="${path}/static/img/2.jpg"></a></li>
    <li><a href="" ><img class="my-img" src="${path}/static/img/3.jpg"></a></li>
    <li><a href="" ><img class="my-img" src="${path}/static/img/4.jpg"></a></li>
</ul>
</div>
   <div class="name">
                <img src="${path}/static/img/p1.jpg" height="50px" width="50px">
                <span>我叫 yy</span>
            </div>
</center>
    <div class="animal">
        <div class="group">
        <div class="animalX1">
            <img src="${path}/static/img/p2.jpg"><span>编号</span><br>
            <p>9</p>
        </div>
        <div class="animalX2">
            <img src="${basePath}/static/img/p3.jpg"><span>生日</span><br>
            <p>2022/01/29</p>
        </div>
        </div>
        <div class="group">
            <div class="animalX3">
                <img src="${basePath}/static/img/p4.jpg"><span>品种</span><br>
                <p>边牧</p>
            </div>
            <div class="animalX4">
                <img src="${basePath}/static/img/p5.jpg"><span>性别</span><br>
                <p>雄性</p>
            </div>
        </div>
        
    </div>
<div class="animal_me">
    <div class="animal_me1"><img src="${basePath}/static/img/p6.jpg"/> <img src="/static/img/p7.jpg"/> <img src="/static/img/p8.jpg"/> <img src="/static/img/p9.jpg"/> <img src="/static/img/p10.jpg"/></div>
    <div class="animal_me2"><p>大家好，我是yy。我的特点是帅气的外表和易于常狗的智商。我很喜欢认识朋友，
        我已经准备好当你的好朋友，你能带我回家吗?</p></div>
    <div class="animal_me3"><img src="${basePath}/static/img/p11.jpg" ></div>
</div>
<div class="my_btn">
    <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">想要领养</button>
    <button class="btn btn-primary btn-lg" id="tianchuan_btn"  onclick="location.href='${path}/user/services.jsp'"
                    style="float: right;position: relative;left: 150px;bottom: 45px">返回中心
            </button>
</div>
</div>
<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    请填写个人信息
                </h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="new_department_form">
                    <div class="form-group">
                        <label for="new_Name" class="col-sm-2 control-label">
                            姓名： </label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="new_Name"
                                   placeholder="name" name="name">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="new_Sex" class="col-sm-2 control-label">
                            性别： </label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="new_Sex"
                                   placeholder="sex" name="sex">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="new_tel" class="col-sm-2 control-label">
                            联系方式： </label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="new_tel"
                                   placeholder="telephone" name="telephone">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="new_Email" class="col-sm-2 control-label">
                            邮件： </label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="new_Email"
                                   placeholder="Email" name="new_Email">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="new_Adress" class="col-sm-2 control-label">
                            地址： </label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="new_Adress"
                                   placeholder="adress" name="address">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="new_remark" class="col-sm-2 control-label">
                            备注： </label>
                        <div class="col-sm-10">
                            <textarea type="text" class="form-control" id="new_remark"
                            placeholder="remark" name="remark"></textarea>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary">提交申请</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

    <div class="comment-list">

    </div>
    <div class="container">
        <div class="commentbox">
            <textarea cols="80" rows="50" placeholder="来说几句吧......" class="mytextarea" id="content"></textarea>
            <div class="btn btn-info pull-right" id="comment">评论</div>
        </div>

    </div>
</div>
<script>
    jQuery(function($){
        $('#demo1').slideBox();

    });

    $(function(){
        $("#comment").click(function(){
            var obj = new Object();
            obj.img="${basePath}/static/img/a2.png";
            obj.replyName="匿名";
            obj.content=$("#content").val();
            obj.browse="福州";
            obj.osname="win10";
            obj.replyBody="";
            $(".comment-list").addCommentList({data:[],add:obj});
        });
    })
</script>
</body>
</html>

