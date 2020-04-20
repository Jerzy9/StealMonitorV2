package loaders;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import products.Product;

public class Loader {

	public ArrayList<Product> getProducts(String url, String divClassName, String classPath) throws Exception {
		
		ArrayList<Product> products = new ArrayList<Product>();
		Document document = Jsoup.connect(url).get();
		Elements productDivs = document.getElementsByClass(divClassName);
		Product product;
		
		
		for (Element element : productDivs) {

			Class<?> c = Class.forName(classPath);
			Constructor<?> cons = c.getConstructor(Element.class);
			product = (Product) cons.newInstance(element);
			
			if (product.scrap()) products.add(product);
		} 
		return products;
	}
	
}
