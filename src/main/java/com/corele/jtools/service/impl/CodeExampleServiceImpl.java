package com.corele.jtools.service.impl;

import com.corele.jtools.mapper.CodeExampleMapper;
import com.corele.jtools.model.CodeExample;
import com.corele.jtools.service.CodeExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liujun
 */
@Service
public class CodeExampleServiceImpl implements CodeExampleService {

    @Autowired
    private CodeExampleMapper codeExampleMapper;

    @Override
    public boolean addExample(CodeExample codeExample) {
        int row = this.codeExampleMapper.insertSelective(codeExample);
        if (row <= 0){
            return false;
        }
        return true;
    }

    /**
     * 查询一个code
     *
     * @param id
     * @return
     */
    @Override
    public CodeExample getById(Integer id) {
        return this.codeExampleMapper.selectByPrimaryKey(id);
    }
}
