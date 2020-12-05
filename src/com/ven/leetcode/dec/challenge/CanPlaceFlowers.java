package com.ven.leetcode.dec.challenge;

/**
 * You have a long flowerbed in which some of the plots are planted, and some
 * are not. However, flowers cannot be planted in adjacent plots.
 * 
 * Given an integer array flowerbed containing 0's and 1's, where 0 means empty
 * and 1 means not empty, and an integer n, return if n new flowers can be
 * planted in the flowerbed without violating the no-adjacent-flowers rule.
 * 
 * 
 * Example 1:
 * 
 * Input: flowerbed = [1,0,0,0,1], n = 1 Output: true Example 2:
 * 
 * Input: flowerbed = [1,0,0,0,1], n = 2 Output: false
 * 
 * 
 * Constraints:
 * 
 * 1 <= flowerbed.length <= 2 * 104 flowerbed[i] is 0 or 1. There are no two
 * adjacent flowers in flowerbed. 0 <= n <= flowerbed.length
 * 
 * @author Venkatesh Manohar
 *
 */
public class CanPlaceFlowers {
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		if (n == 0)
			return true;
		if (flowerbed.length == 1) {
			if (flowerbed[0] == 0) {
				return true;
			} else {
				return false;
			}
		}
		for (int i = 0; i < flowerbed.length; i++) {
			if (flowerbed[i] == 0) {
				if (i == 0 && i + 1 < flowerbed.length && flowerbed[i + 1] == 0) {
					n--;
					flowerbed[i] = 1;
				} else if (i > 0 && i + 1 < flowerbed.length) {
					if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
						n--;
						flowerbed[i] = 1;
					}
				} else if (i > 0 && i == flowerbed.length - 1) {
					if (flowerbed[i - 1] == 0) {
						n--;
						flowerbed[i] = 1;
					}
				}

			}
			if (n == 0)
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		CanPlaceFlowers c = new CanPlaceFlowers();
		System.out.println(c.canPlaceFlowers(new int[] {1,0,0,0,1}, 1));
		System.out.println(c.canPlaceFlowers(new int[] {1,0,0,0,1}, 2));
		System.out.println(c.canPlaceFlowers(new int[] {1}, 1));
		System.out.println(c.canPlaceFlowers(new int[] {0}, 1));
		System.out.println(c.canPlaceFlowers(new int[] {0,0,0,0,0}, 3));
		System.out.println(c.canPlaceFlowers(new int[] {0,0,1,0,0}, 2));
		System.out.println(c.canPlaceFlowers(new int[] {0,1,0,0,0}, 2));
		System.out.println(c.canPlaceFlowers(new int[] {0,1,0,0,0}, 1));
	}
}
