package org.zhan.domain;

class A{
	public int i = 1;
	public A print(){
		System.out.println(i);
		return this;
	}
	public void unbelievable(){
		System.out.println(i+1);
	}
}
public class B extends A {
	public int i = 0;
	@Override
	public void unbelievable(){
		System.out.println(i-1);
	}
	public static void main(String[] args) {
		new B().print().unbelievable();
	}
}
