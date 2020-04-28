package interfaces;

import java.util.ArrayList;

public interface ILoader {

	public ArrayList<IProduct> getProducts(String url, String divClassName, String classPath) throws Exception;
	
}
