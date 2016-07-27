package org.chapter1;

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item>{
	private Node first;
	private Node last;
	private int N;
	private class Node{
		Item item;
		Node next;
	}
	public boolean isEmpty(){
		return first == null;//or N == 0;
	}
	public int size(){
		return N;
	}
	public void enqueue(Item item){
		Node oldlast = last;
		last = new Node();
		last.item = item;
		if(isEmpty()){
			first = last;
		}else{
			oldlast = last;
		}
		N++;
	}
	public Item dequeue(){
		Item item = first.item;
		first = first.next;
		if(isEmpty()){
			last = null;
		}
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
