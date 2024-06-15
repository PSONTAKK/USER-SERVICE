package com.self.ace.exception;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
@Data
@Slf4j
public class AceException extends Exception{

    private List<String> errorMessages;
}
