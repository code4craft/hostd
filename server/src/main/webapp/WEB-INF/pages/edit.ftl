<!doctype html>
<html>
<!--rubyblue ambiance solarized-->
<head>
    <meta charset="utf-8"/>
    <title>CodeMirror</title>
    <script src="/js/codemirror.js"></script>
    <script src="/js/jquery-1.9.1.js"></script>
    <script src="/js/javascript.js"></script>
    <script src="/js/edit.js"></script>
    <script src="/js/common-action.js"></script>
    <link rel="stylesheet" href="/css/codemirror.css">
    <link rel="stylesheet" href="/css/dashboard.css">
    <link rel="stylesheet" href="/css/solarized.css">
</head>

<body>
<p style="font-size:30px;">&nbsp;<a href="/">&lt;&lt;</a>&nbsp;配置-<input type="text" id="zones-name" value="${name}"/></p>
<br/>

<div class="cm-s-solarized CodeMirror">
    <textArea id="code" file-id="${id}">${content}</textArea>
</div>
<p style="font-size:20px;margin-left: 10%"><a id="apply-a" file-id="${id}" href="javascript:void(0)">应用</a>
 <#if userPassport?exists && user==userPassport.username>   &nbsp;&nbsp;&nbsp;<a id="save" file-id="#{id}" href="javascript:void(0)">保存</a>
     <#if id gt 0>&nbsp;&nbsp;&nbsp;<a id="del" file-id="#{id}" href="javascript:void(0)">删除</a></#if></p>
 </#if>
</body>

</html>