package com.assignment.truestrength;

import android.content.Intent;
import android.media.Image;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity
{
    private final long timer = 3000; // milliseconds

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView logo = (ImageView)findViewById(R.id.logo);

        // fade in animation
        AlphaAnimation fadeIn = new AlphaAnimation(0.0f, 1.0f);
        logo.startAnimation(fadeIn);
        fadeIn.setDuration(timer);
        fadeIn.setFillAfter(true);



        new CountDownTimer(3000, 1000)
        {
            public void onTick(long millisUntilFinished)
            {
            }

            public void onFinish()
            {
                /** if user has NOT logged in info
                 * then go to login info activity
                 * else go to mainActivity
                 */
                startMainActivity();
            }
        }.start();
    }

    private void startMainActivity()
    {
        Intent mainActivity = new Intent(this, MainActivity.class);
        startActivity(mainActivity);
    }
}
