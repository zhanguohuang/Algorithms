package org.chapter2;

//ԭ�ع鲢����a[k]Ϊԭ
public class OriginMerge {
	private static Comparable[] aux;
	//��a[lo..mid]��a[mid+1..hi]�鲢
	public static void merge(Comparable[] a, int lo, int mid, int hi){
		int i = lo;
		int j = mid + 1;
		for(int k=lo;k<=hi;k++){
			aux[k] = a[k];
		}
		for(int k=lo;k<hi;k++){
			if(i>mid) a[k] = aux[j++];
			else if(j>hi) a[k] = aux[i++];
			else if(less(aux[j], aux[i])) a[k] = a[j++];
			else a[k] = a[i++];
		}
	}
	private static boolean less(Comparable v, Comparable w){
		return v.compareTo(w) < 0;
	}
}
