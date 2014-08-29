package com.lkk.lostfound.model;

import javax.persistence.*;

import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

@Entity
public class Announcement {
	private long id;
	private String imageUrl;
	private Boolean display;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "announcement_id")
	public long getId() {
		return id;
	}

	@Column(name = "announcement_image", nullable = false)
	public String getImageUrl() {
		return imageUrl;
	}

	@Column(name = "announcement_display")
	public boolean isDisplay() {
		return display;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setDisplay(boolean display) {
		this.display = display;
	}

	@RequiredStringValidator(shortCircuit = true, key = "validate.required")
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}
