package com.vm.practice;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapSack {

	public static void main(String[] args) {
		int[] wt = { 10, 40, 20, 30 };
		int[] val = { 60, 40, 100, 120 };
		int capacity = 50;

		double maxValue = getMaxValue(wt, val, capacity);
		System.out.println("Maximum value we can obtain = " + maxValue);
	}

	public static double getMaxValue(int[] wt, int[] val, int capacity) {
		Item[] items = new Item[val.length];

		for (int i = 0; i < val.length; i++) {
			items[i] = new Item(val[i], wt[i], i);
		}
		Arrays.sort(items, new Comparator<Item>() {
			@Override
			public int compare(Item o1, Item o2) {
				// TODO Auto-generated method stub
				return o2.getCost().compareTo(o1.getCost());
			}
		});
		double maxVal=0;
		int index = 0;
		while(capacity>0) {
			if((capacity - items[index].getWeight()) > 0 ) {
				capacity -= items[index].getWeight();
				maxVal += items[index].getProfits();
				index++;
			} else {
				capacity =  (int) (capacity - (items[index].getWeight() * (capacity/items[index].getWeight()))); 
				maxVal += (capacity/items[index].getWeight())*items[index].getCost();
				index++;
			}
		}
		return maxVal;
	}
}

class Item {
	private double profits;
	private double weight;
	private int index;
	private Double cost;

	public Item(int profits, int weight, int index) {
		super();
		this.profits = profits;
		this.weight = weight;
		this.index = index;
		this.cost = (double) (profits / weight);
	}

	public double getProfits() {
		return profits;
	}

	public double getWeight() {
		return weight;
	}

	public int getIndex() {
		return index;
	}

	public Double getCost() {
		return cost;
	}

}