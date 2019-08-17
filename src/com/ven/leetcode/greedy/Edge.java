package com.ven.leetcode.greedy;

public class Edge implements Comparable<Edge>{


	private int src;
	private int dest;
	private int weight;
	
	

	public Edge() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public int getSrc() {
		return src;
	}


	public void setSrc(int src) {
		this.src = src;
	}


	public int getDest() {
		return dest;
	}


	public void setDest(int dest) {
		this.dest = dest;
	}


	public int getWeight() {
		return weight;
	}


	public void setWeight(int weight) {
		this.weight = weight;
	}


	@Override
	public String toString() {
		return "Edge [src=" + src + ", dest=" + dest + ", weight=" + weight + "]";
	};

	@Override
	public int compareTo(Edge o) {
		return this.weight - o.weight;
	}

	
}
