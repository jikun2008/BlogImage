package com.test.main.app;

public class StringTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String x="kkkk";
		System.out.println("before String x="+x);
		changeData(x);
		System.out.println("before String x="+x);

	}
	
	public static void changeData(String x){
		x="1234";//String 类型的赋值操作  x="1234" 是简化写法  其实它是这样的写法 x=new String("1234");
		
	}

}
