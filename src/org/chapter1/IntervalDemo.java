package org.chapter1;

import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.Point2D;

public class IntervalDemo {
	public static void main(String[] args) {
		//创建一个间隔
		double xlo = Double.parseDouble(args[0]);// .2
		double xhi = Double.parseDouble(args[1]);// .5
		double ylo = Double.parseDouble(args[2]);// .5
		double yhi = Double.parseDouble(args[3]);// .6
		int T = Integer.parseInt(args[4]);
		Interval1D xinterval = new Interval1D(xlo, xhi);
		Interval1D yinterval = new Interval1D(ylo, yhi);
		Interval2D box = new Interval2D(xinterval, yinterval);
		box.draw();
		
		Counter c = new Counter("hits");
		for(int t=0;t<T;t++){
			double x = Math.random();
			double y = Math.random();
			Point2D p = new Point2D(x, y);
			if(box.contains(p)) c.increment();
		}
	}
}
