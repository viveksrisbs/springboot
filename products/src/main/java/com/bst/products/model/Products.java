package com.bst.products.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity

public class Products {
    
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long pid;
	private String productname;
	private int qty;
	private Double price;
	private Long userid;
	
	
	public Products() {
		super();
	}
	
	public Products(Long pid, String productname, int qty, Double price) {
		super();
		this.pid = pid;
		this.productname = productname;
		this.qty = qty;
		this.price = price;
	}
	
	public Products(Long pid, String productname, int qty, Double price, Long userid) {
		super();
		this.pid = pid;
		this.productname = productname;
		this.qty = qty;
		this.price = price;
		this.userid = userid;
	}
	
	
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	
	
	
}
