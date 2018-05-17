package com.study.zhaoqingfrank.controller;



import com.study.zhaoqingfrank.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.cloud.client.ServiceInstance;

import java.util.logging.Logger;

@RestController
public class HelloController {
    private  final Logger logger=Logger.getLogger(String.valueOf(HelloController.class));

    @Autowired
    private DiscoveryClient client;


    @RequestMapping(value = "/hello",method= RequestMethod.GET)
    public String index(@RequestParam(value = "name",required = false) String name){
      ServiceInstance instance=client.getLocalServiceInstance();
      logger.info(instance.getHost());
       return "hello world"+name;

    }
    @RequestMapping(value = "/hello1",method=RequestMethod.GET)
    public String hello1(@RequestParam String name){
        return "name:"+name;

    }
    @RequestMapping(value = "/hello2",method=RequestMethod.GET)
    public String hello2(@RequestHeader  String name, @RequestParam Integer age){
        return "name:"+name+","+"age:"+age;

    }

    @RequestMapping(value = "/hello3",method=RequestMethod.POST)
    public String hello3(@RequestBody User user){
        return "name:"+user.getName()+",age:"+user.getAge();

    }
/*
    @RequestMapping(value = "/hello1",method= RequestMethod.GET)
    public String index1(){
        ServiceInstance instance=client.getLocalServiceInstance();
        logger.info(instance.getHost());
        return "hello world";

    }*/

}
