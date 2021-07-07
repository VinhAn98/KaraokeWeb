package com.webKaraoke.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "chitiethoadon")
public class Chititethoadon {
	@Id
	@Column(name="Idchitiethd")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Idchitiethd;
	@Column(name="Idhoadon")
	private int Idhoadon;
	@Column(name="totalprice")
	private int totalprice;
	
	
	
	public int getIdchitiethd() {
		return Idchitiethd;
	}
	public void setIdchitiethd(int idchitiethd) {
		Idchitiethd = idchitiethd;
	}
	public int getIdhoadon() {
		return Idhoadon;
	}
	public void setIdhoadon(int idhoadon) {
		Idhoadon = idhoadon;
	}
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	
	
	
}
