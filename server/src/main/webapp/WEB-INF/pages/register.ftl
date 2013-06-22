<!doctype html>
<html>
<!--rubyblue ambiance solarized-->
<head>
    <meta charset="utf-8"/>
    <title>Hostd-register</title>
    <script src="/js/codemirror.js"></script>
    <script src="/js/jquery-1.9.1.js"></script>
    <script src="/js/javascript.js"></script>
    <script src="/js/common-action.js"></script>
    <script src="/js/register.js"></script>
    <link rel="stylesheet" href="/css/codemirror.css">
    <link rel="stylesheet" href="/css/solarized.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/bootstrap.css">
    <link rel="stylesheet" href="/css/bootstrap-responsive.css">
    <link rel="stylesheet" href="/css/font-awesome.css">
    <link rel="shortcut icon" type="image/x-icon" href="/img/favicon.png"/>
</head>

<body>

<div class="row-fluid">
    <div class="span12">
    <#assign tab="register">
        <#include "nav.ftl">
    </div>
    <div style="margin-left: 0%" class="span12">
    <form class="navbar-form span12" action="/register" method="post">
        <div style="margin-left: 0%" class="input-prepend span12">
            <span class="add-on"><i class="icon-user"></i></span>
            <input class="span7" id="username" placeholder="Please input username" type="text" name="username">
        </div>
        <div style="margin-left: 0%" class="input-prepend span12">
            <span class="add-on"><i class="icon-lock"></i></span>
            <input class="span7" id="password" type="password" name="password" placeholder="Please input password">
        </div>
        <div style="margin-left: 0%" class="input-prepend span12">
            <span class="add-on"><i class="icon-key"></i></span>
            <input class="span7" id="repassword" type="password" name="password" placeholder="Confirm your password">
        </div>
        <div class="span12 offset2">
            <input class="btn offset1" id="register-button" type="button" value="Sign Up" name="Sign Up"/>
        </div>
    </form>
    </div>

</div>
</body>

</html>