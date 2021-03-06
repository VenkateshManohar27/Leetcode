package com.ven.leetcode.week15;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Think about Zuma Game. You have a row of balls on the table, colored red(R),
 * yellow(Y), blue(B), green(G), and white(W). You also have several balls in
 * your hand.
 * 
 * Each time, you may choose a ball in your hand, and insert it into the row
 * (including the leftmost place and rightmost place). Then, if there is a group
 * of 3 or more balls in the same color touching, remove these balls. Keep doing
 * this until no more balls can be removed.
 * 
 * Find the minimal balls you have to insert to remove all the balls on the
 * table. If you cannot remove all the balls, output -1.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: board = "WRRBBW", hand = "RB" Output: -1 Explanation: WRRBBW ->
 * WRR[R]BBW -> WBBW -> WBB[B]W -> WW Example 2:
 * 
 * Input: board = "WWRRBBWW", hand = "WRBRW" Output: 2 Explanation: WWRRBBWW ->
 * WWRR[R]BBWW -> WWBBWW -> WWBB[B]WW -> WWWW -> empty Example 3:
 * 
 * Input: board = "G", hand = "GGGGG" Output: 2 Explanation: G -> G[G] -> GG[G]
 * -> empty Example 4:
 * 
 * Input: board = "RBYYBBRRB", hand = "YRBGB" Output: 3 Explanation: RBYYBBRRB
 * -> RBYY[Y]BBRRB -> RBBBRRB -> RRRB -> B -> B[B] -> BB[B] -> empty
 * 
 * 
 * Constraints:
 * 
 * You may assume that the initial row of balls on the table won’t have any 3 or
 * more consecutive balls with the same color. 1 <= board.length <= 16 1 <=
 * hand.length <= 5 Both input strings will be non-empty and only contain
 * characters 'R','Y','B','G','W'.
 * 
 * @author Venkatesh Manohar
 *
 */
class Node {
	String board;
	Map<Character, Integer> handmap = null;

	public Node(String board, Map<Character, Integer> handmap) {
		super();
		this.board = board;
		this.handmap = handmap;
	}
}

public class ZumaGame {
	public int findMinStep(String board, String hand) {
		HashMap<Character, Integer> handmap = new HashMap<>();
		handmap.put('R', 0);
		handmap.put('Y', 0);
		handmap.put('B', 0);
		handmap.put('G', 0);
		handmap.put('W', 0);

		for (int i = 0; i < hand.length(); i++) {
			char c = hand.charAt(i);
			handmap.put(c, handmap.get(c) + 1);
		}
		board = update(board); // to initialize the board string
		if (board.isEmpty()) {
			return 0;
		}
		Set<String> visited = new HashSet<>();

		Queue<Node> q = new LinkedList<>();
		q.add(new Node(board, handmap));
		visited.add(board);
		int level = 0;
		while (!q.isEmpty()) {

			int size = q.size();
			level++;
			while (size > 0) {
				Node node = q.poll();
				String curr = node.board;
				// System.out.println(curr);
				Map<Character, Integer> map = node.handmap;
				// System.out.println(map);
				for (int i = 0; i < curr.length(); i++) {
					char c = curr.charAt(i);
					if (map.get(c) > 0 && (i == 0 || c != curr.charAt(i - 1))) {
						String res = update(curr.substring(0, i) + c + curr.substring(i), i);
						if (res.isEmpty()) {
							return level;
						}
						if (!visited.contains(res)) {
							visited.add(res);
                            Node newNode = new Node(res, map);
                            Map<Character, Integer> newMap = newNode.handmap;
                            newMap.put(c, newMap.get(c) - 1);
                            q.add(newNode);
						}
					}

				}

				size--;
			}
		}

		return -1;
	}

	/*
	 * I overwrite the update function, the first one is used to update the board
	 * string initially, it needs be scan from the begin to end
	 */
	public String update(String str) {
		int len = str.length();
		for (int i = 0; i < len - 2; i++) {
			int j = i + 1;
			while (j < len && str.charAt(j) == str.charAt(i)) {
				j++;
			}

			if (j - i >= 3) {
				return update(str.substring(0, i) + str.substring(j));
			}
		}

		return str;
	}

	/*
	 * The second update function is used to update the board string after
	 * insertion, we keep the insert position i, so as to avoid useless scan
	 */
	public String update(String str, int i) {
		int j = i + 1;
		int len = str.length();
		while (j < len && str.charAt(j) == str.charAt(i)) {
			j++;
		}

		if (j - i >= 3) {
			int next_i = i > 0 ? i - 1 : 0;
			if (i - 2 >= 0 && str.charAt(i - 2) == str.charAt(i - 1)) {
				next_i = i - 2;
			}

			return update(str.substring(0, i) + str.substring(j), next_i);
		}
		return str;
	}

	public static void main(String[] args) {
		ZumaGame z = new ZumaGame();

		// "RRWWRRBBRR"
		// "WB" 2
		System.out.println(z.findMinStep("RRWWRRBBRR", "WB"));
		// 2
		System.out.println(z.findMinStep("G", "GGGGG"));
		// "WWRRBBWW"
		// "WRBRW" 2
		System.out.println(z.findMinStep("WWRRBBWW", "WRBRW"));
		// -1
		System.out.println(z.findMinStep("WRRBBW", "RB"));

		// "WWBBWBBWW","BB", -1
		System.out.println(z.findMinStep("WWBBWBBWW", "BB"));

		// "W", "W", -1
		System.out.println(z.findMinStep("W", "W"));
	}
}
