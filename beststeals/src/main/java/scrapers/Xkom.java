package scrapers;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import interfaces.IScraper;

public class Xkom implements IScraper {
	
	private String siteLink;
	private String siteName;
	private String name;
	private String oldPrice, newPrice;
	private String remaining, sold;
	private String img;
	

	public Xkom() {
		try {
			scrap();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void scrap() throws IOException {
		this.siteLink = "https://www.x-kom.pl";
		this.siteName = "x-kom.pl";
		
		Document doc = Jsoup.connect(siteLink).get();	
		Element hotShot = doc.getElementById("hotShot");
		
		this.name = hotShot.getElementsByClass("product-name").text();
		this.oldPrice = hotShot.getElementsByClass("old-price").text();
		this.newPrice = hotShot.getElementsByClass("new-price").text();
		this.remaining = hotShot.getElementsByClass("gs-quantity").get(0).text();
		this.sold = hotShot.getElementsByClass("gs-quantity").get(1).text();
		Element image = hotShot.getElementsByClass("img-responsive").first();
    	this.img = image.absUrl("src");
		
		
	}

	public String getSiteName() {
		// TODO Auto-generated method stub
		return this.siteName;
	}

	public String getSiteLink() {
		// TODO Auto-generated method stub
		return this.siteLink;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	public String getOldPrice() {
		// TODO Auto-generated method stub
		return this.oldPrice;
	}

	public String getNewPrice() {
		// TODO Auto-generated method stub
		return this.newPrice;
	}

	public String getRemaining() {
		// TODO Auto-generated method stub
		return this.remaining;
	}

	public String getSold() {
		// TODO Auto-generated method stub
		return this.sold;
	}

	public String getImage() {
		// TODO Auto-generated method stub
		return this.img;
	}
}