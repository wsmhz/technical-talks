# 环境： CentOS7+， easy-rsa-3.0
# 用于打通云服务器（腾讯，阿里，华为）和自己的电脑或公司内网，或者打通不同服务商之间云服务器的网络
# 实现可以通过内网互通（集群的环境需要）

1） yum -y install openssl openssl-devel lzo openvpn easy-rsa

2）cp -r /usr/share/easy-rsa/ /etc/openvpn/easy-rsa

3）cd /etc/openvpn/easy-rsa/

4）\rm 3 3.0  #删除软连接 注意有个\

5） cd 3.0.3/

6） find / -type f -name "vars.example" | xargs -i cp {} . && mv vars.example vars

这里说明一下，正常来说 easy-rsa-3.0.3 安装完之后，vars.example 文件在 /usr/share/doc/easy-rsa-3.0.3/ 目录，至于有些人说找不到这个文件

### 创建服务端证书
#### 创建一个新的 PKI 和 CA

7）./easyrsa init-pki  #创建空的pki

8） ./easyrsa build-ca nopass #创建新的CA，不使用密码

==出现==：Common Name (eg: your user, host, or server name) [Easy-RSA CA]: 回车

CA creation complete and you may now import and sign cert requests.
Your new CA certificate file for publishing is at:
/etc/openvpn/easy-rsa/3.0.3/pki/ca.crt

成功！！

#### 创建服务端证书
9）./easyrsa gen-req server nopass

==出现==：Common Name (eg: your user, host, or server name) [server]: 回车

Keypair and certificate request completed. Your files are:
req: /etc/openvpn/easy-rsa/3.0.3/pki/reqs/server.req
key: /etc/openvpn/easy-rsa/3.0.3/pki/private/server.key

成功！!

#### 签约服务端证书

10）  ./easyrsa sign server server

==出现==：Type the word 'yes' to continue, or any other input to abort.
  Confirm request details: yes
  
Signature ok
The Subject's Distinguished Name is as follows
commonName            :ASN.1 12:'server'
Certificate is to be certified until Apr  7 14:54:08 2028 GMT (3650 days)

Write out database with 1 new entries
Data Base Updated

Certificate created at: /etc/openvpn/easy-rsa/3.0.3/pki/issued/server.crt

成功！！

#### 创建 Diffie-Hellman

11）./easyrsa gen-dh

等一段时间，到这里服务端的证书就创建完了

### 创建客户端证书

12）创建客户端证书

复制文件

cp -r /usr/share/easy-rsa/ /etc/openvpn/client/easy-rsa

cd /etc/openvpn/client/easy-rsa/

\rm 3 3.0 

cd 3.0.3/

find / -type f -name "vars.example" | xargs -i cp {} . && mv vars.example vars

13）./easyrsa init-pki #创建新的pki

14） ./easyrsa gen-req dalin nopass  #客户证书名为大林，木有密码，根据自己的修改

15）cd /etc/openvpn/easy-rsa/3.0.3/

16）./easyrsa import-req
/etc/openvpn/client/easy-rsa/3.0.3/pki/reqs/dalin.req dalin

  #根据自己的修改

17）./easyrsa sign client dalin  #根据自己的修改

### 整理证书
现在所有的证书都已经生成完了，下面来整理一下。

18）服务端所需要的文件

mkdir /etc/openvpn/certs

cd /etc/openvpn/certs/  

cp /etc/openvpn/easy-rsa/3.0.3/pki/dh.pem .      

cp /etc/openvpn/easy-rsa/3.0.3/pki/ca.crt .

cp /etc/openvpn/easy-rsa/3.0.3/pki/issued/server.crt .

cp /etc/openvpn/easy-rsa/3.0.3/pki/private/server.key .

ls

19）客户端所需的文件

mkdir /etc/openvpn/client/dalin/

cp /etc/openvpn/easy-rsa/3.0.3/pki/ca.crt /etc/openvpn/client/dalin/

cp /etc/openvpn/easy-rsa/3.0.3/pki/issued/dalin.crt /etc/openvpn/client/dalin/

cp /etc/openvpn/client/easy-rsa/3.0.3/pki/private/dalin.key /etc/openvpn/client/dalin/

ll /etc/openvpn/client/dalin/

20）服务器配置文件

vim /etc/openvpn/server.conf

以下内容：

```
port 1999   #占用端口

proto tcp   #使用udp，tcp

dev tun     #使用tun模式，也可以使用tap

ca /etc/openvpn/certs/ca.crt    #证书位置

cert /etc/openvpn/certs/server.crt

key /etc/openvpn/certs/server.key

dh /etc/openvpn/certs/dh.pem

ifconfig-pool-persist /etc/openvpn/ipp.txt    #存放每个人使用的IP

#虚拟网卡网段，这个是分配给客户端的地址，不要和内网网段重复。
server 5.5.5.0 255.255.255.0

#指定内网的路由,如果有多个,可以多写几条
push "route 172.17.0.0 255.255.240.0"

client-to-client                                    #允许客户端之间互通

keepalive 20 120   #保持连接时间

comp-lzo    #开启vpn压缩

duplicate-cn                    #允许多人使用同一个证书连接VPN，不建议使用

user nobody     #运行用户

group nobody    #运行组

persist-key

persist-tun

status openvpn-status.log

log-append  openvpn.log

verb 3  #日志级别0-9，等级越高，记录越多

mute 20
```
### 启动服务

21）systemctl start openvpn@server

22）然后接下来配置 iptables 及转发，懒得写了


## 客户端连接该vpn

### 配置
1） yum -y install openssl openssl-devel lzo openvpn easy-rsa

2）cd /etc/openvpn/

3）把之前配置的客户端的ca.crt，dalin.crt，dalin.key弄过来

4）配置文件

cd /etc/openvpn

vim client.conf

```
client   #这个不能改
#proto udp  #要与server.conf一致
proto tcp
dev tun    #要与server.conf一致
remote 公网ip 1999

ca E:\\openvpn\\config\\ca.crt   
cert E:\\openvpn\\config\\dalin.crt
key E:\\openvpn\\config\\dalin.key      #对应所下载的证书

remote-cert-tls server

auth-nocache
resolv-retry infinite
nobind
mute-replay-warnings

keepalive 20 120
comp-lzo

user nobody
group nobody

persist-key
persist-tun
status openvpn-status.log
log-append openvpn.log
verb 3
mute 20
```

8）systemctl start openvpn@client

9）测试，ping一下server的内网地址是否通
