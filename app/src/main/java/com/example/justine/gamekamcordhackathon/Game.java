package com.example.justine.gamekamcordhackathon;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.view.View;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class Game extends Activity {
    private ArrayList<Enemy> enemies = new ArrayList<>();
    private GameView gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        // Can you pass enemies to the game view ^ ?
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new Task(), 0, 100);
    }

    class Task extends TimerTask {
        public void run() {

            findViewById(R.id.GameView).postInvalidate();
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

    public void executeAlex(View v) {
        Toast.makeText(this, "HELLO WORLD", Toast.LENGTH_LONG).show();
    }
}
