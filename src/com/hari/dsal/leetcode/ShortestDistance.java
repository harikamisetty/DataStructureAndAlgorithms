package com.hari.dsal.leetcode;

public class ShortestDistance {
	
	public int shortestDistance(String[] words, String word1, String word2) {
        int l = -1, r= -1;
        int shortest =words.length;
        for(int i=0; i< words.length; i++){
            if(word1.equals(words[i])){
                l = i;
            }else if(word2.equals(words[i])){
                r = i;
            }
            if(l >=0 && r >=0){
                shortest = Math.min(shortest, Math.abs(l-r));
            }
        }
        return shortest;
    }
	
	public static void main(String[] args) {
		ShortestDistance sd = new ShortestDistance();
		String[] words= {"practice", "makes", "perfect", "coding", "makes"};
		String word1= "makes";
		String word2 = "coding";
		System.out.println(sd.shortestDistance(words, word1, word2));
	}

}
