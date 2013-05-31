Hostd-server
---------
Hostd-server是blackhole的一个控制套件，它提供一个Web页面，让最终用户可以管理和修改自己的DNS设置。

基于Spring MVC、myBatis、sqlite进行开发。

计划内置jetty作为web容器，sqlite作为存储，是个开箱可用的服务器。但是也可以用其他容易进行部署，并提供mysql连接的支持。

前端部分比较烂，属于赶鸭子上架那种，使用bootstrap做的，希望能做到自适应。js部分使用jQuery和codeMirror。主要配置的选取和编辑功能参考了[HostsAdmin](https://github.com/tg123/chrome-hostadmin)，非常优秀的思路，在此感谢@tg123。

其他部分可以看hostd的[pages](http://code4craft.github.io/hostd/)