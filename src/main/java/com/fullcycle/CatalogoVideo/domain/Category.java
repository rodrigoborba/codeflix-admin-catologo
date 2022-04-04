package com.fullcycle.CatalogoVideo.domain;

import java.util.UUID;

public class Category {
	
	private UUID id;
	private String name;
	private String description;
	private Boolean isActive = true;
	
	public Category(UUID id, String name, String description) throws Exception {
		super();
		setId(UUID.randomUUID());
		setName(name);
		setDescription(description);
	}
	
	public Category(String name, String description) throws Exception {
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
	
	public void setName(String name) throws Exception {
		if(null == name) {
			throw new Exception("Can not be null");
		}
		if(name.isEmpty()) {
			throw new Exception("Can not be empty");
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
	
	public void update(String name, String description, Boolean isActive) throws Exception {
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
