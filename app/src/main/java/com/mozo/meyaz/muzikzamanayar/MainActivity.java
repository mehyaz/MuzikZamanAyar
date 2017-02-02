package com.mozo.meyaz.muzikzamanayar;

import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    public Button play;
    public MediaPlayer mp;
    public Timer timer;
    public TextView tv;
    Handler handle = null;
    Runnable runnable = null;
    int zaman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = (Button) findViewById(R.id.play);
        tv = (TextView) findViewById(R.id.tv);

        mp = MediaPlayer.create(this, R.raw.musicbox);

    }

    public void cal(View view) {
        mp.start();
        zaman = 5;
        handle = new Handler();
        runnable = new Runnable() {

            @Override
            public void run() {

                tv.setText(String.valueOf(zaman));
                if (zaman != 0) {

                    zaman--;
                } else {
                    handle.removeCallbacks(runnable);
                    Toast.makeText(MainActivity.this, "zaman doldu!",
                            Toast.LENGTH_SHORT).show();
                 zaman=5;

                    mp.seekTo(100);



                }
                handle.postDelayed(runnable, 1000);

            }
        };
        runnable.run();




         //   zamanlayici();


    }

    public void dur(View view)
    {
        mp.stop();
    }

 /*   public void zamanlayici()
    {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (mp != null && mp.isPlaying()) {
                            tv.post(new Runnable() {
                                @Override
                                public void run() {
                                    tv.setText(mp.getCurrentPosition());
                                }
                            });
                        } else {
                            timer.cancel();
                            timer.purge();
                        }
                    }
                });
            }
        }, 0, 1000);

       *//* mp.setLooping(true);*//*

    }
*/
}
