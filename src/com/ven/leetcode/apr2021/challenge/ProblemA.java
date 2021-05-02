package com.ven.leetcode.apr2021.challenge;

import java.util.Scanner;

public class ProblemA {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int cases = 1;
		while (cases < 10) {
			if (scan.hasNext()) {
				System.out.print("Case " + cases + ": ");

				int earth = scan.nextInt();
				int mars = scan.nextInt();
				int days = 0;

				while (earth != 0 || mars != 0) {
					earth = (earth + 1) % 365;
					mars = (mars + 1) % 687;
					days++;
				}

				System.out.println(days);
			}
			cases++;
			
		}
		scan.close();
	}
}