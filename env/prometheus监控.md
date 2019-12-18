## 什么是Prometheus?
Prometheus是由SoundCloud开发的开源监控报警系统和时序列数据库(TSDB)。Prometheus使用Go语言开发，是Google BorgMon监控系统的开源版本。


#### Prometheus的特点
- 多维度数据模型。
- 灵活的查询语言。
- 不依赖分布式存储，单个服务器节点是自主的。
- 通过基于HTTP的pull方式采集时序数据。
- 可以通过中间网关进行时序列数据推送。
- 通过服务发现或者静态配置来发现目标服务对象。
- 支持多种多样的图表和界面展示，比如Grafana等。


#### 下面主要搭建一下简化版本的环境，一些简单的功能，复杂的后续再补充吧

## 通过node exporter提供metrics
Node exporter 主要用于暴露主机节点metrics 给 Prometheus，其中 metrics 包括：cpu 的负载，内存的使用情况，网络等。


```
docker run -d \
--name=node-exporter \
-p 9100:9100 \
prom/node-exporter
```
## 通过cadvisor提供metrics
cadvisor,主要用于暴露docker容器内的 metrics 给 Prometheus，其中 metrics 包括：cpu 的负载，内存的使用情况，网络等。

```
docker run \
--volume=/:/rootfs:ro \
--volume=/var/run:/var/run:rw \
--privileged=true \
--volume=/sys:/sys:ro \
--volume=/var/lib/docker/:/var/lib/docker:ro \
--publish=9101:8080 \
--detach=true \
--name=cadvisor \
google/cadvisor:v0.24.1
```

==注意== ==注意== ==注意==

##### 在执行以上命令后，用命令docker logs -f cadvisor 查看容器日志，如果发现以下错误（坑）：
Version: {KernelVersion:3.10.0-693.el7.x86_64 ContainerOsVersion:Alpine Linux v3.4 DockerVersion:Unknown DockerAPIVersion:Unknown

##### 换成版本为google/cadvisor:v0.24.1 就ok了


## 安装Prometheus Server

##### 通过docker方式
首先创建一个配置文件prometheus.yml


挂载之前需要改变文件权限为777，要不会引起修改宿主机上的文件内容不同步的问题

```
global:
  scrape_interval: 10s
  scrape_timeout: 10s
  evaluation_interval: 10s
scrape_configs:
- job_name: prometheus
  honor_timestamps: true
  scrape_interval: 10s
  scrape_timeout: 10s
  metrics_path: /metrics
  scheme: http
  static_configs:
  - targets:
    - 你的ip:9090
- job_name: linux-node-exporter
  honor_timestamps: true
  scrape_interval: 10s
  scrape_timeout: 10s
  metrics_path: /metrics
  scheme: http
  static_configs:
  - targets:
    - 你的ip:9100
- job_name: docker-cadvisor
  honor_timestamps: true
  scrape_interval: 10s
  scrape_timeout: 10s
  metrics_path: /metrics
  scheme: http
  static_configs:
  - targets:
    - 你的ip:9101
```
运行

```
docker run --name=prometheus -d \
    -p 9090:9090 \
    -v /你的路径/prometheus.yml:/etc/prometheus/prometheus.yml \
    -v /你的路径/rules.yml:/etc/prometheus/rules.yml \
    prom/prometheus:v2.9.2 \
    --config.file=/etc/prometheus/prometheus.yml \
    --web.enable-lifecycle
```
启动时加上--web.enable-lifecycle启用远程热加载配置文件
调用指令是curl -X POST http://localhost:9090/-/reload


访问http://你的ip:9090

访问http://你的ip:9090/metrics


最后可以跑个Grafana来展示，超级炫酷，这里就不介绍了。




### **************************  分割线  *********************************

#### swirl结合Prometheus的配置

````
{
  "name": "cpu",
  "title": "CPU使用率",
  "desc": "当前节点CPU使用率",
  "metrics": [
    {
      "legend": "${name}",
      "query": "AVG(irate(node_cpu_seconds_total{mode=\"user\"}[1m]))*100+AVG(irate(node_cpu_seconds_total{mode=\"system\"}[1m]))*100"
    }
  ],
  "kind": "",
  "dashboard": "home",
  "type": "gauge",
  "unit": "percent:100",
  "width": 2,
  "height": 200,
  "options": {}
}
````
````
{
  "name": "memory",
  "title": "内存占用",
  "desc": "服务器内存使用",
  "metrics": [
    {
      "legend": "${instance}",
      "query": "node_memory_MemTotal_bytes-node_memory_MemAvailable_bytes"
    }
  ],
  "kind": "",
  "dashboard": "home",
  "type": "line",
  "unit": "size:bytes",
  "width": 4,
  "height": 200,
  "options": {}
}
````
````
{
  "name": "memory-use",
  "title": "内存使用率",
  "desc": "当前节点内存使用率",
  "metrics": [
    {
      "legend": "${instance}",
      "query": "(SUM(node_memory_MemTotal_bytes)-SUM(node_memory_MemAvailable_bytes))/SUM(node_memory_MemTotal_bytes)*100"
    }
  ],
  "kind": "",
  "dashboard": "home",
  "type": "gauge",
  "unit": "percent:100",
  "width": 2,
  "height": 200,
  "options": {}
}
````
````
{
  "name": "node_load1",
  "title": "服务器负载",
  "desc": "服务器最近一分钟的负载",
  "metrics": [
    {
      "legend": "${instance}",
      "query": "node_load1"
    }
  ],
  "kind": "",
  "dashboard": "home",
  "type": "line",
  "unit": "",
  "width": 4,
  "height": 200,
  "options": {}
}
````
````
{
  "name": "container_memory_total",
  "title": "Total memory usage",
  "desc": "Total memory usage of all containers",
  "metrics": [
    {
      "legend": "${host_name}",
      "query": "sum(container_memory_usage_bytes{image!=\"\"}) by(host_name)"
    }
  ],
  "kind": "",
  "dashboard": "home",
  "type": "pie",
  "unit": "size:bytes",
  "width": 3,
  "height": 200,
  "options": {}
}
````
配置好上述的图表之后，再在设置里面配置好Prometheus address
地址