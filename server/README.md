blackhole-server-suite
---------
blackhole-server-suite是blackhole的一个控制套件，它提供一个Web页面，让最终用户可以管理和修改自己的DNS设置。

blackhole包含一个"自定义"模式，使用自定义模式的时候，每个用户IP都可以配置自己独立的DNS地址，这对于公司内网需要频繁切换DNS地址的时候是非常有用的(至少作者工作过的公司曾有过类似需求)。

server-suite和blackhole是完全独立的，server-suite提供设置页面和一些便捷功能(如保存配置)，而blackhole则负责DNS服务，包括自定义DNS地址，它们之间通过TCP连接进行同步。
