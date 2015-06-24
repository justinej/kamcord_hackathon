package com.example.justine.gamekamcordhackathon;

/**
 * Created by jimmy on 6/24/15.
 */

import android.animation.ObjectAnimator;
import android.content.Context;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by jimmy on 6/24/15.
 */
public class GameView extends View {
    private Path path = null;
    public ArrayList<Bullet> hichews;
    private LinkedList<Enemy> enemies;
    //private Circle cir;
    //private ObjectAnimator objectAnimator;
    private Bitmap tim = BitmapFactory.decodeResource(getResources(), R.drawable.tim);

    public GameView(Context context) {
        this(context, null);
    }

    public GameView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setEnemies(LinkedList<Enemy> enemies) {
        this.enemies = enemies;
    }

    public void init() {
        path = getPath(new Point[]{new Point(-20, getHeight() / 6),
                new Point(getWidth() / 6 * 5, getHeight() / 6 * 1),
                new Point(getWidth() / 6 * 5, getHeight() / 6 * 2),
                new Point(getWidth() / 6 * 1, getHeight() / 6 * 2),
                new Point(getWidth() / 6 * 1, getHeight() / 6 * 3),
                new Point(getWidth() / 6 * 5, getHeight() / 6 * 3),
                new Point(getWidth() / 6 * 5, getHeight() / 6 * 4),
                new Point(getWidth() / 6 * 1, getHeight() / 6 * 4),
                new Point(getWidth() / 6 * 1, getHeight() / 6 * 5),
                new Point(getWidth() / 6 * 5, getHeight() / 6 * 5),
                new Point(getWidth() / 6 * 5, getHeight() / 6 * 6 + 50)});
        //cir = new Circle(0, 0);
        //objectAnimator = ObjectAnimator.ofFloat(cir, "x", "y", path);
        //objectAnimator.setDuration(20000).start();
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
        if(path==null) init();
        canvas.drawPath(path, paint);

        if(enemies.size()==0 || enemies.getFirst().getX() > getWidth()/18) {
            enemies.addFirst(new Enemy(0, 0, path, tim));
        }
        if(enemies.size() > 0 && enemies.getLast().getY() > getHeight() + 30) {
            enemies.removeLast();
        }

        for(Enemy enemy: enemies) {
            Bitmap im = enemy.getImage();
            canvas.drawBitmap(im, enemy.getX()-im.getWidth()/2, enemy.getY()-im.getHeight()/2, null);
        }

        Paint paint2 = new Paint();
        paint2.setColor(Color.GREEN);
        paint2.setStyle(Paint.Style.FILL);
        //canvas.drawOval(cir.x - 20, cir.y - 20, cir.x + 20, cir.y + 20, paint2);
        //canvas.drawBitmap(bitmap, cir.x-bitmap.getWidth()/2, cir.y-bitmap.getHeight()/2, null);

        for (Bullet d : hichews) {
            d.drawOnCanvas(canvas);
        }
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

    //TODO delete
    class Circle {
        float x, y;
        public Circle(int x, int y) {
            this.x=x;
            this.y=y;
        }

        public float getX() {
            return x;
        }

        public float getY() {
            return y;
        }

        public void setX(float x) {
            this.x = x;
        }

        public void setY(float y) {
            this.y = y;
        }
    }
}
