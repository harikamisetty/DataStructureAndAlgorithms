package com.hari.dsal.facebook;

import java.util.ArrayList;
import java.util.List;

public class ListPairing {
	 public String[] solve(String[] strs) {

	        if(strs == null || strs.length == 0)
	            return null;

	         List<String> res = new ArrayList<>();
	         for(int j=0;j<strs.length;j++){
	             if(strs[j].equals("blue"))
	             res.add(0,strs[j]);
	         }
	         for(int j=0;j<strs.length;j++){
	             if(strs[j].equals("green"))
	             res.add(0,strs[j]);
	         }
	         
	       
	         for(int j=0;j<strs.length;j++){
	             if(strs[j].equals("red"))
	             res.add(0,strs[j]);
	         }
	           
	        return res.stream().toArray(String[]::new);
	    }
	 
	 public static void main(String[] args) {
		 ListPairing lp = new ListPairing();
		 String[] strs = {"green", "blue", "red", "red"};
		for(String str: lp.solve(strs)) {
			 System.out.println(str);
		 }
	}
}
