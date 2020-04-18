package products;

import org.jsoup.nodes.Element;

import interfaces.IProduct;
import scrapers.Scraper;

public class MoreleHotShotProduct implements IProduct{
	private String siteLink;
	private String siteName;
	private String name;
	private String oldPrice, newPrice;
	private String remainingQuantity, limitQuantity;
	private String img;
	
	private Element hotShot;
	private Scraper scraper;
	
	public MoreleHotShotProduct(Element el) {
		this.hotShot = el;
		scraper = new Scraper();
	}
	
	public boolean scrap() {
		try {
			this.siteName = "morele.net";
			
			//We have to find a way to get this product's link!
			this.siteLink = scraper.getLinkFromAHref(hotShot, 0);
			
			this.name = scraper.getStringByClass(hotShot, "promo-box-name", 0);
			
			this.oldPrice = scraper.getStringByClass(hotShot, "promo-box-old-price", 0);
			this.newPrice = scraper.getStringByClass(hotShot, "promo-box-new-price", 0);
			
			this.remainingQuantity = scraper.getStringByClass(hotShot, "status-box-was", 0);
			this.remainingQuantity = scraper.substringNum(remainingQuantity, 10, remainingQuantity.length()-5);
			this.limitQuantity = scraper.getStringByClass(hotShot, "status-box-expired", 0);
			this.limitQuantity = scraper.substringNum(limitQuantity, 10, limitQuantity.length()-5);
			
			this.limitQuantity = scraper.addTwoNumbersInString(limitQuantity, remainingQuantity);
			this.img = scraper.getImageStringByTag(hotShot, 0);
	    	
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
