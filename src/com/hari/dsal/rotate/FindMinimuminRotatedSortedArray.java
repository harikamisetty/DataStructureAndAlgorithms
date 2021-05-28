package com.hari.dsal.rotate;

public class FindMinimuminRotatedSortedArray {
	
	public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
         
        int lo = 0;
        int hi = nums.length - 1;
         
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
             
            if (nums[lo] < nums[hi]) {
                return nums[lo];
            } else if (nums[mid] < nums[hi]) {
                hi = mid;
            } else if (nums[lo] < nums[mid]) {
                lo = mid;
            }
        }
         
        return Math.min(nums[lo], nums[hi]);
    }
	
	private int findMinimum(int[] a) {
		int l =0, r = a.length -1;
		
		while(l<r) {
			int mid = (l+r) /2;
			
			if(a[mid]< a[r]) {
				r = mid;
			} else if(a[mid] > a[r]) {
				l = mid +1;
			}else {
				r --;
			}
		}
		return a[l];
	}
	
	public static void main(String[] args) {
		int[] A= {4,5,6,7,0,1,2};
		//int[] A= {3,2,1,0,4,5,6,7,8};
		FindMinimuminRotatedSortedArray fmrsa = new FindMinimuminRotatedSortedArray();
		System.out.println(fmrsa.findMin(A));
		System.out.println(fmrsa.findMinimum(A));
	}
}
