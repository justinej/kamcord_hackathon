package com.example.justine.gamekamcordhackathon;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.view.View;
import android.widget.Toast;


import java.util.ArrayList;


public class Game extends Activity {
    int stevenTextCounter = 0;
    private ArrayList<Enemy> enemies = new ArrayList<>();
    private GameView gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        // Can you pass enemies to the game view ^ ?
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
        String[] possibleTexts = {"topkek, m8", "motherf*ck", "tammie, gimme hichew", "why do I even come here", "にゃん"};
        Toast.makeText(this, possibleTexts[stevenTextCounter], Toast.LENGTH_LONG).show();
        stevenTextCounter = (stevenTextCounter +1) % possibleTexts.length;
    }
    public void executeAlex(View v) {
        String[] possibleTexts = {"k"};
        Toast.makeText(this, possibleTexts[stevenTextCounter], Toast.LENGTH_LONG).show();
        stevenTextCounter = (stevenTextCounter +1) % possibleTexts.length;
    }
}
