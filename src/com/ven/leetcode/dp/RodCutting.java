package com.ven.leetcode.dp;

public class RodCutting {

	/* Driver program to test above functions */
	public static void main(String args[]) {
		int arr[] = new int[] { 1, 5, 8, 9, 10, 17, 17, 20 };
		int size = arr.length;
		int memo[] = new int[size+1];
		memo[0] = 0;
		//System.out.println("Maximum Obtainable Value is " + cutRod(arr,memo, size));
		
		arr = new int[] { 3, 5, 8, 9 };
		 size = arr.length;
		memo = new int[size+1];
		memo[0] = 0;
		System.out.println("Maximum Obtainable Value is " + cutRod(arr,memo, size));
	}

	public static int cutRod(int[] arr, int[] memo, int size) {
		if (size <= 0) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		System.out.println("size: "+size);
		for (int i = 0; i < size; i++) {
			/*System.out.println("max:"+max);
			System.out.println("arr[i]:"+arr[i]);
			System.out.println("size-i-1:"+(size-i-1));*/
			if(memo[size]!= 0) {
				System.out.println("memo["+size+"]:"+memo[size]);
				max = Math.max(max, memo[size]);
			}else {
				System.out.println("max:"+max);
				System.out.println("arr[i]:"+arr[i]);
				System.out.println("size-i-1:"+(size-i-1));
				max = Math.max(max, arr[i]+ cutRod(arr, memo, size-i-1));
			}
			
			/*System.out.println("i:"+i);
			System.out.println("maxafter :"+max);*/
		}
		System.out.println("return max: "+max);
		memo[size] = max;
		return max;
	}
}
