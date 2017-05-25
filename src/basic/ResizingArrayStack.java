package basic;

import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item> {

	private Item[] a;
	private int N;
	
	public ResizingArrayStack(int cap) {
		a = (Item[]) new Object[cap];
	}
	
	public void push(Item item) {
		if(N == a.length) resize(2*N);
		a[N++] = item;
	}
	
	public Item pop() {
		Item item = a[--N];
		a[N] = null;
		if(N > 0 && N < a.length) resize(a.length/2);
		return item;
	}
	
	
	private void resize(int size) {
		Item[] temp = (Item[]) new Object[size];
		for(int i = 0; i < N; i++) {
			temp[i] = a[i];
		}
		a = temp;
	}

	@Override
	public Iterator<Item> iterator() {
		return new ReverseArrayIterator();
	}
	
	private class ReverseArrayIterator implements Iterator<Item> {
		
		private int i = N;
		
		@Override
		public boolean hasNext() {
			return i > 0;
		}

		@Override
		public Item next() {
			return a[--i];
		}
		
	}

}
