package com.self.psmf.controller;

import com.self.psmf.service.UserRegistrationService;
import com.self.psmf.service.dto.ResponseDto;
import com.self.psmf.service.dto.UserRegistrationRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user")
@Slf4j
public class UserRegistrationController {
	
	@Autowired
    UserRegistrationService userRegistrationService;


    @PostMapping("/register-user")
    public ResponseEntity<ResponseDto> registerUser(@RequestBody UserRegistrationRequestDto userRegistrationRequestDto){
        return null;
    }
	
	

}
