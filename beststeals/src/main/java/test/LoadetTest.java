package test;

import java.io.IOException;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import config.AppConfig;
import interfaces.IProduct;
import loaders.Loader;
import mysql.ProductDAO;
import products.MoreleHotShotProduct;
import products.MoreleProduct;
import products.Scraper;
import products.XkomHotShotProduct;

public class LoadetTest {
	
	
	
	public static void main(String[] args) {
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
		//connectt();
//		try {	
//			
//		} catch (Exception e) {
//			System.out.println("Exceeeeepion");
//		}
		ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);
//		MoreleProduct mr = factory.getBean(MoreleProduct.class);
//		//mr.scrap();
//		checkVars(mr);
		Scraper scraper = factory.getBean(Scraper.class);
		String num = scraper.addTwoNumbersInString("3", "3");
		System.out.println(num);
	}
	
	public void connectt() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/steal_monitor?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
		dataSource.setUsername("root");
		dataSource.setPassword("kapiszony123");
		
		ProductDAO dao = new ProductDAO(dataSource);
		Element el = null;
		try {
			Document document = Jsoup.connect("https://www.morele.net/alarmcenowy/").get();
			el = document.getElementsByClass("item").get(0);
		} catch (Exception e) {
			System.out.println("EXCEPTION TEST");
			el = null;
		}
	
		IProduct product = new MoreleProduct(el);
		if(product.scrap()) {
			checkVars(product);
			System.out.println("trueeeeeeee");
		}
		//dao.save(product);
		//product.setRemainingQuantity("69");
		List<IProduct> list = dao.getProducts();
		
		for(int i = 0; i < list.size(); i ++) {
			System.out.println(list.get(i).getRemainingQuantity());
		}
	}
}
