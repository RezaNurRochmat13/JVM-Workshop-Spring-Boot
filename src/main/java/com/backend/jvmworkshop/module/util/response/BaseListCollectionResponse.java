package com.backend.jvmworkshop.module.util.response;

import lombok.Data;

@Data
public class BaseListCollectionResponse {
    private Long total;
    private Integer count;
    private Object result;
}
