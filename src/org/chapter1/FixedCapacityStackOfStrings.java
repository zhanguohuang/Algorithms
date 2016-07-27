package org.chapter1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*
 * ����Stack��ʵ��,�̶�������String
 * ����ʵ������Ϊһ�����ڱ���ջ�е�Ԫ�ص�a[]����һ�����ڱ���ջ�е�Ԫ������������N��
 * Ҫɾ��һ��Ԫ�أ����ǽ�N��1������a[N].
 * Ҫ���һ��Ԫ�أ����ǽ�a[N]��Ϊ��Ԫ�ز���N��1
 */
public class FixedCapacityStackOfStrings { //�����ĵط����ڣ�Nʼ�ձ������index��1
	private String[] a;
	private int N;
	public FixedCapacityStackOfStrings(int cap){
		a = new String[cap];
	}
	public boolean isEmpty(){
		return N == 0;
	}
	public int size(){
		return N;
	}
	public void push(String item){
		a[N++] = item;
	}
	public String pop(){
		return a[--N];
	}
	public static void main(String[] args) {
		FixedCapacityStackOfStrings s;
		s = new FixedCapacityStackOfStrings(100);
		while(!StdIn.isEmpty()){
			String item = StdIn.readString();
			if(!item.equals("-")){ //��Ϊ����ʱ �����ջ��������ջ
				s.push(item);
			}else if(!s.isEmpty()){
				StdOut.print(s.pop() + " ");
			}
		}
		StdOut.println("(" + s.size() + " left on stack)");
	}
}
/*
* ȱ�㣺1.ֻ�ܴ���String����
* 2.�̶�����
*/
