package com.xiaohe.seatamqtwo;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@Slf4j
@SpringBootApplication()
@EnableDiscoveryClient
@EnableFeignClients({"com.xiaohe"})
//@EnableFeignClients(basePackages = {"com.xiaohe"},value = {"com.xiaohe"})
public class SeataMqTwoApplication {

    public static void main(String[] args) {
        log.info("seata-mq-two准备启动");
        SpringApplication.run(SeataMqTwoApplication.class, args);
    }

}
