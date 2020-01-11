package com.corele.jtools.controller;

import com.corele.jtools.common.BaseResponse;
import com.corele.jtools.service.JsonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liujun
 */
@RestController
@RequestMapping("json")
public class JsonController {

    private JsonService jsonService;

    @Autowired
    public void setJsonService(JsonService jsonService){
        this.jsonService = jsonService;
    }

    @GetMapping("format")
    public BaseResponse<String> format(String json){
        String res = this.jsonService.formatJson(json);
        return BaseResponse.success(res);
    }
}
