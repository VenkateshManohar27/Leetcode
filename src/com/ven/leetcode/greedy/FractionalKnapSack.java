package com.ven.leetcode.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given weights and values of n items, we need to put these items in a knapsack
 * of capacity W to get the maximum total value in the knapsack.
 * 
 * In the 0-1 Knapsack problem, we are not allowed to break items. We either
 * take the whole item or don’t take it.
 * 
 * Input: Items as (value, weight) pairs arr[] = {{60, 10}, {100, 20}, {120,
 * 30}} Knapsack Capacity, W = 50; Output: Maximum possible value = 220 by
 * taking items of weight 20 and 30 kg
 * 
 * In Fractional Knapsack, we can break items for maximizing the total value of
 * knapsack. This problem in which we can break an item is also called the
 * fractional knapsack problem.
 * 
 * Input : Same as above Output : Maximum possible value = 240 By taking full
 * items of 10 kg, 20 kg and 2/3rd of last item of 30 kg
 * 
 * @author Venkatesh Manohar
 *
 */

class Item {
	private double weight;
	private double value;
	private Double profit;

	public Item(int wt, int val) {
		this.weight = wt;
		this.value = val;
		this.profit = (double) (value / weight);
	}

	public double getWeight() {
		return weight;
	}

	public double getValue() {
		return value;
	}

	public Double getProfit() {
		return profit;
	}

	@Override
	public String toString() {
		return "Item [weight=" + weight + ", value=" + value + ", cost=" + profit + "]";
	}

}

public class FractionalKnapSack {
	public static double getMaxValue(int[] wt, int[] val, int capacity) {
		Item[] items = new Item[wt.length];
		for (int i = 0; i < wt.length; i++) {
			items[i] = new Item(wt[i], val[i]);
		}

		Arrays.sort(items, new Comparator<Item>() {

			@Override
			public int compare(Item o1, Item o2) {

				return o2.getProfit().compareTo(o1.getProfit());
			}

		});
		Arrays.stream(items).forEach(System.out::println);
		int max = 0;
		for (int i = 0; i < items.length; i++) {
			if (capacity - items[i].getWeight() > 0) {
				max += items[i].getValue();
				capacity -=  items[i].getWeight();
			} else {
				double fraction = capacity/items[i].getWeight();
				max += fraction* items[i].getValue();
				capacity = (int) (capacity - (items[i].getWeight() * fraction));
			}
		}
		return max;
	}

	// Time complexity O(n log n)
	public static void main(String[] args) {
		int[] wt = { 10, 40, 20, 30 };
		int[] val = { 60, 40, 100, 120 };
		int capacity = 50;

		double maxValue = getMaxValue(wt, val, capacity);
		System.out.println("Maximum value we can obtain = " + maxValue);

	}

}
