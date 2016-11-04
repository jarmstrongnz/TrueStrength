package com.assignment.truestrength;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;


public class SplashActivity extends AppCompatActivity {
    private final long timer = 3000; // milliseconds
    private final long tickIterations = 1000; // milliseconds


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView logo = (ImageView) findViewById(R.id.logo);

        // rids of action bar
        getSupportActionBar().hide();

        // fade in animation
        AlphaAnimation fadeIn = new AlphaAnimation(0.0f, 1.0f);
        logo.startAnimation(fadeIn);
        fadeIn.setDuration(timer);
        fadeIn.setFillAfter(true);

        new CountDownTimer(timer, tickIterations) {
            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {
                /** if user has NOT logged in info
                 * then go to login info activity
                 * else go to mainActivity
                 */
                if (is_ID_Present())
                    startMainActivity();
                else
                    startLoginActivity();
            }
        }.start();


    }

    private boolean is_ID_Present() {
        // search database for user ID
        // if there is one then load all their data
        return false;
    }

    private void startLoginActivity() {
        Intent loginActivity = new Intent(this, Login.class);
        startActivity(loginActivity);
    }


    private void startMainActivity() {
        Intent mainActivity = new Intent(this, MainActivity.class);
        startActivity(mainActivity);
    }


}
