package com.lkk.lostfound.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class ItemBase {

	private Long id;
	private String name;
	private String location;
	private Date time;
	private String remark;
	private String character;
	private String Address;
	private String telphone;
	private byte[] image;
	private ItemStatus status;
	private List<Message> messages;
	private User publisher;
	private boolean isDelete;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "item_id")
	public Long getId() {
		return id;
	}

	@Column(name = "item_name", length = 200, nullable = false)
	public String getName() {
		return name;
	}

	@Column(name = "item_location", length = 200, nullable = false)
	public String getLocation() {
		return location;
	}

	@Column(name = "item_time", nullable = false)
	public Date getTime() {
		return time;
	}

	@Column(name = "item_remark", length = 1000)
	public String getRemark() {
		return remark;
	}

	@Column(name = "item_character", length = 1000)
	public String getCharacter() {
		return character;
	}

	@Column(name = "get_return_address", length = 200, nullable = false)
	public String getAddress() {
		return Address;
	}

	@Column(name = "contact_temphone", length = 20, nullable = false)
	public String getTelphone() {
		return telphone;
	}

	@Lob
	@Column(name = "item_image")
	public byte[] getImage() {
		return image;
	}

	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	public ItemStatus getStatus() {
		return status;
	}

	@OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
	public List<Message> getMessages() {
		return messages;
	}

	@ManyToOne
	@JoinColumn(name = "user_id")
	public User getPublisher() {
		return publisher;
	}

	@Column(name = "item_deleted",nullable=false)
	public boolean getIsDelete() {
		return isDelete;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public void setStatus(ItemStatus status) {
		this.status = status;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public void setPublisher(User publisher) {
		this.publisher = publisher;
	}

	public void setIsDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}
}
