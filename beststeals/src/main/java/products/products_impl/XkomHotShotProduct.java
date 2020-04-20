package products.products_impl;

import org.jsoup.nodes.Element;

import products.Product;
import scrapers.scrapers_impl.ScraperImpl;

public class XkomHotShotProduct implements Product {
	private String siteLink;
	private String siteName;
	private String name;
	private String oldPrice, newPrice;
	private String remainingQuantity, limitQuantity;
	private String img;
	private String category;
	
	private Element hotShot;
	private ScraperImpl scraper;
	
	public XkomHotShotProduct(Element el) {
		this.hotShot = el;
		scraper = new ScraperImpl();
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
			category = "null";
	    	
			return true;
		} catch (Exception e) {
			System.out.println("Scrap Exception in " + siteName);
			return false;
		}
	}

	public void setSiteLink(String siteLink) {
		this.siteLink = siteLink;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOldPrice(String oldPrice) {
		this.oldPrice = oldPrice;
	}

	public void setNewPrice(String newPrice) {
		this.newPrice = newPrice;
	}

	public void setRemainingQuantity(String remainingQuantity) {
		this.remainingQuantity = remainingQuantity;
	}

	public void setLimitQuantity(String limitQuantity) {
		this.limitQuantity = limitQuantity;
	}

	public void setImg(String img) {
		this.img = img;
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
		return category;
	}
}
