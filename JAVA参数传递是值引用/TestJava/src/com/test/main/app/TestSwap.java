package com.test.main.app;

public class TestSwap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 3;
		int y = 4;
		swap(x, y);

		System.out.println("x=" + x + ",y=" + y);

	}

	public static void swap(int x, int y) {
		int z = 0;
		z = y;
		y = x;
		x = z;
		System.out.println("x=" + x + ",y=" + y);

	}

}
