package org.chaper3;

public class RedBlackBST<Key extends Comparable<Key>, Value> {
	private Node root;
	
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	
	private class Node{
		Key key;
		Value val;
		Node left,right;
		int N;
		boolean color;
		Node(Key key, Value val, int N, boolean color){
			this.key = key;
			this.val = val;
			this.N = N;
			this.color = color;
		}
	}
	
	public void put(Key key, Value val){
		root = put(root, key, val);
		root.color = BLACK;
	}

	//红黑树的插入操作
	private Node put(Node h, Key key, Value val){
		if(h == null){
			return new Node(key, val, 1, RED);
		}
		int cmp = key.compareTo(h.key);
		if(cmp < 0) h.left = put(h.left, key, val);
		if(cmp > 0) h.right = put(h.right, key, val);
		else h.val = val;
		if(isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
		if(isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
		if(isRed(h.left) && isRed(h.right)) flipColors(h);
		h.N = size(h.left) + size(h.right) + 1;
		return h;
	}
	
	private boolean isRed(Node x){
		if(x == null) return false;
		return x.color == RED;
	}
	
	Node rotateLeft(Node h){ //红转到左边
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = h.color;
		h.color = RED;
		x.N = h.N;
		h.N = 1 + size(h.left) + size(h.right);
		return x;
	}
	
	Node rotateRight(Node h){ //红转到右边
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		h.color = RED;
		x.N = h.N;
		h.N = 1 + size(h.left) + size(h.right);
		return x;
	}
	
	void flipColors(Node h) { //转换树的颜色，根变成红色
		h.color = RED;
		h.left.color = BLACK;
		h.right.color = BLACK;
	}
	
	private int size(){
		return size(root);
	}
	private int size(Node x){
		return x.N;
	}
}
