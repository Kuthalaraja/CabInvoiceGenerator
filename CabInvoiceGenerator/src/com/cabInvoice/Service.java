package com.cabInvoice;

public class Service {

	public static String printBillAmount(Cab cab) {
		int check =4;
		String res = "";
		
		if(!(cab.getBookingID().length()==5 && cab.getBookingID().substring(0,2).equals("TN") && 
				Integer.parseInt(cab.getBookingID().substring(2,cab.getBookingID().length()))>=100)){
			check--;
					System.out.println("Invalid Booking ID: ");
				}
		if(!(cab.getUserId()>=101 && cab.getUserId()<=200)) {
			check--;
			System.out.println("Invalid User ID: ");
		}
		if(!(cab.getCabType().equals("Tata Indigo") || cab.getCabType().equals("Ford") || cab.getCabType().equals("BMW") || cab.getCabType().equals("Maruti"))){
			check--;
			System.out.println("Invalid Cab Type : ");
		}
		if(Integer.parseInt(cab.getKmsUsed())<0) {
			check--;
			try {
				throw new NegativeKilometerException();
			}catch(NegativeKilometerException e){
				System.out.println(e.toString());
			}
		}
		if(check==4) {
			return "Total Amount :"+Billgen(Integer.parseInt(cab.getKmsUsed()), cab.getCabType())[1]+" "+
		"Receipt ID :"+Billgen(Integer.parseInt(cab.getKmsUsed()), cab.getCabType())[0];
		}else {
			return "";
		}
	}
	
	public static int[] Billgen(int kmsUsed, String cabType) {
		String rNoset = "0123456789";
		char[] rArray = new char[5];
		
		for (int i=0;i<5;i++) {
			int n = (int) (Math.random()* 10);
			rArray[i] = rNoset.charAt(n);
		}
		String rNo = String.valueOf(rArray);
		int n = Integer.parseInt(rNo);
		
		int amount = 0;
		
		if(cabType.equals("Tata Indigo")) {
			amount = kmsUsed*12;
		}else if(cabType.equals("Ford")) {
			amount = kmsUsed*10;
		}else if(cabType.equals("BMW")) {
			amount = kmsUsed*45;
		}else if(cabType.equals("Maruti")) {
			amount = kmsUsed*8;
		}
		
		int array[] = new int[2];
		array[0] = n;
		array[1] = amount;
		
		return array;
		
	}
}
