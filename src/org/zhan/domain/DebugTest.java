package org.zhan.domain;

import edu.princeton.cs.algs4.StdIn;

public class DebugTest {
	public static void main(String[] args) {
		
		if(!StdIn.isEmpty()){
			System.out.println(StdIn.readInt());
		}else{
			System.out.println("hello");
		}
		System.out.println("end");
	}
}
