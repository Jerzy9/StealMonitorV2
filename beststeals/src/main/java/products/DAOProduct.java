package products;

import org.jsoup.nodes.Element;

import interfaces.IProduct;

public class DAOProduct implements IProduct {
	
	private int id;
	private String siteLink;
	private String siteName;
	private String name;
	private String oldPrice, newPrice;
	private String remainingQuantity, limitQuantity;
	private String img;
	private String category;
	
	public DAOProduct(int id, String siteLink, String siteName, String name, String oldPrice, String newPrice,
			String remainingQuantity, String limitQuantity, String img, String category) {
		super();
		this.id = id;
		this.siteLink = siteLink;
		this.siteName = siteName;
		this.name = name;
		this.oldPrice = oldPrice;
		this.newPrice = newPrice;
		this.remainingQuantity = remainingQuantity;
		this.limitQuantity = limitQuantity;
		this.img = img;
		this.category = category;
	}


	public boolean scrap() {
		// TODO Auto-generated method stub
		return false;
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
		return this.category;
	}
	public int getId() {
		return this.id;
	}

	public void setRemainingQuantity(String remainingQuantity) {
		// TODO Auto-generated method stub
		
	}

}
