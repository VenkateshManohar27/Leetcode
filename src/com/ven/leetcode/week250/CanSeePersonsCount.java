package com.ven.leetcode.week250;

import com.ven.utility.ArrayUtility;

public class CanSeePersonsCount {
	public int[] canSeePersonsCount(int[] heights) {
        int i, j;
        int n = heights.length;
        int[] countSmaller = new int[heights.length];
        // initialize all the counts in countSmaller array as 0
        for (i = 1; i < n-1; i++)
            countSmaller[i] = 0;
 
        for (i = 0; i < n; i++)
        {
        	int max = 0;
            for (j = i + 1; j < n; j++)
            {
                
                if(heights[j] > heights[i]){
                     countSmaller[i]++;
                    break;
                }
                if (max <heights[j] && heights[j] < heights[i]){
                    countSmaller[i]++;
                }
                max= Math.max(max, heights[j]);
                
            }
        }
        return countSmaller;
    }
	
	public static void main(String[] args) {
		CanSeePersonsCount c = new CanSeePersonsCount();
		ArrayUtility.print(c.canSeePersonsCount(new int[] {10,6,8,5,11,9}));
		ArrayUtility.print(c.canSeePersonsCount(new int[] {5,1,2,3,10}));
	}
}
