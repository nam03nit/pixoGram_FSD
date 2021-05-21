package com.pixogram.user.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.pixogram.user.dto.Media;

import feign.Headers;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;



@FeignClient(url="http://localhost:8082/",name="test",
configuration = {MyFeignClient.MultipartSupportConfig.class})
public interface MyFeignClient {
	
	@GetMapping("/users/media/{userId}")
	public List<Media> getMediasByUserId(@PathVariable int userId);
	
	@PostMapping(path="media/add", consumes = {"multipart/form-data"})
	public Media createMedia(@RequestParam("title") String title,
			@RequestParam("description") String description,
			@RequestParam("tags") String tags,
			@RequestParam("effects") String effects,
			@RequestParam("userId") int userId,
			@RequestPart("image") MultipartFile multipartFile);
	
	public class MultipartSupportConfig {
	    @Bean
	    @Primary
	    @Scope("prototype")
	    public Encoder feignFormEncoder() {
	        return new SpringFormEncoder();
	    }
	  }
	
}
