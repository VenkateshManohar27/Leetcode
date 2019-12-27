package com.vm.practice;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class HuffmanCoding {
	private HuffmanNode root = null;
	private HashMap<Character, String> huffmanCodes = new HashMap<>();

	public HuffmanCoding(String st) {
		super();
		construct(st);
	}

	private void construct(String str) {
		HashMap<Character, Integer> chars = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			Character c = str.charAt(i);
			if (chars.containsKey(c)) {
				chars.put(c, chars.get(c).intValue() + 1);
			} else {
				chars.put(c, 1);
			}
		}
		PriorityQueue<HuffmanNode> pq = new PriorityQueue<>(new Comparator<HuffmanNode>() {
			public int compare(HuffmanNode o1, HuffmanNode o2) {
				return o1.getFrequency() - o2.getFrequency();
			}
		});
		for (char ch : chars.keySet()) {
			System.out.println(ch + ":" + chars.get(ch));
			pq.add(new HuffmanNode(ch, chars.get(ch)));
		}

		while (pq.size() > 1) {
			HuffmanNode ch1 = pq.poll();
			HuffmanNode ch2 = pq.poll();
			HuffmanNode node = new HuffmanNode('-', ch1.getFrequency() + ch2.getFrequency());
			node.left = ch1;
			node.right = ch2;
			pq.add(node);
		}
		this.root = pq.poll();
		populateHuffmanCodes();
	}

	private void populateHuffmanCodes() {
		populateHuffmanCode(root, "");
	}

	public void printHuffmanCode() {
		for (Character c : huffmanCodes.keySet()) {
			System.out.println(c + " " + huffmanCodes.get(c));
		}
	}

	private void populateHuffmanCode(HuffmanNode node, String s) {
		if (node != null && Character.isAlphabetic(node.getC())) {
			huffmanCodes.put(node.getC(), s);
			return;
		}
		populateHuffmanCode(node.left, s + "0");
		populateHuffmanCode(node.right, s + "1");
	}

	public String encode(String str) {
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			res.append(huffmanCodes.get(str.charAt(i)));
		}

		return res.toString();
	}

	public String decode(String st) {
		StringBuilder sb = new StringBuilder();
		HuffmanNode node = root;
		for (int i = 0; i < st.length(); i++) {
			char c = st.charAt(i);
			if (c == '0') {
				node = node.left;
			} else {
				node = node.right;
			}

			if (node.left == null && node.right == null) {
				sb.append(node.getC());
				node = root;
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		HuffmanCoding hc = new HuffmanCoding("BCCABBDDAECCBBAEDDCC");
		hc.printHuffmanCode();
		System.out.println(hc.encode("BCCABBDDAECCBBAEDDCC"));
		System.out.println(hc.decode("101111011101000000110101111101001101000001111"));
	}

}

class HuffmanNode {
	private int frequency;
	private char c;

	HuffmanNode left;
	HuffmanNode right;

	public HuffmanNode(char c, int data) {
		super();
		this.frequency = data;
		this.c = c;
	}

	public int getFrequency() {
		return frequency;
	}

	public char getC() {
		return c;
	}
}