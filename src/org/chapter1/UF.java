package org.chapter1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

//union-find�㷨
public class UF {
	private int[] id;
	private int count;
	public UF(int N){
		count = N;
		id = new int[N];
		for(int i=0;i<N;i++){
			id[i] = i;
		}
	}
	public int count(){
		return count;
	}
	public boolean connected(int p, int q){
		return find(p) == find(q);
	}
	//mid-find
	public int find(int p){//���ص�p���ڵķ���id
		while(p != id[p]){//ֻ�������Լ��ķ�������������id[]
			p = id[p];//��������
		}
		return p;//���ǵ��������һ��������
	}
	//quick-union
	public void union(int p, int q){
		int pRoot = find(p);
		int qRoot = find(q);
		if(pRoot == qRoot)return ;
		id[pRoot] = qRoot; //��������
		count--;
	}
	public static void main(String[] args) {
		int N = StdIn.readInt();
		UF uf = new UF(N);
		while(!StdIn.isEmpty()){
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if(uf.connected(p, q)){
				continue;
			}
			uf.union(p, q);
			StdOut.println(p + " " + q);
		}
		StdOut.println(uf.count() + "components");
	}
	
}


////quick-find
//	public int find(int p){//���ص�p���ڵķ���id
//		return id[p];
//	}
//	//slow-union
//	public void union(int p, int q){
//		int pID = find(p);
//		int qID = find(q);
//		if(pID == qID)return; //����Ѿ�һֱ������������
//		for(int i=0;i<id.length;i++){
//			if(id[i] == pID) id[i] = qID;//������id��£
//		}	
//		count--;
//	}