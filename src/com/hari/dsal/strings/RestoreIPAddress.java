package com.hari.dsal.strings;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress {
	public List<String> restoreIpAddresses(String ipaddress) {
		
		if (ipaddress == null || ipaddress.length() < 4) {
			return null;
		}
		List<String> result = new ArrayList<String>();
		restoreHelper(ipaddress, 0, 1, "", result);

		return result;
	}
	
	// main recursive Logic here
	private void restoreHelper(String ipaddress, int start, int segment, String curr, List<String> result) {
		if (start >= ipaddress.length()) {
			return;
		}

		if (segment == 4) {
			if (isValid(ipaddress.substring(start))) {
				result.add(curr + "." + ipaddress.substring(start));
			}
			return;
		}

		for (int i = 1; i < 4 && start + i < ipaddress.length(); i++) {
			String temp = ipaddress.substring(start, start + i);
			if (isValid(temp)) {
				if (segment == 1) {
					restoreHelper(ipaddress, start + i, segment + 1, temp, result);
				} else {
					restoreHelper(ipaddress, start + i, segment + 1, curr + "." + temp, result);
				}
			}
		}
	}

	private boolean isValid(String str) {
		if (str == null || str.length() > 3) {
			return false;
		}

		int num = Integer.parseInt(str);
		if (str.charAt(0) == '0' && str.length() > 1) {
			return false;
		}

		if (num >= 0 && num <= 255) {
			return true;
		}

		return false;
	}
	
	public static void main(String[] args) {
		String s  = "1111";
		RestoreIPAddress ripa = new RestoreIPAddress();
		List<String> results = ripa.restoreIpAddresses(s);
		
		for(String str : results) {
			System.out.println(str);
		}
	}
}
