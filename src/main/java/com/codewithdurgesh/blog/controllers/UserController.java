package com.codewithdurgesh.blog.controllers;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithdurgesh.blog.payloads.ApiResponse;
import com.codewithdurgesh.blog.payloads.UserDto;
import com.codewithdurgesh.blog.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;

	//POST-create user
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto)
	{
		logger.info("Request received for creating user:{}",userDto);
		UserDto createUserDto=this.userService.createUser(userDto);
		logger.info("User created successfully with ID:{}",createUserDto.getId());
		return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
		
	}
	//PUT -update user
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto,@PathVariable("userId") Integer uid)
	{
		   logger.info("Request received to update user with ID: {}, payload: {}", uid, userDto);
		UserDto updatedUser=this.userService.updateUser(userDto, uid);
		return ResponseEntity.ok(updatedUser);
	}
	//DELETE -delete user
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer uid)
	{
		 this.userService.deleteuser(uid);
		 return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully",true),HttpStatus.OK);
	}
	//Get -get multiple user
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers()
	{
		 logger.info("Request received to fetch all users");
		return ResponseEntity.ok(this.userService.getAllUsers());
	}
	//GET -get single user
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getSingleUsers(@PathVariable Integer userId)
	{
        logger.info("Request received to get single user with ID: {}", userId);
        return ResponseEntity.ok(this.userService.getUserById(userId));
	}
}
