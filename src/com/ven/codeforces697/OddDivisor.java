package com.ven.codeforces697;

import java.util.Scanner;

public class OddDivisor {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 1; i<= n; i++) {
			long num = sc.nextLong();
			if(num % 2 == 1) {
				System.out.println("YES");
			}else {
				while(num % 2 == 0) num/=2;
				if(num > 1) {
					System.out.println("YES");
				}else {
					System.out.println("NO");
				}
			}
		
		}
		
		sc.close();
	}
}
