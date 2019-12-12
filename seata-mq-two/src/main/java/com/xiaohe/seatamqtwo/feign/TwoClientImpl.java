package com.xiaohe.seatamqtwo.feign;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TwoClientImpl implements TwoClient{


    @Override
    public String twoSayHello(String name) {
        return "hello,"+name+"! this is two client. ";
    }
}
