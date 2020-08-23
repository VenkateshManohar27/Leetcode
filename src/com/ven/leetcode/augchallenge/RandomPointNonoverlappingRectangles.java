package com.ven.leetcode.augchallenge;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import com.ven.utility.ArrayUtility;

/**
 * Given a list of non-overlapping axis-aligned rectangles rects, write a
 * function pick which randomly and uniformily picks an integer point in the
 * space covered by the rectangles.
 * 
 * Note:
 * 
 * An integer point is a point that has integer coordinates. A point on the
 * perimeter of a rectangle is included in the space covered by the rectangles.
 * ith rectangle = rects[i] = [x1,y1,x2,y2], where [x1, y1] are the integer
 * coordinates of the bottom-left corner, and [x2, y2] are the integer
 * coordinates of the top-right corner. length and width of each rectangle does
 * not exceed 2000. 1 <= rects.length <= 100 pick return a point as an array of
 * integer coordinates [p_x, p_y] pick is called at most 10000 times. Example 1:
 * 
 * Input: ["Solution","pick","pick","pick"] [[[[1,1,5,5]]],[],[],[]] Output:
 * [null,[4,1],[4,1],[3,3]] Example 2:
 * 
 * Input: ["Solution","pick","pick","pick","pick","pick"]
 * [[[[-2,-2,-1,-1],[1,0,3,0]]],[],[],[],[],[]] Output:
 * [null,[-1,-2],[2,0],[-2,-1],[3,0],[-2,-2]] Explanation of Input Syntax:
 * 
 * The input is two lists: the subroutines called and their arguments.
 * Solution's constructor has one argument, the array of rectangles rects. pick
 * has no arguments. Arguments are always wrapped with a list, even if there
 * aren't any.
 * 
 * @author Venkatesh Manohar
 *
 */
class Rectangle {
	private int xmin, ymin, xmax, ymax;
	private Random r = new Random();

	public Rectangle(int leftx, int lefty, int rightx, int righty) {
		super();
		this.xmin = (leftx < rightx) ? leftx : rightx;
		this.ymin = (lefty < righty) ? lefty : righty;
		this.xmax = (leftx > rightx) ? leftx : rightx;
		this.ymax = (lefty > righty) ? lefty : righty;
	}

	public int[] pick() {
		int randomx = r.nextInt(Math.abs(xmax - xmin) + 1) + xmin;
		int randomy = r.nextInt(Math.abs(ymax - ymin) + 1) + ymin;
		return new int[] { randomx, randomy };
	}

}

public class RandomPointNonoverlappingRectangles {
	Queue<Rectangle> q = new LinkedList<Rectangle>();

	public RandomPointNonoverlappingRectangles(int[][] rects) {
		for (int i = 0; i < rects.length; i++) {
			if (rects[i].length > 0) {
				Rectangle r = new Rectangle(rects[i][0], rects[i][1], rects[i][2], rects[i][3]);
				q.add(r);
			}
		}
	}

	public int[] pick() {
		Rectangle r = q.poll();
		q.add(r);
		return r.pick();

	}

	public static void main(String[] args) {
		RandomPointNonoverlappingRectangles r = new RandomPointNonoverlappingRectangles(
				new int[][] { { 1, 1, 5, 5 }, {}, {}, {} });
		ArrayUtility.print(r.pick());
		ArrayUtility.print(r.pick());
		ArrayUtility.print(r.pick());
		

		r = new RandomPointNonoverlappingRectangles(new int[][] { { -2, -2, -1, -1 }, { 1, 0, 3, 0 }, {}, {}, {}, {} });
		ArrayUtility.print(r.pick());
		ArrayUtility.print(r.pick());
		ArrayUtility.print(r.pick());
		
		
		r = new RandomPointNonoverlappingRectangles(new int[][] {{82918473, -57180867, 82918476, -57180863},{793579, 18088559, 83793580, 18088560},{66574245, 26243152, 66574246, 26243153},{72983930, 11921716, 72983934, 11921720}});
		for (int i = 0; i <10000; i++) {
			ArrayUtility.print(r.pick());
		}
	}
}
