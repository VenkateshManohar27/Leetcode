package com.ven.leetcode.week6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ven.utility.ArrayUtility;

/**
 * You are given an array of people, people, which are the attributes of some
 * people in a queue (not necessarily in order). Each people[i] = [hi, ki]
 * represents the ith person of height hi with exactly ki other people in front
 * who have a height greater than or equal to hi.
 * 
 * Reconstruct and return the queue that is represented by the input array
 * people. The returned queue should be formatted as an array queue, where
 * queue[j] = [hj, kj] is the attributes of the jth person in the queue
 * (queue[0] is the person at the front of the queue).
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]] Output:
 * [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]] Explanation: Person 0 has height 5 with
 * no other people taller or the same height in front. Person 1 has height 7
 * with no other people taller or the same height in front. Person 2 has height
 * 5 with two persons taller or the same height in front, which is person 0 and
 * 1. Person 3 has height 6 with one person taller or the same height in front,
 * which is person 1. Person 4 has height 4 with four people taller or the same
 * height in front, which are people 0, 1, 2, and 3. Person 5 has height 7 with
 * one person taller or the same height in front, which is person 1. Hence
 * [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]] is the reconstructed queue. Example 2:
 * 
 * Input: people = [[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]] Output:
 * [[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]
 * 
 * 
 * Constraints:
 * 
 * 1 <= people.length <= 2000 0 <= hi <= 106 0 <= ki < people.length It is
 * guaranteed that the queue can be reconstructed.
 * 
 * @author Venkatesh Manohar
 *
 */
public class QueueReconstructionByHeight {
	public int[][] reconstructQueue(int[][] people) {
		/*
		 * Arrays.sort(people, (a, b) -> a[0] - b[0]); TreeSet<Integer> set = new
		 * TreeSet<>(); TreeSet<int[]> peopleSet = new TreeSet<>(); int[][] res = new
		 * int[people.length][2]; for (int i = 0; i < res.length; i++) {
		 * peopleSet.add(people[i]); } int index = 0; int curr = 0; while (index <
		 * people.length) {
		 * 
		 * while (curr < people.length) { if (people[curr].length > 1) { int[] person =
		 * people[curr]; if (person.length > 0 && set.tailSet(person[0]).size() >=
		 * person[1]) { people[curr] = new int[] {}; set.add(person[0]); res[index++] =
		 * person; curr = 0; } } curr++; } if (index < people.length && curr >
		 * people.length - 1) curr = 0;
		 * 
		 * }
		 * 
		 * return res;
		 */
		// greedy heap solution!

		Arrays.sort(people, (a, b) -> (a[0] != b[0] ? b[0] - a[0] : a[1] - b[1])); // put tallest people first,
																					// otherwise sort by their people
																					// greater (so that the tallest are
																					// in order)

		List<int[]> res = new ArrayList<>();

		// let's now add them in the sorted order, at the specific index
		// add the tallest first, then put the next level in with the appropriate amount
		// of people on and so on -- arraylist let's us put the person in at the proper
		// index
		for (int[] p : people) {
			res.add(p[1], p);
		}

		// convert to an array
		return res.toArray(new int[people.length][2]);
	}

	public static void main(String[] args) {
		QueueReconstructionByHeight q = new QueueReconstructionByHeight();
		ArrayUtility
				.print(q.reconstructQueue(new int[][] { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } }));

		ArrayUtility
				.print(q.reconstructQueue(new int[][] { { 6, 0 }, { 5, 0 }, { 4, 0 }, { 3, 2 }, { 2, 2 }, { 1, 4 } }));
	}
}
