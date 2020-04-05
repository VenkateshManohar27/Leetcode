package com.ven.leetcode.greedy;

import java.util.Arrays;

/**
 * There are 2N people a company is planning to interview. The cost of flying
 * the i-th person to city A is costs[i][0], and the cost of flying the i-th
 * person to city B is costs[i][1].
 * 
 * Return the minimum cost to fly every person to a city such that exactly N
 * people arrive in each city.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: [[10,20],[30,200],[400,50],[30,20]] Output: 110 Explanation: The first
 * person goes to city A for a cost of 10. The second person goes to city A for
 * a cost of 30. The third person goes to city B for a cost of 50. The fourth
 * person goes to city B for a cost of 20.
 * 
 * The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people
 * interviewing in each city.
 * 
 * 
 * Note:
 * 
 * 1 <= costs.length <= 100 It is guaranteed that costs.length is even. 1 <=
 * costs[i][0], costs[i][1] <= 1000
 * 
 * @author Venkatesh Manohar
 *
 */
public class TwoCityScheduling {
	public int twoCitySchedCost(int[][] costs) {
		int minCost = 0;
		int cityACount = 0;
		int cityBCount = 0;
		Person[] persons = new Person[costs.length];
		for (int i = 0; i < costs.length; i++) {
			persons[i] = new Person(costs[i][0], costs[i][1]);
			if (costs[i][0] <= costs[i][1]) {
				cityACount++;
				minCost += costs[i][0];
				persons[i].city = 'A';
			} else {
				cityBCount++;
				minCost += costs[i][1];
				persons[i].city = 'B';
			}
		}

		Arrays.sort(persons);

		for (int i = 0; i < persons.length && cityACount != cityBCount; i++) {
			if (cityACount > cityBCount && persons[i].city == 'A') {
				cityACount--;
				cityBCount++;
				minCost -= persons[i].cityA;
				minCost += persons[i].cityB;

			} else if (cityBCount > cityACount && persons[i].city == 'B') {
				cityACount++;
				cityBCount--;
				minCost -= persons[i].cityB;
				minCost += persons[i].cityA;

			}
		}

		return minCost;
	}

	class Person implements Comparable<Person> {
		int cityA;
		int cityB;
		int diff;
		char city;

		public Person(int cityA, int cityB) {
			super();
			this.cityA = cityA;
			this.cityB = cityB;
			this.diff = Math.abs(cityA - cityB);
		}

		@Override
		public int compareTo(Person other) {
			if (this.diff == other.diff) {
				return 0;
			} else if (this.diff < other.diff) {
				return -1;
			} else {
				return 1;
			}
		}
	}

	public static void main(String[] args) {
		TwoCityScheduling tcs = new TwoCityScheduling();
		int[][] costs = new int[][] { { 10, 20 }, { 30, 200 }, { 400, 50 }, { 30, 20 } };
		System.out.println(tcs.twoCitySchedCost(costs));

		costs = new int[][] { { 259, 770 }, { 448, 54 }, { 926, 667 }, { 184, 139 }, { 840, 118 }, { 577, 469 } };
		System.out.println(tcs.twoCitySchedCost(costs));

		costs = new int[][] { { 518, 518 }, { 71, 971 }, { 121, 862 }, { 967, 607 }, { 138, 754 }, { 513, 337 },
				{ 499, 873 }, { 337, 387 }, { 647, 917 }, { 76, 417 } };
		System.out.println(tcs.twoCitySchedCost(costs));
	}
}
