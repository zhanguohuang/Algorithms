package org.chaper3;

import java.util.Scanner;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Test {
	public static void main(String[] args) {
		StringBuffer str = new StringBuffer();
		Scanner scan  = new Scanner(new java.io.BufferedInputStream(System.in), "UTF-8");
		while(scan.nextLine() != null){
			str.append(scan.nextLine());
		}
		System.out.println(str);
	}
}
