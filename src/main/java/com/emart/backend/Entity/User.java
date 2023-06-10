package com.emart.backend.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {

	@Id
	private String username;
   	private String password; 
    private String email;
    private long mobilenumber;
    private int points;
    private String address;
    private String cardholder;
    private String fname ;
    private String lname;
    
 
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Orders> orders;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCardholder() {
		return cardholder;
	}

	public void setCardholder(String cardholder) {
		this.cardholder = cardholder;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}


	public Set<Orders> getOrders() {
		return orders;
	}

	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", email=" + email + ", mobilenumber="
				+ mobilenumber + ", points=" + points + ", address=" + address + ", cardholder=" + cardholder
				+ ", fname=" + fname + ", lname=" + lname + ",  orders=" + orders + "]";
	}

	public User(){}
	
	public User(String username, String password, String email, long mobilenumber, int points, String address,
			String cardholder, String fname, String lname,Set<Orders> orders) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.mobilenumber = mobilenumber;
		this.points = points;
		this.address = address;
		this.cardholder = cardholder;
		this.fname = fname;
		this.lname = lname;
		this.orders = orders;
	}
    

	
	
}
