package com.hari.dsal.backtrack;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

	private List<List<String>> getPalindromes(String s){
		List<List<String>> res =new ArrayList<>();
		palindromeHelper(res, new ArrayList<>(),s,0);
		return res;
	}

	private void palindromeHelper(List<List<String>> res, List<String> temp, String s, int start) {

		if(start == s.length()) {
			res.add(new ArrayList<>(temp));
		}else {
			for(int i = start; i< s.length(); i++) {
				if(isPalindrome(s,start,i)) {
					temp.add(s.substring(start, i+1));
					palindromeHelper(res, temp, s, i+1);
					temp.remove(temp.size()-1);
				}
			}
		}
	}

	private boolean isPalindrome(String s, int low, int high) {
		while(low < high)
			if(s.charAt(low++) != s.charAt(high--))
				return false;
		return true;
	}

	public static void main(String[] args) {
		PalindromePartitioning pp = new PalindromePartitioning();

		List<List<String>> res = pp.getPalindromes("aab");
		System.out.println("Hello");
		res.forEach(val ->{
			System.out.print("[");
			val.forEach(k->{
				System.out.print(k+",");
			});
			System.out.println("]");
		});
	}
}
