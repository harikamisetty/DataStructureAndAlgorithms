package com.hari.dsal.number;

public class IntegerToEnglishWord {
	
	static String [] words= {"one","two","three","four","five","six", "seven","eight","nine"};
	
	private static void intToEnglish(int i) {
		
		String s = new StringBuffer(String.valueOf(i)).reverse().toString();
		System.out.println(s);
		
		int temp = Integer.parseInt(s);
		int level = 4;
		while(temp> 0) {
			int num = temp % 10;
			System.out.print(getWord(num,level));
			temp = temp / 10;
			level--;
		}
	}

	private static String getWord(int num, int level) {
		String res = words[Integer.valueOf(num)-1];
		
		if(level == 4) {
			 res = res + " thousand"+ " ";
		} else if(level == 3) {
			 res = res + " Hundered"+ " ";
		}else if(level == 2) {
			 getLevel2Details(res);
		} 
		return res;
	}

	private static void getLevel2Details(String res) {
		
		
		
	}
	
	public static void main(String[] args) {
		intToEnglish(4300);
	}
}
