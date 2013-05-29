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
    <div style="margin-left: 0%" class="span12">
    <#assign tab="login">
        <#include "nav.ftl">
    </div>
    <div style="margin-left: 0%" class="span12">
        <#--<form class="navbar-form span12" action="/login" method="post">-->
            <div style="margin-left: 0%" class="input-prepend span12">
                <span class="add-on"><i class="icon-user"></i></span>
                <input class="span11" id="username" placeholder="Please input username" type="text" name="username">
            </div>
            <div style="margin-left: 0%" class="input-prepend span12">
                <span class="add-on"><i class="icon-lock"></i></span>
                <input class="span11" id="password" type="password" name="password" placeholder="Please input password">
            </div>
            <div class="span11 offset1"><input class="btn btn-primary" id="login-button" type="button" value="Login" name="Login"/>
                <a class="btn offset2" href="/register">Sign Up</a>
            </div>
        <#--</form>-->
    </div>
</div>
</body>

</html>