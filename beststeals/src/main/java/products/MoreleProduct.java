package products;

import java.io.IOException;

import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import config.AppConfig;
import interfaces.IProduct;
import scrapers.Scraper;

//@Component
public class MoreleProduct implements IProduct {
	
	private int id;
	private String siteLink;
	private String siteName;
	private String name;
	private String oldPrice, newPrice;
	private String remainingQuantity, limitQuantity;
	private String img;
	private String category;
	
	private Element hotShot;
	
	private Scraper scraper;
	
	public MoreleProduct(Element el) {
		this.hotShot = el;
		ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);
		scraper = factory.getBean(Scraper.class);
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
			
			this.img = scrapImageString(hotShot, 0);

			this.category = "null";
	
			if (!siteLink.substring(8,22).equals("www.morele.net")) return false;
			return true;
		} catch (Exception e) {
			System.out.println("Scrap Exception in " + siteName);
			return false;
		}
	}
	
	public String scrapImageString(Element el, int index) throws IOException {
		String str;
		Element image = el.getElementsByClass("prod-img ").get(index);
		str = image.toString();
		str = scraper.substringNum(str, 52, str.length()-9);
		return str;
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
		return this.category;
	}

	public int getId() {
		return this.id;
	}
	
	public void setImg(String img) {
		this.img = img;
	}
	
	public String getImg() {												// ????? two same getters
		return img;
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

	public void setCategory(String category) {
		this.category = category;
	}

	public Scraper getScraper() {
		return scraper;
	}

	public void setScraper(Scraper scraper) {
		this.scraper = scraper;
	}
}