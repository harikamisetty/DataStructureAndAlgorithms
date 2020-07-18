package com.hari.dsal.strings.more;

public class Strstr {
	// First Occurrence of a word position
	
	public static void main(String[] args) {
		System.out.println(strStr("hellohowareyouhowareyour","our"));
		System.out.println(strStr("mississippi","issip"));

	}
	
	// Best Solution
    public static int strStr(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }
        // Split the loop totalLength - wordLength and word Length
        for (int i = 0; i < (haystack.length() - needle.length()) + 1; i ++ ){
            for (int j = 0; j < needle.length(); j ++ ) {
                if (haystack.charAt(i+j) != needle.charAt(j)){
                    break;
                }
                if (j == needle.length() -1) {
                    return i;
                }
            }
        }
        return -1;
    }
    
    public static int strStr1(String haystack, String needle) {
        if(haystack==null || needle==null)
            return 0;
        if(haystack.length()==0 && needle.length()==0)
            return 0;
         if(haystack.length()==0) 
            return -1;
        if(needle.length()==0)
            return 0;
        if(haystack.equals(needle))
            return 0;
        int i=0, findl=needle.length(),j=0;
        
        while(i < haystack.length()){
            if(haystack.charAt(i) == needle.charAt(j)){
                while(j<findl){
                    if(haystack.charAt(i) == needle.charAt(j)){
                        i++;
                        j++;
                    } else {
                    	j=0;
                    	break;
                    }
                }
                if(j==findl &&haystack.indexOf(needle) != -1)
                    return i-j;
            }
            i++;
        }
        return -1;
    }

}
