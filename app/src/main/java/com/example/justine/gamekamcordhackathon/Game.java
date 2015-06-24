package com.example.justine.gamekamcordhackathon;

import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.view.View;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;


public class Game extends Activity {
    private ArrayList<Bullet> hichews = new ArrayList<Bullet>();
    private LinkedList<Enemy> enemies = new LinkedList<>();
    private GameView gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        ((GameView)findViewById(R.id.GameView)).setEnemies(enemies);
        ((GameView)findViewById(R.id.GameView)).hichews = hichews;
        // Can you pass enemies to the game view ^ ?
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new Task(), 0, 100);
    }

    class Task extends TimerTask {
        public void run() {
            moveBullets();
            findViewById(R.id.GameView).postInvalidate();
        }
    }

    public void moveBullets() {
        ArrayList<Bullet> bulletsToRemove = new ArrayList<Bullet>();

        for (Bullet bullet : hichews) {
            if(enemies.isEmpty()) {
                for (Bullet extraBullet : bulletsToRemove) {
                    bulletsToRemove.add(extraBullet);
                } break;
            }
            Enemy enemy = enemies.getLast();
            bullet.moveTo((int) enemy.getX(), (int) enemy.getY(), bullet.speed);

            if (bullet.didCollide(enemy)) {
                bulletsToRemove.add(bullet);
                enemies.remove(enemy);
            }
        }

        for (Bullet  bullet : bulletsToRemove) {
            hichews.remove(bullet);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void executeSteven(View v) {
        Toast.makeText(this, "Steven: sarah gimme hichews pls", Toast.LENGTH_LONG).show();
        if (enemies.size() > 0) {
            spawnHiChew((int) v.getX(), (int) v.getY());
        }
    }

    public void executeAlex(View v) {
        Toast.makeText(this, "Alex: what the jank", Toast.LENGTH_LONG).show();
        if (enemies.size() > 0) {
            spawnChipotle((int) v.getX(), (int) v.getY());
        }
    }

    public void executeJimmy(View v) {
        Toast.makeText(this, "Jimmy: hmmmmm", Toast.LENGTH_LONG).show();
        if (enemies.size() > 0) {
            spawnMandM((int) v.getX(), (int) v.getY());
        }
    }

    public void executeJustine(View v) {
        Toast.makeText(this, "Justine: wow, nice, topkek m8", Toast.LENGTH_LONG).show();
        if (enemies.size() > 0) {
            spawnBattleCats((int) v.getX(), (int) v.getY());
        }
    }

    public void spawnChipotle(int x, int y) {
        Bullet bullet = new Bullet(x, y, 300, 170, 50);
        bullet.d =  ResourcesCompat.getDrawable(getResources(), R.drawable.chipotle, null);
        hichews.add(bullet);
    }

    public void spawnMandM(int x, int y) {
        Bullet bullet = new Bullet(x, y, 120, 120, 50);
        bullet.d =  ResourcesCompat.getDrawable(getResources(), R.drawable.mandm, null);
        hichews.add(bullet);
    }

    public void spawnBattleCats(int x, int y) {
        Bullet bullet = new Bullet(x, y, 200, 170, 50);
        bullet.d =  ResourcesCompat.getDrawable(getResources(), R.drawable.battlecats, null);
        hichews.add(bullet);
    }

    public void spawnHiChew(int x, int y) {
        Bullet bullet = new Bullet(x, y, 500, 100, 50);
        bullet.d =  ResourcesCompat.getDrawable(getResources(), R.drawable.hichew, null);
        hichews.add(bullet);
    }
}
