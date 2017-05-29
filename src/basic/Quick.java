package basic;

public class Quick {

	public static void sort(Comparable[] a) {
		sort(a, 0, a.length-1);
	}

	private static void sort(Comparable[] a, int i, int j) {
		if(i >= j) return;
		int mid = partition(a, i, j);
		sort(a, i, mid-1);
		sort(a, mid+1, j);
	}

	private static int partition(Comparable[] a, int lo, int hi) {
		int i = lo;
		int j = hi + 1;
		while(true) {
			while(less(a, ++i, lo))
				if(i >= hi) break; 
			while(less(a, lo, --j)) 
				if(j <= lo) break;
			//关键点,如果情况为 3 1 2时, 明显直接交换3和2即可
			if(i >= j) break;
			exch(a, i, j);
		}
		exch(a, lo, j);
		return j;
	}

	private static void exch(Comparable[] a, int i, int j) {
		Comparable v = a[i];
		a[i] = a[j];
		a[j] = v;
	}

	private static boolean less(Comparable[] a, int i, int j) {
		return a[i].compareTo(a[j]) < 0;
	}
	
}
