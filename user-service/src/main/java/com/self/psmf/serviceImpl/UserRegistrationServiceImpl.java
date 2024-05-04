package com.self.psmf.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.self.psmf.service.UserRegistrationService;
import com.self.psmf.service.dto.UserRegistrationRequestDto;

@Service

public class UserRegistrationServiceImpl implements UserRegistrationService{

	
	private final Logger log = LoggerFactory.getLogger(UserRegistrationServiceImpl.class);
	@Override
	public void registerUser(UserRegistrationRequestDto userRegistrationRequestDto) {
		log.info("Creating User for ");
		
	}

}
