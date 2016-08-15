package org.chaper3;

import edu.princeton.cs.algs4.Queue;

/*
 * 最为优雅的代码，特么是put,get和N的实现
 */
public class BST<Key extends Comparable<Key>, Value> {
	private Node root;
	private class Node{
		private Key key;
		private Value val;
		private Node left;
		private Node right;
		private int N;
		public Node(Key key, Value val, int N){
			this.key = key;
			this.val = val;
			this.N = N;//直接表示含有几个子结点
		}
	}
	public int size(){
		return size(root);
	}
	private int size(Node x){
		if(x == null) return 0;
		else return x.N;
	}
	public Value get(Key key){ //设计模式,精华所在
		return get(root, key);
	}
	private Value get(Node x, Key key){
		if(x == null) return null;
		int cmp = key.compareTo(x.key);
		if(cmp < 0) return get(x.left, key);
		else if(cmp > 0) return get(x.right, key);
		else return x.val;
	}
	public void put(Key key, Value val){
		root = put(root, key, val);
	}
	public Node put(Node x, Key key, Value val){
		if(x == null) return new Node(key, val, 1); //如果为空，则成为叶子结点
		int cmp = key.compareTo(x.key);
		if(cmp < 0) x.left = put(x.left, key, val);  
		else if(cmp > 0) x.right = put(x.right, key, val);
		else x.val = val;
		x.N = size(x.left) + size(x.right) + 1; //几乎完美,应该都从1开始考虑，被遍历过的每一个结点都会执行这段代码
		return x;
	}
	public Key floor(Key key){
		Node x = floor(root, key);
		if(x == null) return null;
		return x.key;
	}
	private Node floor(Node x, Key key){
		if(x == null) return null;
		int cmp = key.compareTo(x.key);
		if(cmp == 0) return x;
		if(cmp < 0) return floor(x.left, key);
		Node t = floor(x.right, key); //永远只保留了右边的最大值，并最终返回他
		if(t != null) return t;
		else return x;
	}
	
	public Key min(){
		return min(root).key;
	}
	private Node min(Node x){
		if (x.left == null) return x;
		return min(x.left);
	}
	public Key max(){
		return max(root).key;
	}
	private Node max(Node x){
		if(x.right == null) return x;
		return max(x.right);
	}
	public Key select(int k){ //寻找排名为k的键
		return select(root, k).key;
	}
	private Node select(Node x, int k){
		if(x == null) return null; //无排名
		int t = size(x.left);
		if(t > k) return select(x.left, k);
		else if(t < k) return select(x.right, k-t-1);//需要减去左边所有的键在寻找
		else return x;
	}
	public int rank(Key key){
		return rank(root, key);
	}
	private int rank(Node x, Key key){
		if(x == null) return 0; //没找到排名为0
		int cmp = key.compareTo(x.key);
		if(cmp < 0) return rank(x.left, key);
		else if(cmp > 0) return 1 + size(x.left) + rank(x.right, key);//递归
		else return size(x.left);
	}
	public void deleteMin(){
		root = deleteMin(root);
	}
	private Node deleteMin(Node x){
		if(x.left == null) return x.right;
		x.left = deleteMin(x.left);
		x.N = size(x.left) + size(x.right) + 1; //所有的左边的N都会被改变
		return x;
	}
	public void delete(Key key){
		root = delete(root, key);
	}
	//最难的操作
	private Node delete(Node x, Key key){
		if(x == null) return null;
		int cmp = key.compareTo(x.key);
		if(cmp < 0) x.left = delete(x.left, key);
		if(cmp > 0) x.right = delete(x.right, key);
		else{
			if(x.right == null) return x.left;
			if(x.left == null) return x.right;
			Node t = x;
			x = min(t.right);
			x.right = deleteMin(t.right);
			x.left = t.left; //把删除的结点接上
		}
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}
	public Iterable<Key> keys(){
		return keys(min(), max());//从最小的key到最大的key
	}
	public Iterable<Key> keys(Key lo, Key hi){
		Queue<Key> queue = new Queue<Key>();
		keys(root, queue, lo, hi);
		return queue;
	}
	//简洁，但不简单
	private void keys(Node x, Queue<Key> queue, Key lo, Key hi){
		if(x == null) return;
		int cmplo = lo.compareTo(x.key);
		int cmphi = hi.compareTo(x.key);
		if(cmplo < 0) keys(x.left, queue, lo, hi);
		if(cmplo <= 0 && cmphi >= 0) queue.enqueue(x.key);//永远只进左边的
		if(cmphi > 0) keys(x.right, queue, lo, hi);
	}
	//max() min() floor() ceiling()
	//select() rank()
	//delete deleteMin() deleteMax()
	//keys()
}
