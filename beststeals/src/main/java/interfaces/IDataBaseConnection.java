package interfaces;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public interface IDataBaseConnection {

	public DriverManagerDataSource connect() throws Exception;
	
}
