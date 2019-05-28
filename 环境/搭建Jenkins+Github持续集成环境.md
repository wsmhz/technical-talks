## CentOS 7.0+ rpm方式安装jenkins及卸载(非war包)

#### 安装
1. jenkins下载：
```
    wget http://pkg.jenkins-ci.org/redhat/jenkins-2.164-1.1.noarch.rpm
```
2. 进入jenkins-2.147-1.1.noarch.rpm存放目录导入jenkins密钥，执行如下命令：
```
    sudo wget -O /etc/yum.repos.d/jenkins.repo https://pkg.jenkins.io/redhat/jenkins.repo
    sudo rpm --import https://pkg.jenkins.io/redhat/jenkins.io.key
    rpm -ivh jenkins-2.164-1.1.noarch.rpm
```
3. 修改jenkins服务端口，所属用户
```
    vim /etc/sysconfig/jenkins
```
4. 修改jdk环境
```
    vim /etc/init.d/jenkins 
```
5. 完成启动
```
    service jenkins start
```
6. 访问你修改的端口，然后你看到需要密码的时候，执行
```
    cat /var/lib/jenkins/secrets/initialAdminPassword
```
获取密码，然后安装提示一步步安装推荐的插件，设置初始密码等等。



#### 彻底卸载jenkins

```
> service jenkins stop
> yum clean all
> yum -y remove jenkins
> rm -rf /var/cache/jenkins
> rm -rf /var/lib/jenkins/
```


## github配置

##### sercret text
**注：此处需要一个对项目有写权限的账户**

进入github --> setting --> Personal Access Token --> Generate new token

自己先保存此token，如果丢失，之后只能重新生成

##### 进入jenkins系统管理中配置GitHub Plugin
系统管理 --> 系统设置 --> GitHub --> Add GitHub Sever

API URL 输入 https://api.github.com

Credentials点击Add添加，Kind选择Secret Text 填入刚刚生成密文

设置完成后，点击TestConnection,提示Credentials verified for user UUserName, rate limit: xxx,则表明有效。

##### 创建一个流水线项目
![Image text](https://user-gold-cdn.xitu.io/2019/5/28/16afd97965d854e3?w=1072&h=633&f=png&s=75978)

填入github-webhook的参数
![Image text](https://user-gold-cdn.xitu.io/2019/5/28/16afd97dc4bc8f63?w=1070&h=461&f=png&s=36262)

设置流水线脚本
![Image text](https://user-gold-cdn.xitu.io/2019/5/28/16afd97eed5649c7?w=1543&h=830&f=png&s=79594)

完成

分享一下我的脚本吧，[地址](https://juejin.im/post/5cecf871e51d45572c05ffda)


##### GitHub webhooks 设置

进入GitHub上指定的项目 --> setting --> WebHooks&Services --> add webhook --> 输入    IP：端口/job/你的流水线名/buildWithParameters?token=****

![Image text](https://user-gold-cdn.xitu.io/2019/5/28/16afd98034eecbc6?w=1045&h=667&f=png&s=64612)

##### 测试
在已设置该hook的项目内提交代码，push操作，然后你可以看见jenkins的任务出现了。
