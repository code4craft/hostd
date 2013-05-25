<!DOCTYPE html>
<html>
<!--rubyblue ambiance solarized-->
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8"/>
    <title>SetHosts</title>
    <link rel="stylesheet" href="/css/bootstrap.css">
    <#--<link rel="stylesheet" href="/css/bootstrap-mobile.css">-->
    <script src="/js/jquery-1.9.1.js"></script>
    <#--<script src="/js/jquery.mobile-1.2.0.js"></script>-->
    <script src="/js/zonespick.js"></script>
    <link rel="stylesheet" href="/css/jqm-icon-pack-1.1.1-fa.css">
    <link rel="stylesheet" href="/css/jquery.mobile.structure-1.2.0.css"/>
    <script>
        BHzones =${data};
    </script>
</head>

<body>
<div data-role="page" data-theme="b">

    <div class="row-fluid">
        <div class="span12">
            <div data-role="header" data-position="inline">
                <h1>hostd</h1>
                <div data-role="navbar">
                    <ul>
                        <li><a href="javascript:void(0)" data-icon="home" class="ui-btn-active">Hosts</a></li>
                        <li><a href="/" data-icon="edit">Edit</a></li>
                        <li><a href="login" data-icon="cogs">Login</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="span10 offset1">
            <div data-role="content" data-theme="a">
                <h1>hosts</h1>
                <ul data-role="listview" data-inset="true" data-divider-theme="b">
                    <li><a href="" id="link">www.dianping.com</a></li>
                    <ul style="display: none" id="hiden" data-role="listview" data-inset="true" data-divider-theme="a">
                        <li data-icon="refresh"><a href="">192.168.9.101</a></li>
                        <li data-icon="refresh"><a href="">192.168.9.101</a></li>
                        <li data-icon="refresh"><a href="">192.168.9.101</a></li>
                        <li data-icon="refresh"><a href="">192.168.9.101</a></li>
                    </ul>
                </ul>

            </div>
        </div>
        <div class="span12">
            <div data-role="content" data-theme="a">

                <a href="https://github.com/commadelimited/jQuery-Mobile-Bootstrap-Theme" data-role="button"
                   data-icon="star">Get the code</a>

                <h2>Buttons</h2>

                <a href="index.html" data-role="button" data-theme="a" data-icon="trash">Swatch A</a>
                <a href="index.html" data-role="button" data-theme="b" data-icon="search">Swatch B</a>
                <a href="index.html" data-role="button" data-theme="c" data-icon="heart">Swatch C</a>
                <a href="index.html" data-role="button" data-theme="d" data-icon="user">Swatch D</a>
                <a href="index.html" data-role="button" data-theme="e" data-icon="off">Swatch E</a>
                <a href="index.html" data-role="button" data-theme="f" data-icon="cog">Swatch F</a>
                <a href="index.html" data-role="button" data-icon="music">Swatch F</a>

            </div>

        </div>
    </div>
</div>
</div>
</div>
</body>

<#--<body>-->
<#--<div data-role="page" data-theme="a">-->
<#--<div data-role="header" data-position="inline">-->
<#--<h1>jQuery Mobile Twitter Bootstrap Theme</h1>-->
<#--<div data-role="navbar">-->
<#--<ul>-->
<#--<li><a href="index.html" data-icon="home">Home</a></li>-->
<#--<li><a href="buttons.html" data-icon="th-large">Buttons</a></li>-->
<#--<li><a href="listviews.html" data-icon="list" class="ui-btn-active">Lists</a></li>-->
<#--<li><a href="nav.html" data-icon="cogs">Nav</a></li>-->
<#--<li><a href="forms.html" data-icon="file">Forms</a></li>-->
<#--</ul>-->
<#--</div>-->
<#--</div>-->
<#--<div data-role="content" data-theme="a">-->

<#--<a href="https://github.com/commadelimited/jQuery-Mobile-Bootstrap-Theme" data-role="button" data-icon="star">Get the code</a>-->

<#--<h2>Listviews</h2>-->

<#--<ul data-role="listview" data-inset="true" data-divider-theme="a">-->
<#--<li data-role="list-divider">Swatch A</li>-->
<#--<li data-icon="repeat"><a href="">A list item</a></li>-->
<#--<li data-icon="refresh"><a href="">A list item</a></li>-->
<#--<li data-icon="lock"><a href="">A list item</a></li>-->
<#--</ul>-->

<#--<ul data-role="listview" data-inset="true" data-divider-theme="b">-->
<#--<li data-role="list-divider">Swatch B</li>-->
<#--<li data-icon="flag"><a href="">A list item</a></li>-->
<#--<li data-icon="headphones"><a href="">A list item</a></li>-->
<#--<li data-icon="tag"><a href="">A list item</a></li>-->
<#--</ul>-->

<#--<ul data-role="listview" data-inset="true" data-divider-theme="c">-->
<#--<li data-role="list-divider">Swatch C</li>-->
<#--<li data-icon="volume-off"><a href="">A list item</a></li>-->
<#--<li data-icon="volume-down"><a href="">A list item</a></li>-->
<#--<li data-icon="volume-up"><a href="">A list item</a></li>-->
<#--</ul>-->

<#--<ul data-role="listview" data-inset="true" data-divider-theme="d">-->
<#--<li data-role="list-divider">Swatch D</li>-->
<#--<li data-icon="bookmark"><a href="">A list item</a></li>-->
<#--<li data-icon="adjust"><a href="">A list item</a></li>-->
<#--<li data-icon="map-marker"><a href="">A list item</a></li>-->
<#--</ul>-->

<#--<ul data-role="listview" data-inset="true" data-divider-theme="e">-->
<#--<li data-role="list-divider">Swatch E</li>-->
<#--<li data-icon="tint"><a href="">A list item</a></li>-->
<#--<li data-icon="move"><a href="">A list item</a></li>-->
<#--<li data-icon="screenshot"><a href="">A list item</a></li>-->
<#--</ul>-->

<#--<ul data-role="listview" data-inset="true" data-divider-theme="f">-->
<#--<li data-role="list-divider">Swatch F</li>-->
<#--<li data-icon="arrow-right"><a href="">A list item</a></li>-->
<#--<li data-icon="arrow-down"><a href="">A list item</a></li>-->
<#--<li data-icon="arrow-left"><a href="">A list item</a></li>-->
<#--<li data-icon="arrow-up"><a href="">A list item</a></li>-->
<#--</ul>-->

<#--</div>-->
<#--</div>-->
<#--</body>-->
</html>