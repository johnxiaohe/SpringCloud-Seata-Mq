package com.xiaohe.seatamqtwo.feign;

import org.springframework.stereotype.Component;

@Component
public class TwoClientFallback implements TwoClient{

    @Override
    public String twoSayHello(String name) {
        return "connection fail";
    }
}
