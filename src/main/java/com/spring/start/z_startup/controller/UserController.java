package com.spring.start.z_startup.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.start.z_startup.configuration.JwtTokenUtil;
import com.spring.start.z_startup.dto.request.LoginUserRequestDTO;
import com.spring.start.z_startup.dto.request.UserRequestDTO;
import com.spring.start.z_startup.dto.request.UserResponseDTO;
import com.spring.start.z_startup.entity.User;
import com.spring.start.z_startup.exception.StartUpRestException;
import com.spring.start.z_startup.service.UserService;
import com.spring.start.z_startup.serviceImpl.JwtUserDetailsService;

@RestController()
@RequestMapping(value = "/user", produces = "application/json")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;

	@PostMapping(value = "/signup", consumes = "application/json")
	public ResponseEntity<Void> create(@Valid @RequestBody UserRequestDTO user, HttpServletRequest req)
			throws Exception {
		User userEntity = userService.createUser(user);
		HttpHeaders h = new HttpHeaders();
		h.add("id", userEntity.getId().toString());
		return new ResponseEntity<>(h, HttpStatus.CREATED);
	}
	
	@PostMapping(value = "/login", consumes = "application/json")
	public ResponseEntity<?> login(@RequestBody LoginUserRequestDTO authenticationRequest) throws Exception {
		//authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		final UserResponseDTO userDetails = userService
				.login(authenticationRequest);
		return ResponseEntity.ok(userDetails);
	}
	
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new StartUpRestException("USER_DISABLED");
		} catch (BadCredentialsException e) {
			throw new StartUpRestException("INVALID_CREDENTIALS");
		}
	}
}
