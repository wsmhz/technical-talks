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
