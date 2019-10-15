package com.spring.start.z_startup.serviceImpl;

import java.util.Arrays;
import java.util.Base64;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.start.z_startup.configuration.JwtTokenUtil;
import com.spring.start.z_startup.dao.UserDao;
import com.spring.start.z_startup.dto.request.LoginUserRequestDTO;
import com.spring.start.z_startup.dto.request.UserRequestDTO;
import com.spring.start.z_startup.dto.request.UserResponseDTO;
import com.spring.start.z_startup.entity.User;
import com.spring.start.z_startup.entity.UserPermission;
import com.spring.start.z_startup.entity.UserPermissionEnum;
import com.spring.start.z_startup.entity.UserStatusEnum;
import com.spring.start.z_startup.exception.ResourceNotFoundException;
import com.spring.start.z_startup.exception.StartUpRestException;
import com.spring.start.z_startup.service.UserService;

@Service(value = "userService")
@Transactional
public class UserServiceImpl implements UserDetailsService, UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	private UserDao userDao;
	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Override
	public User createUser(UserRequestDTO userRequestDTO) throws Exception {
		logger.info("inside serviec to create user.");
		User user = new User();
		User userData = userDao.findByEmail(userRequestDTO.getEmail());
		if (userData != null) {
			throw new StartUpRestException("Email already used.");
		}
		populateUser(userRequestDTO, user);
		return userDao.save(user);
	}

	private void populateUser(UserRequestDTO userRequestDTO, User user) {
		user.setEmail(userRequestDTO.getEmail());
		user.setName(userRequestDTO.getName());
		user.setPassword(bcryptEncoder.encode(userRequestDTO.getPassword()));
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

	private void populateUserDto(UserRequestDTO userRequestDTO, User user) {
		userRequestDTO.setEmail(user.getEmail());
		userRequestDTO.setName(user.getName());
		userRequestDTO.setPassword(Base64.getEncoder().encodeToString((user.getPassword().getBytes())));

	}

	public User findOne(String username) {
		return userDao.findByEmail(username);
	}

	@Override
	public UserResponseDTO login(LoginUserRequestDTO loginUser) throws ResourceNotFoundException, StartUpRestException {
		UserResponseDTO dto = new UserResponseDTO();
		final User user = findOne(loginUser.getEmail());

		if (user == null || !bcryptEncoder.matches(loginUser.getPassword(), user.getPassword())) {
			throw new ResourceNotFoundException("user not found.");
		}
		/*
		 * if(!user.getIsEmailVerified()) { throw new
		 * KalbosRestException("Cann't Login as email is not verified"); }
		 */
		final String token = jwtTokenUtil.generateToken(user);
		dto.setToken(token);
		dto.setEmail(user.getEmail());
		dto.setName(user.getName());
		dto.setId(user.getId());
		return dto;
	}

	public User loadUserByEmail(String username) {
		User user = userDao.findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return user;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				getAuthority());
	}

	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

}
