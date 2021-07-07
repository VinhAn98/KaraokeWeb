package com.webKaraoke.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "hoadon")
public class Hoadon {
	@Id
	@Column(name="Idhoadon")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Idhoadon;
	@Column(name="Idroom")
	private int Idroom;
	@Column(name="ngaylap")
	private Date ngaylap;
	public int getIdhoadon() {
		return Idhoadon;
	}
	public void setIdhoadon(int idhoadon) {
		Idhoadon = idhoadon;
	}
	public int getIdroom() {
		return Idroom;
	}
	public void setIdroom(int idroom) {
		Idroom = idroom;
	}
	public Date getNgaylap() {
		return ngaylap;
	}
	public void setNgaylap(Date ngaylap) {
		this.ngaylap = ngaylap;
	}
	
	
}
