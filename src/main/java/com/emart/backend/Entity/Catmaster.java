package com.emart.backend.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Catmaster")
public class Catmaster {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int catmasterid;
	private String catid;
	private String subcatid;
	private String catname;
	//private int productid;
	private String catimagpath;
	
	
	
	@ManyToOne
    @JoinColumn(name = "productid")
    private Productmaster productmaster;

	public Catmaster(){}
	
	public Catmaster(int catmasterid, String catid, String subcatid, String catname, String catimagpath, String flag) {
		super();
		this.catmasterid = catmasterid;
		this.catid = catid;
		this.subcatid = subcatid;
		this.catname = catname;
		this.catimagpath = catimagpath;
		this.flag = flag;
	}
	@Override
	public String toString() {
		return "Catmaster [catmasterid=" + catmasterid + ", catid=" + catid + ", subcatid=" + subcatid + ", catname="
				+ catname + ", catimagpath=" + catimagpath + ", flag=" + flag + "]";
	}
	public int getCatmasterid() {
		return catmasterid;
	}
	public void setCatmasterid(int catmasterid) {
		this.catmasterid = catmasterid;
	}
	public String getCatid() {
		return catid;
	}
	public void setCatid(String catid) {
		this.catid = catid;
	}
	public String getSubcatid() {
		return subcatid;
	}
	public void setSubcatid(String subcatid) {
		this.subcatid = subcatid;
	}
	public String getCatname() {
		return catname;
	}
	public void setCatname(String catname) {
		this.catname = catname;
	}
	public String getCatimagpath() {
		return catimagpath;
	}
	public void setCatimagpath(String catimagpath) {
		this.catimagpath = catimagpath;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	private String flag;

}
