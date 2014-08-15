package com.lkk.lostfound.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "picked_item")
public class PickedItem extends ItemBase {
	private String infoSource;

	@Column(name = "info_source", length = 200, nullable = true)
	public String getInfoSource() {
		return infoSource;
	}

	public void setInfoSource(String infoSource) {
		this.infoSource = infoSource;
	}
}
