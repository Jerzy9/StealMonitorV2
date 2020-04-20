package products.old.scrapers_impl;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import products.Product;
import products.old.Scrapers;
import scrapers.Scraper;

public class Xkom implements Scrapers {
	
	private String siteLink;
	private String siteName;
	private String name;
	private String oldPrice, newPrice;
	private String remaining = "0", sold;
	private String img;
	
	private Element el;
	private Scraper scraper;
	

	public Xkom() {
		scraper = new Scraper();
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
		
		this.name = scraper.getStringByClass(hotShot, "product-name", 0);
		this.oldPrice = scraper.getStringByClass(hotShot, "old-price", 0);
		this.newPrice = scraper.getStringByClass(hotShot, "new-price", 0);
		this.remaining = scraper.getStringByClass(hotShot, "gs-quantity", 0);
		this.sold = scraper.getStringByClass(hotShot, "gs-quantity", 0);
		
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