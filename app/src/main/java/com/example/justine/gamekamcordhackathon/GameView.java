package com.example.justine.gamekamcordhackathon;

/**
 * Created by jimmy on 6/24/15.
 */
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by jimmy on 6/24/15.
 */
public class GameView extends View {
    private Path path;

    public GameView(Context context) {
        this(context, null);
    }

    public GameView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        path = new Path();
        //path.moveTo()
    }

    public void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(0, 0, getWidth(), getHeight(), paint);
        paint.setARGB(255, 244, 164, 96);
        //paint.setColor(Color.RED);
        //canvas.drawOval(100, 100, 400, 400, paint);
        canvas.drawRect(0, getHeight()/10*4, getWidth(), getHeight()/10*6, paint);

    }
}
