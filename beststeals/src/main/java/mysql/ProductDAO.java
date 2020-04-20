package mysql;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import interfaces.IProduct;

public class ProductDAO {
	private JdbcTemplate jdbcTemplate;
	
	public ProductDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public int save(IProduct p) {
		String sql = "INSERT INTO products (name, site_name, site_link, old_price, new_price, remaining_quantity, limit_quantity, img_string, category) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		return jdbcTemplate.update(sql, p.getName(), p.getSiteName(), p.getSiteLink(), p.getOldPrice(), p.getNewPrice(), p.getRemainingQuantity(), p.getLimitQuantity(), p.getImage(), p.getCategory());
	}

	public int update(IProduct product) {
		// TODO Auto-generated method stub
		return 0;
	}

	public IProduct get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List getProducts() {
		// TODO Auto-generated method stub
		return null;
	}
}
