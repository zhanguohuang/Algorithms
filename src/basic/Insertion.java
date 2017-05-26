package basic;

public class Insertion {

	public static void sort(Comparable[] a) {
		int N = a.length;
		for(int i = 1; i < N; i++) {
			for(int j = i; j > 0 && less(a, j-1, j); j--) {
				exch(a, j, j-1);
			}
		}
	}

	private static void exch(Comparable[] a, int i, int j) {
		Comparable v = a[i];
		a[i] = a[j];
		a[j] = v;
	}

	private static boolean less(Comparable[] a, int i, int j) {
		return a[i].compareTo(j) < 0;
	}
}
