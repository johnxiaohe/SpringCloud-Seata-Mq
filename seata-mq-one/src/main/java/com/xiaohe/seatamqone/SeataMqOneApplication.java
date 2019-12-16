package com.xiaohe.seatamqone;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Properties;

@Slf4j
@SpringBootApplication()
@EnableDiscoveryClient
@EnableFeignClients({"com.xiaohe"})
//@EnableFeignClients(basePackages = {"com.xiaohe"},value = {"com.xiaohe"})
public class SeataMqOneApplication {

    public static void main(String[] args) {
        log.info("seata-mq-one准备启动");
        SpringApplication.run(SeataMqOneApplication.class, args);
//        Properties prop = System.getProperties();
//        prop.setProperty("spring.profiles.active","test");
//        log.info("加载testinfo");
    }



}
