package com.pixogram.user.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.pixogram.user.entity.User;


public interface UserService {

	public List<User> getUsers();
	public User getUser(int userId);
	public User getUserByUsername(String username);
	public User createUser(User user);
	public User updateUser(User user);
	public User deleteUser(User user);
	public String uploadProfilePic (MultipartFile multipartFile,String userId);
}
