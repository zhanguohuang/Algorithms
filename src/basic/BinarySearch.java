package basic;

/**
 * @author
 * @use 白名单过滤
 */
public class BinarySearch {

	public static int rank(int[] a, int key) {
		int lo = 0;
		int hi = a.length - 1;
		//关键点,当数组为[5, 6]且查找6时,会出现当lo=hi=1时才查找到6
		while(lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if(key > a[mid]) lo = mid + 1;
			else if(key < a[mid]) hi = mid - 1;
			else return mid;
		}
		return -1;
	}
}
