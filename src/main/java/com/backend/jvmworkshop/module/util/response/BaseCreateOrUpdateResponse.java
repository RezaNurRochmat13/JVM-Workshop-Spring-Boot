package com.backend.jvmworkshop.module.util.response;

import lombok.Data;

@Data
public class BaseCreateOrUpdateResponse {
    private String messages;
    private Object resourceCreateOrUpdated;
}
