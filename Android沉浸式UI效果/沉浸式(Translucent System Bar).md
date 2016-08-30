## Android沉浸式Translucent System Bar ##


Android沉浸式APP主要是用在Android 4.4以上才会有效果。
也就是api-19+

什么是沉浸式。
如下图：

![JAVA icon](https://github.com/jikun2008/BlogImage/blob/master/Android%E6%B2%89%E6%B5%B8%E5%BC%8FUI%E6%95%88%E6%9E%9C/Android%E6%B2%89%E6%B5%B8%E5%BC%8FUI%E6%95%88%E6%9E%9C.jpg?raw=true)


可以看到第一幅图上面的状态栏和底下的虚拟按键都变成蓝色，比第二张图效果好一些。所以这个就是沉浸式效果

沉浸式效果只能支持Android api 19以上也就是 Android 4.4以上。但是低版本的适配怎么办。

请注意我们可以建立 3个文件夹分别为value  value-v19  value-v21 来进行适配

* value  代表适配Android4.4以前的,styles.xml内容如下：


```JAVA
<resources>

    <!-- Base application theme. -->
    <style name="AppTheme" parent="Theme.AppCompat.Light.NoActionBar">
        <!--Theme.AppCompat.Light.DarkActionBar-->
        <!-- Customize your theme here. -->
        <item name="colorPrimary">@color/colorPrimary</item>
        <item name="colorPrimaryDark">@color/colorPrimaryDark</item>
        <item name="colorAccent">@color/colorAccent</item>
    </style>
</resources>

```

* value-v19 适配api-19 Android4.4以上。

```JAVA

<resources>

    <!-- Base application theme. -->
    <style name="AppTheme" parent="Theme.AppCompat.Light.NoActionBar">
        <!--Theme.AppCompat.Light.DarkActionBar-->
        <!-- Customize your theme here. -->
        <item name="colorPrimary">@color/colorPrimary</item>
        <item name="colorPrimaryDark">@color/colorPrimaryDark</item>
        <item name="colorAccent">@color/colorAccent</item>

        <item name="android:windowTranslucentStatus">false</item>
        <item name="android:windowTranslucentNavigation">false</item>
    </style>
</resources>
```

* value-v21 适配Android5.0以上。
