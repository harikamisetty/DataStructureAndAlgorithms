package com.hari.dsal.dailyCodingProblem;

public class Problem_206 {
	
	private String[] getRespectedStrings(int[] input) {
		
		String[] res = new String[input.length];
		int i=0;
		
		for(int val: input) {
			int intVal = val % 26;
			intVal=intVal+64;
			
			char charval = (char)intVal;
			String str = String.valueOf((char)intVal);
			res[i++] = str;
		}
		return res;
	}
	
	public static void main(String[] args) {
		Problem_206 p206 = new Problem_206();
		int[] input = {2,1,3};
		String res [] =p206.getRespectedStrings(input);
		
		for(String str : res) {
			System.out.println(str);
		}
	}

}
