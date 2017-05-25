package basic;

/**
 * @author Administrator
 * @description 定容字符串栈,固定长度的栈很适合从尾部增删
 */
public class FixedCapacityStackOfStrings {

	private String[] a;
	private int N;
	
	public FixedCapacityStackOfStrings(int cap) {
		a = new String[cap];
	}
	
	//关键点在于为维护了N的大小,很多维护N的集合,增加都是N++,删除都是--N
	public void push(String item) {
		a[N++] = item;
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	//关键点在于为维护了N的大小
	public String pop() {
		return a[--N];
	}
	
	public int size() {
		return N;
	}
}
