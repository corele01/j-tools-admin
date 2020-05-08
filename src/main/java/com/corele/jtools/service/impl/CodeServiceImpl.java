package com.corele.jtools.service.impl;

import com.corele.jtools.dto.AddExampleDTO;
import com.corele.jtools.model.CodeExample;
import com.corele.jtools.service.CodeExampleService;
import com.corele.jtools.service.CodeService;
import com.corele.jtools.vo.CodeExampleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author liujun
 */
@Service
public class CodeServiceImpl implements CodeService {

    @Autowired
    private CodeExampleService codeExampleService;

    /**
     * 获取一个code
     *
     * @param codeName
     * @return
     */
    @Override
    public CodeExampleVO getById(String codeName) {
        CodeExample codeExample = this.codeExampleService.getByCodeName(codeName);
        if (codeExample == null){
            return null;
        }
        CodeExampleVO result = new CodeExampleVO();
        result.setId(codeExample.getId());
        result.setCodeType(codeExample.getCodeType());
        result.setCodeExample(codeExample.getCodeExample());
        return result;
    }

    /**
     * 添加一个code
     *
     * @param codeExample
     * @return
     */
    @Override
    public boolean addExample(AddExampleDTO codeExample) {
        CodeExample addCode = new CodeExample();
        addCode.setCodeType(codeExample.getCodeType());
        addCode.setCodeExample(codeExample.getCodeExample());
        addCode.setGmtCreate(LocalDateTime.now());
        return this.codeExampleService.addExample(addCode);
    }
}
