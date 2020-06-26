package com.hari.dsal.dailyCodingProblem;

public class Problem_210 {
	
	private boolean isManipulationCorrect(int num) {		
		Boolean results = new Boolean(false);
		manipulationHelper(results ,num);
		return results;
	}

	private void manipulationHelper(Boolean results, int num) {
		System.out.print(num +" ");
		if(num <=0) {
			results = false;
			return;
		} else if(num ==1) {
			results = true;
			return;
		} else {
			if(num %2 ==0) {
				manipulationHelper(results, num/2); 
			} else {
				manipulationHelper(results, 3*num+1);
			}
		}		
	}
	
	public static void main(String[] args) {
		Problem_210 p210 = new Problem_210();
		System.out.println(p210.isManipulationCorrect(20));
	}
}

