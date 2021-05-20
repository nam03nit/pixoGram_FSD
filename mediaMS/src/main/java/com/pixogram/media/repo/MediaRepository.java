package com.pixogram.media.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pixogram.media.entity.Media;

public interface MediaRepository extends JpaRepository<Media,Integer>{

	Media findById(int id);
	List<Media> findByUserId(int userId);

}
