package com.ven.leetcode.june2021.challenge;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();

		// Base case; first row is always [1].
		triangle.add(new ArrayList<>());
		triangle.get(0).add(1);

		for (int rowNum = 1; rowNum < numRows; rowNum++) {
			List<Integer> row = new ArrayList<>();
			List<Integer> prevRow = triangle.get(rowNum - 1);

			// The first row element is always 1.
			row.add(1);

			// Each triangle element (other than the first and last of each row)
			// is equal to the sum of the elements above-and-to-the-left and
			// above-and-to-the-right.
			for (int j = 1; j < rowNum; j++) {
				row.add(prevRow.get(j - 1) + prevRow.get(j));
			}

			// The last row element is always 1.
			row.add(1);

			triangle.add(row);
		}

		return triangle;
	}

	public static void main(String[] args) {
		PascalTriangle pst = new PascalTriangle();
		System.out.println(pst.generate(1));
		System.out.println(pst.generate(2));
		System.out.println(pst.generate(3));
		System.out.println(pst.generate(4));
		System.out.println(pst.generate(5));
		System.out.println(pst.generate(6));

	}
}
