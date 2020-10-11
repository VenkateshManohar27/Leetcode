package com.ven.leetcode.week210;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * There is an infrastructure of n cities with some number of roads connecting
 * these cities. Each roads[i] = [ai, bi] indicates that there is a
 * bidirectional road between cities ai and bi.
 * 
 * The network rank of two different cities is defined as the total number of
 * directly connected roads to either city. If a road is directly connected to
 * both cities, it is only counted once.
 * 
 * The maximal network rank of the infrastructure is the maximum network rank of
 * all pairs of different cities.
 * 
 * Given the integer n and the array roads, return the maximal network rank of
 * the entire infrastructure.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * Input: n = 4, roads = [[0,1],[0,3],[1,2],[1,3]] Output: 4 Explanation: The
 * network rank of cities 0 and 1 is 4 as there are 4 roads that are connected
 * to either 0 or 1. The road between 0 and 1 is only counted once. Example 2:
 * 
 * 
 * 
 * Input: n = 5, roads = [[0,1],[0,3],[1,2],[1,3],[2,3],[2,4]] Output: 5
 * Explanation: There are 5 roads that are connected to cities 1 or 2. Example
 * 3:
 * 
 * Input: n = 8, roads = [[0,1],[1,2],[2,3],[2,4],[5,6],[5,7]] Output: 5
 * Explanation: The network rank of 2 and 5 is 5. Notice that all the cities do
 * not have to be connected.
 * 
 * 
 * Constraints:
 * 
 * 2 <= n <= 100 0 <= roads.length <= n * (n - 1) / 2 roads[i].length == 2 0 <=
 * ai, bi <= n-1 ai != bi Each pair of cities has at most one road connecting
 * them.
 * 
 * @author Venkatesh Manohar
 *
 */
public class MaximalNetworkRank {
	public int maximalNetworkRank(int n, int[][] roads) {
		Map<Integer, Set<Integer>> map = new HashMap();
        for(int i=0; i<roads.length; i++) {
            if (!map.containsKey(roads[i][0])) map.put(roads[i][0], new HashSet());
            map.get(roads[i][0]).add(roads[i][1]);
            if (!map.containsKey(roads[i][1])) map.put(roads[i][1], new HashSet());
            map.get(roads[i][1]).add(roads[i][0]);
        }
		Integer[] cities = map.keySet().toArray(new Integer[map.keySet().size()]);
		int max = 0;
		for (int i = 0; i < cities.length-1; i++) {
			for (int j = i+1; j < cities.length; j++) {
				int count = map.get(cities[i]).size()+map.get(cities[j]).size();
				if(map.get(cities[i]).contains(cities[j])) {
					count -=1;
				}
				max = Math.max(max, count);
				
			}
		}
		
		return max;
	}

	public static void main(String[] args) {
		MaximalNetworkRank m = new MaximalNetworkRank();
		System.out.println(m.maximalNetworkRank(4, new int[][] { { 0, 1 }, { 0, 3 }, { 1, 2 }, { 1, 3 } }));
		System.out.println(
				m.maximalNetworkRank(5, new int[][] { { 0, 1 }, { 0, 3 }, { 1, 2 }, { 1, 3 }, { 2, 3 }, { 2, 4 } }));
		System.out.println(
				m.maximalNetworkRank(8, new int[][] { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 2, 4 }, { 5, 6 }, { 5, 7 } }));
	}
}
