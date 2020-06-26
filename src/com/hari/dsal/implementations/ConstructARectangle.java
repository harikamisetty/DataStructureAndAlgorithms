package com.hari.dsal.implementations;

public class ConstructARectangle {
	private int[] getRectangle(int area) {
		int w = (int) Math.sqrt(area);
		
		while(area % w != 0) // To find the moduler value.
			w--;
		return new int[] {area/w,w};
	}
	
	
	
	public static void main(String[] args) {
		ConstructARectangle cr = new ConstructARectangle();
		int  res[] = cr.getRectangle(32);
		
		for(int val : res) {
			System.out.println(val);
		}
	}
}
