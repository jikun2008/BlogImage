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
        
        //�����Ĳ���ʾ�� Ч������һ��������Ľ������ı�
		
	}
	
/**
 * boolean ȡֵ��Χ true false
 * byte:   ȡֵ��Χ -128~127
 * short:  ȡֵ��Χ -2^15~2^15-1
 * char:   ȡֵ��Χ  0~65536
 * int:    ȡֵ��Χ -2^31~2^31-1
 * long:   ȡֵ��Χ -2^64~2^64-1.
 * float   ȡֵ��Χ -3.4E38 ~ 3.4E38
 * double  ȡֵ��Χ -1.7E308~ 1.7E308
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
