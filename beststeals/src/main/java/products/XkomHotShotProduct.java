package products;

import org.jsoup.nodes.Element;

import interfaces.IProduct;
import scrapers.Scraper;

public class XkomHotShotProduct implements IProduct {
	private String siteLink;
	private String siteName;
	private String name;
	private String oldPrice, newPrice;
	private String remainingQuantity, limitQuantity;
	private String img;
	
	private Element hotShot;
	private Scraper scraper;
	
	public XkomHotShotProduct(Element el) {
		this.hotShot = el;
		scraper = new Scraper();
	}
	
	public boolean scrap() {
		try {
			this.siteName = "x-kom.pl";
			
			//We have to find a way to get this product's link!
			//this.siteLink = scraper.getLinkFromAHref(hotShot, 0);
			
			this.name = scraper.getStringByClass(hotShot, "product-name", 0);
			
			this.oldPrice = scraper.getStringByClass(hotShot, "old-price", 0);
			this.newPrice = scraper.getStringByClass(hotShot, "new-price", 0);
			
			this.remainingQuantity = scraper.getStringByClass(hotShot, "gs-quantity", 0);
			this.limitQuantity = scraper.getStringByClass(hotShot, "gs-quantity", 0);
			
			img = scraper.getStringImageByClass(hotShot, "img-responsive", 0);
	    	
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

	public String getCategory() {
		// TODO Auto-generated method stub
		return null;
	}
}