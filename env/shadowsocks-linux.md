### 1） 需要Python环境

### 2） 安装pip
  
```
curl https://bootstrap.pypa.io/get-pip.py -o get-pip.py

python get-pip.py
```
### 3) 安装shadowsocks

```
pip install shadowsocks
```
### 4) 配置shadowsocks

```
vi /etc/shadowsocks.json

{
    "server":"ip",
    "server_port":50013,
    "local_port":1080,
    "password":"密码",
    "timeout":600,
    "method":"aes-256-cfb"
}
```
### 5) 将shadowsocks加入系统服务

```
vi /etc/systemd/system/shadowsocks.service


[Unit]
Description=Shadowsocks
[Service]
TimeoutStartSec=0
ExecStart=/usr/bin/ssserver -c /etc/shadowsocks.json
[Install]
WantedBy=multi-user.target
```

### 6) 启动shadowsocks服务并设置开机自启

```
# 设置开机自启命令
systemctl enable shadowsocks

# 启动命令
systemctl start shadowsocks

#查看状态命令
systemctl status shadowsocks
```



