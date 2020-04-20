package controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import interfaces.IProduct;
import mainloaders.MainLoader;

@Controller
public class HomeController {

	@RequestMapping("/")
	public ModelAndView home() {

		MainLoader ml = new MainLoader();
		
		ArrayList<IProduct> products = new ArrayList<IProduct>();
		try {
			products = ml.getAllProducts();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main.jsp");
		mv.addObject("list", products);
		
		return mv;
	}
	
}
