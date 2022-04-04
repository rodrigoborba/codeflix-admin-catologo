package com.fullcycle.CatalogoVideo.domain.entity;

import java.util.UUID;

import com.fullcycle.CatalogoVideo.domain.exception.NotBlankException;
import com.fullcycle.CatalogoVideo.domain.exception.NotNullException;

public class Category {
	
	private UUID id;
	private String name;
	private String description;
	private Boolean isActive = true;
	
	public Category(UUID id, String name, String description) {
		super();
		setId(UUID.randomUUID());
		setName(name);
		setDescription(description);
	}
	
	public Category(String name, String description) {
		super();
		setId(UUID.randomUUID());
		setName(name);
		setDescription(description);
	}

	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		if(null == name) {
			throw new NotNullException("Can not be null");
		}
		if(name.isEmpty()) {
			throw new NotBlankException("Can not be empty");
		}
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Boolean getIsActive() {
		return isActive;
	}
	
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	public Boolean active() {
		return this.isActive = true;
	}
	
	public Boolean deactive() {
		return this.isActive = false;
	}
	
	public void update(String name, String description, Boolean isActive) {
		this.setName(name);
		this.setDescription(description);
		
		if(isActive != null && isActive != this.getIsActive()) {
			if(isActive == true) {
				this.active();				
			} else {
				this.deactive();
			}
		}
	}

}
