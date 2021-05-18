package com.pixogram.media.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pixogram.media.entity.Media;

public interface MediaRepository extends JpaRepository<Media,Integer>{

	Media findById(int userId);

}
