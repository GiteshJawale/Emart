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
@Table(name = "Productdtlmaster")
public class Productdtlmaster {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int productdtlmasterid;
	//private int productid;
	@Column(name = "configid", insertable = false, updatable = false)
	private int configid;
	public int getConfigid() {
		return configid;
	}

	public void setConfigid(int configid) {
		this.configid = configid;
	}
	private String configdtl;
	
	
	@ManyToOne
    @JoinColumn(name = "productid")
    private Productmaster productmaster;
	
	@ManyToOne
    @JoinColumn(name = "configid")
    private Configmaster configmaster;
	
	public Productdtlmaster(){}
	
	public int getProductdtlmasterid() {
		return productdtlmasterid;
	}
	public void setProductdtlmasterid(int productdtlmasterid) {
		this.productdtlmasterid = productdtlmasterid;
	}
	public String getConfigdtl() {
		return configdtl;
	}
	public void setConfigdtl(String configdtl) {
		this.configdtl = configdtl;
	}

	@Override
	public String toString() {
		return "Productdtlmaster [productdtlmasterid=" + productdtlmasterid + ", configid=" + configid + ", configdtl="
				+ configdtl + ", productmaster=" + productmaster + ", configmaster=" + configmaster + "]";
	}

	public Productdtlmaster(int productdtlmasterid, int configid, String configdtl, Productmaster productmaster,
			Configmaster configmaster) {
		super();
		this.productdtlmasterid = productdtlmasterid;
		this.configid = configid;
		this.configdtl = configdtl;
		this.productmaster = productmaster;
		this.configmaster = configmaster;
	}
	
	
	
	

}
