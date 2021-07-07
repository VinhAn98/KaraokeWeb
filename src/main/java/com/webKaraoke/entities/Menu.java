package com.webKaraoke.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "menu")
public class Menu {
	@Id
	@Column(name="Idmenu")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Idmenu;
	@Column(name="name")
	private String name;
	@Column(name="price")
	private int price;
	@Column(name="type")
	private String type;
	@Column(name="Imgname")
	private String Imgname;
	
	public int getIdmenu() {
		return Idmenu;
	}
	public void setIdmenu(int idmenu) {
		this.Idmenu = idmenu;
	}
	
	public String getImgname() {
		return Imgname;
	}
	public void setImgname(String imgname) {
		Imgname = imgname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	

}
