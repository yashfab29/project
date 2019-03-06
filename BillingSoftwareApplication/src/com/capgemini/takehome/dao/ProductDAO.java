package com.capgemini.takehome.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.capgemini.bean.Product;

public class ProductDAO implements IProductDAO {
	
	Map<Integer,Product> products = new HashMap<Integer,Product>();
	
	
	public Product getProductDetails(int ProductCode)
	{
		
		Set<Map.Entry<Integer,Product>> st=products.entrySet();
		
		for(Map.Entry<Integer,Product> i:st)
		{
			if(i.getValue().getProductCode()==ProductCode)
			{
				return i.getValue();
			}
		}
		
		return null;
	}
	
	public Product save(Product product)
	{
		
		products.put(product.getProductCode(),product);
		return product;
	}
	
	

}
