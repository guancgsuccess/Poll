<%--
  Created by IntelliJ IDEA.
  User: success
  Date: 2018/7/25 0025
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>实训学员考评系统Poll-v1.0</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="${path}/dist/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="${path}/css/admin/login.css"/>
</head>
<body>
    <!--引入导航-->
    <%@ include file="../common/header.jsp"%>

    <!--登录界面-->
    <div class="container">
        <div class="row">
            <div class="col-md-offset-2 col-md-8">
                <div id="login">
                    <fieldset>
                        <legend>用户登录入口</legend>
                        <form class="form-horizontal" action="${path}/teacher/logincl" role="form" method="post">
                            <div class="form-group has-feedback">
                                <label for="firstname" class="col-sm-2 control-label">用户名</label>
                                <div class="col-sm-5">
                                    <input type="text" name="username" class="form-control" id="firstname" placeholder="请输入名字">
                                    <span class="glyphicon glyphicon-user form-control-feedback"></span>
                                </div>
                                <c:if test="${loginError==0}">
                                    <div class="col-md-2" style="padding-top: 5px;">
                                        <label class="alert-danger">用户名不存在</label>
                                    </div>
                                </c:if>
                            </div>
                            <div class="form-group has-feedback">
                                <label for="lastname" class="col-sm-2 control-label">密码</label>
                                <div class="col-sm-5">
                                    <input name="password" type="password" class="form-control" id="lastname" placeholder="请输入密码">
                                    <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                                </div>
                                <c:if test="${loginError==1}">
                                    <div class="col-md-2" style="padding-top: 5px;">
                                        <label class="alert-danger">密码不正确</label>
                                    </div>
                                </c:if>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <button type="submit" class="btn btn-primary">登录</button>
                                </div>
                            </div>
                        </form>
                    </fieldset>
                </div>
            </div>
        </div>
    </div>

    <!--导入尾部-->
    <%@ include file="../common/footer.jsp"%>
    <script type="text/javascript" src="${path}/dist/js/jquery.min.js"></script>
    <script type="text/javascript" src="${path}/dist/js/bootstrap.min.js"></script>
</body>
</html>
