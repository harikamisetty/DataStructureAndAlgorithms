package com.hari.dsal.number;

import java.util.ArrayList;
import java.util.List;

public class NestedListWeight {
	
	 private static int maxDepth = 0;
	    public static int depthSumInverse(List<NestedInteger> nestedList) {
	        if (nestedList == null || nestedList.size() == 0) {
	            return 0;
	        }
	         
	        getDepth(1, nestedList);
	         
	        return depthSumHelper(maxDepth, nestedList);
	    }
	     
	    private static void getDepth(int level, List<NestedInteger> nestedList) {
	        maxDepth = Math.max(maxDepth, level);
	        for (NestedInteger n : nestedList) {
	            if (!n.isInteger()) {
	                getDepth(level + 1, n.getList());
	            }
	        }
	    }
	     
	    private static int depthSumHelper(int depth, List<NestedInteger> nestedList) {
	        int sum = 0;
	        for (NestedInteger n : nestedList) {
	            if (n.isInteger()) {
	                sum += depth * n.getInteger();
	            } else {
	                sum += depthSumHelper(depth - 1, n.getList());
	            }
	        }
	         
	        return sum;
	    }
	    
	    public static void main(String[] args) {
	    	List<NestedInteger> list = new ArrayList<NestedInteger>();
	    	NestedInteger main = new NestedInteger(list);
	    	
	    	NestedInteger nestedInteger = new NestedInteger();
	    	nestedInteger.setInteger(10);
	    	NestedInteger e = new NestedInteger(20);
			e.setInteger(20);
	    	nestedInteger.add(e);
	    	list.add(nestedInteger);
	    	
			main.add(nestedInteger);
			
			depthSumInverse(list);
		}
}
