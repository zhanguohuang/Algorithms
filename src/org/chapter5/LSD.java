package org.chapter5;

public class LSD {

	/**
	 * @param a
	 * @param W 每个串的长度
	 */
	public static void sort(String[] a, int W) {
		//通过前W个字符将a[]排序
		int N = a.length;
		int R = 256;
		String aux[] = new String[N];
		
		for(int d = W-1; d >= 0; d--) {
			int[] count = new int[R + 1];
			//计算出现的频率
			for(int i = 0; i < N; i++) {
				count[a[i].charAt(d) + 1]++; //巧妙的移位，让第一个总是为0，最后一个总是用不上
			}
			//将频率转换为索引
			for(int r = 0; r < R; r++) {
				count[r + 1] += count[r]; 
			}
			//将元素分类
			for(int i = 0; i < N; i++) {
				aux[count[a[i].charAt(d)]++] = a[i];
			}
			//回写
			for(int i = 0; i < N; i++) {
				a[i] = aux[i];
			}
		}
	}
}
