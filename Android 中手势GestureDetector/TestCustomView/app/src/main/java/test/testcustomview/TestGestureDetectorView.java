package test.testcustomview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by jikun on 2016/12/12.
 */

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
                //请注意这里要返回true（注：因为事件消费的原因如果你在自定义控件为LinearLayout默认没有消费事件的，那么onScroll事件就不能执行当为Button的时候要执行）
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
