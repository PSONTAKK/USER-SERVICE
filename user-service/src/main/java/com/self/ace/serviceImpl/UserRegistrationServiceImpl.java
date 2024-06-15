package com.self.ace.serviceImpl;

import com.self.ace.contstant.UserRole;
import com.self.ace.data.entity.UserProfile;
import com.self.ace.data.repository.UserProfileRepository;
import com.self.ace.service.UserRegistrationService;
import com.self.ace.service.dto.UserRegistrationRequestDto;
import io.micrometer.common.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;


import java.util.UUID;

@Service

public class UserRegistrationServiceImpl implements UserRegistrationService {

	
	private final Logger log = LoggerFactory.getLogger(UserRegistrationServiceImpl.class);
	@Autowired
	private UserProfileRepository userProfileRepository;

	@Override
	public void registerUser(UserRegistrationRequestDto userRegistrationRequestDto) {
		log.info("Creating User");
		if (StringUtils.isNotEmpty(userRegistrationRequestDto.getUserMobile())) {
			UserProfile userProfile = userProfileRepository.findByUserName(userRegistrationRequestDto.getUserName());
			if (!ObjectUtils.isEmpty(userProfile)) {
				log.info("userName should not be Same for {}", userRegistrationRequestDto.getUserName());
				throw new RuntimeException();
			}
			userProfile = UserProfile.builder().userRole(UserRole.USER)
					.referalCode(StringUtils.isEmpty(userRegistrationRequestDto.getReferalCode()) ? null : userRegistrationRequestDto.getReferalCode())
					.userEmail(StringUtils.isEmpty(userRegistrationRequestDto.getUserEmail()) ? null : userRegistrationRequestDto.getUserEmail())
					.userName(userRegistrationRequestDto.getUserName())
					.userMobileNo(userRegistrationRequestDto.getUserMobile()).refNo(UUID.randomUUID().toString()).build();
			userProfileRepository.save(userProfile);
		}

	}

}
