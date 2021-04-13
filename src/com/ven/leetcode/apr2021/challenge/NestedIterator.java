package com.ven.leetcode.apr2021.challenge;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * You are given a nested list of integers nestedList. Each element is either an
 * integer or a list whose elements may also be integers or other lists.
 * Implement an iterator to flatten it.
 * 
 * Implement the NestedIterator class:
 * 
 * NestedIterator(List<NestedInteger> nestedList) Initializes the iterator with
 * the nested list nestedList. int next() Returns the next integer in the nested
 * list. boolean hasNext() Returns true if there are still some integers in the
 * nested list and false otherwise.
 * 
 * 
 * Example 1:
 * 
 * Input: nestedList = [[1,1],2,[1,1]] Output: [1,1,2,1,1] Explanation: By
 * calling next repeatedly until hasNext returns false, the order of elements
 * returned by next should be: [1,1,2,1,1]. Example 2:
 * 
 * Input: nestedList = [1,[4,[6]]] Output: [1,4,6] Explanation: By calling next
 * repeatedly until hasNext returns false, the order of elements returned by
 * next should be: [1,4,6].
 * 
 * 
 * Constraints:
 * 
 * 1 <= nestedList.length <= 500 The values of the integers in the nested list
 * is in the range [-106, 106].
 * 
 * @author Venkatesh Manohar
 *
 */

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {

	// @return true if this NestedInteger holds a single integer, rather than a
	// nested list.
	public boolean isInteger();

	// @return the single integer that this NestedInteger holds, if it holds a
	// single integer
	// Return null if this NestedInteger holds a nested list
	public Integer getInteger();

	// @return the nested list that this NestedInteger holds, if it holds a nested
	// list
	// Return empty list if this NestedInteger holds a single integer
	public List<NestedInteger> getList();
}

public class NestedIterator implements Iterator<Integer> {
	List<Integer> li = null;
	Iterator<Integer> it = null;

	public NestedIterator(List<NestedInteger> nestedList) {
		li = new ArrayList<>();
		helper(nestedList, li);

		it = li.iterator();
	}

	private void helper(List<NestedInteger> nl, List<Integer> li) {
		for (int i = 0; i < nl.size(); i++) {
			NestedInteger n = nl.get(i);
			if (n.isInteger()) {
				li.add(n.getInteger());
			} else {
				helper(n.getList(), li);
			}
		}
	}

	@Override
	public Integer next() {
		return it.next();
	}

	@Override
	public boolean hasNext() {
		return it.hasNext();
	}
}