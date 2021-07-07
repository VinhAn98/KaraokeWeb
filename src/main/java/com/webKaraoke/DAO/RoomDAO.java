package com.webKaraoke.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.webKaraoke.entities.Room;

@Repository(value = "roomDAO")

@Transactional(rollbackFor = Exception.class)
public class RoomDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(final Room room) {
		entityManager.persist(room);
	}

	public void remove(final Room room) {
		entityManager.remove(room);
	}
	public List<Room> findAll() {
		
		List<Room> room = entityManager.createQuery(" from Room", Room.class).getResultList();
		
	    return room;  
	}
	public Room findbyId(int id) {
		String  sql = "SELECT * from room WHERE id = ?";
		return entityManager.find(Room.class, id);
	}
}
