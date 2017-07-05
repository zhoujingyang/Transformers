package com.platform.controller;

import com.platform.model.TestDemo;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/demo")
public class Demo {

    @Autowired
    private Datastore dataStore;

    @RequestMapping(value = ("get"), method = RequestMethod.GET)
    public String getDemo(){

        return "hello spring boot";
    }

    @RequestMapping(value = "/post",method = RequestMethod.POST)
    public String postDemo(@RequestBody String str){
        String result = "你输入的数据是 : " + str;
        return  result;
    }

    @RequestMapping(value = "mongo", method = RequestMethod.GET)
    public String testMongoGet(){

        TestDemo demo =  dataStore.find(TestDemo.class).get();
        return demo.getName();
    }

}

