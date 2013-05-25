<!DOCTYPE html>
<html>
<!--rubyblue ambiance solarized-->
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8"/>
    <title>SetHosts</title>
    <link rel="stylesheet" href="/css/bootstrap.css">
    <link rel="stylesheet" href="/css/bootstrap-responsive.css">
    <link rel="stylesheet" href="/css/font-awesome.css">
    <link rel="stylesheet" href="/css/hostd.css">
    <script src="/js/jquery-1.9.1.js"></script>
    <script src="/js/zonespick.js"></script>
    <script>
        BHzones =${data};
    </script>
</head>

<body>
<div class="row-fluid">
    <div class="span12">
    <#assign tab="hosts">
        <#include "nav.ftl">
    </div>
    <div class="span10 offset1">
        <div data-role="content" data-theme="a">
            <h1>hosts</h1>
            <ul>
                <li class="ui-btn-up-a ui-btn-inner"><a href="javascript:void(0)" id="link">www.dianping.com&nbsp;<i id="link-icon" class="icon-double-angle-down"></i></a></li>
                <li>
                    <ul id="hiden" style="display: none">
                        <li data-icon="refresh" class="ui-btn-up-a ui-btn-inner"><a href=""><i style="color: #46a546" class="icon-ok"></i>&nbsp;192.168.9.101</a></li>
                        <li data-icon="refresh" class="ui-btn-up-a ui-btn-inner"><a href="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;192.168.9.101</a></li>
                        <li data-icon="refresh" class="ui-btn-up-a ui-btn-inner"><a href="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;192.168.9.101</a></li>
                        <li data-icon="refresh" class="ui-btn-up-a ui-btn-inner"><a href="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;192.168.9.101</a></li>
                    </ul>
                </li>
            </ul>

        </div>
    </div>
</div>
</body>

</html>