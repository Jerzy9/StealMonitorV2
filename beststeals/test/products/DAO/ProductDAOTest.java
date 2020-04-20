package products.DAO;

import static org.junit.jupiter.api.Assertions.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import jdk.internal.org.objectweb.asm.tree.analysis.SourceInterpreter;
import products.Product;
import products.DAO.DAO_impl.ProductDAOImpl;
import products.products_impl.MoreleProduct;

class ProductDAOTest {
	
	private DriverManagerDataSource dataSource;
	private ProductDAO dao;

	@Test
	void testSave() {
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
		int result = dao.save(product);
		
		assertTrue(result>0);
	}

	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	void testGet() {
		fail("Not yet implemented");
	}

	@Test
	void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	void testGetProducts() {
		fail("Not yet implemented");
	}

}
