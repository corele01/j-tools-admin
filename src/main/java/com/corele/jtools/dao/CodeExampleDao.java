package com.corele.jtools.dao;

import com.corele.jtools.model.CodeExample;

/**
 * @author corele
 */
public interface CodeExampleDao {

    /**
     * 获取一个代码片段
     * @param codeName 代码标识
     * @return 代码实体
     */
    CodeExample getByCodeName(String codeName);

    /**
     * 保存一个代码片段
     * @param codeExample 代码片段
     */
    void saveCodeExample(CodeExample codeExample);
}
