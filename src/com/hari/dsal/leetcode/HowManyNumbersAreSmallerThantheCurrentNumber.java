package com.hari.dsal.leetcode;

import java.util.Arrays;

public class HowManyNumbersAreSmallerThantheCurrentNumber {
public int[] smallerNumbersThanCurrent(int[] nums) {
        
        int[] res = new int[nums.length];
        int[] temp = nums;
        
        Arrays.sort(temp);
        
        for(int i=0; i <nums.length; i++){
            for(int j=0; j< temp.length;j++){
                if(nums[i] == temp[j])
                    res[i] = j;
            }
        }
       return res; 
    }

public static void main(String[] args) {
	HowManyNumbersAreSmallerThantheCurrentNumber hn = new HowManyNumbersAreSmallerThantheCurrentNumber();
	
	int[] input = {8,1,2,2,3};
	int[] res = hn.smallerNumbersThanCurrent(input);
	
	for(int i=0; i < res.length; i++) {
		System.out.print(res[i]+ ",");
	}
}

}
