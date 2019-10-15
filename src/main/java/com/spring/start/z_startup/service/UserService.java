package com.spring.start.z_startup.service;

import com.spring.start.z_startup.dto.request.LoginUserRequestDTO;
import com.spring.start.z_startup.dto.request.UserRequestDTO;
import com.spring.start.z_startup.dto.request.UserResponseDTO;
import com.spring.start.z_startup.entity.User;
import com.spring.start.z_startup.exception.ResourceNotFoundException;
import com.spring.start.z_startup.exception.StartUpRestException;


public interface UserService {

	/**
	 * method is used to save the user
	 * @param user
	 * @return
	 * @throws StartUpRestException 
	 */
	User createUser(UserRequestDTO user) throws Exception;

	UserResponseDTO login(LoginUserRequestDTO authenticationRequest) throws ResourceNotFoundException, StartUpRestException;

	

}
