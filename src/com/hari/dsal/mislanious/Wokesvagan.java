package com.hari.dsal.mislanious;

public class Wokesvagan {
	
	public static void main(String[] args) {
		char cArr[][] = {{'a','a','a','b'},{'a','b','c','c'},{'b','c','b','b'},{'b','c','b','b'}};
		
		int result = noOfCollers(cArr);
	}

	private static int noOfCollers(char[][] cArr) {
		
		int m = cArr.length;
		int n = cArr[0].length;
		
		// allocate two addtional space to store zeros
        boolean[][] boolMat = new boolean[m][n];
        boolean[] col = new boolean[n];
		
        char initial = cArr[0][0];
        boolMat[0][0] = true;
        int j = 1;
        int colorCount = 0;
        
        for(int p =0; p < m; p++) {
        	while(j<m) {
        	if(cArr[p][j] == initial) {
        		j++;
        		boolMat[p][j] = true;
        		} else if(cArr[++p][j] == initial){
        			j++;
        			boolMat[++p][j] = true;
        		}else {
        			initial = cArr[p][j];
        		}
        	}
        	
        }
        
        
		for(int i = 0; i< m ; i++) {
			
			if(m < i && n<j) {
				return colorCount;
			}
			
			if(cArr[i][j] != initial && cArr[++i][j] != initial) {
								
			} else {
				colorCount++;
			}
			
		}
		
		return colorCount;
	}

}
