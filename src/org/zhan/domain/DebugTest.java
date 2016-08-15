package org.zhan.domain;

import java.util.Scanner;
import java.util.TreeSet;

public class DebugTest {
	public static void main(String[] args) {
		int[] a = {2,3,5};
		//´Ë
		int n = new Scanner(System.in).nextInt();
		TreeSet<Integer> set = new TreeSet<Integer>();
		int size = a.length;
		for(int i=0;i<size;i++){
			set.add(a[i]);
			for(int j=i;j<size;j++){
				set.add(a[i]*a[j]);
				for(int k=j;k<size;k++){
					set.add(a[i]*a[j]*a[k]);
				}
			}
		}
		System.out.println(n);
	}
}
