package org.chapter2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Insertion {
	public static void sort(Comparable[] a){
		int N = a.length;
		for(int i=1;i<N;i++){
			for(int j=i;j>0 && less(a[j],a[j-1]);j--){ //��Χ�ڵ�����
				exch(a, j, j-1);
			}
		}
	}
	private static boolean less(Comparable v, Comparable w){
		return v.compareTo(w) < 0;
	}
	private static void exch(Comparable[] a, int i, int j){
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	private static boolean isSorted(Comparable[] a){
		for(int i=1;i<a.length;i++){
			if(less(a[i],a[i-1])){
				return false;
			}
		}
		return true;
	}
	private static void show(Comparable[] a){
		for(int i=0;i<a.length;i++){
			StdOut.print(a[i] + " ");
		}
		StdOut.println();
	}
	public static void main(String[] args) {
		String[]  a = StdIn.readStrings();
		sort(a);
		assert isSorted(a);
		show(a);
	}
}
