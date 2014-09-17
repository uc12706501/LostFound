package com.lkk.lostfound.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.opensymphony.xwork2.conversion.annotations.TypeConversion;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "DISCRIMINSTOR", discriminatorType = DiscriminatorType.INTEGER)
public class ItemBase {

	private long id;
	private String name;
	private String location;
	private Date time;
	private String remark;
	private String character;
	private String address;
	private String telphone;
	private byte[] image;
	private ItemStatus status;
	private List<Message> messages;
	private User publisher;
	private boolean isDelete;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "item_id")
	public long getId() {
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
		return address;
	}

	@Column(name = "contact_temphone", length = 20, nullable = false)
	public String getTelphone() {
		return telphone;
	}

	@Lob
	@Column(name = "item_image", length = 2097152)
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
	@JoinColumn(name = "user_id", nullable = false)
	public User getPublisher() {
		return publisher;
	}

	@Column(name = "item_deleted", nullable = false)
	public boolean getIsDelete() {
		return isDelete;
	}

	public void setId(long id) {
		this.id = id;
	}

	@RequiredStringValidator(message = "请输入物品名称")
	@StringLengthFieldValidator(maxLength = "200", message = "长度不超过200字符")
	public void setName(String name) {
		this.name = name;
	}

	@RequiredStringValidator(message = "请输入地点", shortCircuit = true)
	@StringLengthFieldValidator(maxLength = "200", message = "长度不超过200字符")
	public void setLocation(String location) {
		this.location = location;
	}

	@RequiredFieldValidator(message = "请输入时间")
	public void setTime(Date time) {
		this.time = time;
	}

	@StringLengthFieldValidator(maxLength = "1000", message = "长度不超过1000")
	public void setCharacter(String character) {
		this.character = character;
	}

	@StringLengthFieldValidator(maxLength = "1000", message = "长度不超过1000")
	public void setRemark(String remark) {
		this.remark = remark;
	}

	@StringLengthFieldValidator(maxLength = "200", message = "长度不超过200")
	@RequiredStringValidator(message = "请输入地址")
	public void setAddress(String address) {
		this.address = address;
	}

	@RequiredStringValidator(message = "请输入联系号码")
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
