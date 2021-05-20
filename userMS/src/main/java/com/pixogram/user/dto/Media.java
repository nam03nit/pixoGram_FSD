package com.pixogram.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder({
    "id",
    "title",
    "description",
    "tags",
    "imagePath",
    "effects",
    "userId"
})
public class Media {
	
	@JsonProperty("id")
    private Integer id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("description")
    private String description;
    @JsonProperty("tags")
    private String tags;
    @JsonProperty("imagePath")
    private String imagePath;
    @JsonProperty("effects")
    private String effects;
    @JsonProperty("userId")
    private int userId;
    
    @JsonProperty("id")
	public Integer getId() {
		return id;
	}
    
    @JsonProperty("id")
	public void setId(Integer id) {
		this.id = id;
	}
    
    @JsonProperty("title")
	public String getTitle() {
		return title;
	}
    
    @JsonProperty("title")
	public void setTitle(String title) {
		this.title = title;
	}
    
    @JsonProperty("description")
	public String getDescription() {
		return description;
	}
    
    @JsonProperty("description")
	public void setDescription(String description) {
		this.description = description;
	}
    
    @JsonProperty("tags")
	public String getTags() {
		return tags;
	}
    
    @JsonProperty("tags")
	public void setTags(String tags) {
		this.tags = tags;
	}
    
    @JsonProperty("imagePath")
	public String getImagePath() {
		return imagePath;
	}
    
    @JsonProperty("imagePath")
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
    
    @JsonProperty("effects")
	public String getEffects() {
		return effects;
	}
    
    @JsonProperty("effects")
	public void setEffects(String effects) {
		this.effects = effects;
	}
    
    @JsonProperty("userId")
	public int getUserId() {
		return userId;
	}
    
    @JsonProperty("userId")
	public void setUserId(int userId) {
		this.userId = userId;
	}

    
}
