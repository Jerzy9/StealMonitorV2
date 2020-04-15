package scrapers;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import interfaces.IScraper;

public class Xkom implements IScraper {
	
	private String siteLink;
	private String siteName;
	public String name;
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
		
		this.name = getStringByClass(hotShot, "product-name", 0);
		this.oldPrice = getStringByClass(hotShot, "old-price", 0);
		this.newPrice = getStringByClass(hotShot, "new-price", 0);
		this.remaining = getStringByClass(hotShot, "gs-quantity", 0);
		this.sold = getStringByClass(hotShot, "gs-quantity", 0);
		
		Element image = hotShot.getElementsByClass("img-responsive").first();
    	this.img = image.absUrl("src");
		
		
	}
	
	private String getStringByClass(Element el, String className, int index) {
		String str;
		try {
			str = el.getElementsByClass(className).get(index).text();
		} catch (Exception e) {
			System.out.println("NIE ZNALAZLO WARTOSCI");
			str = "NIE ZNALAZLO WARTOSCI w klasie: " + className;
		}
		return str;
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