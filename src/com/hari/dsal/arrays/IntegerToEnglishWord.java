package com.hari.dsal.arrays;

public class IntegerToEnglishWord {
	
	static String [] words= {"one","two","three","four","five","six", "seven","eight","nine"};
	static String[] dict1 = { "", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine ", "Ten ",
			"Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ",
			"Nineteen " };
	static String[] dict2 = { "", "", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ",
			"Ninety " };
	
	private static void intToEnglish(int i) {
		
		String s = new StringBuffer(String.valueOf(i)).reverse().toString(); // Reverse String
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
			res = res + getLevel2Details(res, dict1, dict2);
		} 
		return res;
	}

	private static String getLevel2Details(String res, String[] dict1, String[] dict2) {
		
		StringBuffer result = new StringBuffer();
		int num = Integer.valueOf(res);
		
		int a = num / 100;
		int b = num % 100;
		int c = num % 10;

		if (a > 0) {
			result.append(dict1[a] + "Hundred ");
		}

		if (b > 0 && b < 20) {
			result.append(dict1[b]);
			c = 0;
		} else if (b >= 20) {
			b /= 10;
			result.append(dict2[b]);
		}

		if (c > 0) {
			result.append(dict1[c]);
		}

		return result.toString();
		
	}
	
	public static void main(String[] args) {
		intToEnglish(4300);
	}
}
