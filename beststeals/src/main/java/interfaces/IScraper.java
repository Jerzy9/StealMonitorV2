package interfaces;

import java.io.IOException;

public interface IScraper {
	
	public void scrap() throws IOException;
	public String getSiteName(); 
	public String getSiteLink();
	public String getName();
	public String getOldPrice();
	public String getNewPrice();
	public String getRemaining();
	public String getSold();
	public String getImage();
	
}
