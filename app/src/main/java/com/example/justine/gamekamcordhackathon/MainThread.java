package com.example.justine.gamekamcordhackathon;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

/**
 * Created by justine on 6/24/15.
 */
public class MainThread extends Thread {
    private long time;

    private SurfaceHolder surfaceHolder;
    private GamePanel gamePanel;
    private boolean running;
    public static Canvas canvas;

    public MainThread(SurfaceHolder surfaceHolder, GamePanel gamePanel) {
        super();
        this.surfaceHolder = surfaceHolder;
        this.gamePanel = gamePanel;
    }

    @Override
    public void run(){
        try {
            long previousTime = 0;
            while(running) {
                time = System.nanoTime();

                if (0 == previousTime) {
                    previousTime = time;
                }
                // can use dt as argument in update so it is not frame-based
                long dt = time - previousTime;

                canvas = null;
                System.out.println(time);

                canvas = this.surfaceHolder.lockCanvas();
                synchronized (surfaceHolder) {
                    this.gamePanel.update();
                    this.gamePanel.draw(canvas);
                }
            }
        } catch(Exception e){}
        finally {
            if (canvas != null) {
                try {
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
                catch (Exception e) {e.printStackTrace();}
            }
        }

    }

    public void setRunning(boolean b){
        running = b;
    }
}
