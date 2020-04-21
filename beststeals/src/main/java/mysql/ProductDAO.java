package mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import interfaces.IProduct;
import products.DataBaseProduct;

public class ProductDAO {
	private JdbcTemplate jdbcTemplate;
	
	public ProductDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public int save(IProduct p) {
		String sql = "INSERT INTO products (name, site_name, site_link, old_price, new_price, "
					+ "remaining_quantity, limit_quantity, img_string, category) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		return jdbcTemplate.update(sql, p.getName(), p.getSiteName(), p.getSiteLink(), p.getOldPrice(), 
										p.getNewPrice(), p.getRemainingQuantity(), p.getLimitQuantity(), p.getImage(), p.getCategory());
	}

	public int update(IProduct product) {
		String sql = "UPDATE products SET remaining_quantity=? WHERE product_id =?";
		return jdbcTemplate.update(sql, product.getRemainingQuantity(), product.getId());
	}

	public IProduct get(int id) {
//		String sql = "SELECT * FROM products WHERE product_id=" + id;
//		
//		ResultSetExtractor<IProduct> extractor = new ResultSetExtractor<IProduct>() {
//
//			public IProduct extractData(ResultSet rs) throws SQLException, DataAccessException {
//				if(rs.next()) {
//					String name = rs.getString("name");
//					String site_name = rs.getString("site_name");
//					String site_link = rs.getString("site_link");
//					String old_price = rs.getString("old_price");
//					String new_price = rs.getString("new_price");
//					String remaining_quantity = rs.getString("remaining_quantity");
//					String limit_quantity = rs.getString("limit_quantity");
//					String img_string = rs.getString("img_string");
//					String category = rs.getString("category");
//					
//					S
//					//return new 
//				}
//				return null;
//			}
//		};
		
		return null;
	}

	public int delete(int id) {
		String sql = "DELETE FROM products WHERE product_id=" + id;
		return jdbcTemplate.update(sql);
	}

	public List<IProduct> getProducts() {
		String sql = "SELECT * FROM products";
		
		RowMapper rowMapper = new RowMapper<IProduct>() {

			public IProduct mapRow(ResultSet rs, int rowNum) throws SQLException {
				int id = rs.getInt("product_id");
				String name = rs.getString("name");
				String site_name = rs.getString("site_name");
				String site_link = rs.getString("site_link");
				String old_price = rs.getString("old_price");
				String new_price = rs.getString("name");
				String remaining_quantity = rs.getString("remaining_quantity");
				String limit_quantity = rs.getString("limit_quantity");
				String img_string = rs.getString("img_string");
				String category = rs.getString("category");
				
				return new DataBaseProduct(id, site_link, site_name, name, old_price, new_price, remaining_quantity, limit_quantity, img_string, category);
			}
		};
		
		return jdbcTemplate.query(sql, rowMapper);
	}
}
