package org.chapter1;

import java.util.Iterator;
/* 
 * ������ѹջ��ʵ��
 * 1.�����Դ����������͵�����
 * 2.����Ŀռ����Ǻͼ��ϵĴ�С������
 * 3.���������ʱ�����Ǻͼ��ϵĴ�С�޹�
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
