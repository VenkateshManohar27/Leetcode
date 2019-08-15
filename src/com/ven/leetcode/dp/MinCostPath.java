package com.ven.leetcode.dp;

public class MinCostPath {

	// Driver code
	public static void main(String args[]) {

		int cost[][] = { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };

		
		System.out.println("minCost:" + minCost(cost,2,2));
		System.out.println("minCostRecursive:" + minCostRecursive(cost, 2, 2));

		
	}

	 private static int minCost(int cost[][], int m, int n) 
	    { 
	        int i, j; 
	        int tc[][]=new int[m+1][n+1]; 
	  
	        tc[0][0] = cost[0][0]; 
	  
	        /* Initialize first column of total cost(tc) array */
	        for (i = 1; i <= m; i++) 
	            tc[i][0] = tc[i-1][0] + cost[i][0]; 
	  
	        /* Initialize first row of tc array */
	        for (j = 1; j <= n; j++) 
	            tc[0][j] = tc[0][j-1] + cost[0][j]; 
	  
	        /* Construct rest of the tc array */
	        for (i = 1; i <= m; i++) 
	            for (j = 1; j <= n; j++) 
	                tc[i][j] = min(tc[i-1][j-1],  
	                               tc[i-1][j], 
	                               tc[i][j-1]) + cost[i][j]; 
	  
	        return tc[m][n]; 
	    } 

	private static int minCostRecursive(int[][] cost, int i, int j) {
		if (i < 0 || j < 0) {
			return Integer.MAX_VALUE;
		}

		if (i == 0 && j == 0) {
			return cost[i][j];
		}

		return cost[i][j] + min(minCostRecursive(cost, i, j - 1), minCostRecursive(cost, i - 1, j - 1),
				minCostRecursive(cost, i - 1, j));
	}

	private static int min(int i, int j, int k) {
		int res = (i < j) ? i : j;
		res = (res < k) ? res : k;
		return res;
	}
}
