package org.chapter1;

//加权quick-union
public class WeightedQuickUnionUF {
	private int[] id;
	private int[] sz;	//(由触点索引的)各个根节点所对应的分量的大小
	private int count;
	public WeightedQuickUnionUF(int N){
		count = N;
		id = new int[N];
		for(int i=0;i<N;i++){
			id[i] = i;
		}
		sz = new int[N];
		for(int i=0;i<N;i++){
			sz[i] = 1;
		}
	}
	public int count(){
		return count;
	}
	public boolean connect(int p, int q){
		return find(p) == find(q);
	}
	public int find(int p){
		while(p != id[p]){
			p = id[p];
		}
		return p;
	}
	public void union(int p, int q){
		int i = find(p);
		int j = find(q);
		if(i == j) return;
		if(sz[i] < sz[j]){
			id[i] = j; //关键所在
			sz[j] += sz[i];//关键所在
		}else{
			id[j] = i;
			sz[i] += sz[j];
		}
		count++;
	}
}
