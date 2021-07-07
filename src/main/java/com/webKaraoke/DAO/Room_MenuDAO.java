package com.webKaraoke.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.webKaraoke.entities.Room_Menu;

@Repository(value = "room_menuDAO")

@Transactional(rollbackFor = Exception.class)
public class Room_MenuDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(final Room_Menu room_menu) {
		entityManager.persist(room_menu);
	}

	public void remove(final Room_Menu room_menu) {
		entityManager.remove(room_menu);
	}

	public List<Room_Menu> findAll() {

		List<Room_Menu> room_menu = entityManager.createQuery(" from Room_Menu", Room_Menu.class).getResultList();

		return room_menu;
	}
	public Room_Menu findById(int id) {
		return entityManager.find(Room_Menu.class, id);
	}
	
	public List<Room_Menu> findByIdroom(int id){
		
		return entityManager.createQuery("from Room_Menu where Idroom = '"+id+"'", Room_Menu.class).getResultList();
		
	}
}
