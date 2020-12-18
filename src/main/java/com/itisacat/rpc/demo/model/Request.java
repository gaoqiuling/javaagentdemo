package com.itisacat.rpc.demo.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Request implements Serializable {
    private String className;
    private String methodName;
    private Class<?> [] parameTypes;
    private Object [] parameters;
}
