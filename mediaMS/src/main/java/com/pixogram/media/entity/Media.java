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
	private String imageName;
	private String email;
	
	
	
	//Constructor using fields
	public Media(int id, String title, String description, String imageName, String email) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.imageName = imageName;
		this.email = email;
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

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	//ToString
	@Override
	public String toString() {
		return "Media [id=" + id + ", title=" + title + ", description=" + description + ", imageName=" + imageName
				+ ", email=" + email + "]";
	}
	
	
}
