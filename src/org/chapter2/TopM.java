package org.chapter2;

import org.chapter1.Stack;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Transaction;

public class TopM {
	public static void main(String[] args) {
		int M = Integer.parseInt(args[0]);
		MinPQ<Transaction> pq = new MinPQ<Transaction>(M+1);
		while(StdIn.hasNextLine()){
			pq.insert(new Transaction(StdIn.readLine()));
			if(pq.size() > M){
				pq.delMin();//如果优先队列中存在M+1个元素则删除其中最小的元素
			}
		}
		Stack<Transaction> stack = new Stack<Transaction>();
		while(!pq.isEmpty()) stack.push(pq.delMin());
		for(Transaction t : stack) StdOut.println(t);
	}
}
