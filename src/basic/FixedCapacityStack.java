package basic;

/**
 * @author Administrator
 *
 * @param <Item>
 * @description 带泛型的 {@link FixedCapacityStackOfStrings}
 */
public class FixedCapacityStack<Item> {

	private Item[] a;
	private int N;
	
	public FixedCapacityStack(int cap) {
		a = (Item[]) new Object[cap];
	}
	
	public void push(Item item) {
		if(N == a.length) resize(2*N);
		a[N++] = item;
	}
	
	public Item pop() {
		Item item = a[--N];
		//避免对象游离
		a[N] = null;
		if(N > 0 && N < a.length/4) resize(a.length/2);
		return item;
	}
	
	public int size() {
		return N;
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	/**
	 * @param 移动
	 */
	private void resize(int size) {
		Item[] temp = (Item[]) new Object[size];
		for(int i = 0; i < N; i++) {
			temp[i] = a[i];
		}
		a = temp;
	}
}
