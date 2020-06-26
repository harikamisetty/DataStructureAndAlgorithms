package com.hari.dsal.strings.more;

public class Strstr {
	// First Occurrence of a word position
	
	public static void main(String[] args) {
		System.out.println(strStr("hellohowareyouhowareyour","our"));
	}

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

}
