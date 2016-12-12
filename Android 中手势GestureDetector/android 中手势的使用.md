

## android 中手势GestureDetector


### GestureDetector 的代码使用




```java
public class TestGestureDetectorView extends LinearLayout {

    public static final String TAG = TestGestureDetectorView.class.getSimpleName() + "----";


    public static final int ACTION_DOWN = 0;

    public static final int ACTION_UP = 1;

    public static final int ACTION_MOVE = 2;

    public TestGestureDetectorView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    GestureDetector gestureDetector;


    public void init() {


        gestureDetector = new GestureDetector(getContext(), onGestureListener);

        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                gestureDetector.onTouchEvent(motionEvent);
                return true;
                //请注意这里要返回true（注：因为事件消费的原因如果你在自定义控件为LinearLayout默认没有消费事件的(返回的false)，那么onScroll事件就不能执行当为Button的时候要执行）
                //（所以返回true代表我们消费了down事件，以后的事件onMove onUp处理都会在这里处理）
            }
        });
    }

    GestureDetector.OnGestureListener onGestureListener = new GestureDetector.OnGestureListener() {
        @Override
        public boolean onDown(MotionEvent motionEvent) {
            Log.e(TAG, TAG + "onDown---" + "motionEvent=" + getAction(motionEvent));
            return true;
        }

        @Override
        public void onShowPress(MotionEvent motionEvent) {
            Log.e(TAG, TAG + "onShowPress---" + "motionEvent=" + getAction(motionEvent));
        }

        @Override
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            Log.e(TAG, TAG + "onSingleTapUp---" + "motionEvent=" + getAction(motionEvent));
            return false;
        }

        @Override
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
            Log.e(TAG, TAG + "onScroll---" + "motionEvent=" + getAction(motionEvent) + "---motionEvent1=" + getAction(motionEvent1));
            return false;
        }

        @Override
        public void onLongPress(MotionEvent motionEvent) {
            Log.e(TAG, TAG + "onLongPress---" + "motionEvent=" + getAction(motionEvent));
        }

        @Override
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
            Log.e(TAG, TAG + "onFling---" + "motionEvent=" + getAction(motionEvent) + "---motionEvent1=" + getAction(motionEvent1));
            return false;
        }
    };

    public String getAction(MotionEvent motionEvent) {
        String action = "noneAction";
        switch (motionEvent.getAction()) {

            case ACTION_DOWN:
                action = "ACTION_DOWN";
                break;
            case ACTION_MOVE:
                action = "ACTION_MOVE";
                break;
            case ACTION_UP:
                action = "ACTION_UP";
                break;
        }

        return action;

    }
}
```

好的我们现在来分析一下  
这些事件

#### onDown(MotionEvent motionEvent)------ 当按下屏幕的时候 触发，  
-  触发回调方法 onDown(ACTION_DOWN) 

注意:
-  onDown方法只会接收到ACTION_DOWN的事件



#### onShowPress(MotionEvent motionEvent)------ 短暂停留点击 触发，    
-  触发回调方法 onDown(ACTION_DOWN)----onShowPress(ACTION_DOWN)

注意:
-  onShowPress方法只会接收到ACTION_DOWN的事件



#### onSingleTapUp(MotionEvent motionEvent)-----快速点击一下并不滑动 触发，  
触发回调方法 有两种可能 
1.  onDown(ACTION_DOWN)---onSingleTapUp(ACTION_UP)
2.  onDown(ACTION_DOWN)----onShowPress(ACTION_DOWN) ---onSingleTapUp(ACTION_UP)

注意:
-   onSingleTapUp方法只会接收到ACTION_UP的事件



#### onLongPress(MotionEvent motionEvent)-----长时间按下并不滑动 触发    
触发回掉方法   
-  onDown(ACTION_DOWN)----onShowPress(ACTION_DOWN)---onLongPress(ACTION_DOWN)

注意:
-  onLongPress方法只会接收到ACTION_DOWN的事件


####  onScroll（MotionEvent motionEvent,MotionEvent motionEvent1）----按下并滑动 触发      
触发回掉方法有两中可能  
1. onDown(ACTION_DOWN)--onScroll(ACTION_DOWN,ACTION_MOVE)---onScroll(ACTION_DOWN,ACTION_MOVE)---onFling(ACTION_UP)
2. onDown(ACTION_DOWN)--onScroll(ACTION_DOWN,ACTION_MOVE)---onScroll(ACTION_DOWN,ACTION_MOVE)

注意:
- onScroll方法第一个参数motionEvent接收的是我们ACTION_DOWN的事件，并且不会变化，它和onDown的事件是一样的
- onScroll方法第二个参数motionEvent是我们ACTION_MOVE的事件，只接收ACTION_MOVE
- 请注意网上说onFling一定会被执行是错误的（请大家先向右边滑动再滑动回来就不会触发onFling)

####  onFling（MotionEvent motionEvent,MotionEvent motionEvent1） 
- 请看onScroll方法