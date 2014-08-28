package com.lkk.lostfound.model;

import javax.persistence.*;

@Entity
public class Announcement {
	private long id;
	private byte[] image;
	private boolean diaplay;

	@Id
	@Column(name = "announcement_id")
	public long getId() {
		return id;
	}

	@Column(name = "announcement_image")
	@Lob
	public byte[] getImage() {
		return image;
	}

	@Column(name = "announcement_display")
	public boolean isDiaplay() {
		return diaplay;
	}

	public void setDiaplay(boolean diaplay) {
		this.diaplay = diaplay;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
}
