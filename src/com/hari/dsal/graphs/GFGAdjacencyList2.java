package com.hari.dsal.graphs;

//Java implementation of the approach 
import java.util.ArrayList; 
import java.util.Arrays; 
import java.util.List; 

public class GFGAdjacencyList2 { 

	// Function to print the path from 
	// source (s) to destination (d) 
	static void print(int parent[], int s, int d) 
	{ 
		// The while loop will stop only when the 
		// destination and the source node become equal 
		while (s != d) { 

			// Print the destination and store the parent 
			// of the node in the destination since parent 
			// stores the node through which 
			// the current node has been reached 
			System.out.print(d + " <- "); 
			d = parent[d]; 
		} 

		System.out.println(d); 
	} 

	// Finding Path using BFS ALgorithm 
	static void bfs(List<List<Integer> > adjList, int source, int n) 
	{ 
		int parent[] = new int[n]; 
		int que[] = new int[n]; 
		int visited[] = new int[n]; 
		
		Arrays.fill(parent, 0); 
		Arrays.fill(que, 0); 
		Arrays.fill(visited, 0); 

		int front = -1, rear = -1; 
		
		visited[source] = 1; 
		parent[source] = source; 

		// To add any non visited node we will increment the rear 
		// and add that vertex to the end of the array (enqueuing) 
		que[++rear] = source; 

		int k; 

		// The loop will continue till the rear and front are equal 
		while (front != rear) { 

			// Here Dequeuing is nothing but to increment the front int 
			k = que[++front]; 
			List<Integer> list = adjList.get(k); 
			for (int i = 0; i < list.size(); i++) { 
				int j = list.get(i); 
				if (visited[j] == 0) { 
					que[++rear] = j; 
					visited[j] = 1; 
					parent[j] = k; 
				} 
			} 
		} 

		// Print the path from source to every other node 
		for (k = 0; k < n; k++) 
			print(parent, source, k); 
	} 

	// Driver code 
	public static void main(String args[]) 
	{ 

		// Adjacency list representation of the graph 
		List<List<Integer> > adjList = new ArrayList<>(); 

		// Vertices 1 and 2 have an incoming edge 
		// from vertex 0 
		List<Integer> tmp = new ArrayList<Integer>(Arrays.asList(1, 2)); 
		adjList.add(tmp); 

		// Vertex 3 has an incoming edge from vertex 1 
		tmp = new ArrayList<Integer>(Arrays.asList(3)); 
		adjList.add(tmp); 

		// Vertices 0, 5 and 6 have an incoming 
		// edge from vertex 2 
		tmp = new ArrayList<Integer>(Arrays.asList(0, 5, 6)); 
		adjList.add(tmp); 

		// Vertices 1 and 4 have an incoming edge 
		// from vertex 3 
		tmp = new ArrayList<Integer>(Arrays.asList(1, 4)); 
		adjList.add(tmp); 

		// Vertices 2 and 3 have an incoming edge 
		// from vertex 4 
		tmp = new ArrayList<Integer>(Arrays.asList(2, 3)); 
		adjList.add(tmp); 

		// Vertices 4 and 6 have an incoming edge 
		// from vertex 5 
		tmp = new ArrayList<Integer>(Arrays.asList(4, 6)); 
		adjList.add(tmp); 

		// Vertex 5 has an incoming edge from vertex 6 
		tmp = new ArrayList<Integer>(Arrays.asList(5)); 
		adjList.add(tmp); 

		int n = adjList.size(); 

		int source = 2; 
		bfs(adjList, source, n); 
	} 
} 

