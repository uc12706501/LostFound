package com.lkk.lostfound.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "message")
public class Message {
	private long id;
	private Date time;
	private String content;
	private ItemBase item;
	private String editorName;

	@Id
	@Column(name = "message_id")
	public long getId() {
		return id;
	}

	@Column(name = "leave_time")
	public Date getTime() {
		return time;
	}

	@Column(name = "message_content", length = 1000, nullable = false)
	public String getContent() {
		return content;
	}

	@ManyToOne
	@JoinColumn(name = "item_id")
	public ItemBase getItem() {
		return item;
	}

	@Column(name = "message_editor", length = 20, nullable = true)
	public String getEditorName() {
		return editorName;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setItem(ItemBase item) {
		this.item = item;
	}

	public void setEditorName(String editorName) {
		this.editorName = editorName;
	}

}
