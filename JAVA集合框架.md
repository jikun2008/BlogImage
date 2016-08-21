# Java 集合框架的学习#
![JAVA icon](https://github.com/jikun2008/BlogImage/blob/master/JAVA%E9%9B%86%E5%90%88%E6%A1%86%E6%9E%B6.png?raw=true)

上图标红的是需要我们掌握的并理解的实现类

### List ###

1.  Vector
 * 是利用数据结构的中顺序表的原理来实现的。
 * 是线程安全的（是同步的）
 * 用法和ArrayList是一样的。

2. ArrayList
 * 是利用数据结构的中顺序表的原理来实现的。
 * 它不是线程安全的 （不是同步的）
 * 允许元素为null，
 * 通过get(i)方法查询数据的运算时间是常量O(1)
 *  add remove 方法（）的算法时间就是O(n)。

3. LinkedList
	* 是利用数据结构中的双向链表的原来来实现的。
	* 它不是线程安全的（不是同步的）允许元素为null
	* 通过get(i)方法查询数据的运算时间是O(n)
	* add remove 方法（）的算法时间是常数级O(1)的）
	* LinkedList可以当做队列和栈来使用   
	* 栈使用的时候请注意 push("str")和pop()方法 后进先出。
	* 队列使用的时候   可以使用 addLast("str")  poll()方法
	* (poll是队列数据结构实现类的方法，从队首获取元素，同时获取的这个元素将从原队列删除；
	* pop是栈结构的实现类的方法，表示返回栈顶的元素，同时该元素从栈中删除，当栈中没有元素时，调用该方法会发生异常)

4. Stack  栈，
 * 遵循后进先出的原理  
 * push pop等方法

```JAVA



private static  void testLinedList(){
	LinkedList<String> linkedList=new LinkedList<>();
	linkedList.add("1");
	linkedList.add("2");
	linkedList.add("3");
	linkedList.add("4");
	linkedList.add("5");
	System.out.println("peekLast:"+linkedList.peekLast());
	//请注意LinedList的peek方法不会移除元素，
	System.out.println("peekFirst:"+linkedList.peekFirst());
	System.out.println("peek:"+linkedList.peek());
	System.out.println(linkedList);
	//注意pop 和poll方法都会移除元素	   

}
```
### SET###
不允许有相同的元素,(根据equals来判断元素是否相同)
1. HashSet
  * 不允许有相同的元素
  * 不能保证元素的排列顺序，顺序有可能变化
  * 不是线程安全的（不是同步的）
  * 请注意的实现它的hashCode()方法和equals()方法

2. LinkedHashSet
  * 不允许有相同的元素
  * 能保证元素的排列顺序，
  * 不是线程安全的（不是同步的）
  * 请注意的实现它的hashCode()方法和equals()方法

3. TreeSet
   * 可以确保元素处于排序状态
   * TreeSet支持两种排序方式，自然排序 和定制排序，其中自然排序为默认的排序方式
   * 你也可以实现Comparator方法来自定义排序
   * bj1.compareTo(obj2)方法如果返回0，则说明被比较的两个对象相等，如果返回一个正数，则表明obj1大于obj2，如果是 负数，则表明obj1小于obj2

```JAVA


Set<String> hashSet=new HashSet<>();
hashSet.add("1sfsfs");
hashSet.add("2fsfsd");
hashSet.add("3fsfs");
hashSet.add("413123");


for(String t:hashSet){
	System.out.println(t);//输出是随机顺序的。
}

LinkedHashSet<String> linkedHashSet=new LinkedHashSet<>();

linkedHashSet.add("1sfsfs");
linkedHashSet.add("2fsfsd");
linkedHashSet.add("3fsfs");
linkedHashSet.add("413123");
System.out.println("-----------------");
System.out.println("-----------------");
System.out.println("-----------------");
for(String t:linkedHashSet){
	System.out.println(t);//输出是按照插入的顺序的
}
```

### MAP ###
采用键值队的形式来保存数据 key不能重复 value可以重复

1. HashMap

  * 不能保证元素的排列顺序
  * 允许key和value 为null
  * 不是线程安全的（不是同步的）

2. HashTable

   * 不允许key和value为null
	 * 不能保证元素的排列顺序
	 * 是线程安全的（是同步的）

3. LinkedHashMap
   * 和HashMap一样
	 * 能保证元素的排列顺序

4. TreeMap
   * 不允许key和value为null
   * 能保证元素的排列顺序
   * 默认是按升序排序
   * 当用Iteraor遍历TreeMap时，得到的记录是排过序的。

```JAVA


private static void tableTest(){
	Map<String, String> hashTable=new Hashtable<>();
	hashTable.put("ssss", "ssss");
	hashTable.put("ssss1", "ssss1");
	hashTable.put("ssss2", "ssss2");
	hashTable.put("ssss133", "ssss133");
	hashTable.put("ssss3", "ssss3");
	hashTable.put("ssss4", "ssss4");
	Set<String> keys=hashTable.keySet();
	for(String key:keys){
		System.out.println(hashTable.get(key));
		//输出顺序是随机的
	}
}
```

```JAVA

private static void  mapTest(){
	Map<String, String> hashMap=new HashMap<>();
	hashMap.put("ssss", "ssss");
	hashMap.put("ssss1", "ssss1");
	hashMap.put("ssss2", "ssss2");
	hashMap.put("ssss3", "ssss3");
	hashMap.put("ssss4", "ssss4");

	Set<String> keys=hashMap.keySet();
	for(String key:keys){
		System.out.println(hashMap.get(key));
		//输出顺序是随机的
	}


	Collection<String> collection = hashMap.values();//返回值是个值的Collection集合
	System.out.println(collection);

	Set<Map.Entry<String, String>> test=hashMap.entrySet();
	for(Map.Entry<String, String> map:test){
		System.out.println("key:"+map.getKey()+"-----values"+map.getValue());
	}
}



```
