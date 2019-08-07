1.下载Python3安装包

```
wget https://www.python.org/ftp/python/3.7.2/Python-3.7.2.tgz
```


2.创建安装目录

```
mkdir -p /usr/local/python3
```



3.解压安装包

```
tar -zxvf Python-3.7.2.tgz
```



4.进入解压后的目录，编译安装

1）进入解压后的目录

2）执行./configure

```
./configure --prefix=/usr/local/python3
```

3）执行make指令

```
make
```

4）再执行make install 命令

```
make install
```


==注意！==./configure时报错，configure: error: no acceptable C compiler found in $PATH

```
sudo yum install gcc-c++
```


重新执行

5.建立python3的软链

```
ln -s /usr/local/python3/bin/python3 /usr/bin/python3
```

6.将/usr/local/python3/bin加入PATH

```
sudo vim /etc/profile
```


然后在文件末尾添加

```
export PATH=$PATH:/usr/local/python3/bin
```


7.保存生效

```
source /etc/profile
```



8.测试是否安装成功

```
python3 -V

pip3 -V
```


如果没安装pip，执行

```
curl https://bootstrap.pypa.io/get-pip.py -o get-pip.py   # 下载安装脚本
```

==注意==：用哪个版本的 Python 运行安装脚本，pip 就被关联到哪个版本

```
sudo python3 get-pip.py    # 运行安装脚本
```


如果pip3 -V找不到，可以尝试创建一下pip3的软链接：

```
ln -s /usr/local/python3/bin/pip3 /usr/bin/pip3
```

