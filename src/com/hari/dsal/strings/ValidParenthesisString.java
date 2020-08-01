package com.hari.dsal.strings;

public class ValidParenthesisString {

	public static void main(String[] args) {
		ValidParenthesisString vps = new ValidParenthesisString();
		System.out.println(vps.checkValidString1("*********"));
	}

	public boolean checkValidString1(String s) {
		int lo = 0, hi = 0;
		for (char c : s.toCharArray()) {
			lo += c == '(' ? 1 : -1;
			hi += c != ')' ? 1 : -1;
			if (hi < 0)
				break;
			lo = Math.max(lo, 0);
		}
		return lo == 0;
	}

}
