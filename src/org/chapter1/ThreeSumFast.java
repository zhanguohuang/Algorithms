package org.chapter1;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

//改进后的3-sum算法
public class ThreeSumFast {
	public static int count(int a[]){
		Arrays.sort(a); //NlogN
		int N = a.length;
		int cnt = 0;
		for(int i=0;i<N;i++){
			for(int j=i+1;j<N;j++){  //N*Nlog2N
				if(BinarySearch.rank(-a[i]-a[j], a) > j){
					cnt++;
				}
			}
		}
		return cnt;
	}
	public static void main(String[] args) {
		int[] a = In.readInts(args[0]);
		StdOut.println(count(a));
	}
}
