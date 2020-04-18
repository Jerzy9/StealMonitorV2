package loaders;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import interfaces.IProduct;

public class Loader {

	public ArrayList<IProduct> getProducts(String url, String divClassName, String classPath) throws Exception {
		
		ArrayList<IProduct> products = new ArrayList<IProduct>();
		Document document = Jsoup.connect(url).get();
		Elements productDivs = document.getElementsByClass(divClassName);
		IProduct product;
		
		
		for (Element element : productDivs) {

			Class<?> c = Class.forName(classPath);
			Constructor<?> cons = c.getConstructor(Element.class);
			product = (IProduct) cons.newInstance(element);
			
			if (product.scrap()) products.add(product);
		} 
		return products;
	}
	
}
