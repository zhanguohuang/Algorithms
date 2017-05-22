package org.chapter5;

public class MSD {

	private static int R = 256;
	private static int M = 15;
	private static String[] aux;

	private static int charAt(String s, int d) {
		if(d < s.length()) return s.charAt(d);
		return -1;
	}
	
	public static void sort(String a[]) {
		int N = a.length;
		aux = new String[N];
		sort(a, 0, N-1, 0);
	}

	private static void sort(String[] a, int lo, int hi, int d) {
		if(hi <= lo + M) {
			insertSort(a, lo, hi);
			return ;
		}
		int[] count = new int[R + 2];
		for(int i = lo; i <= hi; i++) {
			count[charAt(a[i], d) + 2]++;
		}
		for(int r = 0; r < R + 1; r++) {
			count[r + 1] += count[r];
		}
		for(int i = lo; i <= hi; i++) {
			aux[count[charAt(a[i], d) + 1]++] = a[i];
		}
		for(int i = lo; i <= hi; i++) {
			a[i] = aux[i - lo];
		}
		for(int r = 0; r < R; r++) {
			sort(a, lo + count[r], lo + count[r + 1] - 1, d++);
		}
	}

	private static void insertSort(String[] a, int lo, int hi) {
		for(int i = lo + 1; i <= hi; i++) {
			for(int j = i; j > lo && a[j].compareTo(a[j - 1]) < 0; j--) {
				String temp = a[j];
				a[j] = a[j - 1];
				a[j - 1] = temp;
			}
		}
	}
	
}
