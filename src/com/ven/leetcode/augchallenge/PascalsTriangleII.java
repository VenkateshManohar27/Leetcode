package com.ven.leetcode.augchallenge;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-negative index k where k <= 33, return the kth index row of the
 * Pascal's triangle.
 * 
 * Note that the row index starts from 0.
 * 
 * 
 * In Pascal's triangle, each number is the sum of the two numbers directly
 * above it.
 * 
 * Example:
 * 
 * Input: 3 Output: [1,3,3,1]
 * 
 * @author Venkatesh Manohar
 *
 */
public class PascalsTriangleII {

	private static List<List<Integer>> pascal = new ArrayList<List<Integer>>();

	public List<Integer> getRow(int rowIndex) {
		if (pascal.size() == 0) {
			pascal.add(new ArrayList<>());
			pascal.get(0).add(1);
			pascal.add(new ArrayList<>());
			pascal.get(1).add(1);
			pascal.get(1).add(1);

			for (int i = 2; i <= 33; i++) {
				List<Integer> l = new ArrayList<>();
				l.add(1);
				for (int j = 1; j < i; j++) {
					l.add(pascal.get(i-1).get(j-1)+(pascal.get(i-1).get(j)));
				}
				l.add(1);
				pascal.add(l);
			}
		}
		return pascal.get(rowIndex);
	}
	public static void main(String[] args) {
		PascalsTriangleII p = new PascalsTriangleII();
		for (int i = 0; i <= 33; i++) {
			System.out.println(p.getRow(i));
		}
		
	}
}
