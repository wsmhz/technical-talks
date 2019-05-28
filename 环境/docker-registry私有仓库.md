有时候使用 Docker Hub 这样的公共仓库可能不方便，用户可以创建一个本地仓库供私人使用。

docker-registry 是官方提供的工具，可以用于构建私有的镜像仓库

### 容器直接运行方式安装
这将使用官方的 registry 镜像来启动私有仓库。默认情况下，仓库会被创建在容器的 /var/lib/registry 目录下。你可以通过 -v 参数来将镜像文件存放在本地的指定路径。

例如下面的例子将上传的镜像放到本地的 /opt/data/registry 目录。
```
    docker run -d \
        -p 5000:5000 \
        -v /opt/data/registry:/var/lib/registry \
        registry
```
#### 查看本地镜像
创建好私有仓库之后，就可以使用 docker tag 来标记一个镜像，然后推送它到仓库。

例如私有仓库地址为 127.0.0.1:5000。

先在本机查看已有的镜像。

```
    docker image ls
```
#### 标记本地镜像
使用 docker tag 将 nginx:latest 这个镜像标记

格式为 docker tag IMAGE[:TAG] [REGISTRY_HOST[:REGISTRY_PORT]/]REPOSITORY[:TAG]

```
    docker tag nginx:latest 127.0.0.1:5000/nginx:latest
```
#### 上传镜像

```
    docker push 127.0.0.1:5000/nginx:latest
```
#### 用 curl 查看仓库中的镜像

```
    curl 127.0.0.1:5000/v2/_catalog
```
应该会出现你刚刚上传的镜像

#### 下载仓库镜像
先删除已有镜像，再尝试从私有仓库中下载这个镜像。

```
    docker image rm 127.0.0.1:5000/nginx:latest
    
    docker pull 127.0.0.1:5000/nginx:latest
```
#### 可能出现的问题
##### 拒绝链接问题 或者  http: server gave HTTP response to HTTPS client

打开文件
```
    vim /usr/lib/systemd/system/docker.service
```
在12行ExecStart=/usr/bin/dockerd后面增加  --insecure-registry  ip：5000
