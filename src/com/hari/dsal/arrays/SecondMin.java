package com.hari.dsal.arrays;

import java.util.ArrayList;
import java.util.List;

public class SecondMin {
	
	public static void main(String[] args) {
		int[] a = {2,2,5,5,7};
		List<Integer> res = new ArrayList<>();
		res.add(2);
		res.add(2);
		res.add(5);
		res.add(5);
		res.add(7);
		
		 int fmin =res.get(0), smin=res.get(1);
	        
	        if(fmin > smin)
	            fmin = smin;            
	            
	        for(int i=2;i< res.size();i++){
	        	 if(fmin==smin){
	        		 if(res.get(i) < fmin) {
	        			 fmin = res.get(i);
	        		 }else if( res.get(i) < smin) {
	        			 smin = res.get(i);
	        		 } else if(res.get(i) > fmin && res.get(i) < smin) {
	        			 smin = res.get(i);
	        		 } else {
	        			 smin = res.get(i);
	        		 }
	        		 
	        	 }else
	            if(res.get(i) < smin && res.get(i) > fmin){
	                smin = res.get(i);
	            } else if(res.get(i) < fmin){
	                fmin = res.get(i); 
	            }                
	        }
	        System.out.println(smin);
	}

}
