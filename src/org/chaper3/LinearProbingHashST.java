package org.chaper3;

//散列表的线性探测法
public class LinearProbingHashST<Key, Value> {
	private int N;   		//符号表中的总键值对
	private int M;			//线性探测表的大小
	private Key[] keys;		//键
	private Value[] vals;	//值
	public LinearProbingHashST(){
		keys = (Key[]) new Object[M];
		vals = (Value[]) new Object[M];
	}
	public LinearProbingHashST(int cap){
		keys = (Key[]) new Object[cap];
		vals = (Value[]) new Object[cap];
	}
	private int hash(Key key){
		return (key.hashCode() & 0x7fffffff) % M;
	}
	private void resize(){};
	public void put(Key key, Value val){
		if(N >= M/2) resize(2*M);  //将数组的大小加倍
		int i;
		for(i = hash(key); keys[i] != null;i = (i+1) % M){ //从头开始
			if(keys[i].equals(key)) {
				vals[i] = val;
				return ;
			}
		}
		keys[i] = key;
		vals[i] = val;
		N++;
	}
	public Value get(Key key){
		for(int i = hash(key);keys[i] != null;i = (i+1) % M){
			if(keys[i].equals(key)) return vals[i];
		}
		return null;
	}
	//删除一个Key时，要将后面所有的key重新插入
	public void delete(Key key){
		if(!contain(key)) return ;
		int i = hash(key);
		while(!key.equals(keys[i])){
			i = (i + 1) % M;
		}	
		keys[i] = null;
		vals[i] = null;
		i = (i + 1) % M;//从下一个开始
		while(keys[i] != null){
			Key keyToRedo = keys[i];
			Value valToRedo = vals[i];
			keys[i] = null;
			vals[i] = null;
			N--;
			put(keyToRedo, valToRedo);
			i = (i + 1) % M;
		}
		N--;
		if(N > 0 && N == M/8) resize(M/2);
	}
	private void resize(int cap){
		LinearProbingHashST<Key, Value> t;
		t = new LinearProbingHashST<Key, Value>(cap);
		for(int i=0;i<M;i++) {
			if(keys[i] != null){
				t.put(keys[i], vals[i]);
			}
		}
		keys = t.keys;
		vals = t.vals;
		M = t.M;
	}
	//自定义
	private boolean contain(Key key){
		return get(key) != null;
	}
}
