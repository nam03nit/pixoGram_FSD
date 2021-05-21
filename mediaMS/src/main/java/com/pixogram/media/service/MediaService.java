package com.pixogram.media.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.pixogram.media.entity.Media;


public interface MediaService {

	public List<Media> getMedias();
	public Media getMedia(int mediaId);
	public Media updateMedia(Media media);
	public Media deleteMedia(Media media);
	public Media createMedia(String title, String description, String tags,
			String effects, int userId,MultipartFile multipartFile);
	public List<Media> getMediasByUserId(int userId);
	
}
