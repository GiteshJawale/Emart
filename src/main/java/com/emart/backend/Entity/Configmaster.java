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
@Table(name = "Configmaster")
public class Configmaster {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int configid;
	private String configname;
	
	@OneToMany(mappedBy = "configmaster", cascade = CascadeType.ALL)
	private Set<Productdtlmaster> productdtlmasters;
	
	
	
	
	public int getConfigid() {
		return configid;
	}
	public void setConfigid(int configid) {
		this.configid = configid;
	}
	public String getConfigname() {
		return configname;
	}
	public void setConfigname(String configname) {
		this.configname = configname;
	}
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "configid", referencedColumnName="configid", insertable = false, updatable = false)
	public Set<Productdtlmaster> getProductdtlmasters() {
		return productdtlmasters;
	}
	public void setProductdtlmasters(Set<Productdtlmaster> productdtlmasters) {
		this.productdtlmasters = productdtlmasters;
	}
	@Override
	public String toString() {
		return "Configmaster [configid=" + configid + ", configname=" + configname + ", productdtlmasters="
				+ productdtlmasters + "]";
	}
	public Configmaster(int configid, String configname, Set<Productdtlmaster> productdtlmasters) {
		super();
		this.configid = configid;
		this.configname = configname;
		this.productdtlmasters = productdtlmasters;
	}
	
	public Configmaster(){}
	

}
