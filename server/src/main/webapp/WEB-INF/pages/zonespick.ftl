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
    <script src="/js/baiduTemplate.js"></script>
    <script>
        BHzones =${zones};
    </script>
</head>

<body>
<div class="row-fluid">
    <div class="span12">
    <#assign tab="hosts">
        <#include "nav.ftl">
    </div>
    <script type="text/template" id="zones-template">
        <div class="span10 offset1">
            <h1>hosts</h1>
            <% if (zones.length>0)
                {
                for (var i=0;i<zones.length;i++)
                    {
                       var zone=zones[i];
            %>
            <ul>
                <li class="ui-btn-up-b ui-btn-inner"><a class="ui-link-inherit"
                                                        href="javascript:void(0)" id="link"><%=zone.domain%>&nbsp;<i
                        id="link-icon" class="icon-double-angle-down"></i></a><span
                        style="float:right;"><a class="ui-link-inherit" href="javascript:void(0)" id="link">新建<i
                        class="icon-plus"></i></a></span></li>
                <li>
                    <ul id="hiden" style="display: none">
                        <% if (zone.config.length>0)
                             {
                                for (int j=0;j<zone.config.length;j++)
                                {
                                  var config = zone.config[j];
                                %>
                        <li class="ui-btn-up-a ui-btn-inner"><a class="ui-link-inherit" href=""><i
                                style="color: #46a546"
                                class="icon-ok"></i>&nbsp;config.ip</a>
                            <span
                                    style="float:right;"><a class="ui-link-inherit" href="javascript:void(0)" id="link">编辑<i
                                    class="icon-edit"></i></a></span>
                        </li>
                        <%      }
                             }%>
                        <li class="ui-btn-up-a ui-btn-inner"><a class="ui-link-inherit" href="javascript:void(0)">
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;192.168.9.101</a>
                            <span
                                    style="float:right;"><a class="ui-link-inherit" href="javascript:void(0)" id="link">编辑<i
                                    class="icon-edit"></i></a></span>
                        </li>
                        <li class="ui-btn-up-a ui-btn-inner"><a class="ui-link-inherit" href="javascript:void(0)">
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;192.168.9.101</a>
                        </li>
                        <li class="ui-btn-up-a ui-btn-inner"><a class="ui-link-inherit" href="javascript:void(0)">
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;192.168.9.101</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <%
                    }
                }%>

        </div>
    </script>
    <div id="container"></div>
    <script type="text/javascript">
        var data = {
            zones: BHzones
        }
        var bt = baidu.template;
        var html = bt("zones-template", data);
        document.getElementById('container').innerHTML = html;
    </script>

<#--<div class="span10 offset1">-->
<#--<div data-role="content" data-theme="a">-->
<#--<h1>hosts</h1>-->
<#--<ul>-->
<#--<li class="ui-btn-up-b ui-btn-inner"><a class="ui-link-inherit"-->
<#--href="javascript:void(0)" id="link">WWW.DIANPING.COM&nbsp;<i-->
<#--id="link-icon" class="icon-double-angle-down"></i></a><span-->
<#--style="float:right;"><a class="ui-link-inherit" href="javascript:void(0)" id="link">新建<i-->
<#--class="icon-plus"></i></a></span></li>-->
<#--<li>-->
<#--<ul id="hiden" style="display: none">-->
<#--<li class="ui-btn-up-a ui-btn-inner"><a class="ui-link-inherit" href=""><i-->
<#--style="color: #46a546"-->
<#--class="icon-ok"></i>&nbsp;192.168.9.101</a>-->
<#--<span-->
<#--style="float:right;"><a class="ui-link-inherit" href="javascript:void(0)" id="link">编辑<i-->
<#--class="icon-edit"></i></a></span>-->
<#--</li>-->
<#--<li class="ui-btn-up-a ui-btn-inner"><a class="ui-link-inherit" href="javascript:void(0)">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;192.168.9.101</a>-->
<#--<span-->
<#--style="float:right;"><a class="ui-link-inherit" href="javascript:void(0)" id="link">编辑<i-->
<#--class="icon-edit"></i></a></span>-->
<#--</li>-->
<#--<li class="ui-btn-up-a ui-btn-inner"><a class="ui-link-inherit" href="javascript:void(0)">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;192.168.9.101</a>-->
<#--</li>-->
<#--<li class="ui-btn-up-a ui-btn-inner"><a class="ui-link-inherit" href="javascript:void(0)">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;192.168.9.101</a>-->
<#--</li>-->
<#--</ul>-->
<#--</li>-->
<#--</ul>-->

<#--</div>-->
<#--</div>-->
</div>
</body>

</html>