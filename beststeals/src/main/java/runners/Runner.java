package runners;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppConfig;
import interfaces.IDataBaseConnection;
import interfaces.IMainLoader;
import interfaces.IProduct;
import interfaces.IProductDAO;
import mainloaders.MainLoader;
import mysql.ProductDAO;

public class Runner {
	
	ApplicationContext factory;

	IProductDAO productDAO;
	IMainLoader mainLoader;
	
	ArrayList<IProduct> allProducts;
	ArrayList<IProduct> hotProducts;
	
	public Runner() {
		
		factory =  new AnnotationConfigApplicationContext(AppConfig.class);
		productDAO = factory.getBean(ProductDAO.class);
		mainLoader = factory.getBean(MainLoader.class);
		
	}
	
	public void loadAllProductsToDB() {
		try {
			allProducts = mainLoader.getAllProducts();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception in Runner with mainLoader.getAllProducts");
		}
		for (IProduct product : allProducts) {
			productDAO.save(product);
			// it gives "blank category" to data base instead instead of normal category, it will change in the future
		}
	}
	
	public void loadHotProductsToDB() {
		try {
			hotProducts = mainLoader.getHotProducts();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("TEMP ERROR");
		}
		for (IProduct product : hotProducts) {
			productDAO.saveHot(product);
			// it gives "blank category" to data base instead instead of normal category, it will change in the future
		}
	}
	
	

}
