package com.xiaohe.seatamqtwo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        value="seata-mq-two"
//        fallback = TwoClientFallback.class
)
public interface TwoClient {

    @GetMapping("/twoSayHello")
    String twoSayHello(@RequestParam String name);
}
