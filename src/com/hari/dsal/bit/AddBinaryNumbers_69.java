package com.hari.dsal.bit;

public class AddBinaryNumbers_69 {
	private String add2Numbers(String a, String b) {
		
		StringBuilder sb = new StringBuilder();
		int i = a.length() - 1, j = b.length() - 1, carry = 0;
		
		while (i > -1 || j > -1) {
			int sum = carry;
			if (i > -1)
				sum += a.charAt(i--) - '0';
			if (j > -1)
				sum += b.charAt(j--) - '0';
			sb.append(sum % 2);
			carry = sum / 2;
		}
		
		if (carry != 0)
			sb.append(carry);

		return sb.reverse().toString();
	}
	
	 public String addBinary(String a, String b) {
		    StringBuilder sb = new StringBuilder();
		    int carry = 0;
		    int i = a.length() - 1;
		    int j = b.length() - 1;

		    while (i >= 0 || j >= 0 || carry == 1) {
		      if (i >= 0)
		        carry += a.charAt(i--) - '0';
		      if (j >= 0)
		        carry += b.charAt(j--) - '0';
		      sb.append(carry % 2);
		      carry /= 2;
		    }

		    return sb.reverse().toString();
		  }
	
	public static void main(String[] args) {
		AddBinaryNumbers_69 abn = new AddBinaryNumbers_69();
		System.out.println(abn.add2Numbers("10", "111"));
	}
}
