package com.ven.leetcode.dec.challenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * You are given the array paths, where paths[i] = [cityAi, cityBi] means there
 * exists a direct path going from cityAi to cityBi. Return the destination
 * city, that is, the city without any path outgoing to another city.
 * 
 * It is guaranteed that the graph of paths forms a line without any loop,
 * therefore, there will be exactly one destination city.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: paths = [["London","New York"],["New York","Lima"],["Lima","Sao
 * Paulo"]] Output: "Sao Paulo" Explanation: Starting at "London" city you will
 * reach "Sao Paulo" city which is the destination city. Your trip consist of:
 * "London" -> "New York" -> "Lima" -> "Sao Paulo". Example 2:
 * 
 * Input: paths = [["B","C"],["D","B"],["C","A"]] Output: "A" Explanation: All
 * possible trips are: "D" -> "B" -> "C" -> "A". "B" -> "C" -> "A". "C" -> "A".
 * "A". Clearly the destination city is "A". Example 3:
 * 
 * Input: paths = [["A","Z"]] Output: "Z"
 * 
 * 
 * Constraints:
 * 
 * 1 <= paths.length <= 100 paths[i].length == 2 1 <= cityAi.length,
 * cityBi.length <= 10 cityAi != cityBi All strings consist of lowercase and
 * uppercase English letters and the space character.
 * 
 * @author Venkatesh Manohar
 *
 */
public class DestinationCity {
	public String destCity(List<List<String>> paths) {
		HashMap<String, List<String>> graph = new HashMap<>();

		for (List<String> l : paths) {
			String src = l.get(0);
			String dest = l.get(1);

			if (graph.containsKey(src)) {
				graph.get(src).add(dest);
			} else {
				List<String> li = new ArrayList<>();
				li.add(dest);
				graph.put(src, li);
			}
			if (!graph.containsKey(dest)) {
				graph.put(dest, new ArrayList<>());
			}

		}
		System.out.println(graph);
		String res = null;

		for (String key : graph.keySet()) {
			if (graph.get(key).size() == 0) {
				return key;
			}
		}

		return res;
	}
}
