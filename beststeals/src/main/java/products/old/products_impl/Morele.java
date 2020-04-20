package products.old.products_impl;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sun.org.apache.bcel.internal.generic.ReturnInstruction;

import products.Product;
import products.old.Scrapers;

public class Morele implements Scrapers {
	
	private String siteName;
	private String siteLink;
	private String name;
	private String newPrice;
	private String oldPrice;
	private String remaining;
	private String sold;
	private String img;
	
	public Morele() {
		try {
			scrap();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void scrap() throws IOException {
		Document doc = Jsoup.connect("https://www.morele.net").get();
    	Element hotShot = doc.getElementsByClass("home-sections-promotion").get(0);
		
		this.siteName = "morele.net";
    	this.siteLink = "https://www.morele.net";
    	this.name = hotShot.getElementsByClass("promo-box-name").get(0).text();
    	this.newPrice = hotShot.getElementsByClass("promo-box-new-price").get(0).text();
    	this.oldPrice = hotShot.getElementsByClass("promo-box-old-price").get(0).text();
    	this.remaining = hotShot.getElementsByClass("status-box-was").get(0).text();
    	this.sold = hotShot.getElementsByClass("status-box-expired").get(0).text();
    	Element image = hotShot.getElementsByTag("img").first();
    	this.img = image.absUrl("src");
    	
    	
    	remaining = substringNum(remaining);
    	sold = substringNum(sold);
	}
	
	private String substringNum(String text) {
    	return text.substring(10, text.length()-4);
    }

	public String getSiteName() {
		return this.siteName;
	}

	public String getSiteLink() {
		return this.siteLink;
	}

	public String getName() {
		return this.name;
	}

	public String getOldPrice() {
		return this.oldPrice;
	}

	public String getNewPrice() {
		return this.newPrice;
	}

	public String getRemaining() {
		return this.remaining;
	}

	public String getSold() {
		return this.sold;
	}

	public String getImage() {
		return this.img;
	}
	
}
