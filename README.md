## 简述
    customer是客户系统(即客户监测系统)，采用Dubbo服务治理
## 组织结构

``` lua
customer
├── customer-common -- 公共模块
|    ├── customer-common-pojo -- 系统领域模型相关(DO/BO/DTO/VO)
├── customer-dao -- 数据库操作层
|    ├── customer-dao-api -- dao层接口
|    ├── customer-dao-impl -- dao层实现
|    ├── customer-hbase-common -- hbase ORM分离出来的公共资源
|    ├── customer-hbase-orm -- hbase ORM框架
├── customer-server -- 服务层
|    ├── customer-server-api -- server层服务接口
|    ├── customer-server-impl -- server层实现
├── customer-web -- web接口层
```

## 技术选型
待添加...

## API文档
![API文档](http://img.blog.csdn.net/20170420095340652?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvYTQ2NjM1MDY2NQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
   