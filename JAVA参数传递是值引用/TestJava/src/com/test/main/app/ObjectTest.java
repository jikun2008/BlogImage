package com.test.main.app;

public class ObjectTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Info info=new Info();
		System.out.println("before info.x="+info.x);
		changeData(info);
		System.out.println("after info.x="+info.x);

	}
	
	
	public static class Info{
		
		public int x=5;
		
	}
	
	public static void changeData(Info info){
		info.x=10;
	}
	

}
