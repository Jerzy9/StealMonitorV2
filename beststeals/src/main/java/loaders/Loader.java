package loaders;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import interfaces.ILoader;
import interfaces.IProduct;
import products.MoreleHotShotProduct;
import products.MoreleProduct;
import products.XkomHotShotProduct;


/* 
 * This class is responsible for loading all desirable elements on pages,
 * and creating list of products that have been scanned
 * 
 * */

public class Loader implements ILoader {

	public ArrayList<IProduct> getProducts(String url, String divClassName) throws IOException {
		
		ArrayList<IProduct> products = new ArrayList<IProduct>();
		Document document = Jsoup.connect(url).get();
		Elements productDivs = document.getElementsByClass(divClassName);
		IProduct product;
		
		
		for (Element element : productDivs) {
			try {
			Class<?> c = Class.forName("products.MoreleProduct");
			Constructor<?> cons = c.getConstructor(Element.class);
			Object object = cons.newInstance(element);
			product = (IProduct) object;
			if (product.scrap()) products.add(product);
			} catch (Exception e) {
				//
			}
			
		} 
		return products;
	}
	
}
