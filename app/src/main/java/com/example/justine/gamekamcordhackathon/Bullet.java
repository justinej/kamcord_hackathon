package com.example.justine.gamekamcordhackathon;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;

/**
 * Created by alexxiao on 6/24/15.
 */
public class Bullet {

    public Drawable d;
    public int x,y,width,height, speed;

    public Bullet(int x, int y, int width, int height, int speed) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
    }

    public void moveTo(int x, int y, int speed) {
        int xDist = x - this.x;
        int yDist = y - this.y;
        double pythagorean =  Math.sqrt(xDist * xDist + yDist * yDist);
        this.x += (int) (xDist / pythagorean * speed);
        this.y += (int) (yDist / pythagorean * speed);
    }

    public boolean didCollide(Enemy enemy) {
        double x = enemy.getX();
        double y = enemy.getY();

        if (-25 < x - this.x && x - this.x < 525
                && -125 < y - this.y && y - this.y < 25) {
            return true;
        }
        return false;
    }

    public void drawOnCanvas(Canvas canvas) {
        d.setBounds(x, y, x + width, y + height);
        d.draw(canvas);
    }
}
