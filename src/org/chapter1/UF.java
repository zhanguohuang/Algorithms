package org.chapter1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

//union-find算法
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
	public int find(int p){//返回的p属于的分量id
		while(p != id[p]){//只遍历了自己的分量而不是所有id[]
			p = id[p];//精华所在
		}
		return p;//总是到达了最后一个根触点
	}
	//quick-union
	public void union(int p, int q){
		int pRoot = find(p);
		int qRoot = find(q);
		if(pRoot == qRoot)return ;
		id[pRoot] = qRoot; //精华所在
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
//	public int find(int p){//返回的p属于的分量id
//		return id[p];
//	}
//	//slow-union
//	public void union(int p, int q){
//		int pID = find(p);
//		int qID = find(q);
//		if(pID == qID)return; //如果已经一直则不续保保存了
//		for(int i=0;i<id.length;i++){
//			if(id[i] == pID) id[i] = qID;//向后面的id靠拢
//		}	
//		count--;
//	}