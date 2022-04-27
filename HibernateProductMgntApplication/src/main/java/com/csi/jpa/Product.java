package com.csi.jpa;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity

public class Product {

	@Id
	@GeneratedValue
	private int productId;
	private String productName;
	private double productPrice;
	
	@Temporal(TemporalType.DATE)
	private Date productLaunchDate;// dd-MM-yyyy
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String productName, double productPrice, Date productLaunchDate) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.productLaunchDate = productLaunchDate;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public Date getProductLaunchDate() {
		return productLaunchDate;
	}

	public void setProductLaunchDate(Date productLaunchDate) {
		this.productLaunchDate = productLaunchDate;
	}

	@Override
	public String toString() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		
		String launchDate = simpleDateFormat.format(productLaunchDate);
		
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productLaunchDate=" + launchDate + "]";
	}
	
	
	

}
