package basic;

/**
 * @author Administrator
 *
 * @param <Item>
 * 只需要维护一个first就行了
 */
public class Stack<Item> {

	private Node first;
	private int N;
	
	public void push(Item item) {
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		N++;
	}
	
	public Item pop() {
		if(isEmpty()) return null;
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}
	
	public int size() {
		return N;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	private class Node {
		Item item;
		Node next;
	}
}
