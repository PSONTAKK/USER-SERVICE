package com.self.ace.service.dto;

import com.self.ace.contstant.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Slf4j
public class UserRegistrationRequestDto {
		
	private String userName;
	private String userMobile;
	private String userEmail;
	private String password;
	private UserRole userRole;
	private String referalCode;
}
