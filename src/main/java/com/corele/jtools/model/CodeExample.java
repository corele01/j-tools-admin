package com.corele.jtools.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author liujun
 */
@Data
@Entity
public class CodeExample {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    private Integer codeType;
    @Column(columnDefinition = "longtext")
    private String codeExample;
    @Column(columnDefinition = "timestamp")
    private LocalDateTime gmtCreate;
    @Column(columnDefinition = "timestamp")
    private LocalDateTime gmtModify;
}
