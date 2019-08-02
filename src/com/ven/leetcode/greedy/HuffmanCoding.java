package com.ven.leetcode.greedy;

import java.util.PriorityQueue;

public class HuffmanCoding {
	private HuffmanNode root = null;

	public void createHuffmanCode(char[] chars, int[] frequency) {
		if (chars == null || chars.length == 0 || frequency == null || frequency.length == 0) {
			return;
		}
		PriorityQueue<HuffmanNode> pq = new PriorityQueue<HuffmanNode>(frequency.length, (node1, node2) -> {
			return node1.getData() - node2.getData();
		});
		for (int i = 0; i < frequency.length; i++) {
			HuffmanNode node = new HuffmanNode(chars[i], frequency[i]);
			pq.add(node);
		}
		while (pq.size() > 1) {
			HuffmanNode node1 = pq.poll();
			HuffmanNode node2 = pq.poll();
			HuffmanNode node3 = new HuffmanNode('#', node1.getData() + node2.getData());
			node3.left = node1;
			node3.right = node2;
			pq.add(node3);
		}
		root = pq.poll();
		printHuffmanCode(root, "");
	}

	private void printHuffmanCode(HuffmanNode node, String s) {
		if (node != null && node.left == null && node.right == null && Character.isLetter(node.getC())) {
			System.out.println(node.getC() + " : " + s);
			return;
		}
		printHuffmanCode(node.left, s + "0");
		printHuffmanCode(node.right, s + "1");
	}

	public String huffmanDecoding(String s) {
		int length = s.length();
		HuffmanNode node = root;
		int index = 0;
		StringBuilder sb = new StringBuilder();
		while (index < length) {

			if (s.charAt(index) == '0') {
				node = node.left;
				index++;
			} else {
				node = node.right;
				index++;
			}
			if (node.left == null && node.right == null) {
				// System.out.println(node.getC());
				sb.append(node.getC());
				node = root;
			}

		}
		return sb.toString();
	}

	public static void main(String[] args) {
		int n = 6;
		char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' };
		int[] charfreq = { 5, 9, 12, 13, 16, 45 };
		HuffmanCoding hc = new HuffmanCoding();
		hc.createHuffmanCode(charArray, charfreq);

		charArray = new char[] { 'A', 'B', 'C', 'D', 'E' };
		charfreq = new int[] { 6, 1, 6, 2, 5 };
		hc = new HuffmanCoding();
		hc.createHuffmanCode(charArray, charfreq);
		String result = hc.huffmanDecoding("0000000000001100101010101011111111010101010");
		System.out.println("Decoded Data = " + result);
		System.out.println("Matching :" + result.equals("AAAAAABCCCCCCDDEEEEE"));
	}
}
