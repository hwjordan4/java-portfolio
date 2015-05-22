/* Harrison Jordan
 * CS 3401
 * Section 02
 * Prof. Gayler
 * 02/02/2015
 * Assignment 3-1
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
/**
 *  @category Constructor class for Point
 *
 */
public class Point {

	private int x;
	private int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public String toString() {
		return "(" + getX() + ", " + getY() + ")";
	}

	/**
	 *  @category Comparator class for y-coordinates
	 *
	 */
	static class CompareY implements Comparator<Point> {

		
		public int compare(Point o1, Point o2) {
			assert(o1!=null);
			assert(o2!=null);
			
			int y1 = o1.getY();
			int y2 = o2.getY();

			if (y1 < y2)
				return -1;
			else if (y1 == y2) 
			{
				if (o1.getX() < o2.getX())
					return -1;
				else if (o1.getX() == o2.getX())
					return 0;
				else
					return 1;
			} 
			else
				return 1;
		}

	}

	/**
	 *  @category Comparator class for x-coordinates
	 *
	 */
	static class CompareX implements Comparator<Point> {

		public int compare(Point o1, Point o2) {
			assert(o1!=null);
			assert(o2!=null);
			
			int x1 = o1.getX();
			int x2 = o2.getX();

			if (x1 < x2)
				return -1;
			else if (x1 == x2) 
			{
				if (o1.getY() < o2.getY())
					return -1;
				else if (o1.getY() == o2.getY())
					return 0;
				else
					return 1;
			} 
			else
				return 1;
		}

	}

	public static void main(String[] args) {
		Random r = new Random();
		List<Point> points = new ArrayList<Point>();
		int i = 0;
		while (i < 100) 
		{
			points.add(new Point(r.nextInt(50), r.nextInt(50)));
			i++;
		}
		Collections.sort(points, new Point.CompareX());
		System.out.println("Comparing X Coordinates");
		System.out.println(points.toString());
		
		Collections.sort(points, new Point.CompareY());
		System.out.println("Comparing Y Coordinates");
		System.out.println(points.toString());
	}

}
