package com.ven.leetcode.augchallenge;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Design an Iterator class, which has:
 * 
 * A constructor that takes a string characters of sorted distinct lowercase
 * English letters and a number combinationLength as arguments. A function
 * next() that returns the next combination of length combinationLength in
 * lexicographical order. A function hasNext() that returns True if and only if
 * there exists a next combination.
 * 
 * 
 * Example:
 * 
 * CombinationIterator iterator = new CombinationIterator("abc", 2); // creates
 * the iterator.
 * 
 * iterator.next(); // returns "ab" iterator.hasNext(); // returns true
 * iterator.next(); // returns "ac" iterator.hasNext(); // returns true
 * iterator.next(); // returns "bc" iterator.hasNext(); // returns false
 * 
 * 
 * Constraints:
 * 
 * 1 <= combinationLength <= characters.length <= 15 There will be at most 10^4
 * function calls per test. It's guaranteed that all calls of the function next
 * are valid.
 * 
 * @author Venkatesh Manohar
 *
 */
public class CombinationIterator {

	private List<String> combinations = null;
	private int count = 0;

	public CombinationIterator(String characters, int combinationLength) {
		combinations = new ArrayList<String>();
		helper(0, characters, combinationLength, "");
	}

	public void helper(int index, String characters, int combinationLength, String val) {
		if (val.length() == combinationLength) {
			combinations.add(val);
			return;
		}
		for (int i = index; i < characters.length(); i++) {
			helper(i + 1, characters, combinationLength, val + characters.charAt(i));
		}
	}

	public String next() {

		return combinations.get(count++);
	}

	public boolean hasNext() {
		return count < combinations.size();
	}

	public static void main(String[] args) {
		CombinationIterator iterator = new CombinationIterator("abc", 2); // creates the iterator.

		System.out.println(iterator.next()); // returns "ab"
		System.out.println(iterator.hasNext()); // returns true
		System.out.println(iterator.next()); // returns "ac"
		System.out.println(iterator.hasNext()); // returns true
		System.out.println(iterator.next()); // returns "bc"
		System.out.println(iterator.hasNext()); // returns false

		System.out.println("-------------------------------------------------");
		iterator = new CombinationIterator("abcd", 2); // creates the iterator.

		System.out.println(iterator.next()); // returns "ab"
		System.out.println(iterator.hasNext()); // returns true
		System.out.println(iterator.next()); // returns "ac"
		System.out.println(iterator.hasNext()); // returns true
		System.out.println(iterator.next()); // returns "bc"
		System.out.println(iterator.hasNext()); // returns false
		System.out.println(iterator.next()); // returns "ab"
		System.out.println(iterator.hasNext()); // returns true
		System.out.println(iterator.next()); // returns "ac"
		System.out.println(iterator.hasNext()); // returns true
		System.out.println(iterator.next()); // returns "bc"
		System.out.println(iterator.hasNext()); // returns false
	}
}
