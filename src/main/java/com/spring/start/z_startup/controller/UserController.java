package com.spring.start.z_startup.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.start.z_startup.dto.request.UserRequestDTO;
import com.spring.start.z_startup.entity.User;
import com.spring.start.z_startup.service.UserService;

@RestController()
@RequestMapping(value = "/user", produces = "application/json")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(value = "/signup", consumes = "application/json")
	public ResponseEntity<Void> create(@Valid @RequestBody UserRequestDTO user, HttpServletRequest req)
			throws Exception {
		User userEntity = userService.createUser(user);
		HttpHeaders h = new HttpHeaders();
		h.add("id", userEntity.getId().toString());
		return new ResponseEntity<>(h, HttpStatus.CREATED);
	}
}
