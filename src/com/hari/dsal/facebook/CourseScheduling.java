package com.hari.dsal.facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseScheduling {
	
	private boolean getCourseScheduling(int[][] courses,int nooofcourse) {
		
		Map<Integer, Integer> nodetointeger = new HashMap<>();
		Map<Integer, List<Integer>> neibours = new HashMap<>();
		
		int indegree = 0;
		
		for(int i=0;i<courses.length;i++) {
			nodetointeger.put(i, 0);
			neibours.put(i,new ArrayList<>());
		}
		// On how many people I depend on ?
		for(int [] values : courses) {
			indegree = nodetointeger.get(values[1]);
			indegree++;
			nodetointeger.put(values[1], indegree);
		}
		
		// Who are my neighbors
		for(int [] values : courses) {
			List<Integer> temp = neibours.get(values[0]);
			if(temp== null)
				temp = new ArrayList<>();
			temp.add(values[1]);
			neibours.put(values[0],temp);
		}
		
		int noofnodes = 0;
		Queue<Integer> queue = new LinkedList<>();
		
		for(int node : nodetointeger.keySet()) {
			
			if(nodetointeger.get(node) == 0) {
				queue.offer(node);
				noofnodes++;				
			}			
		}
		
		while(!queue.isEmpty()) {			
			int value = queue.poll();
			
			for(int neighbour : neibours.get(value)) {
				int nevalue =nodetointeger.get(neighbour);
				nevalue--;
				nodetointeger.put(neighbour, nevalue);
				if(nevalue == 0 ) {
					queue.add(neighbour);
					noofnodes++;
				}
			}			
		}	
		
		return noofnodes==nooofcourse;
	}
	
	public static void main(String[] args) {
		
		int nooofcourse=5;
		int[][] courses = {{1,0},{2,0},{3,1},{4,3}};
		CourseScheduling cs = new CourseScheduling();
		System.out.println(cs.getCourseScheduling(courses, nooofcourse));
	}

}
