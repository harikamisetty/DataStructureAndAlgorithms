package com.hari.dsal.Amazon;

public class LookAndSay {
	public String solve(int n) {
		String prev = "1";
		n -= 1;

		for (int i = 0; i < n; i++) {
			StringBuilder next = new StringBuilder();

			int count = 1;
			for (int idx = 1; idx < prev.length(); idx++) {
				if (prev.charAt(idx) == prev.charAt(idx - 1)) {
					count += 1;
				} else {
					next.append(Integer.toString(count));
					next.append(prev.charAt(idx - 1));
					count = 1;
				}
			}
			next.append(Integer.toString(count));
			next.append(prev.charAt(prev.length() - 1));

			prev = next.toString();
		}
		return prev;
	}
	
	public static void main(String[] args) {
		LookAndSay las = new LookAndSay();
		
		System.out.println(las.solve(5));
	}
}
