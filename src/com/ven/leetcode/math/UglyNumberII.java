package com.ven.leetcode.math;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 
 * @author Venkatesh Manohar
 *
 */
public class UglyNumberII {
	public int nthUglyNumber(int n) {
		int ugly[] = new int[n];
		ugly[0] = 1;
		int factor2 = 2, factor3 = 3, factor5 = 5;
		int index2 = 0, index3 = 0, index5 = 0;
		for (int i = 1; i < ugly.length; i++) {
			int min = Math.min(factor2, Math.min(factor3, factor5));
			ugly[i] = min;
			if (min == factor2) {
				index2++;
				factor2 = 2 * ugly[index2];
			}
			if (min == factor3) {
				index3++;
				factor3 = 3 * ugly[index3];
			}
			if (min == factor5) {
				index5++;
				factor5 = 5 * ugly[index5];
			}
		}
		return ugly[n - 1];
	}

	public static void main(String[] args) {
		UglyNumberII un = new UglyNumberII();
		int res = un.nthUglyNumber(1);
		System.out.println(res);
		res = un.nthUglyNumber(2);
		System.out.println(res);
		res = un.nthUglyNumber(3);
		System.out.println(res);
		res = un.nthUglyNumber(10);
		System.out.println(res);
		res = un.nthUglyNumber(11);
		System.out.println(res);
		res = un.nthUglyNumber(12);
		System.out.println(res);
		res = un.nthUglyNumber(1690);
		System.out.println(res);
	}
}
