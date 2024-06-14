package com.self.ace.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class ErrorResponseDto {

    private final Long timestamp;

    private String errorCode;

    private String message;

    private String[] debugMessage;

    private List<?> errorMessages;

    private Map<?, ?> data;

    public ErrorResponseDto() {
        timestamp = Instant.now().getEpochSecond();
    }

    public void setData(Map<?, ?> data) {
        this.data =data;
    }
}
