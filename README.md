# SpringCloud微服务技术整合练习

## Nacos整合
1. 依赖部分  
> a. 暂时不支持SpringBoot2.2以上版本  
> b. 依赖spring-cloud-dependencies、spring-cloud-alibaba-dependencies  
> c. spring-cloud-starter-alibaba-nacos-config配置中心依赖  
> d. spring-cloud-starter-alibaba-nacos-discovery服务注册发现依赖
2. 配置部分
> a. 需要添加对应的bootstrap.properties配置文件(具体内容看文件注释)  
> b. 服务发现需要在application.yml中添加服务发现地址配置spring.cloud.nacos.discovery.server-addr  
3. 代码部分
> a. Application启动类中加入@EnableDiscoveryClient注解启用服务发现  
> b. @Value("${test.msg:aYouMeiNaDao}")获取配置

## Feign整合
1. 依赖部分
> a. spring-cloud-starter-openfeign
2. 配置部分
> a. feign.hystrix.enabled 熔断开启关闭
3. 代码部分
> a. @EnableFeignClients(basePackages = {"com.xiaohe"},value = {"com.xiaohe"}) 启用Feign,并声明扫描包  
> b. @FeignClient(value="seata-mq-two",fallback = TwoClientFallback.class) feign对外远程接口声明注解,对应实现类加@controller注解,熔断类加@Component注解

## Druid连接池整合
1.依赖`这里尽量不要用.13以下的连接池版本，会报找不到RelaxedDataBinder类的错误`
```text
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-jdbc</artifactId>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid-spring-boot-starter</artifactId>
            <version>1.1.13</version>
        </dependency>
```
2.配置`因为Druid只是起到连接池的作用，所以连接的操作还是交给连接的依赖所以这里配置不需要加druid`
```text
spring:
    datasource:
        url: jdbc:mysql://127.0.0.1:3306/seata_mq_test
        username: rool
        password: rool
        # 使用druid数据源
        type: com.alibaba.druid.pool.DruidDataSource
        driver-class-name: com.mysql.cj.jdbc.Driver
        filters: stat
        maxActive: 20
        initialSize: 1
        maxWait: 60000
        minIdle: 1
        timeBetweenEvictionRunsMillis: 60000
        minEvictableIdleTimeMillis: 300000
        validationQuery: select 'x'
        testWhileIdle: true
        testOnBorrow: false
        testOnReturn: false
        poolPreparedStatements: true
        maxOpenPreparedStatements: 20
```

## mybatis整合
1.依赖
```text
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>1.3.0</version>
        </dependency>
```
2.配置
```text
    # MyBatis注解形式扫描实体类路径或者启动类@MapperScan("com.xiaohe.*.mapper")
    mybatis.type-aliases-package=com.xiaohe.*.mapper
    # MyBatis 的mapper映射路径 不设置默认和mapper接口一个包下。这里表示在resources/mybatis/mapper下的xml文件
    mybatis.mapper-locations=classpath:mybatis/mapper/*.xml
```
3.使用
> 1. 接口和XML文件以Mapper结尾，尽量两个名称相同。接口上方增加@Mapper注解

