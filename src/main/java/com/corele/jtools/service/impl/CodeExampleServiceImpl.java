package com.corele.jtools.service.impl;

import com.corele.jtools.dao.CodeExampleDao;
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
    private CodeExampleDao codeExampleDao;

    @Override
    public boolean addExample(CodeExample codeExample) {
        this.codeExampleDao.saveCodeExample(codeExample);
        return true;
    }

    /**
     * 查询一个code
     *
     * @param codeName 片段标识
     * @return 代码片段
     */
    @Override
    public CodeExample getByCodeName(String codeName) {
        return this.codeExampleDao.getByCodeName(codeName);
    }
}
