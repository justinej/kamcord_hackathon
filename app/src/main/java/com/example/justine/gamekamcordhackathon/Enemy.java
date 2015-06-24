package com.example.justine.gamekamcordhackathon;

import android.animation.ObjectAnimator;
import android.graphics.Path;

/**
 * Created by jimmy on 6/24/15.
 */
public class Enemy {
    private float x, y, speed, health;
    private ObjectAnimator objectAnimator;

    public Enemy(int x, int y, Path path) {
        this(x, y, path, 1, 100);
    }

    public Enemy(int x, int y, Path path, int speed, int health) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.health = health;
        objectAnimator = ObjectAnimator.ofFloat(this, "x", "y", path);
        objectAnimator.setDuration(20000).start();
    }

    public void diePls() {
        this.health -= 10;
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
}
