package com.online.mrytlebeach.service;

import com.online.mrytlebeach.domain.PartnerDomain;

public class TestGenerateReportForPartner {

	public static void main(String[] args) {

		PartnerDomain partnerDomain = new PartnerDomain();
		int partnerID = 1;
		partnerDomain.generatePartnerReport(partnerID);
	}

}
