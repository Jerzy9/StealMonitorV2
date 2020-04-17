package loaders;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import interfaces.ILoader;
import interfaces.IProduct;
import products.MoreleProduct;


/* 
 * This class is responsible for loading all desirable divs on morele.net page,
 * also it can be scaled for almost all promotion subpages on foregoing site 
 * */

public class MoreleLoader implements ILoader {

	public ArrayList<IProduct> getProducts(String url) throws IOException {
		
		ArrayList<IProduct> products = new ArrayList<IProduct>();
		Document document = Jsoup.connect(url).get();
		Elements productDivs = document.getElementsByClass("owl-item");
		
		for (Element element : productDivs) {
			MoreleProduct moreleProduct = new MoreleProduct(element);
			if (moreleProduct.scrap()) products.add(moreleProduct);
		}
		
		return products;
	}
	
}
