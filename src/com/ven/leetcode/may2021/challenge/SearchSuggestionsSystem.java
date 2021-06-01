package com.ven.leetcode.may2021.challenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given an array of strings products and a string searchWord. We want to design
 * a system that suggests at most three product names from products after each
 * character of searchWord is typed. Suggested products should have common
 * prefix with the searchWord. If there are more than three products with a
 * common prefix return the three lexicographically minimums products.
 * 
 * Return list of lists of the suggested products after each character of
 * searchWord is typed.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: products = ["mobile","mouse","moneypot","monitor","mousepad"],
 * searchWord = "mouse" Output: [ ["mobile","moneypot","monitor"],
 * ["mobile","moneypot","monitor"], ["mouse","mousepad"], ["mouse","mousepad"],
 * ["mouse","mousepad"] ] Explanation: products sorted lexicographically =
 * ["mobile","moneypot","monitor","mouse","mousepad"] After typing m and mo all
 * products match and we show user ["mobile","moneypot","monitor"] After typing
 * mou, mous and mouse the system suggests ["mouse","mousepad"] Example 2:
 * 
 * Input: products = ["havana"], searchWord = "havana" Output:
 * [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]] Example
 * 3:
 * 
 * Input: products = ["bags","baggage","banner","box","cloths"], searchWord =
 * "bags" Output:
 * [["baggage","bags","banner"],["baggage","bags","banner"],["baggage","bags"],["bags"]]
 * Example 4:
 * 
 * Input: products = ["havana"], searchWord = "tatiana" Output:
 * [[],[],[],[],[],[],[]]
 * 
 * 
 * Constraints:
 * 
 * 1 <= products.length <= 1000 There are no repeated elements in products. 1 <=
 * products[i].length <= 2 * 10^4 All characters of products[i] are lower-case
 * English letters. 1 <= searchWord.length <= 1000 All characters of searchWord
 * are lower-case English letters.
 * 
 * @author Venkatesh Manohar
 *
 */

class Trie {
	Trie[] childrens = null;
	List<String> list = null;
	boolean isEnd = false;
	private static final int SIZE = 3;

	public Trie() {
		this.childrens = new Trie[26];
		list = new ArrayList<String>();
	}

	public void addProduct(String product) {
		this.list.add(product);
		Collections.sort(list);
		while (list.size() > SIZE) {
			this.list.remove(list.size() - 1);
		}
	}

}

class Solution {
	Trie root = new Trie();

	public List<List<String>> suggestedProducts(String[] products, String searchWord) {
		initialize(products);
		List<List<String>> li = new ArrayList<>();
		search(li, searchWord);
		return li;
	}

	private void initialize(String[] products) {
		for (int i = 0; i < products.length; i++) {
			String prod = products[i];
			Trie curr = root;
			for (int j = 0; j < prod.length(); j++) {
				int ind = prod.charAt(j) - 'a';
				if (curr.childrens[ind] != null) {
					curr = curr.childrens[ind];
					curr.addProduct(prod);
				} else {
					curr.childrens[ind] = new Trie();
					curr = curr.childrens[ind];
					curr.addProduct(prod);
				}
				if (j == prod.length() - 1) {
					curr.isEnd = true;
				}
			}
		}
	}

	private void search(List<List<String>> li, String s) {
		Trie curr = root;

		for (int i = 0; i < s.length(); i++) {
			int ind = s.charAt(i) - 'a';
			if (curr != null) {
				if (curr.childrens[ind] != null) {
					li.add(curr.childrens[ind].list);
					curr = curr.childrens[ind];
				} else {
					curr = null;
					li.add(new ArrayList<>());
				}
			} else {
				li.add(new ArrayList<>());
			}

		}
	}
}