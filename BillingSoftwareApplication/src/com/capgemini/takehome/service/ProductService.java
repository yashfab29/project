package com.capgemini.takehome.service;

import com.capgemini.bean.Product;
import com.capgemini.takehome.dao.ProductDAO;

public class ProductService implements IProductService{
	
	ProductDAO productDAO= new ProductDAO();
	
	
	public Product getProductDetails(int productCode) {
			Product product = productDAO.getProductDetails(productCode);
		
		return product;
	}
}
