package com.lkk.lostfound.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;

@Entity
@Table(name = "picked_item")
@DiscriminatorValue("2")
public class PickedItem extends ItemBase {
	private String infoSource;

	@Column(name = "info_source", length = 200, nullable = true)
	public String getInfoSource() {
		return infoSource;
	}

	@StringLengthFieldValidator(maxLength = "200", message = "长度不超过200字符")
	public void setInfoSource(String infoSource) {
		this.infoSource = infoSource;
	}
}
