package basic;

public class Selection {

	public static void sort(Comparable[] a) {
		int N = a.length;
		for(int i = 0; i < N; i++) {
			//精妙的地方在于用min保存了i
			int min = i;
			for(int j = i+1; j < N; j++) {
				if(less(a, j, min)) min = j;
			}
			exch(a, i, min);
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
