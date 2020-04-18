package stealer;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import interfaces.IProduct;
import interfaces.IScrapers;
import loaders.Loader;
import products.XkomHotShotProduct;
import products.old.Morele;
import products.old.Xkom;

@Controller
public class HomeController {

	@RequestMapping("/")
	public ModelAndView home() {

//		ArrayList<IScrapers> scrapers = new ArrayList<IScrapers>();
//		scrapers.add(new Xkom());
//		scrapers.add(new Morele());
		
		
		Loader loader = new Loader();
		
		ArrayList<IProduct> products = new ArrayList<IProduct>();
		try {
			products = loader.getProducts("https://www.morele.net/", "home-sections-promotion");
		} catch (IOException e) {
			//
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main.jsp");
		//mv.addObject("list", scrapers);
		mv.addObject("list", products);
		
		return mv;
	}
	
}
