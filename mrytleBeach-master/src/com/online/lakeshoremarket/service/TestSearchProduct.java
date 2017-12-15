package com.online.mrytlebeach.service;

import com.online.mrytlebeach.domain.ProductDomain;
import com.online.mrytlebeach.model.product.Product;

public class TestSearchProduct {

	public static void main(String[] args) {

		Product prod = null;
		String prodName = "Oliver Twist";
		ProductDomain prodDomain = new ProductDomain();
		prod = prodDomain.searchProductByName(prodName);
		if(0 == prod.getProductID()){
			System.out.println("Product not found");
		}else{
			prod.displayProductDetails();
		}
	}

}
