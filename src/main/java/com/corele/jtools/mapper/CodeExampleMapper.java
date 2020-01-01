package com.corele.jtools.mapper;

import com.corele.jtools.model.CodeExample;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author liujun
 */
@Component
@org.apache.ibatis.annotations.Mapper
public interface CodeExampleMapper extends Mapper<CodeExample> {
}
