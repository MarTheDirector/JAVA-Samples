package com.online.mrytlebeach.service;

import java.util.ArrayList;
import java.util.Iterator;

import com.online.mrytlebeach.domain.ProductDomain;
import com.online.mrytlebeach.model.product.Product;

public class TestSearchProducts {

	public static void main(String[] args) {

		ArrayList<Product> prodList = new ArrayList<Product>();
		String prodName = "es";
		ProductDomain prodDomain = new ProductDomain();
		prodList = prodDomain.searchProductByLikeName(prodName);
		Iterator<Product> prodListIterator = prodList.iterator();
		while (prodListIterator.hasNext()) {
			prodListIterator.next().displayProductDetails();
			System.out.println("**************************************************");
		}
	}

}
