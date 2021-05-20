package com.pixogram.media.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pixogram.media.entity.Media;
import com.pixogram.media.service.MediaService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "/")
public class MediaController {
	
	@Autowired
	private MediaService mediaService;
	
	//Get one media
//	@GetMapping("media/{mediaId}")
//	public Media getMedia(@PathVariable int mediaId) {
//		return this.mediaService.getMedia(mediaId);
//	}
	
	//Get all media
//	@GetMapping("media/")
//	public List<Media> getMedias() {
//		return this.mediaService.getMedias();
//	}
	
	//Get media by userId
	@GetMapping("users/media/{userId}")
	public List<Media> getMediasByUserId(@PathVariable int userId) {
		return this.mediaService.getMediasByUserId(userId);
	}
	
	//Create a media
	@PostMapping("media/add")
	public Media createMedia(@RequestParam("title") String title,
			@RequestParam("description") String description,
			@RequestParam("tags") String tags,
			@RequestParam("effects") String effects,
			@RequestParam("userId") int userId,
			@RequestParam("image") MultipartFile multipartFile) throws IOException { 
		return this.mediaService.createMedia(multipartFile,title,description,
				 tags,effects,userId);
	}
	//Update a user
	@DeleteMapping("media/update") 
	public Media updateMedia(@RequestBody Media media) {
		return this.mediaService.updateMedia(media);
	}
	
	//Delete a user
	@DeleteMapping("media/delete") 
	public Media deleteMedia(@RequestBody Media media) {
		return this.mediaService.deleteMedia(media);
	}
	
	
	

}
