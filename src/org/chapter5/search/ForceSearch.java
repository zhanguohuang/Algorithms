package org.chapter5.search;

public class ForceSearch {

	/**
	 * 暴力搜索
	 * @param pat
	 * @param txt
	 * @return
	 */
	public static int search0(String pat, String txt) {
		int M = pat.length();
		int N = txt.length();
		for(int i = 0; i <= N - M; i++) {
			int j;
			for(j = 0; j < M; j++)
				if(txt.charAt(i + j) != pat.charAt(j))
					break;
			if(j == M) return i;
		}
		return N;
	}
	
	public static int search(String pat, String txt) {
		int j, M = pat.length();
		int i, N = txt.length();
		for(i = 0, j = 0; i < N && j < M; i++) {
			if(txt.charAt(i) == pat.charAt(j)) j ++;
			else {
				i -= j; // 回退
				j = 0;
			}
		}
		if(j == M) return i - M;
		else return N;
	}
}
