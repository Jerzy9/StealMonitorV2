package test;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import interfaces.IProduct;
import loaders.Loader;
import products.MoreleProduct;
import products.MoreleHotShotProduct;
import products.XkomHotShotProduct;

public class LoadetTest {
	
	public static void main(String[] args) {
		
//		Loader ml = new Loader();
//		ArrayList<IProduct> products = new ArrayList<IProduct>();
//		try {
//			products = ml.getProducts("https://www.x-kom.pl/", "hot-shot", "products.XkomHotShotProduct");
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//
//		for (IProduct p : products) {
//			System.out.println(p.getName());
//		}
		
		new LoadetTest();
		
	}
	
	public void makeMorele() throws IOException {
		Document doc = Jsoup.connect("https://www.morele.net/alarmcenowy/").get();	
		Element el = doc.getElementsByClass("item").get(0);
		System.out.println(el);
		IProduct morele = new MoreleProduct(el);
		if(morele.scrap()) {
			System.out.println("return true morele");
			checkVars(morele);
		}
	}
	
	public void makeXkom() throws IOException {
		Document doc = Jsoup.connect("https://www.x-kom.pl").get();	
		Element hotShot = doc.getElementById("hotShot");
		
		IProduct product = new XkomHotShotProduct(hotShot);
		if(product.scrap()) {
			System.out.println("return true x-kom");
			checkVars(product);
		}
	}
	
	public void makeMainMorele() throws IOException {
		Document doc = Jsoup.connect("https://www.morele.net").get();
    	Element hotShot = doc.getElementsByClass("home-sections-promotion").get(0);
		System.out.println(hotShot);
		IProduct product = new MoreleHotShotProduct(hotShot);
		if(product.scrap()) {
			System.out.println("return true mainMorele");
			checkVars(product);
		}
	}
	
	public void checkVars(IProduct product) {
		System.out.println(product.getName());
		System.out.println(product.getNewPrice());
		System.out.println(product.getOldPrice());
		System.out.println(product.getRemainingQuantity());
		System.out.println(product.getLimitQuantity());
		System.out.println(product.getSiteLink());
		System.out.println(product.getSiteName());
		System.out.println(product.getImage());
	}
	
	public LoadetTest() {
		try {	
			//makeMorele();
			makeMorele();
			
			
		} catch (Exception e) {
			System.out.println("Excepion");
		}
	}
}
