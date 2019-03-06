package com.capgemini.bean;

public class Product {
	private int productCode;
	private String productName;
	private String productCategory;
	private int productPrice;
	private String productDescription;
	public int getProductCode() {
		return productCode;
	}
	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public Product(int productCode, String productName, String productCategory, String productDescription,int productPrice) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.productCategory = productCategory;
		this.productPrice = productPrice;
		this.productDescription = productDescription;
	}
}