package com.ven.comparator;

import java.util.Arrays;
import java.util.Comparator;

public class CompartorSorting {

	public void sortAscending(Score[] arr) {
		Arrays.sort(arr);
	}
	
	public void sortdescending(Score[] arr) {
		Arrays.sort(arr, new Comparator<Score>() {

			@Override
			public int compare(Score a, Score b) {
				// TODO Auto-generated method stub
				return b.getScore()-a.getScore();
			}
			
		});
		
		Arrays.stream(arr).forEach(System.out::println);
	}

	public static void main(String[] args) {
		CompartorSorting cs = new CompartorSorting();
		Score sc1 = new Score(1);
		Score sc2 = new Score(2);
		Score sc3 = new Score(3);
		Score sc4 = new Score(4);
		Score sc5 = new Score(5);
		Score sc6 = new Score(6);
		Score sc7 = new Score(7);

		cs.sortdescending(new Score[] {sc1,sc2,sc3,sc4,sc5,sc6,sc7});
	}
}
