## 卸载原有的
列出安装包，然后删除
```
    yum list installed | grep docker
    sudo yum -y remove docker-engine.x86_64
    rm -rf /var/lib/docker
```
## 安装docker
##### Docker 要求 CentOS 系统的内核版本高于 3.10 
查看你当前的内核版本

```
    uname -r
```
确保 yum 包更新到最新

```
    sudo yum update
```
再次卸载旧版本(如果安装过旧版本的话)

```
    sudo yum remove docker  docker-common docker-selinux docker-engine
```
安装需要的软件包依赖

```
    sudo yum install -y yum-utils device-mapper-persistent-data lvm2
```

设置yum源

```
    sudo yum-config-manager --add-repo https://download.docker.com/linux/centos/docker-ce.repo
```

可以查看所有仓库中所有docker版本，并选择特定版本安装

```
    yum list docker-ce --showduplicates | sort -r
```

安装docker

```
    sudo yum install docker-ce
```
由于repo中默认只开启stable仓库，故这里安装的是最新稳定版

启动并加入开机启动

```
    $ sudo systemctl start docker
    $ sudo systemctl enable docker
```

验证安装是否成功(有client和service两部分表示docker安装启动都成功了)

```
    $ docker version
```

#### 免sudo使用docker命令
如果还没有 docker group 就添加一个   
```
    sudo groupadd docker
```

将用户加入该 group 内  
```
    sudo gpasswd -a ${USER} docker
    sudo service docker restart
```
切换当前会话到新 group 或者重启 X 会话   
```
    newgrp - docker
```

#### 镜像加速器
在 /etc/docker/daemon.json 中写入如下内容（如果文件不存在请新建该文件）

```
{
    "registry-mirrors": [
        "https://registry.docker-cn.com"
    ]
}
```

之后重新启动服务。

```
    $ sudo systemctl daemon-reload
    $ sudo systemctl restart dock
```
