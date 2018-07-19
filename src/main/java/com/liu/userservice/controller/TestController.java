package com.liu.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/7/12.
 */
@RestController
public class TestController {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @RequestMapping(value="/userservice/api")
    public String goUploadImg() {
        System.out.println("userservice2");
        return "userservice2";
    }

    @PostMapping(value="/send")
    public String send(String name) {

        kafkaTemplate.send("TextLinesTopic",name);
        return "succeed";
    }


}
