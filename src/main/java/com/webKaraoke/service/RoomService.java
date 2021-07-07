package com.webKaraoke.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.webKaraoke.DAO.RoomDAO;

import com.webKaraoke.entities.Room;

@Service
@Transactional
public class RoomService {
	@Autowired
	private RoomDAO RoomDAO;
	
	
	public List<Room> findAll(){
		return RoomDAO.findAll();
	}
	
	public Room findById(final int id) {
		return RoomDAO.findbyId(id);
	} 
	public void useRoom(Room room,int id) {
		Room useroom = RoomDAO.findbyId(id);
		useroom.setName(room.getName());
		useroom.setPeople(room.getPeople());
		useroom.setGuestnumber(room.getGuestnumber());
		useroom.setSituation(true);
		RoomDAO.persist(useroom);
	}
	
	public void cleanRoom(Room room,int id) {
		Room useroom = RoomDAO.findbyId(id);
		useroom.setName("");
		useroom.setPeople(5);
		useroom.setGuestnumber(0);
		useroom.setSituation(false);
		RoomDAO.persist(useroom);
		
	}
}
