package com.hari.dsal.Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriticalConnectionsinaNetwork_L1192 {
	boolean[] visited; // Whether we visited this node before
	List<Integer>[] graph; // Adjacent list of the graph
	int[] low; // Low value of this node: lowest id this node can reach
	int[] ids; // Id of this node
	int id; // Current id
	List<List<Integer>> ans;// List of all the critical connections

	public List<List<Integer>> criticalConnections1(int n, List<List<Integer>> connections) {
		// Init the instance variables
		visited = new boolean[n];
		graph = new List[n];
		for (int i = 0; i < graph.length; i++)
			graph[i] = new ArrayList<>();
		low = new int[n];
		ids = new int[n];
		id = 0;
		ans = new ArrayList<>();

		// Init the graph adjacent list
		for (List<Integer> c : connections) {
			graph[c.get(0)].add(c.get(1));
			graph[c.get(1)].add(c.get(0));
		}

		// Run DFS from every possible nodes in the graph
		id = 0;
		for (int i = 0; i < n; i++) {
			// Start DFS from node i with no parent
			if (!visited[i])
				DFS(i, -1);
		}

		return ans;
	}

	private void DFS(int at, int parent) {
		visited[at] = true;
		ids[at] = ++id;
		low[at] = ids[at];

		// For edge from "at" to "to"
		for (int to : graph[at]) {
			if (to == parent)
				continue; // Avoid duplicates: [1, 3] and [3, 1]

			if (!visited[to]) {
				DFS(to, at);
				low[at] = Math.min(low[at], low[to]); // Update low when children nodes reach nodes with lower id

				// If there is no other way between "at" and "to", this edge is a critical
				// connection
				if (ids[at] < low[to]) {
					ans.add(Arrays.asList(at, to));
				}

			} else {
				low[at] = Math.min(low[at], ids[to]); // Update low[at] because of the edge from "at" to "to"
														// ??: Can we use low[at] = Math.min(low[at], low[to]); here?
			}
		}
	}

	// Solution 2
	List<List<Integer>> results;
	// List<Integer>[] graph;
	int[] visitedTimes;
	int[] lowTimes;
	int time;

	public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

		if (connections == null)
			return null;

		results = new ArrayList<>();
		graph = new ArrayList[n];
		visitedTimes = new int[n];
		lowTimes = new int[n];

		// build graph using adjacency list
		buildGraph(connections);
		boolean[] visited = new boolean[n];
		dfs(visited, 0, -1);

		return results;
	}

	// dfs graph
	// Torzan Algorithms
	private void dfs(boolean[] visited, int currentNode, int parentNode) {
		visited[currentNode] = true;
		visitedTimes[currentNode] = lowTimes[currentNode] = time++;

		for (int neighbor : graph[currentNode]) {
			if (neighbor == parentNode)
				continue;
			if (!visited[neighbor]) {
				dfs(visited, neighbor, currentNode);
				lowTimes[currentNode] = Math.min(lowTimes[currentNode], lowTimes[neighbor]);
				if (visitedTimes[currentNode] < lowTimes[neighbor])
					results.add(Arrays.asList(currentNode, neighbor));
			} else {
				lowTimes[currentNode] = Math.min(lowTimes[currentNode], visitedTimes[neighbor]);
			}
		}
	}

	// build grapth from given connections
	// using adjacency list
	private void buildGraph(List<List<Integer>> connections) {
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}

		for (List<Integer> edge : connections) {
			int u = edge.get(0);
			int v = edge.get(1);
			graph[u].add(v);
			graph[v].add(u);
		}
	}

	public static void main(String[] args) {
		CriticalConnectionsinaNetwork_L1192 cc = new CriticalConnectionsinaNetwork_L1192();
		int n=4;
		List<List<Integer>> connections = new ArrayList<List<Integer>>();
		connections.add(Arrays.asList(0,1));
		connections.add(Arrays.asList(1,2));
		connections.add(Arrays.asList(2,0));
		connections.add(Arrays.asList(1,3));		
		
		cc.criticalConnections(n, connections);
	}
}
