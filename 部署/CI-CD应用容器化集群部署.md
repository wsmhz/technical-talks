## jenkins + github + docker-swarm + swirl实现CI/CD持续集成、持续交付的应用容器化集群部署方案


        

&emsp;&emsp; **作为一名开发者，所接触的东西不应该只限于开发方面的东西。**


&emsp;&emsp; **如果作为一名管理者，一个团队的leader更应该全面掌握产品从无到有，从开发到上线的整个流程，同时确保整个的流程每个人的职责以及各个环节的安全性把控，在此基础上同时提高效率。**


&emsp;&emsp; 那么一套自动化部署及运维方案是很有必要的。折腾了几个月搞了下面的这一套方案。


![Image text](https://user-gold-cdn.xitu.io/2019/5/29/16b012c9f32f18a6?w=801&h=528&f=png&s=74081)

首先：
#### Jenkins + GitHub

&emsp;&emsp;详见整理的文档--搭建Jenkins+Github持续集成环境，[地址](https://github.com/wsmhz/technical-talks/blob/master/%E7%8E%AF%E5%A2%83/%E6%90%AD%E5%BB%BAJenkins+Github%E6%8C%81%E7%BB%AD%E9%9B%86%E6%88%90%E7%8E%AF%E5%A2%83.md)
    
    
==注意：==
    
&emsp;&emsp; 1） jenkins步骤中有构建项目，如果是java项目，注意**maven jdk**等环境
    
&emsp;&emsp; 2） jenkins步骤中有构建docker镜像，**docker环境搭建**，[给个链接吧](https://github.com/wsmhz/technical-talks/blob/master/%E7%8E%AF%E5%A2%83/docker-linux.md)
    
&emsp;&emsp; 3） jenkins步骤中有推送镜像，需要一个**镜像仓库**，这里可以选择的很多，如公共的dockerhub，或者自己搭一个私有仓库，rancher，docker自带的registry等等，我这里就选择docker自带的registry直接部在在同一台服务器上，[再次给链接吧](https://github.com/wsmhz/technical-talks/blob/master/%E7%8E%AF%E5%A2%83/docker-registry%E7%A7%81%E6%9C%89%E4%BB%93%E5%BA%93.md)
    
&emsp;&emsp; **emmmm~接着就是怎么使用这些镜像的问题了**。

==说明：==

&emsp;&emsp; 其实这一步有很多选择的，高级点的k8s全家桶（有点复杂，后续转为k8s），官方的docker-swarm，我这里就选择官方的了，至于docker-swarm已经在安装docker的时候已经集成进来了，现在需要的是有个可视化界面去编排我们的服务，同时简化操作。

&emsp;&emsp; **我选择的是swirl这个开源插件**,[地址](https://github.com/cuigh/swirl)，开始吧~~

### swirl
##### 数据库直接用MongoDB ，docker直接启动吧

```
    docker run -d -p 8001:8001 \
    --mount type=bind,src=/var/run/docker.sock,dst=/var/run/docker.sock \
    -e DB_TYPE=mongo \
    -e DB_ADDRESS=你的ip:27017/swirl \
    --name=swirl \
    cuigh/swirl
```

&emsp;&emsp; 开始访问你的swirl，浏览器输入ip和你的端口

&emsp;&emsp;设置一下你的用户名和密码

==注意：==

&emsp;&emsp; swirl需要swarm集群环境，所以可能会报一个没有找到swarm节点的错，进入你的服务器
    
```
    docker init swarm 
```
&emsp;&emsp; 再次访问就好了，至于swarm的集群知识就不多说了，有多的服务器就使劲加节点吧

效果图
![Image text](https://user-gold-cdn.xitu.io/2019/5/28/16afdfa9dbe4ee92?w=1902&h=702&f=png&s=247057)
![Image text](https://user-gold-cdn.xitu.io/2019/5/29/16b012b8c2bc5620?w=1512&h=571&f=png&s=83264)


**最后附上我所搭建的访问地址吧**

**jenkins**：   http://jenkins.wsmhz.cn

**swirl**：   http://swirl.wsmhz.cn     用户名：guest   密码：guest

**业务项目**：  http://www.wsmhz.cn （可能服务器会挂掉）

**业务后台**： http://admin.wsmhz.cn （可能服务器会挂掉）
