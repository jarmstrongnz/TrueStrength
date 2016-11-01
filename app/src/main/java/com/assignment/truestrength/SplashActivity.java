package com.assignment.truestrength;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class SplashActivity extends AppCompatActivity {
    private final long timer = 3000; // milliseconds
    private final long tickIterations = 1000; // milliseconds
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


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

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
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

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Splash Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
