package com.test.spring.springbean.controller;

import com.test.spring.springbean.bean.PrototypeBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

//    @Autowired
//    private PrototypeBean prototypeBean;

    @GetMapping("/get")
    public String getName(){
        System.out.println(getPrototypeBean());
        return "hello";
    }

    @Lookup
    public PrototypeBean getPrototypeBean(){
        return null;
    }

}
