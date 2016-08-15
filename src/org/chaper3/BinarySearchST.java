package org.chaper3;

public class BinarySearchST<Key extends Comparable<Key>, Value> {
	private Key[] keys;
	private Value[] vals;
	private int N;
	public BinarySearchST(int capacity){
		keys = (Key[]) new Comparable[capacity];
		vals = (Value[]) new Object[capacity];
	}
	public int size(){
		return N;
	}
	public Value get(Key key){
		if(isEmpty()) return null;
		int i = rank(key); //返回有多少个值小于key
		if(i<N && keys[i].compareTo(key) == 0) return vals[i];  //说明已找到且刚好就是vals[i]
		else return null;
	}
	public int rank(Key key){  //简单是二分查找，用where实现而不是递归
		int lo = 0;
		int hi = N-1;
		while(lo <= hi){
			int mid = lo + (lo + hi) / 2;
			int cmp = key.compareTo(keys[mid]);
			if(cmp < 0) hi = mid - 1;
			else if(cmp > 0) lo = mid + 1;
			else return mid;
		}
		return lo; //最后肯定是lo是刚好大于他的index
	}
	
	public void put(Key key, Value val){
		int i = rank(key);
		if(i<N && keys[i].compareTo(key) == 0){
			vals[i] = val; //如果恰好相等则覆盖，不然肯定是小于key
			return ;
		}
		for(int j=N;j>i;j--){
			keys[j] = keys[j-1];
			vals[j] = vals[j-1];//不会超过边界
		}
		keys[i] = key;
		vals[i] = val;
		N++;
	}
	public void delete(Key key){};
	
	public boolean isEmpty(){
		return N == 0;
	}
}
