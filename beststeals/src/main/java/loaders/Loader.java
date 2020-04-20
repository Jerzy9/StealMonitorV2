package loaders;

import java.util.ArrayList;

import products.Product;

public interface Loader {

	public ArrayList<Product> getProducts(String url, String divClassName, String classPath) throws Exception;
	
}
