package com.hari.dsal.implementations;

public class LicenseKeyFormatting {
	
	private String getLicenceKey(String input, int k) {		
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = input.length() -1; i >= 0; i--) {
			if(input.charAt(i) != '-') {
				sb.append(sb.length() % (k +1) ==k ? '-' : "").append(input.charAt(i));
			}
		}
		return sb.reverse().toString().toUpperCase();		
	}
	public static void main(String[] args) {
		LicenseKeyFormatting lkf = new LicenseKeyFormatting();
		System.out.println(lkf.getLicenceKey("2-4A0r7-4k", 4));
	}
}
