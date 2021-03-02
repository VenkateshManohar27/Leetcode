package com.ven.leetcode.feb2021.challenge;

import java.util.List;

public class CountItemsMatchingRule {
	public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
		int i = getIndexForRuleKey(ruleKey);
		if( i == -1) {
			return 0;
		}
		int count = 0;
		for(List<String> li: items ) {
			if(ruleValue.equals(li.get(i))){
				count++;
			}
		}
		return count;
	}

	private int getIndexForRuleKey(String rule) {
		switch (rule) {
		case "type":
			return 0;
		case "color":
			return 1;
		case "name":
			return 2;
		default:
			return -1;
		}
	}
}
