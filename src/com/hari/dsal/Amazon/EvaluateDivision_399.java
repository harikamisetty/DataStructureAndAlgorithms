package com.hari.dsal.Amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision_399 {

	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

		HashMap<String, HashMap<String, Double>> graph = new HashMap<>();

		// Step 1). build the graph from the equations
		for (int i = 0; i < equations.size(); i++) {
			List<String> equation = equations.get(i);
			String dividend = equation.get(0), divisor = equation.get(1);
			double quotient = values[i];

			if (!graph.containsKey(dividend))
				graph.put(dividend, new HashMap<String, Double>());
			if (!graph.containsKey(divisor))
				graph.put(divisor, new HashMap<String, Double>());

			graph.get(dividend).put(divisor, quotient);
			graph.get(divisor).put(dividend, 1 / quotient);
		}

		// Step 2). Evaluate each query via bactracking (DFS)
		// by verifying if there exists a path from dividend to divisor
		double[] results = new double[queries.size()];
		for (int i = 0; i < queries.size(); i++) {
			List<String> query = queries.get(i);
			String dividend = query.get(0), divisor = query.get(1);

			if (!graph.containsKey(dividend) || !graph.containsKey(divisor))
				results[i] = -1.0;
			else if (dividend == divisor)
				results[i] = 1.0;
			else {
				HashSet<String> visited = new HashSet<>();
				results[i] = backtrackEvaluate(graph, dividend, divisor, 1, visited);
			}
		}

		return results;
	}

	private double backtrackEvaluate(HashMap<String, HashMap<String, Double>> graph, String currNode, String targetNode,
			double accProduct, Set<String> visited) {

		// mark the visit
		visited.add(currNode);
		double ret = -1.0;

		Map<String, Double> neighbors = graph.get(currNode);
		if (neighbors.containsKey(targetNode))
			ret = accProduct * neighbors.get(targetNode);
		else {
			for (Map.Entry<String, Double> pair : neighbors.entrySet()) {
				String nextNode = pair.getKey();
				if (visited.contains(nextNode))
					continue;
				ret = backtrackEvaluate(graph, nextNode, targetNode, accProduct * pair.getValue(), visited);
				if (ret != -1.0)
					break;
			}
		}

		// unmark the visit, for the next backtracking
		visited.remove(currNode);
		return ret;
	}
	// Solution #2
	 public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
         Map<String, List<String>> pairs = new HashMap<>();
         Map<String, List<Double>> valuePairs = new HashMap<>();
         for (int i = 0; i < equations.length; i++) {
             String[] equation = equations[i];
             if (!pairs.containsKey(equation[0])) {
                 pairs.put(equation[0], new ArrayList<>());
                 valuePairs.put(equation[0], new ArrayList<>());
             }
             if (!pairs.containsKey(equation[1])) {
                 pairs.put(equation[1], new ArrayList<>());
                 valuePairs.put(equation[1], new ArrayList<>());
             }
             pairs.get(equation[0]).add(equation[1]);
             pairs.get(equation[1]).add(equation[0]);
             valuePairs.get(equation[0]).add(values[i]);
             valuePairs.get(equation[1]).add(1 / values[i]);
         }

         double[] result = new double[queries.length];
         for (int i = 0; i < queries.length; i++) {
             String[] query = queries[i];
             result[i] = dfs(query[0], query[1], pairs, valuePairs, new HashSet<>(), 1.0);
             if (result[i] == 0.0) {
                 result[i] = -1.0;
             }
         }
         return result;
     }

     private double dfs(String start, String end, Map<String, List<String>> pairs,
         Map<String, List<Double>> valuePairs, HashSet<String> set, double value) {
         if (set.contains(start)) {
             return 0.0;
         }
         if (!pairs.containsKey(start)) {
             return 0.0;
         }
         if (start.equals(end)) {
             return value;
         }
         set.add(start);

         List<String> stringList = pairs.get(start);
         List<Double> valueList = valuePairs.get(start);
         double tmp = 0.0;
         for (int i = 0; i < stringList.size(); i++) {
             tmp = dfs(stringList.get(i), end, pairs, valuePairs, set, value * valueList.get(i));
             if (tmp != 0.0) {
                 break;
             }
         }
         set.remove(start);
         return tmp;
     }
     
     public static void main(String[] args) {
    	String[][] equations = {{"a","b"},{"b","c"}};
    	double[]values = {2.0,3.0};
    	String[][] queries = {{"a","c"},{"b","a"},{"a","e"},{"a","a"},{"x","x"}};
    	
    	EvaluateDivision_399 ed = new EvaluateDivision_399();
    	for(double val : ed.calcEquation(equations, values, queries)) {
    		System.out.println(val);
    	}
	}
}
