package com.webKaraoke.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "login")
public class Login {
	@Id
	@Column(name="Iduser")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Iduser;
	@Column(name="username")
	private String username;
	@Column(name="pasword")
	private String password;
	@Column(name="roll")
	private String roll;
	
	
	
	public int getIduser() {
		return Iduser;
	}
	public void setIduser(int iduser) {
		Iduser = iduser;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRoll() {
		return roll;
	}
	public void setRoll(String roll) {
		this.roll = roll;
	}
	
	
}
