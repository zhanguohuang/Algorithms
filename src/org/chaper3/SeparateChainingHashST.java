package org.chaper3;

/*
 * 拉链法散列表的实现
 */

public class SeparateChainingHashST<Key, Value> {
	private int N; 					//键值对总数
	private int M; 					//散列表的大小
	private SequentialSearchST<Key, Value>[] st;
	public SeparateChainingHashST(){
		this(997);
	}
	public SeparateChainingHashST(int M){
		this.M = M;
		st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
		for(int i=0;i<M;i++){
			st[i] = new SequentialSearchST();
		}
	}
	private int hash(Key key){
		return (key.hashCode() & 0x7fffffff) % M;  //获取hashCode的值
	}
	private Value get(Key key){
		return (Value) st[hash(key)].get(key);
	}
	public void put(Key key, Value val){
		st[hash(key)].put(key, val);
	}
//	public Iterable<Key> keys(){};
}
