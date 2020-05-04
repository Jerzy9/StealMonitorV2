package interfaces;

import java.util.List;

public interface IProductDAO {
	public int save(IProduct product);
	public int saveHot(IProduct p);
	public int update(IProduct product);
	public IProduct get(int id);
	public int delete(int id);
	public List<IProduct> getProducts();
	public List<IProduct> getHotProducts();
}
