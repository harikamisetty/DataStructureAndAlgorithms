package com.hari.dsal.mislanious;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SalesForce {

	public List<Integer> predictAnswer(List<Integer> stockData, List<Integer> queries) {

		List<Integer> res = new ArrayList<>();

		if (stockData == null || queries == null) {
			res.add(-1);
		} else {

			int[] intArr = stockData.stream().mapToInt(Integer::intValue).toArray();
			int slen = intArr.length;

			for (int qval : queries) {
				if (qval > slen) {
					res.add(-1);
					continue;
				}
				int val = intArr[qval-1];
				
				if(qval ==1)
					res.add(findNearValue(intArr, val,qval-1));
				else
				if (intArr[qval] > val && intArr[qval - 2] > val) {
					res.add(findSmallValue(intArr, val, qval));
				} else if (intArr[qval] < val && intArr[qval - 2] < val) {
					res.add(findNearValue(intArr, val, qval));
				} else {
					res.add(qval-1);
				}
			}
		}
		return res;
	}

	private Integer findNearValue(int[] intArr, int val, int index) {
		
		if(intArr[index-1] > intArr[index+1]) {
			return index-1;
		} if (intArr[index-1] == intArr[index+1]) {
			return findSmallValue(intArr, val, index);
		}		
		return -1;
	}

	private Integer findSmallValue(int[] arr,int K, int index) {
		int res = arr[0];
		int N = arr.length;
		System.out.println(K);
		for(int i = 1; i < N; i++) 
	    {	      
	        if (Math.abs(K - res) > Math.abs(K - arr[i]))
	        {
	            res = arr[i];
	        }
	        
	    }
		System.out.println(res);
		int fres =-1;
		for(int i = 1; i < N; i++) {
			if(res == arr[i]) {
				fres = i;
			}
		}		
		return fres-1;
	}

	public static void main(String[] args) {
		
		SalesForce sf = new SalesForce();
		List<Integer> stockData = Arrays.asList(5, 6, 8, 4, 9, 10, 8, 3, 6, 4);
		List<Integer> queries = Arrays.asList(5);
		List<Integer> res = sf.predictAnswer(stockData, queries);
		
		for(int val : res) {
			System.out.println(val);
		}
	} 

}
