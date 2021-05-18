package com.pixogram.user.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.pixogram.user.entity.User;
import com.pixogram.user.repo.UserRepository;
import com.pixogram.user.utils.FileUploadUtil;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	List<User> users;
	
	public UserServiceImpl() {
		users = new ArrayList<>();
	}
	
	
	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
		
	}

	@Override
	public User getUser(int userId) {
		User user = userRepository.findById(userId);
		return user;
	}

	@Override
	public User getUserByUsername(String username) {
		User user = userRepository.findByUserName(username);
		return user;
	}


	@Override
	public User createUser(User user) {  
		userRepository.save(user);
	  return user;
	}
	
	@Override
	public String uploadProfilePic(MultipartFile multipartFile,String userId) {
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		int uuid=Integer.parseInt(userId);
		System.out.println("uuid"+uuid);
		User user = userRepository.findById(uuid);
		userRepository.delete(user);
		String uploadDir = "C:\\Users\\NamrataKumari\\Documents\\workspace-spring-tool-suite-4-4.10.0.RELEASE\\userMS\\src\\main\\resources\\users-photos\\"+fileName;
		user.setProfilePicture(uploadDir);
		  try {
			FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		  
		  userRepository.save(user);
		  return null;
	}


	@Override
	public User deleteUser(User user) {
		userRepository.delete(user);
		return user;
	}


	@Override
	public User updateUser(User user) {
		userRepository.delete(user);
		userRepository.save(user);
		return user;
	}

}
