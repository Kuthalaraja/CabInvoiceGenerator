package com.cabInvoice;

public class CabInvoice {

	public static void main(String[] args) {
		Cab cab = new Cab();
		cab.setBookingID("TN150");
		cab.setCabType("BMW");
		cab.setKmsUsed("120");
		cab.setUserId(111);
		cab.setUserNme("Raj");
		String result = Service.printBillAmount(cab);
		System.out.println(result);
	}

}
