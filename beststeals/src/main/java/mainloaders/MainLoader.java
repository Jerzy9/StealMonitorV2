package mainloaders;

import java.util.ArrayList;

import interfaces.IProduct;
import loaders.Loader;

public class MainLoader {

	Loader loader = new Loader();
	ArrayList<IProduct> allProducts = new ArrayList<IProduct>();
	
	ArrayList<String> urls = new ArrayList<String>();
	ArrayList<String> classNames = new ArrayList<String>();
	ArrayList<String> paths = new ArrayList<String>();
	
	public ArrayList<IProduct> getAllProducts() throws Exception {
		importInfo();
		
		ArrayList<IProduct> loaderProducts = new ArrayList<IProduct>();
		
		for (int i = 0; i < urls.size(); i++) {
			loaderProducts = loader.getProducts(urls.get(i), classNames.get(i), paths.get(i));
			allProducts.addAll(loaderProducts);
		}
		
		return allProducts;
	}
	
	private void importInfo() {
		// xkom hotshot
		urls.add("https://www.x-kom.pl/");
		classNames.add("hot-shot");
		paths.add("products.XkomHotShotProduct");
		
		// morele hotshot
		urls.add("https://www.morele.net/");
		classNames.add("prom-box-content");
		paths.add("products.MoreleHotShotProduct");
		
		//morele alarm cenowy
		urls.add("https://www.morele.net/alarmcenowy/");
		classNames.add("owl-item");
		paths.add("products.MoreleProduct");
	}
	
	
}