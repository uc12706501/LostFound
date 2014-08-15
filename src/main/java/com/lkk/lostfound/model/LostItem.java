package com.lkk.lostfound.model;

import javax.persistence.*;

@Entity
@Table(name = "lost_item")
public class LostItem extends ItemBase {
	private String ownerName;

	@Column(name="itme_owner",nullable=false,length=200)
	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
}
