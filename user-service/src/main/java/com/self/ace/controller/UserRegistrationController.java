package com.self.ace.controller;


import com.self.ace.service.UserRegistrationService;
import com.self.ace.service.dto.UserRegistrationRequestDto;
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
    public ResponseEntity<String> registerUser(@RequestBody UserRegistrationRequestDto userRegistrationRequestDto){
        return null;
    }
	
	

}
