package com.hari.dsal.backtrack;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddress {

	private List<String> getIpAddress(String s) {

		List<String> result = new ArrayList<String>();

		if (s == null || s.length() < 4) {
			return result;
		}
		restoreHelper(result,"",s, 0, 1 );

		return result;
	}

	private void restoreHelper(List<String> result, String curr, String s, int start, int segment) {
		if (start >= s.length()) {
			return;
		}

		if (segment == 4) {
			if (isValid(s.substring(start))) {
				result.add(curr + "." + s.substring(start));
			}
			return;
		}

		for (int i = 1; i < 4 && start + i < s.length(); i++) {
			String temp = s.substring(start, start + i);
			if (isValid(temp)) {
				if (segment == 1) {
					restoreHelper(result, temp, s, start + i, segment + 1);
				} else {
					restoreHelper(result, curr + "." + temp, s, start + i, segment + 1);
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
		RestoreIpAddress rip = new RestoreIpAddress();
		System.out.println(rip.getIpAddress("253635"));
	}
}
