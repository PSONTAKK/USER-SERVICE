package com.self.ace.service.dto;


public class ResponseDto {

    private SuccessResponseDto<?> success;

    private ErrorResponseDto error;

    /**
     * @return the success
     */
    public SuccessResponseDto<?> getSuccess() {
        return success;
    }

    /**
     * @param success the success to set
     */
    public void setSuccess(SuccessResponseDto<?> success) {
        this.success = success;
    }

    /**
     * @return the error
     */
    public ErrorResponseDto getError() {
        return error;
    }

    /**
     * @param error the error to set
     */
    public void setError(ErrorResponseDto error) {
        this.error = error;
    }
}