package controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import runners.Runner;

@Controller
public class HomeController {
	
	ApplicationContext factory =  new AnnotationConfigApplicationContext(AppConfig.class);
	IProductDAO productDAO = factory.getBean(ProductDAO.class);

	@RequestMapping("/")
	public ModelAndView home() {

		//MainLoader ml = new MainLoader();
		         
		List<IProduct> products = new ArrayList<IProduct>();
		try {
			products = productDAO.getHotProducts();

			//products = ml.getHotProducts();
			//this won't work, because if you want to use @Autowired, 
			//you have to use it everywhere, so you can't just create there "new MainLoader"
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Home Controller get hot prodcuts excepion");
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main.jsp");
		mv.addObject("list", products);
		
		return mv;
	}
	
}
