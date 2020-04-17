package interfaces;

import java.io.IOException;

/*This is old version of Product*/

public interface IScrapers {
	
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