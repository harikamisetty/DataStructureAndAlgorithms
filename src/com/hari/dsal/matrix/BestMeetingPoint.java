package com.hari.dsal.matrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BestMeetingPoint {
	
	public int minTotalDistance(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
         
        int m = grid.length;
        int n = grid[0].length;
         
        List<Integer> rowIndex = new ArrayList<>();
        List<Integer> colIndex = new ArrayList<>();
         
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rowIndex.add(i);
                    colIndex.add(j);
                }
            }
        }
         
        int sum = 0;
        int mid = rowIndex.get(rowIndex.size() / 2); //Find mid ROW 
        for (int x : rowIndex) {
            sum += Math.abs(x - mid); //Delete MID from each pointer
        }
         
        Collections.sort(colIndex);
        mid = colIndex.get(colIndex.size() / 2); //Find mid COLUMN
         
        for (int y : colIndex) {
            sum += Math.abs(y - mid); //Delete MID from each pointer
        }
         
        return sum;
    }
	
	 public int minTotalDistance1(int[][] grid) {
	        // Write your code here
	        List<Integer> x = new ArrayList<>();
	        List<Integer> y = new ArrayList<>();
	        for (int i = 0; i < grid.length; i++) {
	            for (int j = 0; j < grid[0].length; j++) {
	                if (grid[i][j] == 1) {
	                    x.add(i);
	                    y.add(j);
	                }
	            }
	        }
	        return getMD(x) + getMD(y);
	    }
	    public int getMD(List<Integer> nums) {
	        // zhong dian is here
	        Collections.sort(nums);
	        int i = 0, j = nums.size()-1;
	        int distance = 0;
	        while (i < j) {
	            distance += nums.get(j--) - nums.get(i++);
	        }
	        return distance;
	    }
	
	public static void main(String[] args) {
		
		int grid[][] = { { 1, 0, 0, 0, 1 }, 
						 { 0, 0, 0, 0, 0 }, 
						 { 0, 0, 1, 0, 0 } 
					   };
		
		BestMeetingPoint bmp = new BestMeetingPoint();
		System.out.println(bmp.minTotalDistance(grid));
	}
}
