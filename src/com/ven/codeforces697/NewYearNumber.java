package com.ven.codeforces697;

import java.util.Scanner;

public class NewYearNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 1; i<= n; i++) {
			int num = sc.nextInt();
			if(num < 2020) {
				System.out.println("NO");
			}else {
				int p = num %2020;
				int d = num/2020;
				if(p<=d) {
					System.out.println("YES");
				}else {
					System.out.println("NO");
				}
			}
		
		}
		
		sc.close();
	}
}
