package com.ven.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> triangle = new ArrayList<List<Integer>>(numRows);
		for (int i = 0; i < numRows; i++) {
			triangle.add(i, new ArrayList<>(i + 1));
			for (int j = 0; j <= i; j++) {
				List<Integer> list = triangle.get(i);
				if (j == 0) {
					list.add(j, 1);
					continue;
				}
				if (i == j) {
					list.add(j, 1);
					continue;
				}

				list.add(j, triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j));
			}
		}
		return triangle;
	}

	public List<Integer> generateSpaceEfficient(int rowIndex) {
		rowIndex++;
		List<Integer> lastRow = new ArrayList<Integer>(rowIndex);
		List<Integer> auxiliary = new ArrayList<Integer>(rowIndex);
		auxiliary.add(0, 1);
		for (int i = 0; i < rowIndex; i++) {
			lastRow.clear();
			for (int j = 0; j <= i; j++) {
				if (j == 0 || i == j) {
					lastRow.add(j, 1);
					continue;
				}
				lastRow.add(j, auxiliary.get(j - 1) + auxiliary.get(j));
			}
			auxiliary.clear();
			auxiliary.addAll(lastRow);
		}
		return lastRow;
	}

	public List<Integer> generateSpaceEfficient2(int rowIndex) {
		Integer[] arr = new Integer[rowIndex + 1];
		Arrays.fill(arr, 0);
		arr[0] = 1;
		for (int i = 0; i <= rowIndex; i++) {
			for (int j = i; j > 0; j--) {
				arr[j] = arr[j]+arr[j-1];
			}
		}
		return Arrays.asList(arr);
	}

	public static void main(String[] args) {
		PascalTriangle pst = new PascalTriangle();
		System.out.println(pst.generate(1));
		System.out.println(pst.generate(2));
		System.out.println(pst.generate(3));
		System.out.println(pst.generate(4));
		System.out.println(pst.generate(5));
		System.out.println(pst.generate(6));

		System.out.println(pst.generateSpaceEfficient(1));
		System.out.println(pst.generateSpaceEfficient(2));
		System.out.println(pst.generateSpaceEfficient(3));
		System.out.println(pst.generateSpaceEfficient(4));
		System.out.println(pst.generateSpaceEfficient(5));
		System.out.println(pst.generateSpaceEfficient(6));
		
		System.out.println(pst.generateSpaceEfficient2(1));
		System.out.println(pst.generateSpaceEfficient2(2));
		System.out.println(pst.generateSpaceEfficient2(3));
		System.out.println(pst.generateSpaceEfficient2(4));
		System.out.println(pst.generateSpaceEfficient2(5));
		System.out.println(pst.generateSpaceEfficient2(6));
	}
}
