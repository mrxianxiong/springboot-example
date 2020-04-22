# springboot-example

## 1. springboot+redis实现布隆过滤器

### springboot-redis-bloom： 

#### docker部署redisbloom

```
下载镜像
docker pull redislabs/rebloom
```
```
启动
docker run -itd -p 6379:6379 --restart=always --name redis-redisbloom redislabs/rebloom:latest
```
```
查看运行的容器id
docker ps

进入容器
docker exec -it $containerId sh

redisclis:
redis-cli

新增一个bloom
BF.ADD newFilter foo
判断是否存在key
BF.EXISTS newFilter foo
```