package interfaces;

import java.awt.List;

public interface IProductDAO {
	public int save(IProduct product);
	public int update(IProduct product);
	public IProduct get(int id);
	public int delete(int id);
	public List getProducts();
}
