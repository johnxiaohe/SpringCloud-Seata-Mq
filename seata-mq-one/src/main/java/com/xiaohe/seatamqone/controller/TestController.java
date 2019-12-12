package com.xiaohe.seatamqone.controller;

import com.xiaohe.seatamqtwo.feign.TwoClient;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
public class TestController {

    @Autowired
    private TwoClient twoClient;
    @Value("${test.msg:aYouMeiNaDao}")
    private String username;

    @GetMapping("/getMsg")
    public String getMsg(){
        System.out.println("msg内容是: "+username);
        return username;
    }

    @GetMapping("/twoSayHello")
    public String twoSayHello(@RequestParam String name){
        return twoClient.twoSayHello(name);
    }
}
