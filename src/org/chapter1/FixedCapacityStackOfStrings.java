package org.chapter1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*
 * 简单型Stack的实现,固定容量的String
 * 它的实例变量为一个用于保存栈中的元素的a[]，和一个用于保存栈中的元素数量的整数N。
 * 要删除一个元素，我们将N减1并返回a[N].
 * 要添加一个元素，我们将a[N]设为新元素并将N加1
 */
public class FixedCapacityStackOfStrings { //高明的地方在于，N始终比数组的index多1
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
			if(!item.equals("-")){ //当为减号时 ，则出栈，否则入栈
				s.push(item);
			}else if(!s.isEmpty()){
				StdOut.print(s.pop() + " ");
			}
		}
		StdOut.println("(" + s.size() + " left on stack)");
	}
}
/*
* 缺点：1.只能处理String对象
* 2.固定长度
*/
