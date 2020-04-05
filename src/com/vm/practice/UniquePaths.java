package com.vm.practice;

public class UniquePaths {
	public int uniquePaths(int m, int n) {
		int[][] paths = new int[m][n];
		for (int i = 0; i < m; i++) {
			paths[i][0] = 1;
		}
		
		for (int i = 0; i < n; i++) {
			paths[0][i] = 1;
		}
		
		for (int i = 1; i < paths.length; i++) {
			for (int j = 1; j < paths[i].length; j++) {
				paths[i][j] = paths[i-1][j]+paths[i][j-1];
			}
		}
		
		return paths[m-1][n-1];
		
	}
	
	public static void main(String[] args) {
		UniquePaths up = new UniquePaths();
		System.out.println(up.uniquePaths(3, 2));
		System.out.println(up.uniquePaths(7, 3));
	}
}
