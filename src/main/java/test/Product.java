package test;

public class Product {
	
	private int productid;
	private String productname;
	private String productimagpath;
	private String productshortdesc;
	private String productlongdesc;
	private double price;
	private int cardholderprice;
	
	public Product(){}
	
	

	public Product(int productid, String productname, String productimagpath, String productshortdesc,
			String productlongdesc, double price, int cardholderprice) {
		super();
		this.productid = productid;
		this.productname = productname;
		this.productimagpath = productimagpath;
		this.productshortdesc = productshortdesc;
		this.productlongdesc = productlongdesc;
		this.price = price;
		this.cardholderprice = cardholderprice;
	}



	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getProductimagpath() {
		return productimagpath;
	}

	public void setProductimagpath(String productimagpath) {
		this.productimagpath = productimagpath;
	}

	public String getProductshortdesc() {
		return productshortdesc;
	}

	public void setProductshortdesc(String productshortdesc) {
		this.productshortdesc = productshortdesc;
	}

	public String getProductlongdesc() {
		return productlongdesc;
	}

	public void setProductlongdesc(String productlongdesc) {
		this.productlongdesc = productlongdesc;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCardholderprice() {
		return cardholderprice;
	}

	public void setCardholderprice(int cardholderprice) {
		this.cardholderprice = cardholderprice;
	}
	

}
