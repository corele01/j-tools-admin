package com.corele.jtools.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * @author liujun
 */
@Getter
@Setter
@Document("code-example")
@CompoundIndexes({
        @CompoundIndex(unique = true,name = "idx_codeName",def ="{codeName:1}" )
})
public class CodeExample {

    private ObjectId id;
    private String codeName;
    private Integer codeType;
    private String codeExample;
    private LocalDateTime gmtCreate;
    private LocalDateTime gmtModify;
}
