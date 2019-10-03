package com.spring.start.z_startup.service;

import com.spring.start.z_startup.dto.request.UserRequestDTO;
import com.spring.start.z_startup.entity.User;


public interface UserService {

	/**
	 * method is used to save the user
	 * @param user
	 * @return
	 * @throws KalbosRestException 
	 */
	User createUser(UserRequestDTO user) throws Exception;

	

}
