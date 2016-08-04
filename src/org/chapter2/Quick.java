package org.chapter2;

import edu.princeton.cs.algs4.StdRandom;

public class Quick {
	public static void sort(Comparable[] a){
		StdRandom.shuffle(a); //ֻ������Ľ�������˳�����
		sort(a, 0, a.length-1);
	}
	private static void sort(Comparable[] a, int lo, int hi){
		if(hi<=lo)return ;
		int j = partition(a, lo, hi); //���һ���±�����������
		sort(a, lo, j-1); //lo---j-1
		sort(a, j+1, hi); //j+1---hi
	}
	/*
	 * �ؼ����� i = lo;++i;j=hi+1;--j;
	 */
	private static int partition(Comparable[] a, int lo, int hi){
		//�������з�Ϊa[lo..i-1],a[i],a[i+1..hi]
		int i = lo;
		int j = hi+1;
		Comparable v = a[lo];//�з�Ԫ��
		while(true){
			while(less(a[++i], v)) if(i == hi) break; // ++i
			while(less(v, a[--j])) if(j == lo) break; // --j
			if(i >= j) break; //�����Ǵ�ָ��ͬһ����ʼ���ǲ���Ҫ����
			exch(a, i, j);  //�������ĵط�����i��j����
		}
		exch(a, lo, j);//���տ϶�����i==j
		return j; //���ص����±�
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
