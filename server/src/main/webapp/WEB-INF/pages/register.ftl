<!doctype html>
<html>
<!--rubyblue ambiance solarized-->
<head>
    <meta charset="utf-8"/>
    <title>SetHosts-注册</title>
    <script src="/js/codemirror.js"></script>
    <script src="/js/jquery-1.9.1.js"></script>
    <script src="/js/javascript.js"></script>
    <script src="/js/common-action.js"></script>
    <script src="/js/register.js"></script>
    <link rel="stylesheet" href="/css/codemirror.css">
    <link rel="stylesheet" href="/css/dashboard.css">
    <link rel="stylesheet" href="/css/solarized.css">
</head>

<body>
<div class="dashboard cm-s-solarized CodeMirror">
    <h1>&nbsp;注册</h1>
    <form action="/login" method="post">
          <ul class="config-list" id="zones-public">
              <li><span>用户名</span><input id="username" type="text" name="username"/></li>
              <li><span>密码</span><input id="password" type="password" name="password"/></li>
              <li><span>重复密码</span><input id="repassword" type="password" name="password"/></li>
              <li><input id="register-button" type="button" value="注册" name="注册"/></li>
    </form>
</div>
</body>

</html>