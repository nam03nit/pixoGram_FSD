package com.pixogram.media.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Media {

	@Id
	@GeneratedValue
	private int id;
	private String title;
	private String description;
	private String tags;
	private String effects;
	private String imagePath;
	private int userId;
	
	
	
	//Constructor using fields
	public Media(int id, String title, String description, String tags, String effects,String imagePath,int userId) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.tags = tags;
		this.effects = effects;
		this.imagePath = imagePath;
		this.userId = userId;
	}

	//Default Constructor 
	public Media() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	//Getters and Setters

	public int getId() {
		return id;
	}

	

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getEffects() {
		return effects;
	}

	public void setEffects(String effects) {
		this.effects = effects;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	//ToString
	@Override
	public String toString() {
		return "Media [id=" + id + ", title=" + title + ", description=" + description + ", tags=" + tags + ", effects="
				+ effects + ", imagePath=" + imagePath + ", userId=" + userId + "]";
	}

	
	
	
}
