package com.test.main.app;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean isfalse=true;
        byte by=-50;
        System.out.println("isfalse---before="+isfalse);
        System.out.println("by---before=+"+by);
        changeData(isfalse, by);
        
        System.out.println("isfalse---after="+isfalse);
        System.out.println("by---after=+"+by);
        
        //其他的不演示了 效果都是一样，输出的结果不会改变
		
	}
	
/**
 * boolean 取值范围 true false
 * byte:   取值范围 -128~127
 * short:  取值范围 -2^15~2^15-1
 * char:   取值范围  0~65536
 * int:    取值范围 -2^31~2^31-1
 * long:   取值范围 -2^64~2^64-1.
 * float   取值范围 -3.4E38 ~ 3.4E38
 * double  取值范围 -1.7E308~ 1.7E308
 */
    public static void changeData(boolean bl,byte by){
        bl=false;
        by= 100;
      }
    public static void chageData(char nchar,short mshort){
    	nchar='1';
    	mshort=5555;
    	
    }

}
