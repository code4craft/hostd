<!DOCTYPE html>
<html>
<!--rubyblue ambiance solarized-->
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8"/>
    <title>Hostd</title>
    <link rel="stylesheet" href="/css/bootstrap.css">
    <link rel="stylesheet" href="/css/bootstrap-responsive.css">
    <link rel="stylesheet" href="/css/font-awesome.css">
    <link rel="stylesheet" href="/css/hostd.css">
    <script src="/js/jquery-1.9.1.js"></script>
    <script src="/js/common-action.js"></script>
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
            <div class="alert alert-info">
                Config has not effect? Set your DNS server to ${localIp} first. Learn <a href="/help/dns">how to set</a>.
            </div>
            <% if (zones.length>0)
            {
            for (var i=0;i
            <zones.length
            ;i++)
            {
            var zone=zones[i];
            %>
            <ul data-index="<%=i%>">
                <li class="ui-btn-up-b ui-btn-inner"><a class="ui-link-inherit"
                                                        href="javascript:void(0)" id="fold-button"><%=zone.domain%>&nbsp;<i
                        id="fold-icon" class="icon-double-angle-up"></i></a><span
                        style="float:right;"><a class="ui-link-inherit" href="javascript:void(0)" id="link">新建<i
                        class="icon-plus"></i></a></span></li>
                <li id="configs">
                    <ul class="folded">
                        <% if (zone.config.length>0)
                        {
                        for (var j=0;j
                        <zone.config.length
                        ;j++)
                        {
                        var config = zone.config[j];
                        %>
                        <li class="ui-btn-up-a ui-btn-inner" data="<%=config.ip%>" domain-index="<%=i%>"
                            config-index="<%=j%>">
                            <a class="ui-link-inherit" id="active-button" href="javascript:void(0)">
                                <% if (config.active) {%><i
                                    style="color: #46a546"
                                    class="icon-ok"></i><%}
                                else {
                                %>&nbsp;&nbsp;&nbsp;&nbsp;<%}%>&nbsp;<%=config.ip%></a>
                            <span
                                    style="float:right;"><a class="ui-link-inherit" href="javascript:void(0)" id="link">编辑<i
                                    class="icon-edit"></i></a></span>
                        </li>
                        <% }
                        }%>
                    </ul>
                </li>
            </ul>
            <%
            }
            } else {%>
                <p>No config? </p><p>Try <a class="btn" href="/edit"><i class="icon-edit"></i>Edit</a></p><p> or <a class="btn" href="/login"><i class="icon-key"></i>Login</a> to
                    share config in other device</p>
            <%}%>

        </div>
    </script>
    <div id="container"></div>
    <script type="text/javascript">
        function render() {
            var data = {
                zones: BHzones
            }
            var bt = baidu.template;
            var html = bt("zones-template", data);
            document.getElementById('container').innerHTML = html;
        }
        render()
    </script>

</div>
</body>

</html>