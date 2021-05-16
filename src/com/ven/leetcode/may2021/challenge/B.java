package com.ven.leetcode.may2021.challenge;

import com.ven.utility.ArrayUtility;

public class B {
	public char[][] rotateTheBox(char[][] box) {
		int m = box.length;
		int n = box[0].length;
		char[][] res = new char[n][m];

		for (int i = 0; i < m; i++) {
			int obstacle = n-1;
			int index = n-1;
			while (index >= 0) {
				if (box[i][index] == '.') {
					index--;
					continue;
				}
				if(box[i][index] == '*') {
					obstacle = index;
				}
				//obstacle--;
				int j = obstacle;
				while (j >= 0) {
					if(box[i][j] == '*') {
						obstacle = j-1;;
					}
					if (box[i][j] == '#') {
						char temp = box[i][j];
						box[i][j] = '.';
						box[i][obstacle--] = temp;
					}
					j--;
				}
				index = j;
			}

			

		}
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				res[j][m-i-1] = box[i][j];
			}
		}
		//ArrayUtility.print(res);
		return res;
	}

	public static void main(String[] args) {
		B b = new B();
		char[][] box = new char[][] { { '#', '#', '*', '.', '*', '.' }, { '#', '#', '#', '*', '.', '.' },
				{ '#', '#', '#', '.', '#', '.' } };
		b.rotateTheBox(box);
		
		
		box = new char[][] { { '*','#','*','.','.','.','#','.','*','.'}};
		b.rotateTheBox(box);
		
		
		box = new char[][] { { '#', '#', '.', '*', '*', '.' }, { '#', '#', '.', '*', '#', '*' },
			{ '#', '#', '#', '.', '#', '.' } };
	b.rotateTheBox(box);
	
	
	box = new char[][] { { '*','#','*','.','.','.','#','.','*','.'}};
	b.rotateTheBox(box);
	}
}
