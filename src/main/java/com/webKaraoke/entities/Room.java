package com.webKaraoke.entities;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "room")
public class Room {
	@Id
	@Column(name="Idroom")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Idroom;
	@Column(name="time")
	private Time time;
	@Column(name="people")
	private int people;
	@Column(name="name")
	private String name;
	@Column(name="situation")
	private Boolean situation;
	@Column(name="price")
	private int price;
	@Column(name="guestnumber")
	private int guestnumber;

	public int getIdroom() {
		return Idroom;
	}
	public void setIdroom(int Idroom) {
		this.Idroom = Idroom;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public int getPeople() {
		return people;
	}
	public void setPeople(int people) {
		this.people = people;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getSituation() {
		return situation;
	}
	public void setSituation(Boolean situation) {
		this.situation = situation;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getGuestnumber() {
		return guestnumber;
	}
	public void setGuestnumber(int guestnumber) {
		this.guestnumber = guestnumber;
	}
}
