package basic;

/**
 * @author Administrator
 * @description 希尔排序是{@link Insertion}的变体,理解其过程很重要
 */
public class Shell {

	public static void sort(Comparable[] a) {
		int N = a.length;
		for(int d = N/2; d > 0; d /= 2) {
			for(int i = d; i < N; i++) {
				//易错点 j >= d,为什么会有等于呢,是因为等于的时候明显j-d是有值的,即index->0
				for(int j = i; j >= d && less(a, j, j-d); j -= d) {
					exch(a, j, j-d);
				}
			}
		}
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
