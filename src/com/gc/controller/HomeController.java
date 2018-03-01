package com.gc.controller;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gc.model.Items;
import com.gc.util.HibernateUtil;

/*
 * author: Nick Soule
 *
 */

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public ModelAndView showIndex() {
		return new ModelAndView("index", "", "");
	}

	@RequestMapping("/welcome")
	// listing all the data from the product class
	public ModelAndView helloWorld(Model model) {

		ArrayList<Items> prodList = listProducts();

		return new ModelAndView("welcome", "pList", prodList);
	}

	public ArrayList<Items> listProducts() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();
		// the transaction represents the unit of work/actual implementation of code
		Transaction tx = session.beginTransaction();
		Criteria crit = session.createCriteria(Items.class);
		ArrayList<Items> prodList = (ArrayList<Items>)crit.list();

		// creates an EL to be used in the jsp page
		// model.addAttribute("specificItem", prodList.get(2).getDescription());
		tx.commit();
		session.close();
		return prodList;
	}

	@RequestMapping("/addprodsuccess")
	public ModelAndView addProd() {
		return new ModelAndView("addprodsuccess", "", "");
	}
	
	@RequestMapping("/addproduct")
	public ModelAndView addProduct(@RequestParam("name") String name, @RequestParam("description") String description,
			@RequestParam("quantity") int quantity, @RequestParam("price") double price) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		Items newProd = new Items();
		newProd.setName(name);
		newProd.setDescription(description);
		newProd.setQuantity(quantity);
		newProd.setPrice(price);

		session.save(newProd);

		tx.commit();
		session.close();
		
		ArrayList<Items> prodList = listProducts();
		
		return new ModelAndView("welcome","pList",prodList);
	}

	@RequestMapping("/delete")
	public ModelAndView deleteProduct(@RequestParam("name") String name) {
		// temp object will store info for the object to be deleted
		Items temp = new Items();
		temp.setName(name);

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		session.delete(temp);

		tx.commit();
		session.close();

		ArrayList<Items> prodList = listProducts();

		return new ModelAndView("welcome", "pList", prodList);

	}

	// Adding in the RequestParam to send it to the form and add it as a hidden view
	@RequestMapping("/update")
	public ModelAndView updateForm(@RequestParam("name") String name) {
		

		return new ModelAndView("updateproductform", "productID", name);
	}

	@RequestMapping("/updateproduct")
	public ModelAndView updateProduct(@RequestParam("name") String name,
			@RequestParam("description") String description, @RequestParam("quantity") int quantity,
			@RequestParam("price") double price) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		Items updateProduct = new Items();
		updateProduct.setName(name);
		updateProduct.setDescription(description);
		updateProduct.setQuantity(quantity);
		updateProduct.setPrice(price);

		session.update(updateProduct);

		tx.commit();
		session.close();
		
		ArrayList<Items> prodList = listProducts();
		return new ModelAndView("welcome", "pList", prodList);
	}

}
