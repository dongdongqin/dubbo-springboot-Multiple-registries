package com.example.comtroller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.dubbo.provider.Demo1Service;
import com.example.dubbo.provider.DemoService;
import com.example.dubbo.provider.model.Stu;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class DemoConsumerController {


    @Reference(registry = {"registry2"}, version = "1.0.0", cluster = "broadcast")
    private DemoService demoService;


    @RequestMapping("/test1")
    public Stu sayHello1(@RequestParam int age, String name) {
        Stu stu = demoService.sayHello1(Stu.builder().age(age).name(name).build());
        return stu;
    }

}