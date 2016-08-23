## JAVA只有值传递  ##

首先论述一个观点 JAVA只有值传递

JAVA中值传递还是引用传递这个问题面试经常遇到,做个总结

例如：首先我们来看8种基本数据类型 boolean byte char  short  int  long float double

```JAVA

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
}
/**
*上面代码的输出结果如下：
*isfalse---before=true
*by---before=+-50
*isfalse---after=true
*by---after=+-50
**/

```
其他基本数据类型都是这样的输出结果。当调用changeData方法后，值是没有变化的。

但是在Obect(对象中)就不是这样了我们在来看一个例子
```JAVA
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
/**
*输出结果如下
*
*before info.x=5
*after info.x=10
*
*
*
*
**/
```
这里可以看到info对象中x值被改变了。所以对于对象中改变这个值是有用的
但是这里要注意的是String这个类。例如
```JAVA
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

输出如下：
before String x=kkkk
before String x=kkkk
这里跟上面的对象输出不一样。
```

是因为 String 类型的赋值操作  x="1234" 是简化写法  其实它是这样的写法 x=new String("1234");


### 总结 ###

java中的8种基本数据类型 boolean byte char  short  int  long float double 和 String类的时候当你调用changeData(int x){x=1} 类似这种方法的时候 前后输出的值是一样的。
但是对于我们建立类的对象 调用这个方法的时候是会改变的值 前后输出的值是不一样的。
