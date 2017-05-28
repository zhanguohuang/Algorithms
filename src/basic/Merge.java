package basic;

/**
 * @author Administrator
 * @description 时间复杂NlogN
 */
public class Merge {

	private static Comparable[] aux;
	
	public static void sort(Comparable[] a) {
		int lo = 0;
		int hi = a.length - 1;
		aux = new Comparable[a.length];
		sort(a, lo, hi);
	}
	
	public static void sort(Comparable[] a, int lo, int hi) {
		if(lo >= hi) return;
		int mid = (lo + hi)/2;
		sort(a, lo, mid);
		sort(a, mid+1, hi);
		//多加一个mid参数会使得节省一步mid的计算
		merge(a, lo, mid, hi);
	}

	private static void merge(Comparable[] a, int lo, int mid, int hi) {
		int i = lo;
		//关键点
		int j = mid + 1;
		//此处也无需复制全部,因为要比较的总是那块区域
		for(int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}
		//关键点:谁小归并谁.前期判断的是哪边被提前归并完下次肯定另一边,因为再比较就不对
		for(int k = lo; k <= hi; k++) {
			if(i > mid) a[k] = aux[j++];
			else if(j > hi) a[k] = aux[i++];
			//易错点,此处比较的应为aux
			else if(less(aux, i, j)) a[k] = aux[i++];
			else a[k] = aux[j++];
		}
	}

	private static boolean less(Comparable[] a, int i, int j) {
		return a[i].compareTo(a[j]) < 0;
	}
	
}
