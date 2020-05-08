package com.corele.jtools.dao;

import com.corele.jtools.model.CodeExample;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class CodeExampleDaoTest {

    @Autowired
    private CodeExampleDao codeExampleDao;

    @Test
    void test(){
        CodeExample codeExample = new CodeExample();
        this.codeExampleDao.saveCodeExample(codeExample);
    }
}