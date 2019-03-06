package com.capgemini.takehome.ui;

import java.util.Scanner;

import com.capgemini.bean.Product;
import com.capgemini.takehome.dao.IProductDAO;
import com.capgemini.takehome.dao.ProductDAO;
import com.capgemini.takehome.service.ProductService;

public class Client {
	
	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		ProductDAO pd=new ProductDAO();
		
		
		Product product = new Product(1001, "iPhone", "Electronics","Smart phone", 35000);
		
		pd.save(product);
		
		
		while(true)
		{
			System.out.println("1)Generate bill ");
			System.out.println("2) Exit");
			
			int choice = sc.nextInt();
			
			switch(choice)
			{
			
			case 1: calculateBill();
				break;
				
			case 2: System.exit(0);
			
			default:System.out.println("wrong choice");
			}
		}
	}
	
	
	private static void calculateBill()
	
	{
		ProductService productService= new ProductService();
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter product code");
		int ProductCode=sc.nextInt();
		
		System.out.println("Enter product quantity");
		int productQuantity=sc.nextInt();
		try {
			if(ProductCode>0);
			
		}
		
		catch(Exception e){
			
			System.out.println("Enter valid quantity");
		}
		
		Product product= productService.getProductDetails(ProductCode);
		int lineTotal=productQuantity*(product.getProductPrice());
		System.out.println("product name"+product.getProductName());
	
		System.out.println("product description"+product.getProductDescription());
		System.out.println("product price"+product.getProductPrice());
		
	}

}
