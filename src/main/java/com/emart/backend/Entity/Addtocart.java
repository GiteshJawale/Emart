package com.emart.backend.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Addtocart")
public class Addtocart {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int  cartid;
	private String username;
	private int productid;
	private String productimage;
	private String productname;
	private String productshortdesc;
	private double price;
	private float discount;
	private double cardholderprice;
	private int pointredm;
	private int qty;
	
	
	@ManyToOne
    @JoinColumn(name = "prodid")
    private Productmaster productmaster;


	public int getCartid() {
		return cartid;
	}


	public void setCartid(int cartid) {
		this.cartid = cartid;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public int getProductid() {
		return productid;
	}


	public void setProductid(int productid) {
		this.productid = productid;
	}


	public String getProductimage() {
		return productimage;
	}


	public void setProductimage(String productimage) {
		this.productimage = productimage;
	}


	public String getProductname() {
		return productname;
	}


	public void setProductname(String productname) {
		this.productname = productname;
	}


	public String getProductshortdesc() {
		return productshortdesc;
	}


	public void setProductshortdesc(String productshortdesc) {
		this.productshortdesc = productshortdesc;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public float getDiscount() {
		return discount;
	}


	public void setDiscount(float discount) {
		this.discount = discount;
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


	public int getQty() {
		return qty;
	}


	public void setQty(int qty) {
		this.qty = qty;
	}


	public Productmaster getProductmaster() {
		return productmaster;
	}


	public void setProductmaster(Productmaster productmaster) {
		this.productmaster = productmaster;
	}


	@Override
	public String toString() {
		return "Addtocart [cartid=" + cartid + ", username=" + username + ", productid=" + productid + ", productimage="
				+ productimage + ", productname=" + productname + ", productshortdesc=" + productshortdesc + ", price="
				+ price + ", discount=" + discount + ", cardholderprice=" + cardholderprice + ", pointredm=" + pointredm
				+ ", qty=" + qty + ", productmaster=" + productmaster + "]";
	}

	
	public Addtocart(){}

	public Addtocart(int cartid, String username, int productid, String productimage, String productname,
			String productshortdesc, double price, float discount, double cardholderprice, int pointredm, int qty,
			Productmaster productmaster) {
		super();
		this.cartid = cartid;
		this.username = username;
		this.productid = productid;
		this.productimage = productimage;
		this.productname = productname;
		this.productshortdesc = productshortdesc;
		this.price = price;
		this.discount = discount;
		this.cardholderprice = cardholderprice;
		this.pointredm = pointredm;
		this.qty = qty;
		this.productmaster = productmaster;
	}
	
//	@ManyToOne
//    @JoinColumn(name = "username")
//    private User users;
	
	
	
	
	

}
