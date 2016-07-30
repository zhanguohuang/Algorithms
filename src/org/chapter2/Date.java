package org.chapter2;

//日期
public class Date {
	private final int day;
	private final int month;
	private final int year;
	
	public Date(int d, int m, int y){
		this.day = d;
		this.month = m;
		this.year = y;
	}
	public int day(){
		return this.day;
	}
	public int month(){
		return this.month;
	}
	public int year(){
		return this.year;
	}
	//标准的CompareTo方法的书写方式
	public int compareTo(Date that){
		if(this.year > that.year) return +1;
		if(this.year < that.year) return -1;
		if(this.month > that.month) return +1;
		if(this.month < that.month) return -1;
		if(this.day > that.day) return +1;
		if(this.day < that.day) return -1;
		return 0;
	}
}
