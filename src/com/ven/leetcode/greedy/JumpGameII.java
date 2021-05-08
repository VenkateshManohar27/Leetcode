package com.ven.leetcode.greedy;

import java.util.Arrays;

import com.ven.utility.ArrayUtility;

public class JumpGameII {

	public static void main(String[] args) {
		JumpGameII jg = new JumpGameII();
		/*System.out.println(jg.canJump(new int[] { 2, 3, 1, 1, 4 }));
		System.out.println(jg.canJump(new int[] { 3, 2, 1, 0, 4 }));
		System.out.println(jg.canJump(new int[] { 2, 0 }));
		System.out.println(jg.canJump(new int[] { 0 }));
		System.out.println(jg.canJump(new int[] { 2, 0, 0 }));
		System.out.println(jg.canJump(new int[] { 1, 2, 1, 1, 1 }));*/
		
		System.out.println(jg.jump(new int[] { 2, 3, 1, 1, 4 }));
		System.out.println(jg.jump(new int[] { 3, 2, 1, 0, 4 }));
		System.out.println(jg.jump(new int[] { 2, 0 }));
		System.out.println(jg.jump(new int[] { 0 }));
		System.out.println(jg.jump(new int[] { 2, 0, 0 }));
		System.out.println(jg.jump(new int[] { 1, 2, 1, 1, 1 }));
	}

	

	
	public int jump(int[] nums) {
		int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0; i< nums.length; i++){
            int step = dp[i]+1;
            for(int j = i + nums[i]; j>i; j --){
                if(j > nums.length-1){
                continue;
                }
                dp[j] = Math.min(step, dp[j]);
            }
            
        }
        //System.out.println(Arrays.toString(dp));
        return dp[nums.length-1];
    }
}
