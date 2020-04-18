package loaders;

import java.io.IOException;
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
			// do zmiany na beany
			if (url.equals("https://www.morele.net/alarmcenowy/")) product = new MoreleProduct(element);
			if (url.equals("https://www.morele.net/")) product = new MoreleHotShotProduct(element);
			else product = new XkomHotShotProduct(element);
			
			if (product.scrap()) products.add(product);
			System.out.println("image: " + product.getImage());
		} 
		return products;
	}
	
}
