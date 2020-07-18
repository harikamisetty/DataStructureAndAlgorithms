package com.hari.dsal.leetcode;

public class OneBitTwoBitCharacter {
	
	public boolean isOneBitCharacter(int[] bits) {
        if(bits== null || bits.length ==0)
            return true;
        if(bits.length == 2){
            if(bits[0] == 0)
                return true;
               else
                   return false;
        }
            
        if(bits.length % 2 ==0)
            return false;
        for(int j=0; j< bits.length;j++){
            if(bits[j] ==1)
                break;
            if(j==bits.length-1)
            return true;
        }
        for(int i=0; i<bits.length-2;i=+2){
            if(bits[i]==0)
                return false;
        }         
       return true;
        
    }
	
	public static void main(String[] args) {
		OneBitTwoBitCharacter obc = new OneBitTwoBitCharacter();
		int []bits = {0,0,0};
		System.out.println(obc.isOneBitCharacter(bits));
		
	}
}
