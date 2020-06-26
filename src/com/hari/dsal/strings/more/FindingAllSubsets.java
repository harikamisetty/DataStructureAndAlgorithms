package com.hari.dsal.strings.more;

/*
 * 
 * Input: 
S = {a, b, c, d}
Output:
{}, {a} , {b}, {c}, {d}, {a,b}, {a,c},
{a,d}, {b,c}, {b,d}, {c,d}, {a,b,c}, 
{a,b,d}, {a,c,d}, {b,c,d}, {a,b,c,d}

 */


class FindingAllSubsets 
{ 
	// Print all subsets of given set[] 
	static void printSubsets(char set[]) 
	{ 
		int n = set.length; 
		
		System.out.println(2^n);
		System.out.println(1<<n);

		// Run a loop for printing all 2^n 
		// subsets one by obe 
		for (int i = 0; i < (1<<n); i++) 
		{ 
			System.out.print("{ "); 

			// Print current subset 
			for (int j = 0; j < n; j++) 

				// (1<<j) is a number with jth bit 1 
				// so when we 'and' them with the 
				// subset number we get which numbers 
				// are present in the subset and which 
				// are not 
				if ((i & (1 << j)) > 0) 
					System.out.print(set[j] + " "); 

			System.out.println("}"); 
		} 
	} 

	// Driver code 
	public static void main(String[] args) 
	{ 
		char set[] = {'a', 'b', 'c'}; 
		printSubsets(set); 
	} 
}
