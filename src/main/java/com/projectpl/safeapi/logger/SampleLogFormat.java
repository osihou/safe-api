package com.projectpl.safeapi.logger;

import java.util.UUID;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor()
public @Data class SampleLogFormat {
    private String correlationId = UUID.randomUUID().toString();
    @NonNull
    private String message;
    @NonNull
    private Object payload;

    public SampleLogFormat(String muthu, String jsonPaylod) {
    }
}