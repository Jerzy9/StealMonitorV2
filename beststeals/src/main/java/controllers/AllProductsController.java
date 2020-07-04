package controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import config.AppConfig;
import interfaces.IProduct;
import interfaces.IProductDAO;
import mainloaders.MainLoader;
import mysql.ProductDAO;

@Controller
public class AllProductsController {
	
	ApplicationContext factory =  new AnnotationConfigApplicationContext(AppConfig.class);
	IProductDAO productDAO = factory.getBean(ProductDAO.class);
	
	@RequestMapping("/all")
	public ModelAndView home() {
		
		List<IProduct> products = new ArrayList<IProduct>();
		try {
			products = productDAO.getProducts();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("all_products.jsp");
		mv.addObject("list", products);
		
		return mv;
	}
}