package com.hari.dsal.Amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseSchedule1_207 {

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		// write your code here
		if (numCourses <= 0 || prerequisites == null || prerequisites.length == 0) {
			return true;
		}

		// step 1: create adjlist and in-=degree map
		//
		Map<Integer, Integer> nodeToIndegreeMap = new HashMap<>();
		Map<Integer, List<Integer>> adjList = new HashMap<>();

		for (int i = 0; i < numCourses; i++) {
			nodeToIndegreeMap.put(i, 0);
			adjList.put(i, new ArrayList<>());
		}

		for (int[] prerequisite : prerequisites) {
			int inDegree = nodeToIndegreeMap.get(prerequisite[1]);
			inDegree += 1;
			nodeToIndegreeMap.put(prerequisite[1], inDegree);
		}

		for (int[] prerequisite : prerequisites) {
			List<Integer> neighbors = adjList.get(prerequisite[0]);
			if(neighbors != null) {
			neighbors.add(prerequisite[1]);
			adjList.put(prerequisite[0], neighbors);
			}
		}

		// step 2: get all nodes with indegree 0 and put into the queuue
		//
		Queue<Integer> queue = new LinkedList<>();
		int numNodes = 0;
		for (Integer key : nodeToIndegreeMap.keySet()) {
			int indegree = nodeToIndegreeMap.get(key);
			if (indegree == 0) {
				queue.offer(key);
				numNodes += 1;
			}
		}

		while (!queue.isEmpty()) {
			int curNode = queue.poll();
			for (int neighbor : adjList.get(curNode)) {
				int indegree = nodeToIndegreeMap.get(neighbor);
				indegree -= 1;
				nodeToIndegreeMap.put(neighbor, indegree);

				if (indegree == 0) {
					queue.offer(neighbor);
					numNodes += 1;
				}
			}
		}

		return numNodes == numCourses;
	}

	public static void main(String[] args) {
		
		int numCourses = 5, prerequisites [][]= {{1,0},{2,0},{3,1},{4,3}};
		
		CourseSchedule1_207 cs207 = new CourseSchedule1_207();
		System.out.println(cs207.canFinish(numCourses, prerequisites));
		

	}
}
