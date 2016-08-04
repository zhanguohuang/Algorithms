package org.chapter2;

import edu.princeton.cs.algs4.StdRandom;

public class Quick {
	public static void sort(Comparable[] a){
		StdRandom.shuffle(a); //只是任意的交换打乱顺序而已
		sort(a, 0, a.length-1);
	}
	private static void sort(Comparable[] a, int lo, int hi){
		if(hi<=lo)return ;
		int j = partition(a, lo, hi); //如果一个下标来定义左右
		sort(a, lo, j-1); //lo---j-1
		sort(a, j+1, hi); //j+1---hi
	}
	/*
	 * 关键所在 i = lo;++i;j=hi+1;--j;
	 */
	private static int partition(Comparable[] a, int lo, int hi){
		//将数组切分为a[lo..i-1],a[i],a[i+1..hi]
		int i = lo;
		int j = hi+1;
		Comparable v = a[lo];//切分元素
		while(true){
			while(less(a[++i], v)) if(i == hi) break; // ++i
			while(less(v, a[--j])) if(j == lo) break; // --j
			if(i >= j) break; //当他们从指向同一个开始就是不必要的了
			exch(a, i, j);  //最完美的地方，把i跟j交换
		}
		exch(a, lo, j);//最终肯定会是i==j
		return j; //返回的是下标
	}
	private static boolean less(Comparable v, Comparable w){
		return v.compareTo(w) < 0;
	}
	private static void exch(Comparable[] a, int i, int j){
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
}
