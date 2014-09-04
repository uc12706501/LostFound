package com.lkk.lostfound.model;

import java.util.Date;

import javax.persistence.*;

import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;

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
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	@JoinColumn(name = "item_id",nullable=false)
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

	@RequiredStringValidator(message = "请输入留言内容")
	@StringLengthFieldValidator(maxLength = "1000", message = "留言长度不超过1000字符")
	public void setContent(String content) {
		this.content = content;
	}

	public void setItem(ItemBase item) {
		this.item = item;
	}

	@StringLengthFieldValidator(maxLength = "20", message = "留言长度不超过20字符")
	public void setEditorName(String editorName) {
		this.editorName = editorName;
	}

}
