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

