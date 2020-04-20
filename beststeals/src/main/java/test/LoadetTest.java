package test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import loaders.loaders_impl.LoaderImpl;
import products.Product;
import products.DAO.ProductDAO;
import products.DAO.DAO_impl.ProductDAOImpl;
import products.products_impl.MoreleHotShotProduct;
import products.products_impl.MoreleProduct;
import products.products_impl.XkomHotShotProduct;

public class LoadetTest {
	
	private DriverManagerDataSource dataSource;
	private ProductDAO dao;
	
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
	
	public void connectt() {

			dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName("com.mysql.jdbc.Driver");
			dataSource.setUrl("jdbc:mysql://localhost:3306/steal_monitor");
			dataSource.setUsername("root");
			dataSource.setPassword("kapiszony123");
			
			dao = new ProductDAOImpl(dataSource);
			Element el = null;
			try {
				Document document = Jsoup.connect("https://www.morele.net/alarmcenowy/").get();
				el = document.getElementsByClass("item").get(0);
			} catch (Exception e) {
				System.out.println("EXCEPTION TEST");
				el = null;
			}
		
			Product product = new MoreleProduct(el);
			if(product.scrap()) {
				checkVars(product);
			}
			int result = dao.save(product);
			
	}
	
	public void makeMorele() throws IOException {
		Document doc = Jsoup.connect("https://www.morele.net/alarmcenowy/").get();	
		Element el = doc.getElementsByClass("item").get(0);
		System.out.println(el);
		Product morele = new MoreleProduct(el);
		if(morele.scrap()) {
			System.out.println("return true morele");
			checkVars(morele);
		}
	}
	
	public void makeXkom() throws IOException {
		Document doc = Jsoup.connect("https://www.x-kom.pl").get();	
		Element hotShot = doc.getElementById("hotShot");
		
		Product product = new XkomHotShotProduct(hotShot);
		if(product.scrap()) {
			System.out.println("return true x-kom");
			checkVars(product);
		}
	}
	
	public void makeMainMorele() throws IOException {
		Document doc = Jsoup.connect("https://www.morele.net").get();
    	Element hotShot = doc.getElementsByClass("home-sections-promotion").get(0);
		System.out.println(hotShot);
		Product product = new MoreleHotShotProduct(hotShot);
		if(product.scrap()) {
			System.out.println("return true mainMorele");
			checkVars(product);
		}
	}
	
	public void checkVars(Product product) {
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
			connectt();
			
			
		} catch (Exception e) {
			System.out.println("Excepion");
		}
	}
}
