package com.lkk.lostfound.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
	private long id;
	private String account;
	private String dispalyName;
	private String password;
	private UserRole role;
	private List<ItemBase> items;

	@Id
	@Column(name = "user_id")
	public long getId() {
		return id;
	}

	@Column(name = "user_logon_name", length = 200, nullable = false)
	public String getAccount() {
		return account;
	}

	@Column(name = "user_display_name", length = 200)
	public String getDispalyName() {
		return dispalyName;
	}

	@Column(name = "user_password", length = 200, nullable = false)
	public String getPassword() {
		return password;
	}

	@Column(name = "user_role")
	@Enumerated(EnumType.STRING)
	public UserRole getRole() {
		return role;
	}

	@OneToMany(mappedBy = "publisher", fetch = FetchType.LAZY)
	public List<ItemBase> getItems() {
		return items;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public void setDispalyName(String dispalyName) {
		this.dispalyName = dispalyName;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public void setItems(List<ItemBase> items) {
		this.items = items;
	}
}
