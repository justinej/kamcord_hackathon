package com.example.justine.gamekamcordhackathon;

import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.Path;

/**
 * Created by jimmy on 6/24/15.
 */
public class Enemy {
    private float x, y, speed, health;
    private Bitmap image;
    private ObjectAnimator objectAnimator;

    public Enemy(int x, int y, Path path, Bitmap image) {
        this(x, y, path, 20000, 100, image);
    }

    public Enemy(int x, int y, Path path, int speed, int health, Bitmap image) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.health = health;
        this.image = image;
        objectAnimator = ObjectAnimator.ofFloat(this, "x", "y", path);
        objectAnimator.setDuration(speed).start();
    }

    public void diePls() {
        this.health -= 30;
    }

    public boolean didDie() {
        return this.health <= 0;
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
    public Bitmap getImage() {
        return image;
    }
}
