package com.corele.jtools.dao.impl;

import com.corele.jtools.dao.CodeExampleDao;
import com.corele.jtools.model.CodeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

/**
 * @author corele
 */
@Service
public class CodeExampleDaoImpl implements CodeExampleDao {

    @Autowired
    private MongoTemplate mongoTemplate;


    /**
     * 获取一个代码片段
     *
     * @param codeName 代码标识
     * @return 代码实体
     */
    @Override
    public CodeExample getByCodeName(String codeName) {
        Query query = new Query(Criteria.where("codeName").is(codeName));
        CodeExample codeExample = this.mongoTemplate.findOne(query, CodeExample.class);
        return codeExample;
    }

    /**
     * 保存一个代码片段
     *
     * @param codeExample 代码片段
     */
    @Override
    public void saveCodeExample(CodeExample codeExample) {
        this.mongoTemplate.save(codeExample);
    }
}
