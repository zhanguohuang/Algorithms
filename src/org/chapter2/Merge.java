package org.chapter2;

//�Ե����ϵĹ鲢����
public class Merge {
	private static Comparable[] aux;
	public static void sort(Comparable[] a){
		aux = new Comparable[a.length];
		sort(a, 0, a.length-1);
	}
	/*
	 * ˼�룬�������е�0 0 1
	 * Ȼ������������ұߣ���������͹鲢
	 */
	
	private static void sort(Comparable[] a, int lo, int hi){
		//������a[lo...hi]����
		if(hi <= lo) return ;
		int mid = (lo + hi) / 2;
		sort(a, lo, mid);//ϸ����ߵ����1
		sort(a, mid+1, hi);//ϸ���ұߵ����1
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
