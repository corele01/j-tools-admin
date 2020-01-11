package com.corele.jtools.service;

import com.corele.jtools.dto.AddExampleDTO;
import com.corele.jtools.model.CodeExample;
import com.corele.jtools.vo.CodeExampleVO;

/**
 * @author liujun
 */
public interface CodeExampleService {

    /**
     * 添加一个实例
     * @param codeExample object
     * @return boolean
     */
    boolean addExample(CodeExample codeExample);

    /**
     * 查询一个code
     * @param id id
     * @return object
     */
    CodeExample getById(Integer id);
}
