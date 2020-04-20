package products.DAO;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import products.Product;

public interface ProductDAO {
	public int save(Product product);
	public int update(Product product);
	public Product get(int id);
	public int delete(int id);
	public List getProducts();				// there should be List<Product> instead List

}
