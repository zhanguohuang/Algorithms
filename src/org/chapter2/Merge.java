package org.chapter2;

//自底向上的归并排序
public class Merge {
	private static Comparable[] aux;
	public static void sort(Comparable[] a){
		aux = new Comparable[a.length];
		sort(a, 0, a.length-1);
	}
	/*
	 * 思想，把数组切到0 0 1
	 * 然后排完左边排右边，左右排完就归并
	 */
	
	private static void sort(Comparable[] a, int lo, int hi){
		//将数组a[lo...hi]排序
		if(hi <= lo) return ;
		int mid = (lo + hi) / 2;
		sort(a, lo, mid);//细分左边到间隔1
		sort(a, mid+1, hi);//细分右边到间隔1
		merge(a, lo, mid, hi);
	}
	private static void merge(Comparable[] a, int lo, int mid, int hi){
		int i = lo;
		int j = mid + 1;
		for(int k=lo;k<=hi;k++){
			aux[k] = a[k];
		}
		for(int k=lo;k<=hi;k++){
			if(i>mid) a[k] = aux[j++];
			else if(j>hi) a[k] = aux[i++];
			else if(less(aux[j], aux[i])) a[k] = aux[j++];
			else a[k] = aux[i++];
		}
	}
	private static boolean less(Comparable v, Comparable w){
		return v.compareTo(w) < 0;
	}
}
