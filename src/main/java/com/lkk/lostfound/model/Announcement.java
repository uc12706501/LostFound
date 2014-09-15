package com.lkk.lostfound.model;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Announcement {
	private long id;
	private byte[] image;
	private Boolean display;
	private Date createDate;

	// getter
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "announcement_id")
	public long getId() {
		return id;
	}

	@Column(name = "announcement_image", nullable = false, length = 4194304)
	@Lob
	public byte[] getImage() {
		return image;
	}

	@Column(name = "announcement_display")
	public boolean isDisplay() {
		return display;
	}

	@Column(name = "announcement_createDate")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreateDate() {
		return createDate;
	}

	// setter
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

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
