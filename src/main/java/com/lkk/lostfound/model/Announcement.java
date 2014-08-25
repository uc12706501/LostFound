package com.lkk.lostfound.model;

import javax.persistence.*;

@Entity
public class Announcement {
	private long id;
	private byte[] image;

	@Id
	@Column(name ="announcement_id")
	public long getId() {
		return id;
	}

	@Column(name="announcement_image")
	@Lob
	public byte[] getImage() {
		return image;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
}
