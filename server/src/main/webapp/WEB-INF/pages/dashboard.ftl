<!doctype html>
<html>
<!--rubyblue ambiance solarized-->
<head>
    <meta charset="utf-8"/>
    <title>SetHosts</title>
    <script src="/js/codemirror.js"></script>
    <script src="/js/jquery-1.9.1.js"></script>
    <script src="/js/javascript.js"></script>
    <script src="/js/dashboard.js"></script>
    <script src="/js/common-action.js"></script>
    <link rel="stylesheet" href="/css/codemirror.css">
    <link rel="stylesheet" href="/css/dashboard.css">
    <link rel="stylesheet" href="/css/solarized.css">
    <script>
        BHzones=${data};
    </script>
</head>

<body>
<div class="dashboard cm-s-solarized CodeMirror">
    <h1>&nbsp;公用配置</h1>
    <ul class="config-list" id="zones-public">
    <#if public?exists>
        <#list public as zones>
            <li><a href="/edit/${zones.id}">${zones.name}</a>&nbsp;&nbsp;&nbsp; <a id="apply-a" file-id="${zones.id}"
                                                                         href="javascript:void(0)">使用</a></li>
        </#list>
    </#if>
    </ul>
<#if userPassport?exists>
    <h1>&nbsp;个人配置</h1>
    <ul class="config-list" id="zones-personal">
        <#if personal?exists>
            <#list personal as zones>
                <li><a href="/edit/${zones.id}">${zones.name}</a>&nbsp;&nbsp;&nbsp; <a id="apply-a" file-id="${zones.id}"
                                                                             href="javascript:void(0)">使用</a></li>
            </#list>
        </#if>
        <li><a href="/edit/new">新增</a></li>
    </ul>
<#else>
    <h1>&nbsp;个人配置</h1>
    <ul class="config-list" id="zones-personal">
        <li><a id="login" href="/login">登录</a>&nbsp;&nbsp;&nbsp;<a id="register" href="/register">注册</a></li>
    </ul>
</#if>
</div>
</body>

</html>