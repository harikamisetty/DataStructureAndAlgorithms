package com.hari.dsal.Salesforce;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class VMPricing {
	
	private String getPrice(int []ni,double []price,int n) {
		DecimalFormat df = new DecimalFormat("0.00");
		int len = ni.length;
		
		if(n > ni[len-1]) {
			int i = n-ni[len-1];
			int j = ni[len-1] - ni[len-2];
			double qdiff = (double)i / j;
			System.out.println(qdiff);
			int plen = price.length;
			double p1 = price[plen-2] - price[plen-1];
			df.setRoundingMode(RoundingMode.UP);
			return  (df.format(price[plen-1] - (qdiff * p1)));
			
		} else {
			for(int k =0; k<len;k++) {
				if(ni[k] == n)
					return String.valueOf(price[k]);
				if(ni[k] > n) {
					int i = n-ni[k-1];
					int j = ni[k-1] - ni[k-2];
					double qdiff = (double)i / j;
					System.out.println(qdiff);
					
					double p1 = price[k-2] - price[k-1];
					df.setRoundingMode(RoundingMode.UP);
					return  (df.format(price[k-1] - (qdiff * p1)));
				}
			}
		}
		return null;		
	}
	
	
	public static void main(String[] args) {
		
		int [] instances = {10,25,50,100,500};
		double [] price = {27.32,23.13,21.25,18.00,15.50};
		
		VMPricing vp = new VMPricing();
		System.out.println(vp.getPrice(instances, price, 200 )); // try 2000
	}

}
