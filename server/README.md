Hostd-server
---------
Hostd-server是blackhole的一个控制套件，它提供一个Web页面，让最终用户可以管理和修改自己的DNS设置。

基于Spring MVC、myBatis、sqlite进行开发。

计划内置jetty作为web容器，sqlite作为存储，是个开箱可用的服务器。但是也可以用其他容易进行部署，并提供mysql连接的支持。

前端部分比较烂，属于赶鸭子上架那种，使用bootstrap做的，希望能做到自适应。js部分使用jQuery和codeMirror。主要配置的选取和编辑功能参考了[HostsAdmin](https://github.com/tg123/chrome-hostadmin)，非常优秀的思路，在此感谢@tg123。

### 体验

hostd本身包含了一个dns服务器，这里我们先不直接将系统的dns改为42.96.139.35，而是使用nslookup进行测试。

* 测试dns结果
		
		nslookup www.dianping.com 42.96.139.35
		
* 访问http://42.96.139.35/,进行配置的修改。[图]例如这里，我们将www.dianping.com配置一个ip: 127.0.0.1。
* 重新测试dns结果
	
		nslookup www.dianping.com 42.96.139.35
		
	可以看到，这里dns发生了变化，变成了你配置的dns。

### 本地搭建server
本地搭建server需要部署blackhole和hostd。blackhole是一个独立的dns服务器，基于dnsjava基础包，hostd是一个标准的Java web项目。

执行命令

curl | sh
