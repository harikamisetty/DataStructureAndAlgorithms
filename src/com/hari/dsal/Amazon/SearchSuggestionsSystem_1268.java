package com.hari.dsal.Amazon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SearchSuggestionsSystem_1268 {
	 public List<List<String>> suggestedProducts(String[] products, String searchWord) {
	        List<List<String>> result = new LinkedList<>();
	        Arrays.sort(products);
	        
	        for (int i = 1; i <= searchWord.length(); i++) {
	            String currentMatching = searchWord.substring(0, i);
	            List<String> list = new LinkedList<>();
	            for (String product : products) {
	                if (product.length() >= i && product.substring(0, i).equals(currentMatching)) {
	                    list.add(product);
	                    if (list.size() == 3) {
	                        break;
	                    }
	                }
	            }
	            result.add(list);
	        }
	        
	        return result;
	 }
	 
	 public static void main(String[] args) {
		String[] products = {"mobile","mouse","moneypot","monitor","mousepad"}; 
		String searchWord = "mouse";
		
		SearchSuggestionsSystem_1268 ss = new SearchSuggestionsSystem_1268();
		
		for (List<String> list : ss.suggestedProducts(products, searchWord)){
			System.out.println("\n");
			for(String str : list) {
				System.out.print(str+",");
			}
		}
	}
}
