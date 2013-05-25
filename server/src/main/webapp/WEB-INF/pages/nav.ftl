<div class="navbar">
    <div class="navbar-inner">
    <#--<a class="brand" href="#">Nav</a>-->
        <ul class="nav">
            <li <#if tab="hosts">class="active"</#if>><a href="/zonespick"><i class="icon-home"></i>Hosts</a></li>
            <li <#if tab="switch">class="active"</#if>><a href="/"><i class="icon-exchange"></i>Switch</a></li>
            <li <#if tab="edit">class="active"</#if>><a href="/edit"><i class="icon-edit"></i>Edit</a></li>
            <li <#if tab="login">class="active"</#if>><a href="/login"><i class="icon-key"></i>Login</a></li>
        </ul>
    </div>
</div>