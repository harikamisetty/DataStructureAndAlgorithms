package com.hari.dsal.leetcode;

public class BackspaceStringCompare {

	public boolean backspaceCompare(String S, String T) {

		if (S == null || T == null)
			return false;
		int i = 0, j = 0;
		if (S.contains("#")) {
			StringBuilder sb = new StringBuilder();
			while (i < S.length()) {
				if(S.charAt(i) != '#') {
					sb.append(S.charAt(i));
				}else if(i >0 && sb.length()>0) {
					sb.deleteCharAt(sb.length()-1);
				}
				i++;
			}
			S=sb.toString();
		}

		if (T.contains("#")) {
			StringBuilder sb1 = new StringBuilder();
			
			while(j < T.length()) {
				if(T.charAt(j) != '#') {
					sb1.append(T.charAt(j));
				}else if(j >0 && sb1.length()>0) {
					sb1.deleteCharAt(sb1.length()-1);
				}
				j++;
			}
			T = sb1.toString();
		}
		if(S.equalsIgnoreCase(T))
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		BackspaceStringCompare bssc = new BackspaceStringCompare();
		System.out.println(bssc.backspaceCompare("ab##", "a#c#"));
	}
}
