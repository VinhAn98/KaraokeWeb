package com.webKaraoke.service;

import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webKaraoke.DAO.Room_MenuDAO;
import com.webKaraoke.entities.Room_Menu;

@Service
@Transactional
public class Room_MenuService {
	@Autowired
	private Room_MenuDAO room_menuDAO;
	
	public List<Room_Menu> findAll(){
		return room_menuDAO.findAll();
	}
	
	public Room_Menu findById(final int id){
		return room_menuDAO.findById(id);
	}
	
	public List<Room_Menu> findByIdroom(final int id){
		return room_menuDAO.findByIdroom(id);
	}
	
	public void addOrder(Room_Menu room_menu) {
		  room_menuDAO.persist(room_menu);
	}
	
	public void clearOder( int idroom) {
		List<Room_Menu> listordered = room_menuDAO.findByIdroom(idroom);
		for (Room_Menu room_Menu : listordered) {
			room_menuDAO.remove(room_Menu);
		}
		
	}
	
}
