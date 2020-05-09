package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import interfaces.IDataBaseConnection;
import loaders.Loader;
import mainloaders.MainLoader;
import mysql.Connection;
import mysql.ProductDAO;

@Configuration
@ComponentScan({"scrapers", "mysql", "mainloaders", "loaders"})
public class AppConfig {

	@Bean
    public ProductDAO productDAO() {
		// class Connection creates DataSource and gives it to the constructor's ProductDao
		// and this bean return new ProductDao
		IDataBaseConnection connection = new Connection();
        try {
			return new ProductDAO(connection.connect());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception in AppConfig with connection");
			return null;
			
		}
    }
	
	@Bean
	public Loader loader() {
		return new Loader();
	}
	
	@Bean
	public MainLoader mainLoader() {
		return new MainLoader();
	}
}
