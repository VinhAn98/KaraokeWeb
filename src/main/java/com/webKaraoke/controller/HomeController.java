package com.webKaraoke.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import com.webKaraoke.entities.Menu;
import com.webKaraoke.entities.Room;
import com.webKaraoke.entities.Room_Menu;
import com.webKaraoke.service.MenuService;
import com.webKaraoke.service.RoomService;
import com.webKaraoke.service.Room_MenuService;

@Controller
@Transactional
public class HomeController {
	@Autowired
	private RoomService roomService;
	@Autowired
	private MenuService menuService;
	@Autowired
	private Room_MenuService room_menuService;

	/*
	 * @RequestMapping(value= {"/","/index"}) public String listRoom(Model model)
	 * throws Exception { if(!roomService.findAll().isEmpty()) {
	 * System.out.print("something"); } //System.out.print("hello world");
	 * model.addAttribute("listroom", roomService.findAll()); return "index"; }
	 */
	@RequestMapping(value = { "/", "/index" })
	public String listroom(Model model) {
		/*
		 * if(!roomService.findAll().isEmpty()) { List<Room> room =
		 * roomService.findAll() ; for (Room room2 : room) {
		 * System.out.println(room2.getIdroom()); } }
		 */
		List<Room> room = roomService.findAll();
		model.addAttribute("listroom", room);
		// System.out.println( roomService.findAll()+ "thong tin");
		return "index";
	}

	@RequestMapping("/menu")
	public String menudisplay(Model model) {
		/*
		 * if(!menuService.findAll().isEmpty()) { List<Menu> menu =
		 * menuService.findAll() ; for (Menu menu2 : menu) {
		 * System.out.println(menu2.getIdmenu()); } }
		 */
		List<Menu> menu = menuService.findAll();
		model.addAttribute("listmenu", menu);

		return "menu";
	}

	@RequestMapping(value = "/addMenu")
	public String addMenuForm(Model model) {
		Menu newMenu = new Menu();
		model.addAttribute("newMenu", newMenu);

		// menuService.addMenu();
		return "menu-detail";
	}

	@RequestMapping(value = { "/saveMenu" }, method = RequestMethod.POST)
	public String saveMenu(Model model, @ModelAttribute("newMenu") Menu newMenu, BindingResult result) {
		if (result.hasErrors()) {
			return "error";
		}

		menuService.addMenu(newMenu);

		model.addAttribute("listmenu", menuService.findAll());

		// menuService.addMenu();
		return "redirect:/menu";
	}

	@RequestMapping(value = { "/changeMenu/saveMenu/{id}" }, method = RequestMethod.POST)
	public String updateMenu(Model model, @ModelAttribute("newMenu") Menu menu, @PathVariable int id) {

		System.out.println(menu.getType());
		System.out.println(menu.getName());
		System.out.println(menu.getIdmenu());
		menuService.updateMenu(menu, id);

		model.addAttribute("listmenu", menuService.findAll());

		// menuService.addMenu();
		return "redirect:/menu";
	}

	@RequestMapping(value = { "/deleteMenu/{id}" })
	public String deleteMenu(Model model, @PathVariable int id) {
		menuService.removeMenu(id);
		model.addAttribute("listmenu", menuService.findAll());
		return "redirect:/menu";
	}

	@RequestMapping(value = { "/changeMenu/{id}" })
	public String changeMenu(Model model, @PathVariable int id) {
		Menu menu = menuService.findById(id);
		model.addAttribute("newMenu", menu);
		return "menu-detail";
	}

	@RequestMapping(value = "useroom/room/{id}", method = RequestMethod.POST)
	public String roomdisplay(Model model, @PathVariable int id, @ModelAttribute("inforoom") Room room) {

		// Room_Menu order = room_menuService.findById(id);

		List<Room_Menu> ordered = room_menuService.findByIdroom(id);
		int total_price = 0;
		if (!room_menuService.findAll().isEmpty()) {
		
			for (Room_Menu temp : ordered) {
				total_price  += temp.getTotal_price();
			}
		}

		// room.setSituation(true);
		Room roomUSE = roomService.findById(id);
		roomService.useRoom(room, id);
		System.out.println(roomUSE.getIdroom());
		model.addAttribute("listorder", ordered);
		model.addAttribute("inforoom", room);
		model.addAttribute("IdroomUSE", roomUSE.getIdroom());
		model.addAttribute("total_Price", total_price);
		return "room";
	}

	@RequestMapping(value = "/useroom/{id}")
	public String useRoom(Model model, @PathVariable int id) {
		Room room = roomService.findById(id);

		// System.out.print(room.getIdroom());
		// System.out.print(room.getName());
		model.addAttribute("inforoom", room);
		return "add-room";
	}

	@RequestMapping(value = "/useroom/room/orderFood/{id}")
	public String orderFood(Model model, @PathVariable int id) {
		Room roomUSE = roomService.findById(id);
		model.addAttribute("IdroomUSE", roomUSE.getIdroom());
		model.addAttribute("listmenu", menuService.findAll());
		return "order-food";
	}

	@RequestMapping(value = "/useroom/room/orderFood/orderForm/{idr}/{idm}")
	public String orderForm(Model model, @PathVariable int idr, @PathVariable int idm) {
		Room roomUSE = roomService.findById(idr);
		model.addAttribute("IdroomUSE", roomUSE.getIdroom()); // add id room to jsp

		Menu menuUse = menuService.findById(idm);
		model.addAttribute("IdmenuUSE", menuUse.getIdmenu()); // add id menu to jsp

		Room_Menu orderedFood = new Room_Menu();
		model.addAttribute("orderedFood", orderedFood); // add room_menu
		return "order-view";
	}

	@RequestMapping(value = "/useroom/room/orderFood/orderForm/{id}/saveOrder/{id}", method = RequestMethod.POST)
	public String saveOrder(Model model, @PathVariable int id, @ModelAttribute("orderedFood") Room_Menu orderedFood) {
		// logic save to room_order_list to show order

		System.out.println(orderedFood.getIdmenu());
		System.out.println(orderedFood.getIdroom());
		System.out.println(orderedFood.getNumber());
		System.out.println(orderedFood.getTime_order());
		System.out.println(orderedFood.getTotal_price());
		room_menuService.addOrder(orderedFood);
		return "redirect:/useroom/room/orderFood/{id}";
	}

	@RequestMapping(value = "useroom/room/{id}/payRoom")
	public String payRoom(Model model, @PathVariable int id) {
		//List<Room_Menu> orderedUse = room_menuService.findByIdroom(id);
		Room roomUSE = roomService.findById(id);
		System.out.println("pay thanh cong");
		roomService.cleanRoom(roomUSE, id);
		room_menuService.clearOder(id);
		return "redirect:/index";
	}

}
