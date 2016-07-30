package org.chapter2;

public class Selection {
	public static void sort(Comparable[] a){
		int N = a.length;
		for(int i=0;i<N;i++){
			int min = i; //ȡindex
			for(int j=i+1;j<N;j++){
				if(less(a[j], a[i])){
					min = j;
					exch(a, i, min);
				}
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
	private boolean isSorted(Comparable[] a){
		for(int i=1;i<a.length;i++){
			if(less(a[i], a[i-1])){
				return false;
			}
		}
		return true;
	}
}
