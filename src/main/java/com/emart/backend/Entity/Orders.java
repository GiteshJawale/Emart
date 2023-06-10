package com.emart.backend.Entity;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "Orders")
public class Orders {

	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	 private int ordertid;
	 private int cartid;
	 private String productname;
	 private double price;
	 private float discount;
	 private double cardholderprice;
	 private int pointredm;
	 private int qty;
	 private LocalDate orderdate;
	 private double grandtotal;
		private int productid;
		@Column(name = "username", insertable = false, updatable = false)
		private String username;
	  
     
     public Orders() {
		super();
	}



     @ManyToOne
     @JoinColumn(name = "prodid")
     private Productmaster productmaster;


     @ManyToOne
     @JoinColumn(name = "username")
     private User user;


	public int getOrdertid() {
		return ordertid;
	}


	public void setOrdertid(int ordertid) {
		this.ordertid = ordertid;
	}


	public int getCartid() {
		return cartid;
	}


	public void setCartid(int cartid) {
		this.cartid = cartid;
	}


	public String getProductname() {
		return productname;
	}


	public void setProductname(String productname) {
		this.productname = productname;
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


	public LocalDate getOrderdate() {
		return orderdate;
	}


	public void setOrderdate(LocalDate orderdate) {
		this.orderdate = orderdate;
	}


	public double getGrandtotal() {
		return grandtotal;
	}


	public void setGrandtotal(double grandtotal) {
		this.grandtotal = grandtotal;
	}


	public int getProductid() {
		return productid;
	}


	public void setProductid(int productid) {
		this.productid = productid;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public Productmaster getProductmaster() {
		return productmaster;
	}


	public void setProductmaster(Productmaster productmaster) {
		this.productmaster = productmaster;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "Orders [ordertid=" + ordertid + ", cartid=" + cartid + ", productname=" + productname + ", price="
				+ price + ", discount=" + discount + ", cardholderprice=" + cardholderprice + ", pointredm=" + pointredm
				+ ", qty=" + qty + ", orderdate=" + orderdate + ", grandtotal=" + grandtotal + ", productid="
				+ productid + ", username=" + username + ", productmaster=" + productmaster + ", user=" + user + "]";
	}


	public Orders(int ordertid, int cartid, String productname, double price, float discount, double cardholderprice,
			int pointredm, int qty, LocalDate orderdate, double grandtotal, int productid, String username,
			Productmaster productmaster, User user) {
		super();
		this.ordertid = ordertid;
		this.cartid = cartid;
		this.productname = productname;
		this.price = price;
		this.discount = discount;
		this.cardholderprice = cardholderprice;
		this.pointredm = pointredm;
		this.qty = qty;
		this.orderdate = orderdate;
		this.grandtotal = grandtotal;
		this.productid = productid;
		this.username = username;
		this.productmaster = productmaster;
		this.user = user;
	}


     

}
	
	
	
	

