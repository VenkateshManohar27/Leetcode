package com.ven.leetcode.greedy;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class HuffmanCoding2 {
	private HuffmanNode root;

	public void createHuffmanCode(String str) {
		HashMap<Character, Integer> charFrequencyMap = new HashMap<>();
		for(char c: str.toCharArray()) {
			if(charFrequencyMap.containsKey(c)) {
				charFrequencyMap.put(c, charFrequencyMap.get(c)+1);
			}else {
				charFrequencyMap.put(c, 1);
			}
		}
		
		PriorityQueue<HuffmanNode> pq = new PriorityQueue<HuffmanNode>((node1, node2)-> {
			return node1.getFrequency() - node2.getFrequency();
		});
		
		for(Entry<Character, Integer> entry: charFrequencyMap.entrySet()) {
			System.out.println(entry.getKey() +":"+entry.getValue());
			pq.add(new HuffmanNode(entry.getKey(), entry.getValue()));
		}
		
		
		while(pq.size()>1) {
			HuffmanNode node1 = pq.poll();
			HuffmanNode node2 = pq.poll();
			HuffmanNode node = new HuffmanNode('#', node1.getFrequency()+node2.getFrequency());
			node.left = node1;
			node.right = node2;
			pq.add(node);
		}
		
		root = pq.poll();
		printHuffmanCode(root,"");
	}

	private void printHuffmanCode(HuffmanNode node, String s) {
		if(node.left == null && node.right == null) {
			System.out.println(node.getC()+" : "+s);
			return;
		}
		printHuffmanCode(node.left, s+"0");
		printHuffmanCode(node.right, s+"1");		
		
	}
	
	private String huffmanDecoding(String string) {
		HuffmanNode node = root;
		StringBuilder sb = new StringBuilder();
		for(char c: string.toCharArray()) {
			if(c=='0') {
				node = node.left;
			}else if(c=='1') {
				node = node.right;
			}
			
			if(node.left == null && node.right == null) {
				sb.append(node.getC());
				node = root;
			}
		}
		
		
		return sb.toString();
	}

	public static void main(String[] args) {
		int n = 6;
		HuffmanCoding2 hc = new HuffmanCoding2();
		hc.createHuffmanCode("AAAAAABCCCCCCDDEEEEE");
		String result = hc.huffmanDecoding("0000000000001100101010101011111111010101010");
		System.out.println("Decoded Data = " + result);
		System.out.println("Matching :" + result.equals("BBBBADEEEEEAAACCCCC"));
		
		result = hc.huffmanDecoding("1111111111110001010101010100010010101010101");
		System.out.println("Decoded Data = " + result);
		System.out.println("Matching :" + result.equals("AAAAAABCCCCCCDDEEEEE"));
		
		hc.createHuffmanCode("BCCABBDDAECCBBAEDDCC");
	}

	

}
