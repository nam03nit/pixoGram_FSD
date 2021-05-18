package com.pixogram.media.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pixogram.media.entity.Media;
import com.pixogram.media.repo.MediaRepository;

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
	public Media createMedia(Media media) {
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
}
