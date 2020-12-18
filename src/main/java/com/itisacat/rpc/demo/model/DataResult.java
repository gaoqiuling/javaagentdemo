package com.itisacat.rpc.demo.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class DataResult implements Serializable {
    private Object data;
    private int status;
    private String message;
}
