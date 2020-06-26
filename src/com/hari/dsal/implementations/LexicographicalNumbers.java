package com.hari.dsal.implementations;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {
	
	private List<Integer> getLexicographicalNumbers(int num) {
		List<Integer> res = new ArrayList<Integer>();
		int curr =1;
		
		for(int i =1; i<=num; i++) {
			res.add(curr);
			
			if(curr * 10<= num) {
				curr= curr * 10;
			} else if(curr % 10 != 9 && curr + 1 <= num){
				curr++;
			} else {
				while((curr / 10) % 10 == 9) {
					curr = curr / 10;
				}
				curr = curr / 10 + 1;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		LexicographicalNumbers ln = new LexicographicalNumbers();
		List<Integer> res = ln.getLexicographicalNumbers(9);
		
		res.forEach(e -> System.out.println(e));
	}
}
