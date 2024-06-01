package com.self.ace.service;

import com.self.ace.service.dto.UserRegistrationRequestDto;
import org.springframework.stereotype.Service;

@Service
public interface UserRegistrationService {
	
	public void registerUser(UserRegistrationRequestDto userRegistrationRequestDto);

}
