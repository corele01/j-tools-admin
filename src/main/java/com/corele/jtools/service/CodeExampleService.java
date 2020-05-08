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
     * @param codeExample 片段实例
     * @return 是否成功
     */
    boolean addExample(CodeExample codeExample);

    /**
     * 查询一个code
     * @param codeName 片段标识
     * @return 代码片段
     */
    CodeExample getByCodeName(String codeName);
}
