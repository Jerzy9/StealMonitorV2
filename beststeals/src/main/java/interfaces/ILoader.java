package interfaces;

import java.io.IOException;
import java.util.ArrayList;

public interface ILoader {

	public ArrayList<IProduct> getProducts(String url, String divClassName) throws IOException;
	
}