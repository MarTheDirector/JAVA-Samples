package com.online.mrytlebeach.service;

import com.online.mrytlebeach.domain.ReviewDomain;
import com.online.mrytlebeach.model.review.Review;
import com.online.mrytlebeach.model.review.ReviewImpl;

public class TestProductReview {

	public static void main(String[] args) {
		
		Review review = new ReviewImpl();
		review.setCustomerID(1);
		review.setRating(10);
		review.setProductID(1);
		review.setReview("This is the Best Book of my LIFE!! Seriously.. ");
		
		int productReviewID = 0;
		ReviewDomain reviewDomain = new ReviewDomain();
		productReviewID = reviewDomain.addProductReview(review);
		if(0 != productReviewID){
			System.out.println("Product Review is successfully added into the system.");
		}else{
			System.out.println("Product Review is NOT added into the system");
		}
	}

}
