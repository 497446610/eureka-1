运行3个eureka组成的集群，运行3次，各自运行时的参数如下：
--spring.profiles.active=server1
--spring.profiles.active=server2
--spring.profiles.active=server3

windows环境需要修改hosts文件：
c:\Windows\System32\drivers\etc\hosts，添加：

127.0.0.1   eureka-server-1111
127.0.0.1   eureka-server-2222