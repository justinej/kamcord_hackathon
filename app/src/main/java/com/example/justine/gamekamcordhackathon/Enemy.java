package com.example.justine.gamekamcordhackathon;

/**
 * Created by jimmy on 6/24/15.
 */
public class Enemy {
    private int x, y, speed, health;

    public Enemy(int x, int y) {
        this(x, y, 1, 100);
    }

    public Enemy(int x, int y, int speed, int health) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.health = health;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
}
