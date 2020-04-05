package com.ven.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GrayCode {
	public List<Integer> grayCode(int n) {
		List<Integer> codes = new ArrayList<Integer>();
		if(n == 0) {
			codes.add(0);
			return codes;
		}
		helper(n, new ArrayList<>(), codes);
		return codes;
	}
	
	private void helper(int n, List<Integer> s, List<Integer> codes) {
		if(s.size() == n) {
			StringBuilder sb = new StringBuilder();
			for(int a :s) {
				sb.append(a);
			}
			codes.add(Integer.parseInt(sb.toString(), 2));
			return;
		}
		for (int i = 0; i <=1; i++) {
			s.add(i);
			helper(n,s , codes);
			s.remove(s.size()-1);
		}
		
	}
	
	public static void main(String[] args) {
		GrayCode gc = new GrayCode();
		System.out.println(gc.grayCode(0));
		System.out.println(gc.grayCode(2));
		System.out.println(gc.grayCode(3));
		System.out.println(gc.grayCode(4));
	}
}
