package com.hari.dsal.strings;

public class RepeatedSubstringPattern {

	public boolean isRepeatedSubstringPattern(String str) {

		int l = str.length();

		for (int i = l / 2; i >= 1; i--) {
			if (l % i == 0) {
				int m = l / i;
				String subS = str.substring(0, i);
				StringBuilder sb = new StringBuilder();

				for (int j = 0; j < m; j++) {
					sb.append(subS);
				}

				if (sb.toString().equals(str))
					return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		RepeatedSubstringPattern rsp = new RepeatedSubstringPattern();
		String str = "howhowhowhowhow";
		System.out.println(rsp.isRepeatedSubstringPattern(str));
	}
}
