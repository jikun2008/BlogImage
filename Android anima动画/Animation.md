
## Android动画 View Animation 动画效果


Android 动画分为补间动画，View动画，属性动画。

View Animation的效果由四个因素决定  
* 初始位置
* 结束位置
* 持续时间   （如果我们不设置 那么默认是30ms）
* Interpolator


View动画中有AlphaAnimation，RotateAnimation，ScaleAnimation，TranslateAnimation 透明度，旋转，大小，位移

使用View动画  可以采用XML方式和纯JAVA代码方式。

XML方式

请注意XML文件请放在res目录下的anim文件夹下

   注意：  with the exception of repeatCount and fillEnabled
   注意：     android:fillEnabled="true"   
             android:repeatCount="infinite"   在AnimationSet设置是不管用。（要在Animation设置才管用）

android:pivotX和android:pivotY,我们知道
pivot的意思是轴心的意思，所以这两个属性定义的是此次动画变化的轴心位置，默认是左上角，当我们把它们两者都赋值为50%，则变化轴心在中心。


```XML
<?xml version="1.0" encoding="utf-8"?>
<set xmlns:android="http://schemas.android.com/apk/res/android"
   android:duration="1000"
   android:zAdjustment="bottom">
  <alpha
      android:fromAlpha="1.0"//从全不透明变为全透明
      android:toAlpha="0.0"></alpha>
  <translate
      android:fromXDelta="0"
      android:toXDelta="500"></translate>
  <scale
      android:fromXScale="0"
      android:fromYScale="0"
      android:pivotX="50%"
      android:pivotY="50%"
      android:toXScale="2"
      android:toYScale="2"//横向放大2倍，纵向放大2倍
      ></scale>
  <rotate
      android:fromDegrees="0"
      android:pivotX="50%"
      android:pivotY="50%"//顺时针旋转90度
      android:toDegrees="90"
      ></rotate>
</set>

```
```JAVA
Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.view_anim);
bt_test.startAnimation(animation);

```
纯JAVA代码方式

```JAVA
private void testDaiMaiViewAnim(){

    RotateAnimation rotateAnimation=new RotateAnimation(0,90);//角度旋转动画 从0度到90度
    rotateAnimation.setDuration(2000);

    AlphaAnimation alphaAnimation=new AlphaAnimation(1,0.5f);//透明度动画 从全不透明到半透明
    alphaAnimation.setDuration(2000);
//
    TranslateAnimation translateAnimation=new TranslateAnimation(0,500,0,0);//位移动画
    translateAnimation.setDuration(2000);

    ScaleAnimation scaleAnimation=new ScaleAnimation(1,2,1,2);//放大倍数
    scaleAnimation.setDuration(2000);
    scaleAnimation.setRepeatCount(3);   //fillEnabled，repeatCount 在AnimationSet设置不管用 必须在Animation设置


    AnimationSet animationSet=new AnimationSet(false);
    scaleAnimation.setRepeatMode(Animation.REVERSE);
    animationSet.addAnimation(rotateAnimation);
    animationSet.addAnimation(alphaAnimation);
    animationSet.addAnimation(translateAnimation);
    animationSet.addAnimation(scaleAnimation);



    bt_test.startAnimation(animationSet);
}

```
