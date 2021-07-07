package com.webKaraoke.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.webKaraoke.entities.Menu;


@Repository(value = "menuDAO")

@Transactional(rollbackFor = Exception.class)
public class MenuDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	public void persist(final Menu menu) {
		
		entityManager.persist(menu);
	
	}

	public void remove(final Menu menu) {
		entityManager.remove(menu);
	}
	
	public List<Menu> findAll() {
		
		List<Menu> menu = entityManager.createQuery(" from Menu", Menu.class).getResultList();
		
	    return menu;
	    
	}
	public Menu findById(int id) {
		return entityManager.find(Menu.class, id);
	}
}
