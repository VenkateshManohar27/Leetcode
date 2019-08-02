package com.ven.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class BenchArrangement {
	public List<String> arrange(int boys, int girls) {
		List<String> list = new ArrayList<>();
		if (boys == 0 && girls == 0) {
			return list;
		}
		generateArrangement(boys, girls, "", list);
		return list;
	}

	private void generateArrangement(int boys, int girls, String arrangement, List<String> list) {
		if (boys == 0 && girls == 0) {
			list.add(arrangement);
			return;
		}

		if (boys > 0) {
			generateArrangement(boys - 1, girls, arrangement + "B", list);
		}
		if (girls > 0) {
			generateArrangement(boys, girls - 1, arrangement + "G", list);
		}
	}
	
	public static void main(String[] args) {
		BenchArrangement ba = new BenchArrangement();
		List<String> list = ba.arrange(2, 1);
		
		list.stream().forEach(s-> System.out.println(s));
	}
}
