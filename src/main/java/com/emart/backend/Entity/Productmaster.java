package com.emart.backend.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Productmaster")
public class Productmaster {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int productid;
	private String productname;
	private String productimagpath;
	private String productshortdesc;
	private String productlongdesc;
	private double price;
	private double cardholderprice;
	private int pointredm;
	private float discount;
	
	
	@OneToMany(mappedBy = "productmaster", cascade = CascadeType.ALL)
	private Set<Catmaster> catmasters;
	@OneToMany(mappedBy = "productmaster", cascade = CascadeType.ALL)
	private Set<Productdtlmaster> productdtlmasters;
	@OneToMany(mappedBy = "productmaster", cascade = CascadeType.ALL)
	private Set<Addtocart> addtocarts;
	
	
	public Productmaster(){}
	
	
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
	public double getCardholderprice() {
		return cardholderprice;
	}
	public void setCardholderprice(double cardholderprice) {
		this.cardholderprice = cardholderprice;
	}
	public int getPointredm() {
		return pointredm;
	}
	public void setPointredm(int pointredm) {
		this.pointredm = pointredm;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "productid", referencedColumnName="productid")
	public Set<Catmaster> getCatmasters() {
		return catmasters;
	}
	public void setCatmasters(Set<Catmaster> catmasters) {
		this.catmasters = catmasters;
	}
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "productid", referencedColumnName="productid")
	public Set<Productdtlmaster> getProductdtlmasters() {
		return productdtlmasters;
	}
	public void setProductdtlmasters(Set<Productdtlmaster> productdtlmasters) {
		this.productdtlmasters = productdtlmasters;
	}
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "prodid", referencedColumnName="productid")
	public Set<Addtocart> getAddtocarts() {
		return addtocarts;
	}
	public void setAddtocarts(Set<Addtocart> addtocarts) {
		this.addtocarts = addtocarts;
	}
	@Override
	public String toString() {
		return "Productmaster [productid=" + productid + ", productname=" + productname + ", productimagpath="
				+ productimagpath + ", productshortdesc=" + productshortdesc + ", productlongdesc=" + productlongdesc
				+ ", price=" + price + ", cardholderprice=" + cardholderprice + ", pointredm=" + pointredm
				+ ", discount=" + discount + ", catmasters=" + catmasters + ", productdtlmasters=" + productdtlmasters
				+ ", addtocarts=" + addtocarts + "]";
	}
	public Productmaster(int productid, String productname, String productimagpath, String productshortdesc,
			String productlongdesc, double price, double cardholderprice, int pointredm, float discount,
			Set<Catmaster> catmasters, Set<Productdtlmaster> productdtlmasters, Set<Addtocart> addtocarts) {
		super();
		this.productid = productid;
		this.productname = productname;
		this.productimagpath = productimagpath;
		this.productshortdesc = productshortdesc;
		this.productlongdesc = productlongdesc;
		this.price = price;
		this.cardholderprice = cardholderprice;
		this.pointredm = pointredm;
		this.discount = discount;
		this.catmasters = catmasters;
		this.productdtlmasters = productdtlmasters;
		this.addtocarts = addtocarts;
	}
	
	

}
