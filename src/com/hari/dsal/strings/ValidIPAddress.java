package com.hari.dsal.strings;

public class ValidIPAddress {
	public String validIPAddress(String IP) {
		if (IP == null || IP.length() == 0) {
			return "Neither";
		}

		if (IP.contains(".")) {
			boolean valid = validateIPv4(IP);
			if (valid) {
				return "IPv4";
			}
		} else if (IP.contains(":")) {
			boolean valid = validateIPv6(IP);
			if (valid) {
				return "IPv6";
			}
		}

		return "Neither";
	}

	private boolean validateIPv4(String s) {
		String[] tokens = s.split("[.]");
		if (tokens.length != 4) {
			return false;
		}

		if (s.charAt(0) == '.' || s.charAt(s.length() - 1) == '.') {
			return false;
		}

		for (String token : tokens) {
			if (!validateIpv4Helper(token)) {
				return false;
			}
		}

		return true;
	}

	private boolean validateIpv4Helper(String s) {
		if (s == null || s.length() == 0 || s.length() > 3) {
			return false;
		}

		if (s.length() > 1 && s.charAt(0) == '0') {
			return false;
		}

		int num = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c < '0' || c > '9') {
				return false;
			}

			int digit = (int) (c - '0');
			num = num * 10 + digit;
		}

		if (num < 0 || num > 255) {
			return false;
		}

		return true;
	}

	private boolean validateIPv6(String s) {
		if (s.charAt(0) == ':' || s.charAt(s.length() - 1) == ':') {
			return false;
		}

		String[] tokens = s.split("[:]");
		if (tokens.length != 8) {
			return false;
		}

		for (String token : tokens) {
			if (!validateIpv6Helper(token)) {
				return false;
			}
		}

		return true;
	}

	private boolean validateIpv6Helper(String s) {
		if (s == null || s.length() == 0 || s.length() > 4) {
			return false;
		}

		s = s.toLowerCase();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				if (c < '0' || c > '9') {
					return false;
				}
			} else {
				if (c < 'a' || c > 'f') {
					return false;
				}
			}
		}

		return true;
	}
	
	public static void main(String[] args) {
		ValidIPAddress vipa = new ValidIPAddress();
		System.out.println(vipa.validIPAddress("200.234.23.26"));
	}

}
