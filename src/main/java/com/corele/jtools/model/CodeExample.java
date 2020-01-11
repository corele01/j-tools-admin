package com.corele.jtools.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author liujun
 */
@Data
public class CodeExample {

    @Id
    private Integer id;
    private Integer codeType;
    private String codeExample;
    private LocalDateTime gmtCreate;
    private LocalDateTime gmtModify;
}
