package stealer;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import interfaces.IProduct;
import interfaces.IScrapers;
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
		
		
		ArrayList<IProduct> products = new ArrayList<IProduct>();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main.jsp");
		mv.addObject("list", scrapers);
		
		return mv;
	}
	
}
