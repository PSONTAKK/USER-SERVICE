package com.self.ace.exception;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.self.ace.service.dto.ResponseDto;
import com.self.ace.service.dto.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@RestControllerAdvice
public class ControllerAdviceExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseStatus(value = HttpStatus.OK)
    @ExceptionHandler(Exception.class)
    public String handleException(Exception exception) {
        return exception.getMessage();
    }

    @ResponseStatus(value = HttpStatus.OK)
    @ExceptionHandler(AceException.class)
    public List<String> handleGenericException(AceException aceException) {
        return aceException.getErrorMessages();
    }

    @ExceptionHandler(PreLoginFailedException.class)
    protected ResponseEntity<ResponseDto> handlePreLoginFailedException(PreLoginFailedException ex) {
        log.error("Handling PreLoginFailedException...", ex);
        return ResponseUtil.populateErrorResponseDomain(ex.getError(), ex.getData(), ex.getErrorMessages());
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
                                                                     HttpHeaders headers, HttpStatus status, WebRequest request) {
        logger.error("Handling unsupported media type exception...", ex);
        return ResponseUtil.populateErrorResponseDomainAsObject(HttpStatus.UNSUPPORTED_MEDIA_TYPE,
                ErrorDetails.UNSUPPORTED_MEDIA_TYPE);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<FieldError> errorList = ex.getBindingResult().getFieldErrors().stream().collect(Collectors.toList());
        Set<String> errorField = errorList.stream().map(fieldError -> fieldError.getDefaultMessage())
                .collect(Collectors.toSet());
        return ResponseUtil.populateErrorResponseDomainAsObjectWithErrorList(HttpStatus.BAD_REQUEST, new ArrayList<>(errorField),
                ErrorDetails.REQUEST_VALIDATION_FAILED);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        if (ex.getCause() instanceof InvalidFormatException) {
            InvalidFormatException invalidFormatException = (InvalidFormatException) ex.getCause();
            if (invalidFormatException.getTargetType() != null) {
                String errorDetails = String.format("%s is not valid", invalidFormatException.getPath()
                        .get(invalidFormatException.getPath().size() - 1).getFieldName());
                return ResponseUtil.populateErrorResponseDomainAsObjectWithErrorList(HttpStatus.BAD_REQUEST,
                        Stream.of(errorDetails).collect(Collectors.toList()), ErrorDetails.REQUEST_VALIDATION_FAILED);
            }
        } else if (ex.getCause() instanceof JsonMappingException) {
            JsonMappingException jsonMappingException = (JsonMappingException) ex.getCause();
            String errorDetails = String.format("%s is not valid", jsonMappingException.getPath()
                    .get(jsonMappingException.getPath().size() - 1).getFieldName());
            return ResponseUtil.populateErrorResponseDomainAsObjectWithErrorList(HttpStatus.BAD_REQUEST,
                    Stream.of(errorDetails).collect(Collectors.toList()), ErrorDetails.REQUEST_VALIDATION_FAILED);
        }
        return ResponseUtil.populateErrorResponseDomainAsObject(HttpStatus.BAD_REQUEST,
                ErrorDetails.REQUEST_VALIDATION_FAILED);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
                                                                         HttpHeaders headers, HttpStatus status, WebRequest request) {
        logger.error("Handling method not supported exception...", ex);
        return ResponseUtil.populateErrorResponseDomainAsObject(HttpStatus.METHOD_NOT_ALLOWED,
                ErrorDetails.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(MissingRequestHeaderException.class)
    protected ResponseEntity<ResponseDto> handleMissingHeaderException(MissingRequestHeaderException ex) {
        logger.error("Handling Missing Header Exception...", ex);
        return ResponseUtil.populateErrorResponseDomain(HttpStatus.BAD_REQUEST, ErrorDetails.INVALID_HEADER_DETAILS);
    }

}