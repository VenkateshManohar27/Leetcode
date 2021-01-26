package com.ven.leetcode.jan2021.challenge;

public class NumberofProvincesUF {
	public int findCircleNum(int[][] isConnected) {
		UnionFind uf = new UnionFind(isConnected.length);
		for (int i = 0; i < isConnected.length; i++) {
			for (int j = i + 1; j < isConnected.length; j++) {
				if (isConnected[i][j] == 1) {
					uf.union(i, j);
				}
			}
		}
		return uf.getRoots();
	}

	public static void main(String[] args) {
		NumberofProvincesUF n = new NumberofProvincesUF();
		System.out.println(n.findCircleNum(new int[][] { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } }));
		System.out.println(n.findCircleNum(new int[][] { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } }));
	}
}

class UnionFind {
	private int roots = 0;
	private int[] parent;
	private int[] size;

	public int getRoots() {
		return roots;
	}

	public UnionFind(int n) {
		super();
		this.roots = n;
		parent = new int[n];
		size = new int[n];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
			size[i] = 1;
		}
	}

	public void union(int i, int j) {
		int rooti = find(i);
		int rootj = find(j);
		if (rooti == rootj) {
			return;
		}
		roots--;
		if (size[rooti] > size[rootj]) {
			parent[rootj] = rooti;
			size[rooti] += size[rootj];
		} else {
			parent[rooti] = rootj;
			size[rootj] += size[rooti];
		}
	}

	public int find(int i) {
		int curr = i;
		while (curr != parent[curr]) {
			curr = parent[curr];
		}
		return curr;
	}

}