package com.hari.dsal.implementations;

public class LongestAbsoluteFilePath {
	
	private int longPath(String filePath) {
		
		String[] path = filePath.split("\n");
		int[] stack = new int[path.length +1];
		int maxLen =0;
		
		for(String str : path) {
			int lev = str.lastIndexOf("\t") + 1;
			int curLen = stack[lev + 1] = stack[lev] + str.length() - lev +1;
			
			if(str.contains("."))
				maxLen = Math.max(maxLen, curLen - 1);
		}
		return maxLen;
	}
	
	public static void main(String[] args) {
		LongestAbsoluteFilePath lbfp = new LongestAbsoluteFilePath();
		System.out.println(lbfp.longPath("dir\n\tstrdir1\n\tfile1.txt\n\tdir\n\tstrdir2\n\thello\n\tfile2.txt"));
	}

}
