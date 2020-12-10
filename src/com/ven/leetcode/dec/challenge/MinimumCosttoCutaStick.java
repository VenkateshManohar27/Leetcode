package com.ven.leetcode.dec.challenge;

import java.util.Arrays;

public class MinimumCosttoCutaStick {
	/*private static int MIN = Integer.MAX_VALUE;

	public int minCost(int n, int[] cuts) {
		Arrays.sort(cuts);
		return helper(n, 0, cuts.length, cuts);
	}

	private int helper(int n, int s, int e, int[] cuts) {
		if (s >= e)
			return 0;
		int min = MIN;
		int start = (s == 0) ? 0 : cuts[s - 1];
		int end = (e == cuts.length) ? n : cuts[e];
		int cost = end - start;
		for (int i = s; i < e; i++) {
			min = Math.min(min, cost + helper(n, s, i, cuts) + helper(n, i+1, e, cuts));
		}
		return min;
	}*/
	
	static int MAX = Integer.MAX_VALUE;
    int n = 0;
    public int minCost(int n, int[] cuts) {
        this.n = n;
        Arrays.sort(cuts);
        int len = cuts.length;
        int[][] dp = new int[len+1][len+1];
        return helper(cuts, 0, cuts.length, dp);
    }

    private int helper(int[] cuts, int start, int end, int[][] dp){
        if(start >= end) return 0;
        if(dp[start][end] != 0) return dp[start][end];
        int min = MAX;
        int actualEnd = (end == cuts.length ? n : cuts[end]);
        int actualStart = (start == 0 ? 0 : cuts[start-1]);
        int costHere = actualEnd - actualStart;
        for(int i=start ; i<end ; i++){
            min = Math.min(min, costHere +
                      helper(cuts, start, i, dp) + 
                      helper(cuts, i+1, end, dp));
        }
        return dp[start][end] = min;
    }
    

	public static void main(String[] args) {
		MinimumCosttoCutaStick m = new MinimumCosttoCutaStick();
		System.out.println(m.minCost(7, new int[] { 1, 3, 4, 5 }));
	}
}
