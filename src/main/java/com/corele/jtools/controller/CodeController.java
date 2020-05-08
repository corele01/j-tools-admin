package com.corele.jtools.controller;

import com.corele.jtools.common.BaseResponse;
import com.corele.jtools.dto.AddExampleDTO;
import com.corele.jtools.service.CodeExampleService;
import com.corele.jtools.service.CodeService;
import com.corele.jtools.vo.CodeExampleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author liujun
 */
@RequestMapping("code")
@RestController
@CrossOrigin(allowCredentials = "true",allowedHeaders = {"*"},origins = {"*"},methods = {RequestMethod.POST,RequestMethod.GET})
public class CodeController {

    @Autowired
    private CodeService codeService;

    /**
     * 添加code
     * @param addExampleDTO
     * @return
     */
    @PostMapping("addExample")
    public BaseResponse addExample(@RequestBody AddExampleDTO addExampleDTO){
        boolean flag = this.codeService.addExample(addExampleDTO);
        if (flag){
            return BaseResponse.success();
        }
        return BaseResponse.fail();
    }

    /**
     * 获取一个code
     * @param codeName
     * @return
     */
    @GetMapping("example/{codeName}")
    public BaseResponse<CodeExampleVO> getExample(@PathVariable String codeName){
        CodeExampleVO res = this.codeService.getById(codeName);
        return BaseResponse.success(res);
    }
}
