package basic;

/**
 * @author Administrator
 *
 * @param <Item>
 * @description 对比{@link Stack}多维护了一个last变量,使得插入元素变得容易
 */
public class Queue<Item> {

	private Node first;
	private Node last;
	private int N;
	
	public void enqueue(Item item) {
		Node oldLast = last;
		last = new Node();
		last.item = item;
		//最精妙的地方,延迟了对isEmpty的判断
		if(isEmpty()) first = last;
		else oldLast.next = last;
		N++;
	}
	
	public Item dequeue() {
		if(isEmpty()) return null;
		Item item = first.item;
		first = first.next;
		if(isEmpty()) last = null;
		N--;
		return item;
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
