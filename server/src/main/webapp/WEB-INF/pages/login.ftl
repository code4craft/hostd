<!doctype html>
<html>
<!--rubyblue ambiance solarized-->
<head>
    <meta charset="utf-8"/>
    <title>Hostd-login</title>
    <script src="/js/codemirror.js"></script>
    <script src="/js/jquery-1.9.1.js"></script>
    <script src="/js/javascript.js"></script>
    <script src="/js/common-action.js"></script>
    <script src="/js/login.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/codemirror.css">
    <link rel="stylesheet" href="/css/shareboard.css">
    <link rel="stylesheet" href="/css/solarized.css">
    <link rel="stylesheet" href="/css/hostd.css">
    <link rel="stylesheet" href="/css/bootstrap.css">
    <link rel="stylesheet" href="/css/bootstrap-responsive.css">
    <link rel="stylesheet" href="/css/font-awesome.css">
</head>

<body>
<div class="row-fluid">
    <div class="span12">
    <#assign tab="login">
        <#include "nav.ftl">
    </div>
    <div class="span7 offset4">
        <form class="navbar-form pull-left" action="/login" method="post">
            <div class="span12">
                <#--<div class="span5 offset3"><h2>&nbsp;登录</h2></div>-->
            </div>
            <div class="input-prepend span12">
                <span class="add-on"><i class="icon-user"></i></span>
                <input class="span7" id="username" placeholder="请输入用户名" type="text" name="username">
            </div>
            <div class="input-prepend span12">
                <span class="add-on"><i class="icon-lock"></i></span>
                <input class="span7" id="password" type="password" name="password" placeholder="请输入密码">
            </div>
            <div class="span12 offset1"><input class="btn btn-primary" id="login-button" type="button" value="登录" name="登录"/>
                <a class="btn offset2" href="/register">注册</a>
            </div>
        </form>
    </div>
</div>
</body>

</html>