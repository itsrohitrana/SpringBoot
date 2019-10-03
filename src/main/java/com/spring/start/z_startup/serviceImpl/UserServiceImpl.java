package com.spring.start.z_startup.serviceImpl;

import java.util.Base64;
import java.util.LinkedHashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.start.z_startup.dao.UserDao;
import com.spring.start.z_startup.dto.request.UserRequestDTO;
import com.spring.start.z_startup.entity.User;
import com.spring.start.z_startup.entity.UserPermission;
import com.spring.start.z_startup.entity.UserPermissionEnum;
import com.spring.start.z_startup.entity.UserStatusEnum;
import com.spring.start.z_startup.service.UserService;


@Service(value = "userService")
@Transactional
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	private UserDao userDao;
	

	@Override
	public User createUser(UserRequestDTO userRequestDTO) throws Exception {
		logger.info("inside serviec to create user.");
		User user = new User();
		User userData = userDao.findByEmail(userRequestDTO.getEmail());
		if (userData != null) {
			throw new Exception("Email already used.");
		}
		populateUser(userRequestDTO, user);
		return userDao.save(user);
	}

	private void populateUser(UserRequestDTO userRequestDTO, User user) {
		user.setEmail(userRequestDTO.getEmail());
		user.setName(userRequestDTO.getName());
		user.setPassword(Base64.getEncoder().encodeToString((userRequestDTO.getPassword().getBytes())));
		user.setStatus(UserStatusEnum.INACTIVE.getId());
		Set<UserPermission> permissions = new LinkedHashSet<>();
		UserPermission permission = new UserPermission();
		permission.setPermissionId(UserPermissionEnum.IS_DASHBOARD.getId());
		permissions.add(permission);
		UserPermission permission2 = new UserPermission();
		permission2.setPermissionId(UserPermissionEnum.IS_PUBLISHING.getId());
		permissions.add(permission2);
		user.setPermissions(permissions);
	}

	
}
