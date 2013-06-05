<!doctype html>
<html>
<!--rubyblue ambiance solarized-->
<head>
    <meta charset="utf-8"/>
    <title>Hostd-edit</title>
    <script src="/js/codemirror.js"></script>
    <script src="/js/jquery-1.9.1.js"></script>
    <script src="/js/javascript.js"></script>
    <script src="/js/edit.js"></script>
    <script src="/js/bootstrap.js"></script>
    <script src="/js/common-action.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/codemirror.css">
    <link rel="stylesheet" href="/css/shareboard.css">
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
    <div class="span12" id="code-container">
        <input type="hidden" id="zones-name" value="${name?if_exists}"/>
    <#--<br/>-->

        <div class="cm-s-solarized CodeMirror">
            <textArea id="code" file-id="${id?if_exists}">${content?if_exists}</textArea>
        </div>
    </div>

    <div class="span12">
    <#if type?exists && type=="userZones">
        <a id="save-default" class="btn offset1" href="javascript:void(0)"><i class="icon-save"></i>Save</a>
    <#else>
        <a id="apply-a" file-id="${id?if_exists}" class="btn offset1" href="javascript:void(0)">应用</a>
        <#if userPassport?exists && user==userPassport.username>
            <a id="save" file-id="#{id?if_exists}" class="btn offset1" href="javascript:void(0)">保存</a>
            <#if id gt 0><a id="del" file-id="#{id?if_exists}" class="btn offset1"
                            href="javascript:void(0)">删除</a></#if>
        </#if>
    </#if>
    </div>
    <div class="span12"></div>
    <div class="span11 alert alert-info">
        <p class="lead">Syntax:</p>


        <ul>
            <li>
                <p>ip domain</p>

                <p>e.g. 127.0.0.1 www.dianping.com</p>

            </li>
            <li>
                <p>"*" stand for any length of charactor</p>

                <p>e.g. 127.0.0.1 *.dianping.com</p>

            </li>
            <li>
                <p>"#" for comment</p>

                <p>e.g. #127.0.0.1 t.dianping.com</p>

                <p>Commented line is a candidate for choice.</p>
            </li>
            <li>
                <p>"#" in line for comment of config</p>

                <p>e.g. #127.0.0.1 t.dianping.com #local test</p>

                <p>'local test' is comment of this line.</p>
            </li>
        </ul>
    </div>
</div>
</body>

</html>