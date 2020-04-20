package configs;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import products.old.Scrapers;
import products.old.scrapers_impl.Morele;
import products.old.scrapers_impl.Xkom;

@Controller
public class HomeController {

	@RequestMapping("/")
	public ModelAndView home() {

		ArrayList<Scrapers> scrapers = new ArrayList<Scrapers>();
		scrapers.add(new Xkom());
		scrapers.add(new Morele());
		
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main.jsp");
		mv.addObject("list", scrapers);
		
		return mv;
	}
	
}
