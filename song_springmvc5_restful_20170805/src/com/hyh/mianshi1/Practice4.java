package com.hyh.mianshi1;

public class Practice4 {

	static int x, y; // x=0, y=0

	public static void main(String[] args) {
		x--; // x--=0, x=-1
		System.out.println("x = " + x + ", y = " + y);

		method();
		System.out.println("x = " + x + ", y = " + y);

		System.out.println(x + y + ++x); //1+0+2

//		 int a = 1;
//		 System.out.println( "--a = " + --a + ", a = " + a );
//		 System.out.println( "a-- = " + a-- + ", a = " + a );
		// System.out.println( "++a = " + ++a );
		// System.out.println( "a++ = " + a++ );
	}

	public static void method() {
		System.out.println("in method : x = " + x + ", y = " + y);
		y = x++ + ++x; //x=-1, x++=-1, x=0, ++x=1, x=1, y=0 
		System.out.println("out method : x = " + x + ", y = " + y);
	}

}
