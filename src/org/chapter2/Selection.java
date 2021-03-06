package org.chapter2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Selection {
	public static void sort(Comparable[] a){
		int N = a.length;
		for(int i=0;i<N;i++){
			int min = i; //取index
			for(int j=i+1;j<N;j++){//循环选择出最小的那一个
				if(less(a[j], a[min])){
					min = j;	
				}
			}
			exch(a, i, min);//注意放置的位置
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
			if(less(a[i], a[i-1])){
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
		String[] a = StdIn.readStrings();//排序字符
		sort(a);
		assert isSorted(a);
		show(a);
	}
}
