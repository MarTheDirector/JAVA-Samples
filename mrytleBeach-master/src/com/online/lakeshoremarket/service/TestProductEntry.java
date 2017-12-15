package com.online.mrytlebeach.service;

import com.online.mrytlebeach.domain.ProductDomain;
import com.online.mrytlebeach.model.product.ProdImpl;
import com.online.mrytlebeach.model.product.Product;

public class TestProductEntry {

	public static void main(String[] args) {
		Product prodNew  = new ProdImpl();
		prodNew.setPartnerID(1);
		prodNew.setTaxonomyID(1);
		prodNew.setCost(110);
		prodNew.setPrice(300);
		prodNew.setProductName("Test2");
		prodNew.setDescription("This xzcvxzcizdffzdfvdzfvs afdsbdsfbffdsbsdsbHDMI cable for connecting to the TV");
		prodNew.setQoh(33);
		prodNew.setActive(true);
		
		ProductDomain prodDomain = new ProductDomain();
		
		int rowsUpdated = prodDomain.addProduct(prodNew);
		System.out.println("Rows Updated = "  + rowsUpdated);
	}

}
