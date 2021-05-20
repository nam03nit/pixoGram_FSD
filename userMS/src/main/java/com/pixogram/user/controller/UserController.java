package com.pixogram.user.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.pixogram.user.dto.Media;
import com.pixogram.user.entity.User;
import com.pixogram.user.feign.MyFeignClient;
import com.pixogram.user.service.UserService;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/")
public class UserController {
	
	@Autowired
	private UserService userservice;
	@Autowired
	private MyFeignClient feignClient;
	
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
	public User createUser(@RequestBody User user) throws Exception {
		String userName = user.getUserName();
		if(userName!=null && "".equals(userName)) {
			User userObj = userservice.getUserByUsername(userName);
			if(userObj != null) {
				throw new Exception("user with userName"+userName+"is already present");
			}
		}
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
	
	@HystrixCommand(fallbackMethod="defaultMedia")
	@GetMapping("/users/media/{userId}")
	public List<Media> getMedias(@PathVariable int userId) {
		return feignClient.getMediasByUserId(userId);
	}
	
	public List<Media> defaultMedia(int id) {
		List<Media> mediaObj = new ArrayList<Media>();
		return mediaObj;
	}
	
	@HystrixCommand(fallbackMethod="createFailed")
	@PostMapping("media/add")
	public Media createMedia(@RequestParam("title") String title,
			@RequestParam("description") String description,
			@RequestParam("tags") String tags,
			@RequestParam("effects") String effects,
			@RequestParam("userId") int userId,
			@RequestParam("image") MultipartFile multipartFile) throws IOException { 
		return this.feignClient.createMediaForUser(title,description,
				 tags,effects,userId,multipartFile);
	}	
	
	public Media createFailed(String title,String description,String tags,
			String effects,int userId,MultipartFile multipartFile) {
		Media mediaObj = new Media();
		return mediaObj;
	}
	

}
