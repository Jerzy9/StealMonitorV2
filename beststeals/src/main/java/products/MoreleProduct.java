package products;

import org.jsoup.nodes.Element;

import interfaces.IProduct;
import scrapers.Scraper;

public class MoreleProduct implements IProduct {
	
	private String siteLink;
	private String siteName;
	private String name;
	private String oldPrice, newPrice;
	private String remainingQuantity, limitQuantity;
	private String img;
	
	private Element hotShot;
	private Scraper scraper;
	

	public MoreleProduct(Element el) {
		this.hotShot = el;
		scraper = new Scraper();
	}
	
	public boolean scrap() {
		try {
			this.siteName = "morele.net";
			this.siteLink = scraper.getLinkFromAHref(hotShot, 0);
			
			this.name = scraper.getStringByClass(hotShot, "product-slider-name", 0);
		
			this.oldPrice = scraper.getStringByClass(hotShot, "price-old", 0);
			this.newPrice = scraper.getStringByClass(hotShot, "product-slider-price text-right", 0);
			this.newPrice = scraper.substringNum(newPrice, newPrice.length()/2+1, newPrice.length());
			
			this.remainingQuantity = scraper.getStringByClass(hotShot, "was_quantity", 0);
			this.limitQuantity =  scraper.getStringByClass(hotShot, "limit_quantity", 0);
			
			img = null;
	    	
			return true;
		} catch (Exception e) {
			System.out.println("Scrap Exception in " + siteName);
			return false;
		}
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

	public String getRemainingQuantity() {
		return this.remainingQuantity;
	}

	public String getLimitQuantity() {
		return this.limitQuantity;
	}

	public String getImage() {
		return this.img;
	}
}