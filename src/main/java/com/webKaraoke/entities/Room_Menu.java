
package com.webKaraoke.entities;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name = "room_menu")
public class Room_Menu {
	@Id
	@Column(name = "Id_room_menu")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id_room_menu;
	
	
	@Column(name = "Idroom")
	private int Idroom;

	@Column(name = "Idmenu")
	private int Idmenu;

	@Column(name = "number")
	private int number;

	@Column(name = "total_price")
	private int total_price;

	@Column(name = "time_order")
	private Time time_order;

	public int getId_room_menu() {
		return Id_room_menu;
	}

	public void setId_room_menu(int id_room_menu) {
		Id_room_menu = id_room_menu;
	}

	public int getIdroom() {
		return Idroom;
	}

	public void setIdroom(int idroom) {
		Idroom = idroom;
	}

	public int getIdmenu() {
		return Idmenu;
	}

	public void setIdmenu(int idmenu) {
		Idmenu = idmenu;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	public Time getTime_order() {
		return time_order;
	}

	public void setTime_order(Time time_order) {
		this.time_order = time_order;
	}

}
