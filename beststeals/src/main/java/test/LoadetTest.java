package test;

import java.io.IOException;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import interfaces.IProduct;
import loaders.Loader;
import mysql.ProductDAO;
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
		connectt();
		try {	
			
		} catch (Exception e) {
			System.out.println("Exceeeeepion");
		}
	}
	
	public void connectt() {
		//Connection conn = null;
//		try {
//		    conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/test?" + "user=minty&password=greatsqldb");
//
//		} catch (SQLException ex) {
//		    // handle any errors
//		    System.out.println("SQLException: " + ex.getMessage());
//		    System.out.println("SQLState: " + ex.getSQLState());
//		    System.out.println("VendorError: " + ex.getErrorCode());
//		}
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
