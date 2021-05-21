package com.pixogram.media.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.pixogram.media.entity.Media;
import com.pixogram.media.repo.MediaRepository;
import com.pixogram.media.utils.FileUploadUtil;

@Service
public class MediaServiceImpl implements MediaService {

	@Autowired
	private MediaRepository mediaRepository;

	List<Media> media;
	
	public MediaServiceImpl() {
		media = new ArrayList<>();
	}
	
	
	@Override
	public List<Media> getMedias() {
		return mediaRepository.findAll();
		
	}

	@Override
	public Media getMedia(int mediaId) {
		Media media = mediaRepository.findById(mediaId);
		return media;
	}
	
	@Override
	public Media createMedia(String title,String description,
			String tags,String effects, int userId,MultipartFile multipartFile) {
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		
		Media media = new Media();		
		String uploadDir = "C:\\Users\\NamrataKumari\\Documents\\workspace-spring-tool-suite-4-4.10.0.RELEASE\\mediaMS\\src\\main\\resources"+fileName;
		media.setImagePath(uploadDir);
		media.setTitle(title);
		media.setDescription(description);
		media.setTags(tags);
		media.setEffects(effects);
		
		  try {
			FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		  
		  mediaRepository.save(media);
		  return media;
	}


	@Override
	public Media deleteMedia(Media media) {
		mediaRepository.delete(media);
		return media;
	}


	@Override
	public Media updateMedia(Media media) {
		mediaRepository.delete(media);
		mediaRepository.save(media);
		return media;
	}


	@Override
	public List<Media> getMediasByUserId(int userId) {
		List<Media> medias = mediaRepository.findByUserId(userId);
		return medias;
	}
}
