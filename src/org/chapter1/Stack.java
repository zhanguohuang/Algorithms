package org.chapter1;

import java.util.Iterator;
/* 
 * 完美下压栈的实现
 * 1.它可以处理任意类型的数据
 * 2.所需的空间总是和集合的大小成正比
 * 3.操作所需的时间总是和集合的大小无关
 */
public class Stack<Item> implements Iterable<Item>{
	private Node first;
	private int N;
	private class Node{
		Item item;
		Node next;
	}
	public boolean hasNext(){
		return first == null;//or N == 0;
	}
	public int size(){
		return N;
	}
	public void push(Item item){
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		N++;
	}
	public Item pop(){
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}
	public Iterator<Item> iterator(){
		return new ListIterator();
	}
	private class ListIterator implements Iterator<Item>{
		private Node current = first;
		public Item next(){
			Item item = current.item;
			current = current.next;
			return item;
		}
		public void remove(){}
		@Override
		public boolean hasNext() {
			return current != null;
		}
	}
}
