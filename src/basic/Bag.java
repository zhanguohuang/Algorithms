package basic;

/**
 * @author Administrator
 *
 * @param <Item>
 * @description {@link Stack}的简化版
 */
public class Bag<Item> {

	private Node first;
	private int N;
	
	public void add(Item item) {
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		N++;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public int size() {
		return N;
	}
	
	private class Node {
		Item item;
		Node next;
	}
}
