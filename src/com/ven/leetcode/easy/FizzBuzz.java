package com.ven.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

interface Rule {
	boolean apply(int i);
}

public class FizzBuzz {
	public static List<String> fizzBuzz(int n) {
		List<String> output = new ArrayList<String>(n);

		for (int i = 1; i <= n; i++) {
			if (i % 15 == 0) {
				output.add("FizzBuzz");
			} else if (i % 3 == 0) {
				output.add("Fizz");
			} else if (i % 5 == 0) {
				output.add("Buzz");
			} else {
				output.add("" + i);
			}
		}
		return output;
	}

	private Map<Rule, String> ruleContainers = new HashMap<>();
	private Set<Rule> rules = new HashSet<>();

	public FizzBuzz() {
        addRule(i -> i % 15 == 0, "FizzBuzz");
        addRule(i -> i % 3 == 0, "Fizz");
        addRule(i -> i % 5 == 0, "Buzz");
    }

	public void addRule(Rule rule, String res) {
		rules.add(rule);
		ruleContainers.put(rule, res);
	}

	public String getValue(int i) {
		for (Rule rule : rules) {
			if (rule.apply(i)) {
				return ruleContainers.get(rule);
			}
		}
		return String.valueOf(i);
	}

	// then the origin code should be as follows:
	public List<String> fizzBuzz2(int n) {
		List<String> res = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			res.add(getValue(i));
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(fizzBuzz(1));
		System.out.println(fizzBuzz(2));
		System.out.println(fizzBuzz(3));
		System.out.println(fizzBuzz(5));
		System.out.println(fizzBuzz(9));
		System.out.println(fizzBuzz(10));
		System.out.println(fizzBuzz(15));
		System.out.println(fizzBuzz(21));
		System.out.println(fizzBuzz(24));
		System.out.println(fizzBuzz(30));
		System.out.println(fizzBuzz(35));

	}
}
