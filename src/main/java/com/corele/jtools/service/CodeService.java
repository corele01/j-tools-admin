package com.corele.jtools.service;

import com.corele.jtools.dto.AddExampleDTO;
import com.corele.jtools.model.CodeExample;
import com.corele.jtools.vo.CodeExampleVO;

/**
 * @author liujun
 */
public interface CodeService {

    /**
     * 获取一个code
     * @param codeName 标识
     * @return
     */
    CodeExampleVO getById(String codeName);

    /**
     * 添加一个code
     * @param addExampleDTO
     * @return
     */
    boolean addExample(AddExampleDTO addExampleDTO);
}
