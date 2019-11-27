#### 各个镜像版本
```
docker pull docker.elastic.co/elasticsearch/elasticsearch:6.6.2
docker pull docker.elastic.co/kibana/kibana:6.6.2
docker pull docker.elastic.co/beats/filebeat:6.6.2
docker pull docker.elastic.co/logstash/logstash:6.6.2
```

#### Elasticsearch 容器部署
新建文件夹/data/elk/elasticsearch

启动命令
```
docker run -d \
    --user root \
    -p 144.34.244.17:9200:9200 \
    -p 9300:9300 \
    -m 1024M \
    --cpus=0.4 \
    --log-driver json-file \
    --log-opt max-size=10m \
    --log-opt max-file=3 \
    --name elasticsearch \
    --restart=always \
    -e "discovery.type=single-node" \
    -v /data/elk/elasticsearch:/usr/share/elasticsearch/data \
    docker.elastic.co/elasticsearch/elasticsearch:6.6.2
```

测试：curl -XGET 144.34.244.17:9200

#### Logstash 容器部署
配置文件 /data/elk/config/logstash.conf

```
input {
        beats {
                port => "5043"
        }
}
filter {
        json {
            source => "message"
            remove_field => ["message","beat","offset","host","prospector","tags"]
        }
        grok {
                match => {
                        "log" => "%{TIMESTAMP_ISO8601:logdate}\s+%{LOGLEVEL:level}\s+\[(?<appname>(?<=\[)[^,]+)"
                }
        }
        date {
                match => [ "logdate" , "yyyy-MM-dd HH:mm:sss","ISO8601" ]
                target => "@timestamp"
        }
        ruby {
                code => "event.set('timestamp', event.get('@timestamp').time.localtime + 0*60*60)"
        }
        ruby {
                code => "event.set('@timestamp',event.get('timestamp'))"
        }
        mutate {
                remove_field => ["timestamp"]
        }
}
output {
        if[log]=~/^(\d{4}-\d{2}-\d{2}) (\d{2}:\d{2}:\d{2})/{
           elasticsearch {
                hosts => ["http://144.34.244.17:9200"]
                index => "%{appname}-%{+YYYY.MM.dd}"
           }
        }
        stdout {
                codec => rubydebug
        }
}

```
配置说明：

1.采用filebeat配合

2.采集的docker的容器日志，json格式为{"log":"","stream":"","time":""}，log的key中以类似2019-11-27 16:37:02.389这样的时间开头

启动命令

```
docker run -p 5043:5043 -d \
    --user root \
    -m 1024M \
    --cpus=0.4 \
    --log-driver json-file \
    --log-opt max-size=10m \
    --log-opt max-file=3 \
    --name logstash \
    --restart=always \
    --link elasticsearch \
    -v /data/elk/config/logstash.conf:/usr/share/logstash/pipeline/logstash.conf \
    docker.elastic.co/logstash/logstash:6.6.2
```
#### Kibana容器部署
配置文件 /data/elk/config/kibana.yml

```
server.port: 5601
server.host: "0.0.0.0"
server.name: "0.0.0.0"
elasticsearch.hosts: [
        "http://144.34.244.17:9200"
]
elasticsearch.preserveHost: true
kibana.index: ".kibana"
elasticsearch.pingTimeout: 1500
elasticsearch.requestTimeout: 30000
ops.interval: 5000
i18n.locale: "zh-CN"
```
启动命令

```
docker run -p 5601:5601 -d \
    -m 1024M \
    --cpus=0.4 \
    --user root \
    --log-driver json-file \
    --log-opt max-size=10m \
    --log-opt max-file=3 \
    --name kibana \
    --link elasticsearch \
    --restart=always \
    -e ELASTICSEARCH_URL=http://144.34.244.17:9200 \
    -v /data/elk/config/kibana.yml:/usr/share/kibana/config/kibana.yml \
    docker.elastic.co/kibana/kibana:6.6.2
```

#### Filebeat 容器部署
配置文件 /data/elk/config/filebeat.yml

```
filebeat.inputs:
- type: log
  paths:
   - '/var/lib/docker/containers/1001/*.log'

output.logstash: # 输出地址
  hosts: ["144.34.244.17:5043"]

```
启动命令

```
docker run -d \
    -m 200M \
    --cpus=0.2 \
    --name filebeat \
    --user root \
    --log-driver json-file \
    --log-opt max-size=10m \
    --log-opt max-file=3 \
    --restart=always \
    -v /data/elk/config/filebeat.yml:/usr/share/filebeat/filebeat.yml:ro \
    -v /var/lib/docker/containers/:/var/lib/docker/containers/ \
    -v /var/run/docker.sock:/var/run/docker.sock:ro \
    docker.elastic.co/beats/filebeat:6.6.2
```

#### 注意：

1.docker容器日志路径 /var/lib/docker/contains下

2.如果机器配置不是太好，注意内存分配问题

```
cd /var/lib/docker/overlay2
find -name jvm.options
修改列出的所有文件中的jvm参数
-Xms512m
-Xmx512m
```
3.目前的配置文件只针对docker容器中的日志，未解决错误换行多行合并问题（待解决），可采用Filebeat multiline 或者 logstash-filter-multiline插件

4.logstash可收集mq的日志（由业务项目统一log4j配置将日志输出到mq），最佳方案！！！，对应配置如下：

```
input{
    rabbitmq{
        type=>"prod"
        durable=>true 
        exchange=>"logs"
        exchange_type=>"topic"
        key=>"logs"
        host=>"xxxxxxx"
        port=>5672 
        user=>"root"
        password=>"xxxxxx"
        queue=>"logs"
        auto_delete=>false
    }
}
```



