package com.pixogram.media.service;

import java.util.List;

import com.pixogram.media.entity.Media;


public interface MediaService {

	public List<Media> getMedias();
	public Media getMedia(int mediaId);
	public Media createMedia(Media media);
	public Media updateMedia(Media media);
	public Media deleteMedia(Media media);
}
