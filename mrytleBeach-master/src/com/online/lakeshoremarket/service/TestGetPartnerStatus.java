package com.online.mrytlebeach.service;

import com.online.mrytlebeach.domain.PartnerDomain;

public class TestGetPartnerStatus {

	public static void main(String[] args) {

		PartnerDomain partnerDomain = new PartnerDomain();
		int partnerID = 1;
		boolean isPartnerActive = false;
		isPartnerActive = partnerDomain.getStatus(partnerID);
		if(isPartnerActive){
			System.out.println("Partner is active");
		}else{
			System.out.println("Partner is NOT active");
		}
	}

}
