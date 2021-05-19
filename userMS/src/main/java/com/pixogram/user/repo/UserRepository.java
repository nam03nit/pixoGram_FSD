package com.pixogram.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pixogram.user.entity.User;

public interface UserRepository extends JpaRepository<User,Integer>{

	User findById(int userId);
	public User findByUserName(String userName);   

}
