package com.example.comtroller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.example.dubbo.provider.DemoService;
import com.example.dubbo.provider.model.Stu;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class DemoConsumerController2 {


    @Reference(registry = {"registry1"}, version = "1.0.0", cluster = "broadcast")
    private DemoService demo2Service;


    @RequestMapping("/test2")
    public String sayHello2(@RequestParam int age, String name) {
        String stu = demo2Service.sayHello(name);
        return stu;
    }
}

