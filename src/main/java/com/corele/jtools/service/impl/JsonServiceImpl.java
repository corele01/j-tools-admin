package com.corele.jtools.service.impl;

import com.corele.jtools.service.JsonService;
import com.corele.jtools.utils.JsonFormat;
import org.springframework.stereotype.Service;

/**
 * @author liujun
 */
@Service
public class JsonServiceImpl implements JsonService {
    /**
     * 格式化json
     *
     * @param string
     * @return
     */
    @Override
    public String formatJson(String string) {
        JsonFormat jsonFormat = new JsonFormat(string);
        return jsonFormat.format();
    }
}
