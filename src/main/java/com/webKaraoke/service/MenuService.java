package com.webKaraoke.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webKaraoke.DAO.MenuDAO;
import com.webKaraoke.entities.Menu;


@Service
@Transactional
public class MenuService {
	@Autowired
	private MenuDAO menuDAO;
	
	public List<Menu> findAll(){
		return menuDAO.findAll();
	}
	public Menu findById(final int id) {
		return menuDAO.findById(id);
	}
	public void  addMenu(Menu menu) {
		//menu.setIdmenu(Integer.parseInt(null));
		menuDAO.persist(menu);
	}
	public void removeMenu(int id) {
		menuDAO.remove(menuDAO.findById(id));
	}
	public void updateMenu(Menu menu, int id) {
		Menu updatemenu = menuDAO.findById(id);
		updatemenu.setImgname(menu.getImgname());
		updatemenu.setName(menu.getName());
		updatemenu.setType(menu.getType());
		updatemenu.setPrice(menu.getPrice());
		menuDAO.persist(updatemenu);
	}
}
