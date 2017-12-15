package com.online.mrytlebeach.activity;

import java.util.ArrayList;

import com.online.mrytlebeach.domain.ReviewDomain;
import com.online.mrytlebeach.model.review.Review;
import com.online.mrytlebeach.model.review.ReviewImpl;
import com.online.mrytlebeach.representation.generic.GenericResponse;
import com.online.mrytlebeach.representation.generic.Link;
import com.online.mrytlebeach.representation.review.PartnerReviewRequest;
import com.online.mrytlebeach.representation.review.ProductReviewRequest;
import com.online.mrytlebeach.representation.review.ReviewRepresentation;
import com.online.mrytlebeach.util.Constant;

/**
 * Interacts with review model and domain business logic to create and modify review representations
 *
 */

public class ReviewActivity {

	/**
	 * Creates partner review representation
	 * @param partnerReviewRequest
	 * @return genericResponse	success or failure message
	 */
	
	public GenericResponse createPartnerReview(PartnerReviewRequest partnerReviewRequest) {
		int partnerReviewID = 0;
		GenericResponse genericResponse = new GenericResponse();
		ReviewDomain reviewDomain = new ReviewDomain();
		Review review = new ReviewImpl();
		
		review.setCustomerID(partnerReviewRequest.getCustomerID());
		review.setPartnerID(partnerReviewRequest.getPartnerID());
		review.setRating(partnerReviewRequest.getRating());
		review.setReview(partnerReviewRequest.getReview());
		
		partnerReviewID = reviewDomain.addPartnerReview(review);
		if(0 != partnerReviewID){
			genericResponse.setMessage("Partner review is created");
			genericResponse.setSuccess(true);
			genericResponse.setGenericReturnValue( Integer.toString( partnerReviewID ) );
			Link get = new Link("Get Partner Reviews", Constant.LSM_COMMON_URL + "/review/partner/" + partnerReviewRequest.getPartnerID(), "application/xml");
			genericResponse.setLinks(get);
		}else{
			genericResponse.setMessage("Partner review is not created");
			genericResponse.setSuccess(false);
		}
		
		return genericResponse;
	}
	
	/**
	 * Creates product review representation
	 * @param productReviewRequest
	 * @return genericResponse	success or failure message
	 */
	
	public GenericResponse createProductReview(ProductReviewRequest productReviewRequest) {
		int productReviewID = 0;
		GenericResponse genericResponse = new GenericResponse();
		ReviewDomain reviewDomain = new ReviewDomain();
		Review review = new ReviewImpl();
		
		review.setCustomerID(productReviewRequest.getCustomerID());
		review.setProductID(productReviewRequest.getProductID());
		review.setRating(productReviewRequest.getRating());
		review.setReview(productReviewRequest.getReview());
		
		productReviewID = reviewDomain.addProductReview(review);
		if(0 != productReviewID){
			genericResponse.setMessage("Product review is created");
			genericResponse.setSuccess(true);
			genericResponse.setGenericReturnValue( Integer.toString( productReviewID ) );
			Link get = new Link("Get Product Reviews", Constant.LSM_COMMON_URL + "/review/product/" + productReviewRequest.getProductID(), "application/xml");
			genericResponse.setLinks(get);
		}else{
			genericResponse.setMessage("Product review is not created");
			genericResponse.setSuccess(false);
		}
		
		return genericResponse;
	}
	
	/**
	 * Builds an array list of review representations
	 * @param type 		partner or product (lowercase)
	 * @param partnerOrProductID 	the partner ID or product ID, depending on type
	 * @return ReviewRepresentation
	 */
	public ArrayList<ReviewRepresentation> getReviews( String type, int partnerOrProductID ) {
		ReviewDomain revDomain = new ReviewDomain();
		ArrayList<Review> reviewList;
		ArrayList<ReviewRepresentation> revRepList = new ArrayList<>();

		if( type == "partner" ) {
			reviewList = revDomain.getPartnerReviewsByID( partnerOrProductID );
			
			for(int i=0; i< reviewList.size() ; i++){
				ReviewRepresentation revRep = new ReviewRepresentation();
				revRep.setCustomerID( reviewList.get(i).getCustomerID() );
				revRep.setPartnerID( reviewList.get(i).getPartnerID() );
				revRep.setPartnerReviewID( reviewList.get(i).getPartnerReviewID() );
				revRep.setRating( reviewList.get(i).getRating() );
				revRep.setReview( reviewList.get(i).getReview() );
				revRep.setReviewDate( reviewList.get(i).getReviewDate() );
				Link get = new Link("Get Partner Details", Constant.LSM_COMMON_URL + "/partner/" + revRep.getPartnerID(), "application/xml");
				revRep.setLinks(get);
				revRepList.add(revRep);
			}
			
			return revRepList;
			
		} else if( type == "product" ) {
			reviewList = revDomain.getProductReviewsByID( partnerOrProductID );
			
			for(int i=0; i< reviewList.size() ; i++){
				ReviewRepresentation revRep = new ReviewRepresentation();
				revRep.setCustomerID( reviewList.get(i).getCustomerID() );
				revRep.setProductID( reviewList.get(i).getProductID() );
				revRep.setProductReviewID( reviewList.get(i).getProductReviewID() );
				revRep.setRating( reviewList.get(i).getRating() );
				revRep.setReview( reviewList.get(i).getReview() );
				revRep.setReviewDate( reviewList.get(i).getReviewDate() );
				Link get = new Link("Get Product Details", Constant.LSM_COMMON_URL + "/product-by-id/" + revRep.getProductID(), "application/xml");
				Link buy = new Link("Buy Product", Constant.LSM_COMMON_URL + "/order", "application/xml");
				revRep.setLinks(get,buy);
				revRepList.add(revRep);
			}
			
			return revRepList;
			
		} 
		throw new IllegalArgumentException( "Invalid review type (supplied " + type + ")" );
		
	}
}
