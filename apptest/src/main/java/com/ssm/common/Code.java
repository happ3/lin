package com.ssm.common;

import java.util.HashMap;
import java.util.Map;

import com.ssm.exception.BaseException;

public enum Code {
	OK(200, "SUCCESS"),
    WARING_MSG(201, "WARING"),
    REDIRECT(301, "REDIRECT"),
    ERROR(500, "ERROR");

    public final int code;
    public final String name;
    private static final Map<Integer, Code> valueMap;

    private Code(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static Code valueOf(int code) {
        Code err = (Code)valueMap.get(Integer.valueOf(code));
        if(err != null) {
            return err;
        } else {
            throw new BaseException("不存在code=" + code + "的NPConfigError错误");
        }
    }

    static {
        valueMap = new HashMap<Integer, Code>();
        Code[] var0 = values();
        int var1 = var0.length;

        for(int var2 = 0; var2 < var1; ++var2) {
            Code err = var0[var2];
            if(valueMap.put(Integer.valueOf(err.code), err) != null) {
                throw new BaseException("Warnning! Code 重复定义的值, code=" + err.code);
            }
        }

    }
}
