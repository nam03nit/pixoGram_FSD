package com.pixogram.user.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pixogram.user.entity.User;
import com.pixogram.user.service.UserService;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/")
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	//Get one users
	@GetMapping("users/{userId}")
	public User getUser(@PathVariable int userId) {
		return this.userservice.getUser(userId);
	}
	
	//Get one users
	@GetMapping("users/username/{username}")
	public User getUserByUsername(@PathVariable String username) {
		return this.userservice.getUserByUsername(username);
	}
	
	//Get all user
	@GetMapping("users")
	public List<User> getUsers() {
		return this.userservice.getUsers();
	}
	
	//Create a user
	@PostMapping("users/add") 
	public User createUser(@RequestBody User user) {
		return this.userservice.createUser(user);
	}
	
	//Upload Profile
	@PostMapping("users/profile")
	public String createProfile(@RequestParam("userId") String userId,
			@RequestParam("image") MultipartFile multipartFile) throws IOException { 
		return this.userservice.uploadProfilePic(multipartFile,userId);
	}
	
	//Update a user
	@PutMapping("users/update") 
	public User updateUser(@RequestBody User user) {
		return this.userservice.updateUser(user);
	}
	
	//Delete a user
	@DeleteMapping("users/delete") 
	public User deleteUser(@RequestBody User user) {
		return this.userservice.deleteUser(user);
	}
	
	
	

}
