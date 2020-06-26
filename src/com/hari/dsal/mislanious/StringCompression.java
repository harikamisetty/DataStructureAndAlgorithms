package com.hari.dsal.mislanious;

public class StringCompression {

	public static void main(String[] args) {
		String str = "aaaaaaaa";
		System.out.println(compressString(str));
	}

	private static String compressString(String str) {

		if (str == null)
			return null;

		char strChar[] = str.toCharArray();
		char prechar = strChar[0];
		StringBuffer resStr = new StringBuffer();
		int start = 0;

		while (start < strChar.length) {
			prechar = strChar[start];
			int count = 0;
			for (int i = start + 1; i < strChar.length; i++) {
				if (prechar != strChar[i])
					break;

				if (prechar == strChar[i] && strChar[i] >= 'a' && strChar[i] <= 'z') {
					count++;
				}
				if (start == i) {
					start++;
				}
				;
				start = i;
			}
			start++;
			resStr.append(prechar);

			if (count > 0)
				resStr.append(count + 1);

		}
		return resStr.toString();
	}
}
