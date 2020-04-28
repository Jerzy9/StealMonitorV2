package interfaces;

import java.util.ArrayList;

public interface IMainLoader {

	public ArrayList<IProduct> getAllProducts() throws Exception;
	public ArrayList<IProduct> getHotProducts() throws Exception;
	
}
