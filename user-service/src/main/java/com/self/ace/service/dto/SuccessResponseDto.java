package com.self.ace.service.dto;


public class SuccessResponseDto<I> {

    private String successCode;

    private String responseMessage;

    /**
     * @return the successCode
     */
    public String getSuccessCode() {
        return successCode;
    }

    /**
     * @param successCode the successCode to set
     */
    public void setSuccessCode(String successCode) {
        this.successCode = successCode;
    }

    /**
     * @return the responseMessage
     */
    public String getResponseMessage() {
        return responseMessage;
    }

    /**
     * @param responseMessage the responseMessage to set
     */
    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

}