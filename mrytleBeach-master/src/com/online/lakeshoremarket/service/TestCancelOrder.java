package com.online.mrytlebeach.service;

import com.online.mrytlebeach.domain.OrderDomain;

public class TestCancelOrder {

	public static void main(String[] args) {

		OrderDomain orderDomain = new OrderDomain();
		int orderID = 1;
		boolean isOrderRefunded = false;
		isOrderRefunded = orderDomain.cancelAndRefundOrder(orderID);
		if(isOrderRefunded){
			System.out.println("Order is refunded successfully");
		}else{
			System.out.println("Order is NOT refunded");
		}
	}

}
