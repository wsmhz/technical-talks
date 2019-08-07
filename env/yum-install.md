由于yum依赖的是python2.7版本，误删了python2.7导致yum不能使用，需要重新安装yum

1.编辑一键安装脚本

```
vim install-yum.sh
```


编写以下内容

```
wget http://mirrors.163.com/centos/7/os/x86_64/Packages/python-libs-2.7.5-76.el7.x86_64.rpm

wget http://mirrors.163.com/centos/7/os/x86_64/Packages/python-2.7.5-76.el7.x86_64.rpm

wget http://mirrors.163.com/centos/7/os/x86_64/Packages/python-iniparse-0.4-9.el7.noarch.rpm

wget http://mirrors.163.com/centos/7/os/x86_64/Packages/python-pycurl-7.19.0-19.el7.x86_64.rpm

wget http://mirrors.163.com/centos/7/os/x86_64/Packages/rpm-python-4.11.3-35.el7.x86_64.rpm

wget http://mirrors.163.com/centos/7/os/x86_64/Packages/yum-metadata-parser-1.1.4-10.el7.x86_64.rpm

wget http://mirrors.163.com/centos/7/os/x86_64/Packages/yum-3.4.3-161.el7.centos.noarch.rpm

wget http://mirrors.163.com/centos/7/os/x86_64/Packages/yum-plugin-fastestmirror-1.1.31-50.el7.noarch.rpm

ls

rpm -ivh python-libs-2.7.5-76.el7.x86_64.rpm

rpm -ivh python-2.7.5-76.el7.x86_64.rpm

rpm -ivh python-iniparse-0.4-9.el7.noarch.rpm

rpm -ivh python-pycurl-7.19.0-19.el7.x86_64.rpm

rpm -ivh rpm-python-4.11.3-35.el7.x86_64.rpm

rpm -ivh yum-metadata-parser-1.1.4-10.el7.x86_64.rpm


## 这2个相互依赖要一起安装
rpm -ivh yum-3.4.3-161.el7.centos.noarch.rpm yum-plugin-fastestmirror-1.1.31-50.el7.noarch.rpm
```

注意！！
如果出现python-urlgrabber-3.10-8.el7.noarch依赖问题

```
wget http://mirrors.163.com/centos/7/os/x86_64/Packages/python-urlgrabber-3.10-9.el7.noarch.rpm
rpm -ivh python-urlgrabber-3.10-9.el7.noarch.rpm
```


2.测试

```
yum
```


