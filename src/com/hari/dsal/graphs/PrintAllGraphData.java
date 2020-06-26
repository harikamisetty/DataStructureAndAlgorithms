package com.hari.dsal.graphs;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PrintAllGraphData {

	private void graphOperations() {

		printAllvertices(initializeGraphData());
		BFT(initializeGraphData());
		DFS(initializeGraphData());
		DFSWithStack(initializeGraphData());
		DijkstraShortestPath(initializeGraphArray(),0);
	}
	static final int V=9; 

	private void DijkstraShortestPath(int[][] graph, int src) {

		int dist[] = new int[V]; // The output array. dist[i] will hold
		// the shortest distance from src to i

		// sptSet[i] will true if vertex i is included in shortest 
		// path tree or shortest distance from src to i is finalized 
		Boolean sptSet[] = new Boolean[V];

		// Initialize all distances as INFINITE and stpSet[] as false 
		for (int i = 0; i < V; i++) {
			dist[i] = Integer.MAX_VALUE;
			sptSet[i] = false;
		}

		// Distance of source vertex from itself is always 0 
		dist[src] = 0;

		// Find shortest path for all vertices 
		for (int count = 0; count < V - 1; count++) {
				// Pick the minimum distance vertex from the set of vertices 
				// not yet processed. u is always equal to src in first 
				// iteration. 
			int u = minDistance(dist, sptSet);

			// Mark the picked vertex as processed 
			sptSet[u] = true;

				// Update dist value of the adjacent vertices of the 
				// picked vertex. 
			for (int v = 0; v < V; v++)

				// Update dist[v] only if is not in sptSet, there is an 
				// edge from u to v, and total weight of path from src to 
				// v through u is smaller than current value of dist[v] 
				if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
					dist[v] = dist[u] + graph[u][v];
		}

		// print the constructed distance array 
		printSolution(dist, V);
	}
	
	int minDistance(int dist[], Boolean sptSet[]) 
	{ 
		// Initialize min value 
		int min = Integer.MAX_VALUE, min_index=-1; 

		for (int v = 0; v < V; v++) 
			if (sptSet[v] == false && dist[v] <= min) 
			{ 
				min = dist[v]; 
				min_index = v; 
			} 

		return min_index; 
	}
	
		// A utility function to print the constructed distance array 
		void printSolution(int dist[], int n) 
		{ 
			System.out.println("Vertex Distance from Source"); 
			for (int i = 0; i < V; i++) 
				System.out.println(i+" tt "+dist[i]); 
		} 



	private static void DFSWithStack(Graph graph) {
		System.out.println(" DFS With Stack Operation ............");
		if (graph == null)
			return;
		int s = 0;
		boolean visited[] = new boolean[graph.V];
		Stack<Integer> stack = new Stack<>();
		if (graph.adj[0] != null)
			s = 0;
		stack.push(0);
		
		while (!stack.isEmpty()) {
			int res = stack.pop();
			visited[res] = true;
			System.out.println(res);
			for (int data : graph.adj[res]) {
				if (!visited[data]) {
					visited[data] = true;
					stack.push(data);
				}
			}
		}
	}

	private static void DFS(Graph graph) {
		boolean visited[] = new boolean[graph.V]; 
		DFSUtil(graph,graph.V, visited); 
	}

	private static void DFSUtil(Graph graph, int v, boolean[] visited) {

		// Mark the current node as visited and print it
		visited[v] = true;
		System.out.print(v + " ");

		// Recur for all the vertices adjacent to this vertex
		Iterator<Integer> i = graph.adj[v].listIterator();
		while (i.hasNext()) {
			int n = i.next();
			if (!visited[n])
				DFSUtil(graph,n, visited);
		}

	}

	private static void BFT(Graph graph) {
		System.out.println("BFT Traversal ...........");
		if(graph ==null) return;
		int s = 0;
		boolean visited[] = new boolean[graph.V]; 
		Queue<Integer> queue = new LinkedList<>();
		if(graph.adj[0] != null) 
			s = 0;
		queue.add(0);
		System.out.println(s);
		while(!queue.isEmpty()) {
			visited[s] = true;
			int value = queue.poll();
			//System.out.println(value);
			for(int res : graph.adj[value]) {
				if(!visited[res]) {
					System.out.println(res);
					queue.add(res);
					visited[res] = true;
				}
			}
		}
		
	}

	private static void printAllvertices(Graph g) {

		for (int i = 0; i < g.V; i++) {
			// System.out.println(g.adj[i].element());
			for (Integer data : g.adj[i]) {
				System.out.println(" Data id " + data);
			}
		}
	}

	private static Graph initializeGraphData() {

		Graph g = new Graph(4);

		g.addEdge(0, 2);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		return g;
	}
	
	private static int[][] initializeGraphArray() {
		int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0}, 
			{4, 0, 8, 0, 0, 0, 0, 11, 0}, 
			{0, 8, 0, 7, 0, 4, 0, 0, 2}, 
			{0, 0, 7, 0, 9, 14, 0, 0, 0}, 
			{0, 0, 0, 9, 0, 10, 0, 0, 0}, 
			{0, 0, 4, 14, 10, 0, 2, 0, 0}, 
			{0, 0, 0, 0, 0, 2, 0, 1, 6}, 
			{8, 11, 0, 0, 0, 0, 1, 0, 7}, 
			{0, 0, 2, 0, 0, 0, 6, 7, 0} 
			}; 
			return graph;
	}

	public static void main(String[] args) {
		BFT(initializeGraphData());
		DFSWithStack(initializeGraphData());

	}
}
