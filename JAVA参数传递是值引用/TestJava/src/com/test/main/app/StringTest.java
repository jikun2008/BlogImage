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
		x="1234";//String ���͵ĸ�ֵ����  x="1234" �Ǽ�д��  ��ʵ����������д�� x=new String("1234");
		
	}

}
