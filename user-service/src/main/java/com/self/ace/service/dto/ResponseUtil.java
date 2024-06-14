package com.self.ace.service.dto;

import com.self.ace.contstant.ErrorDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class ResponseUtil<I> {

    private static final String ERROR_LOG_MSG = "Populating error response...";
    private static final String SUCCESS_LOG_MSG = "Populating success response";
    /**
     * Populate Error Response json
     *
     * @param httpStatus
     * @param errorMessage
     * @return
     */
    public static ResponseEntity<ResponseDto> populateErrorResponseDomain(HttpStatus httpStatus,
                                                                          String errorMessage) {

        log.info(ERROR_LOG_MSG);
        ResponseDto responseDto = new ResponseDto();
        ErrorResponseDto errorObject = new ErrorResponseDto();
        errorObject.setMessage(errorMessage);
        responseDto.setError(errorObject);
        return new ResponseEntity<>(responseDto, httpStatus);
    }

    /**
     * Populate Error Response json
     *
     * @param httpStatus
     * @param errorMessages
     * @return
     */
    public static ResponseEntity<ResponseDto> populateErrorResponseDomainWithErrorList(HttpStatus httpStatus,
                                                                                       List<String> errorMessages) {
        log.info(ERROR_LOG_MSG);
        ResponseDto responseDto = new ResponseDto();
        ErrorResponseDto errorObject = new ErrorResponseDto();
        errorObject.setErrorMessages(errorMessages);
        responseDto.setError(errorObject);
        return new ResponseEntity<>(responseDto, httpStatus);
    }

    public static ResponseEntity<ResponseDto> populateErrorResponseDomainWithErrorMessages(
            String message, int status, List<String> errorMessages,  String errorCode) {
        log.info(ERROR_LOG_MSG);
        ResponseDto responseDto = new ResponseDto();
        ErrorResponseDto errorObject = new ErrorResponseDto();
        errorObject.setErrorCode(errorCode);
        errorObject.setMessage(message);
        errorObject.setErrorMessages(errorMessages);
        responseDto.setError(errorObject);

        return new ResponseEntity<>(responseDto, HttpStatus.valueOf(status));
    }

    /**
     * Populate Error Response json
     *
     * @param httpStatus
     * @param errorMessages
     * @return
     */
    public static ResponseEntity<ResponseDto> populateErrorResponseDomainWithErrorList(HttpStatus httpStatus,
                                                                                       List<String> errorMessages, ErrorDetails error) {
        log.info(ERROR_LOG_MSG);
        ResponseDto responseDto = new ResponseDto();
        ErrorResponseDto errorObject = new ErrorResponseDto();
        errorObject.setMessage(error.getErrorDescription());
        errorObject.setErrorMessages(errorMessages);
        errorObject.setErrorCode(CommonUtils.getServiceErrorCode(error.getErrorCode()));
        responseDto.setError(errorObject);
        return new ResponseEntity<>(responseDto, httpStatus);
    }

    /**
     * Populate Error Response json
     *
     * @param httpStatus
     * @param errorMessages
     * @return
     */
    public static ResponseEntity<Object> populateErrorResponseDomainAsObjectWithErrorList(HttpStatus httpStatus,
                                                                                          List<?> errorMessages, ErrorDetails error) {
        log.info(ERROR_LOG_MSG);
        ResponseDto responseDto = new ResponseDto();
        ErrorResponseDto errorObject = new ErrorResponseDto();
        errorObject.setMessage(error.getErrorDescription());
        errorObject.setErrorMessages(errorMessages);
        errorObject.setErrorCode(CommonUtils.getServiceErrorCode(error.getErrorCode()));
        responseDto.setError(errorObject);
        return new ResponseEntity<>(responseDto, httpStatus);
    }

    /**
     * Populate error response
     *
     * @param httpStatus
     * @param error
     * @return
     */
    public static ResponseEntity<ResponseDto> populateErrorResponseDomain(HttpStatus httpStatus,
                                                                          ErrorDetails error) {
        log.info(ERROR_LOG_MSG);
        ResponseDto responseDto = new ResponseDto();
        ErrorResponseDto errorObject = new ErrorResponseDto();
        errorObject.setMessage(error.getErrorDescription());
        errorObject.setErrorCode(CommonUtils.getServiceErrorCode(error.getErrorCode()));
        responseDto.setError(errorObject);
        return new ResponseEntity<>(responseDto, httpStatus);
    }

    /**
     * Populate error response
     *
     * @param httpStatus
     * @param error
     * @return
     */
    public static ResponseEntity<Object> populateErrorResponseDomainAsObject(HttpStatus httpStatus,
                                                                             ErrorDetails error) {
        log.info(ERROR_LOG_MSG);
        ResponseDto responseDto = new ResponseDto();
        ErrorResponseDto errorObject = new ErrorResponseDto();
        errorObject.setMessage(error.getErrorDescription());
        errorObject.setErrorCode(CommonUtils.getServiceErrorCode(error.getErrorCode()));
        responseDto.setError(errorObject);
        return new ResponseEntity<>(responseDto, httpStatus);
    }

    /**
     * @param error
     * @param data
     * @return
     */
    public static ResponseEntity<Object> populateErrorResponseDomain(ErrorDetails error,
                                                                     List<ErrorMessageDto> errorMessageList) {
        log.info(ERROR_LOG_MSG);
        ResponseDto responseDto = new ResponseDto();
        ErrorResponseDto errorObject = new ErrorResponseDto();
        errorObject.setMessage(error.getErrorDescription());
        errorObject.setErrorCode(CommonUtils.getServiceErrorCode(error.getErrorCode()));
        errorObject.setErrorMessages(errorMessageList);
        responseDto.setError(errorObject);
        return new ResponseEntity<>(responseDto, error.getHttpStatus());
    }

    /**
     * Populate success response with list of data
     *
     * @param domainList
     * @return
     */
    public ResponseEntity<ResponseDto> populateSuccessResponseDomain(List<I> domainList, SuccessDetails success) {
        log.info(SUCCESS_LOG_MSG);
        ResponseDto responseDto = new ResponseDto();
        SuccessResponseListDto<I> successResponse = new SuccessResponseListDto<>();
        successResponse.setSuccessCode(getServiceSuccessCode(success.getSuccessCode()));
        successResponse.setData(domainList);
        responseDto.setSuccess(successResponse);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    /**
     * Populate success response with data
     *
     * @param data
     * @return
     */
    public ResponseEntity<ResponseDto> populateSuccessResponseDomain(I data, SuccessDetails success) {
        log.info(SUCCESS_LOG_MSG);
        ResponseDto responseDto = new ResponseDto();
        SuccessResponseObjectDto<I> successResponse = new SuccessResponseObjectDto<>();
        successResponse.setSuccessCode(getServiceSuccessCode(success.getSuccessCode()));
        successResponse.setData(data);
        responseDto.setSuccess(successResponse);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    /**
     * Populate success response with list of data and message
     *
     * @param domainList
     * @return
     */
    public ResponseEntity<ResponseDto> populateSuccessResponseWithMessage(List<I> domainList,
                                                                          SuccessDetails success) {
        log.info(SUCCESS_LOG_MSG);
        ResponseDto responseDto = new ResponseDto();
        SuccessResponseListDto<I> successResponse = new SuccessResponseListDto<>();
        successResponse.setSuccessCode(getServiceSuccessCode(success.getSuccessCode()));
        successResponse.setData(domainList);
        successResponse.setResponseMessage(success.getResponseMessage());
        responseDto.setSuccess(successResponse);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    /**
     * Populate success response with list of data and message
     *
     * @param data
     * @return
     */
    public ResponseEntity<ResponseDto> populateSuccessResponseWithMessage(I data, SuccessDetails success) {
        log.info(SUCCESS_LOG_MSG);
        ResponseDto responseDto = new ResponseDto();
        SuccessResponseObjectDto<I> successResponse = new SuccessResponseObjectDto<>();
        successResponse.setSuccessCode(getServiceSuccessCode(success.getSuccessCode()));
        successResponse.setData(data);
        successResponse.setResponseMessage(success.getResponseMessage());
        responseDto.setSuccess(successResponse);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    /**
     * Populate success response with only message
     *
     * @param success
     * @return
     */
    public ResponseEntity<ResponseDto> populateSuccessResponseOnlyWithMessage(SuccessDetails success) {
        log.info(SUCCESS_LOG_MSG);
        ResponseDto responseDto = new ResponseDto();
        SuccessResponseDto<I> successResponse = new SuccessResponseDto<>();
        successResponse.setSuccessCode(getServiceSuccessCode(success.getSuccessCode()));
        successResponse.setResponseMessage(success.getResponseMessage());
        responseDto.setSuccess(successResponse);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    private String getServiceSuccessCode(Integer successCode) {
        if (successCode == null) {
            return null;
        }
        return SERVICE_SHORT_NAME + "SCC-" + String.format("%04d", successCode);
    }

    public static ResponseEntity<Object> populateErrorResponseDomain(ErrorDetails error, Map<?, ?> data,
                                                                     List<String> errorMessages, String errorMessage) {
        log.info(ERROR_LOG_MSG);
        ResponseDto responseDto = new ResponseDto();
        ErrorResponseDto errorObject = new ErrorResponseDto();
        errorObject.setMessage(errorMessage);
        errorObject.setErrorMessages(errorMessages);
        errorObject.setErrorCode(CommonUtils.getServiceErrorCode(error.getErrorCode()));
        errorObject.setData(data);
        responseDto.setError(errorObject);
        return new ResponseEntity<>(responseDto, error.getHttpStatus());
    }
}