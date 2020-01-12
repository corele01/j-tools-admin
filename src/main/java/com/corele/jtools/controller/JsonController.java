package com.corele.jtools.controller;

import com.corele.jtools.common.BaseResponse;
import com.corele.jtools.service.JsonService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @author liujun
 */
@RestController
@RequestMapping("json")
@CrossOrigin(allowCredentials = "true",allowedHeaders = {"*"},origins = {"*"},methods = {RequestMethod.POST,RequestMethod.GET})
public class JsonController {

    private JsonService jsonService;

    @Autowired
    public void setJsonService(JsonService jsonService){
        this.jsonService = jsonService;
    }

    @SneakyThrows
    @GetMapping("format")
    public BaseResponse<String> format(String json){
        json = URLDecoder.decode(json,"UTF-8");
        String res = this.jsonService.formatJson(json);
        return BaseResponse.success(res);
    }
}
