package com.hyh.mianshi1;

public class Practice2 {

	static {
		System.out.println( "Hi there......." );
	}
	
	public void print() {
		System.out.println( "Hello......" );
	}
	
	public static void main(String[] args) {
		Practice2 practice2 = new Practice2();
		practice2.print();
		Practice2 practice22 = new Practice2();
		practice22.print();
	}
	
}
