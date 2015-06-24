package com.example.justine.gamekamcordhackathon;

/**
 * Created by jimmy on 6/24/15.
 */

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by jimmy on 6/24/15.
 */
public class GameView extends View {
    private Path path = null;
    private ArrayList<Enemy> enemies;

    public GameView(Context context) {
        this(context, null);
    }

    public GameView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setEnemies(ArrayList<Enemy> enemies) {
        this.enemies = enemies;
    }

    public void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(0, 0, getWidth(), getHeight(), paint);
        paint.setARGB(255, 244, 164, 96);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeWidth(getHeight() / 20);
        paint.setAntiAlias(true);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        if(path==null) path = getPath(new Point[]{new Point(0, getHeight() / 6),
                new Point(getWidth() / 6 * 5, getHeight() / 6 * 1),
                new Point(getWidth() / 6 * 5, getHeight() / 6 * 2),
                new Point(getWidth() / 6 * 1, getHeight() / 6 * 2),
                new Point(getWidth() / 6 * 1, getHeight() / 6 * 3),
                new Point(getWidth() / 6 * 5, getHeight() / 6 * 3),
                new Point(getWidth() / 6 * 5, getHeight() / 6 * 4),
                new Point(getWidth() / 6 * 1, getHeight() / 6 * 4),
                new Point(getWidth() / 6 * 1, getHeight() / 6 * 5),
                new Point(getWidth() / 6 * 5, getHeight() / 6 * 5),
                new Point(getWidth() / 6 * 5, getHeight() / 6 * 6)});
        canvas.drawPath(path, paint);
    }

    public static Path getPath(Point[] points) {
        Path path = new Path();
        path.moveTo(points[0].x, points[0].y);
        for (int i = 1; i < points.length; i++) {
            path.lineTo(points[i].x, points[i].y);
            path.moveTo(points[i].x, points[i].y);
        }
        path.close();
        return path;
    }
}
