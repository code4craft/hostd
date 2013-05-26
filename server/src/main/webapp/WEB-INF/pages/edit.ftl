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
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/codemirror.css">
    <link rel="stylesheet" href="/css/dashboard.css">
    <link rel="stylesheet" href="/css/solarized.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/bootstrap.css">
    <link rel="stylesheet" href="/css/bootstrap-responsive.css">
    <link rel="stylesheet" href="/css/font-awesome.css">
</head>

<body>
<div class="row-fluid">
    <div class="span12">
    <#assign tab="edit">
        <#include "nav.ftl">
    </div>
    <div class="span12">
        <input type="hidden" id="zones-name" value="${name?if_exists}"/>
    <#--<br/>-->

        <div class="cm-s-solarized CodeMirror span10">
            <textArea id="code" file-id="${id?if_exists}">${content?if_exists}</textArea>
        </div>
    </div>
    <div class="span12"></div>
    <div class="span12">
    <#if type?exists && type=="userZones">
        <a id="save-default" class="btn offset1" href="javascript:void(0)">保存</a>
    <#else>
        <a id="apply-a" file-id="${id?if_exists}" class="btn offset1" href="javascript:void(0)">应用</a>
        <#if userPassport?exists && user==userPassport.username>
            <a id="save" file-id="#{id?if_exists}" class="btn offset1" href="javascript:void(0)">保存</a>
            <#if id gt 0><a id="del" file-id="#{id?if_exists}" class="btn offset1"
                            href="javascript:void(0)">删除</a></#if>
        </#if>
    </#if>
    </div>
</div>
</body>

</html>