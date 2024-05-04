package com.self.psmf.service;

import org.springframework.stereotype.Service;

import com.self.psmf.service.dto.UserRegistrationRequestDto;

@Service
public interface UserRegistrationService {
	
	public void registerUser(UserRegistrationRequestDto userRegistrationRequestDto);

}
