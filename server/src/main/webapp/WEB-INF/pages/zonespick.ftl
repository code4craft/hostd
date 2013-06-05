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
        domainCandidateDefault = []
        ipCandidateDefault = ['127.0.0.1'];
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
            <div class="alert alert-info">
                <span>
                Config has not effect? Set your DNS server to ${localIp} first. Learn <a href="/help/dns">how to set</a>.
                </span>
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
                                %>&nbsp;&nbsp;&nbsp;&nbsp;<%}%>&nbsp;<%=config.ip%>
                                <%if (config.comment != undefined && config.comment!="") {%>
                                <span style="color: #93a1a1">&nbsp;&nbsp;(<%=config.comment%>)</span>
                                <%}%></a>
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
                            %>&nbsp;&nbsp;&nbsp;&nbsp;<%}%>&nbsp;<%=config.ip%>
                            <%if (config.comment != undefined && config.comment!="") {%>
                            <span style="color: #93a1a1">&nbsp;&nbsp;(<%=config.comment%>)</span>
                            <%}%></a>
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
    <div id="container">
    </div>
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
    <div class="span10 offset1">
        <p></p>

        <p><a href="javascript:void(0)" class="btn" id="button-share"><i class="icon-share" style="color: #0480be"></i>Share</a></p>
    </div>
    <div id="addModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
            <h3 id="myModalLabel">Add Config</h3>
        </div>
        <div class="modal-body">
            <div class="input-append span12" style="margin-left: 0%">
                <input class="span11" id="input-domain" placeholder="Please input domain" type="text" name="domain">
                <span class="add-on"><i id="button-clear-domain" style="color: #0480be"
                                        class="offset1 icon-refresh"></i></span>
            </div>
            <div class="input-append span11" style="margin-left: 0%">
                <input class="span12" id="input-ip" placeholder="Please input ip" type="text" name="ip"/>
                <span class="add-on"><i class="icon-refresh offset1" style="color: #0480be"
                                        id="button-clear-ip"></i></span>
            </div>
            <div class="input-append span11" style="margin-left: 0%">
                <input class="span12" id="input-comment" placeholder="comment here" type="text" name="comment"/>
                <span class="add-on"><i class="icon-refresh offset1" style="color: #0480be"
                                        id="button-clear-comment"></i></span>
            </div>

            <div style="margin-left: 0%" class="span12 alert alert-info hide" id="input-error"></div>
            <div class="span12"></div>
            <div class="span12"></div>
        </div>
        <div class="modal-footer">
            <a href="javascript:void(0)" class="btn" data-dismiss="modal" aria-hidden="true">Close</a>
            <a href="javascript:void(0)" id="button-do-add" class="btn btn-primary">Add</a>
        </div>

    </div>
    <div id="shareModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
            <h3 id="myModalLabel">Share Config</h3>
        </div>
        <div class="modal-body">
            <div class="input-append span12" style="margin-left: 0%">
                <input class="span11" id="config-share-url" type="text" name="domain">
            </div>
            <p>Copy the url to share your config with others!</p>
        </div>

    </div>
</body>

</html>