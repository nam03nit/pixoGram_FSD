package com.pixogram.user.feign;

import java.io.IOException;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.pixogram.user.dto.Media;



@FeignClient(url="http://localhost:8082/",name="test")
public interface MyFeignClient {
	
	@GetMapping("/users/media/{userId}")
	public List<Media> getMediasByUserId(@PathVariable int userId);
	
	@PostMapping("media/add")
	public Media createMediaForUser(@RequestParam("title") String title,
			@RequestParam("description") String description,
			@RequestParam("tags") String tags,
			@RequestParam("effects") String effects,
			@RequestParam("userId") int userId,
			@RequestParam("image") MultipartFile multipartFile);
	
}
