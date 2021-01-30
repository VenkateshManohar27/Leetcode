package com.ven.codeforces697;

import java.util.Scanner;

public class BallInBerland {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 1; i<= n; i++) {
			int numB = sc.nextInt();
			int numG = sc.nextInt();
			int k = sc.nextInt();
			/*System.out.println("a:"+numB);

			System.out.println("b:"+numG);

			System.out.println("k:"+k);*/
			int[][] pairs = new int[2][k];
			int[] boys = new int[ numB+1];
			int[] girls = new int[ numG+1];
			
			for (int j = 0; j < k; j++) {
				pairs[0][j] = sc.nextInt();
				boys[pairs[0][j]]++;
			}
			for (int j = 0; j < k; j++) {
				pairs[1][j] = sc.nextInt();
				girls[pairs[1][j]]++;
			}
			
			/*for (int j = 0; j < k; j++) {
				System.out.print("("+pairs[0][j]+","+pairs[0][j]+")");
			}
			System.out.println();*/
			long ans = 0;
			for (int j = 0; j < k; j++) {
				ans+= (k-1) - (boys[pairs[0][j]]-1) - (girls[pairs[1][j]]-1);
			}
			System.out.println(ans/2);
		}
		sc.close();
	}

}
