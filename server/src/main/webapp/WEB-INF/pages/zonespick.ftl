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
    <script src="/js/bootstrap.js"></script>
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
        <div class="span10 offset1" id="configs-container">
            <div class="alert alert-info" style="height:30px">
                <span>
                Config has not effect? Set your DNS server to ${localIp} first. Learn <a href="/help/dns">how to set</a>.
                </span>

                <span class="pull-right"><a class="btn btn-primary" href="javascript:void(0)" id="button-new"><i
                        class="icon-file"></i>New Domain</a></span>
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
                <li class="ui-btn-up-b ui-btn-inner" data-domain="<%=zone.domain%>"><a class="ui-link-inherit"
                                                                                       href="javascript:void(0)"
                                                                                       id="fold-button"><%=zone.domain%>&nbsp;<i
                        id="fold-icon" class="icon-double-angle-up"></i></a><span
                        style="float:right;"><a class="ui-link-inherit" id="button-new" href="javascript:void(0)">Add<i
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
                                    style="float:right;"><a class="ui-link-inherit" href="javascript:void(0)"
                                                            id="delete-button">Delete<i
                                    class="icon-trash"></i></a></span>
                        </li>
                        <% }
                        }%>
                    </ul>
                </li>
            </ul>
            <%
            }
            } else {%>
            <div id="empty-tip">
                <p class="lead">No config? </p>

                <p class="lead"><a class="btn btn-primary" href="javascript:void(0)" id="button-new"><i
                        class="icon-file"></i>Add</a> your first config</p>

                <p class="lead">or Try <a class="btn" href="/edit"><i class="icon-edit"></i>Edit</a> in text form</p>

                <p class="lead"> or <a class="btn" href="/login"><i class="icon-key"></i>Login</a> to
                    synchronize config anywhere!</p>
            </div>
            <%}%>

        </div>
    </script>
    <script type="text/template" id="config-template">
        <ul data-index="<%=i%>">
            <li class="ui-btn-up-b ui-btn-inner" data-domain="<%=zone.domain%>"><a class="ui-link-inherit"
                                                                                   href="javascript:void(0)"
                                                                                   id="fold-button"><%=zone.domain%>&nbsp;<i
                    id="fold-icon" class="icon-double-angle-up"></i></a><span
                    style="float:right;"><a class="ui-link-inherit" id="button-new" href="javascript:void(0)">Add<i
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
                                style="float:right;"><a class="ui-link-inherit" href="javascript:void(0)"
                                                        id="delete-button">Delete<i
                                class="icon-trash"></i></a></span>
                    </li>
                    <% }
                    }%>
                </ul>
            </li>
        </ul>
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
    <div id="addModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
            <h3 id="myModalLabel">Add Config</h3>
        </div>
        <div class="modal-body">
            <p><input class="span12" id="input-domain" placeholder="Please input domain" type="text" name="domain"></p>

            <p><input class="span12" id="input-ip" placeholder="Please input ip" type="text" name="ip"
                      class="typeahead" data-items="2" data-source="candidate"></p>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
        </div>
        <div class="modal-footer">
            <a href="javascript:void(0)" class="btn" data-dismiss="modal" aria-hidden="true">Close</a>
            <a href="javascript:void(0)" id="button-do-add" class="btn btn-primary">Add</a>
        </div>

    </div>
</body>

</html>