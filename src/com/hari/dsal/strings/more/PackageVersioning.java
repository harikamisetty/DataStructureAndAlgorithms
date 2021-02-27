package com.hari.dsal.strings.more;

public class PackageVersioning {

	public boolean solve(String older, String newer) {

		int oldValue = getnumberValue(older);
		int newValue = getnumberValue(newer);

		if (newValue > oldValue) {
			return true;
		}
		return false;
	}

	private int getnumberValue(String str) {
		int i = 0, result = 0;
		while (str.length() > i) {

			if (str.charAt(i) == '.') {
				i++;
				continue;
			}
			if (str.charAt(i) >= '0' && str.charAt(i) <= '9')
				result = result * 10 + (str.charAt(i) - '0');
			i++;

		}
		return result;
	}

	public static void main(String[] args) {
		PackageVersioning pv = new PackageVersioning();
		System.out.println(pv.solve("11.2.3", "11.2.5"));
	}
}
