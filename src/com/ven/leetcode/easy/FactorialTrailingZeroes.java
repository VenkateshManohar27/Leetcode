package com.ven.leetcode.easy;

public class FactorialTrailingZeroes {
	public int trailingZeroes(int n) {
		int fact = fact(n);
		int count = 0;
		while (fact % 10 == 0) {
			fact /= 10;
			count++;
		}
		return count;
	}

	private int fact(int n) {
		if (n == 1 || n == 0) {
			return 1;
		}
		return n * fact(n - 1);
	}

	public int trailingZeroesUsing5Factors(int n) {
		/*int count = 0;

		while (n >= 5)
			count += (n /= 5);

		return count;*/
		int count =0;
		while(n!=0) {
			n = n/5;
			count+= n;
		}
		return count;
	}

	public static void main(String[] args) {
		FactorialTrailingZeroes ftz = new FactorialTrailingZeroes();
		System.out.println(ftz.fact(1));
		System.out.println(ftz.fact(2));
		System.out.println(ftz.fact(3));
		System.out.println(ftz.fact(4));
		System.out.println(ftz.fact(5));

		System.out.println(ftz.fact(6));
		System.out.println(ftz.fact(13));
	}
}
