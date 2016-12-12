package test.testcustomview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by jikun on 2016/12/9.
 */

public class TestCustomInvalidateView extends Button {

    public static final String TAG = TestCustomInvalidateView.class.getSimpleName() + "---";

    public TestCustomInvalidateView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Log.e(TAG, TAG + "TestCustomView");
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                invalidate();
            }
        });
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.e(TAG, TAG + "onMeasure");
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.e(TAG, TAG + "onLayout");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.e(TAG, TAG + "onDraw");
    }
}
