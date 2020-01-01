package com.corele.jtools.controller;


import com.corele.jtools.service.CodeExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liujun
 */
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private CodeExampleService codeExampleService;

    @CrossOrigin
    @GetMapping("test")
    public String test(){
        return "Hello tools";
    }
}
