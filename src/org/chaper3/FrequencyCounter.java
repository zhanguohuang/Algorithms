package org.chaper3;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

//找出所有单词中最后一的一个
public class FrequencyCounter {
	public static void main(String[] args) {
		int minlen = Integer.parseInt(args[0]);
		ST<String, Integer> st = new ST<String, Integer>();
		while(!StdIn.isEmpty()){
			String word = StdIn.readString();
			if(word.length() < minlen) continue;//此单词背忽略
			if(!st.contains(word)) st.put(word, 1);
			else st.put(word, st.get(word) + 1);
		}
		String max = " ";
		st.put(max, 0); //关键所在
		for(String word : st.keys()){
			if(st.get(word) > st.get(max)) max = word;
		}
		StdOut.println(max + " " + st.get(max));
	}
}
