

## android ������GestureDetector


### GestureDetector �Ĵ���ʹ��




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
                //��ע������Ҫ����true��ע����Ϊ�¼����ѵ�ԭ����������Զ���ؼ�ΪLinearLayoutĬ��û�������¼���(���ص�false)����ôonScroll�¼��Ͳ���ִ�е�ΪButton��ʱ��Ҫִ�У�
                //�����Է���true��������������down�¼����Ժ���¼�onMove onUp�����������ﴦ��
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

�õ���������������һ��  
��Щ�¼�

#### onDown(MotionEvent motionEvent)------ ��������Ļ��ʱ�� ������  
-  �����ص����� onDown(ACTION_DOWN) 

ע��:
-  onDown����ֻ����յ�ACTION_DOWN���¼�



#### onShowPress(MotionEvent motionEvent)------ ����ͣ����� ������    
-  �����ص����� onDown(ACTION_DOWN)----onShowPress(ACTION_DOWN)

ע��:
-  onShowPress����ֻ����յ�ACTION_DOWN���¼�



#### onSingleTapUp(MotionEvent motionEvent)-----���ٵ��һ�²������� ������  
�����ص����� �����ֿ��� 
1.  onDown(ACTION_DOWN)---onSingleTapUp(ACTION_UP)
2.  onDown(ACTION_DOWN)----onShowPress(ACTION_DOWN) ---onSingleTapUp(ACTION_UP)

ע��:
-   onSingleTapUp����ֻ����յ�ACTION_UP���¼�



#### onLongPress(MotionEvent motionEvent)-----��ʱ�䰴�²������� ����    
�����ص�����   
-  onDown(ACTION_DOWN)----onShowPress(ACTION_DOWN)---onLongPress(ACTION_DOWN)

ע��:
-  onLongPress����ֻ����յ�ACTION_DOWN���¼�


####  onScroll��MotionEvent motionEvent,MotionEvent motionEvent1��----���²����� ����      
�����ص����������п���  
1. onDown(ACTION_DOWN)--onScroll(ACTION_DOWN,ACTION_MOVE)---onScroll(ACTION_DOWN,ACTION_MOVE)---onFling(ACTION_UP)
2. onDown(ACTION_DOWN)--onScroll(ACTION_DOWN,ACTION_MOVE)---onScroll(ACTION_DOWN,ACTION_MOVE)

ע��:
- onScroll������һ������motionEvent���յ�������ACTION_DOWN���¼������Ҳ���仯������onDown���¼���һ����
- onScroll�����ڶ�������motionEvent������ACTION_MOVE���¼���ֻ����ACTION_MOVE
- ��ע������˵onFlingһ���ᱻִ���Ǵ���ģ����������ұ߻����ٻ��������Ͳ��ᴥ��onFling)

####  onFling��MotionEvent motionEvent,MotionEvent motionEvent1�� 
- �뿴onScroll����