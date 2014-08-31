package com.lkk.lostfound.model;

import javax.persistence.*;

import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

@Entity
public class Announcement {
	private long id;
	private byte[] image;
	private Boolean display;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "announcement_id")
	public long getId() {
		return id;
	}

	@Column(name = "announcement_image", nullable = false)
	@Lob
	public byte[] getImage() {
		return image;
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

	// @RequiredFieldValidator(key = "validate.required")
	public void setImage(byte[] image) {
		this.image = image;
	}
}
