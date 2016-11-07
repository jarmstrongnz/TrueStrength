package com.assignment.truestrength.UI;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.assignment.truestrength.R;

import android.widget.Toast;


import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.ErrorReason;
import com.google.android.youtube.player.YouTubePlayer.PlaybackEventListener;
import com.google.android.youtube.player.YouTubePlayer.PlayerStateChangeListener;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;

public class ExerciseDetails extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {
    //OnClick Variables
    private static final String BUNDLE_EXTRAS = "BUNDLE_EXTRAS";
    private static final String exercise_name = "exercise_name";
    private static final String exercise_type = "exercise_type";
    private static final String exercise_worked = "exercise_worked";
    private static final String exercise_other = "exercise_other";
    private static final String exercise_equipment = "exercise_equipment";
    private static final String exercise_level = "exercise_level";
    private static final String exercise_force = "exercise_force";
    private static final String exercise_img1 = "exercise_img1";
    private static final String exercise_img2 = "exercise_img2";
    private static final String exercise_desc = "exercise_desc";

    //Youtube Variables
    public static final String API_KEY = "AIzaSyCCriCWBCoyKUCnjTkDlOAVpJGGWdrUWtA";

    //What video will be played
    public static final String VIDEO_ID = "tVB1q8zkP3o";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_details);

        ///Initializing YouTube Player View
        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) findViewById(R.id.ytplayer);
        youTubePlayerView.initialize(API_KEY, this);



        Bundle extras = getIntent().getBundleExtra(BUNDLE_EXTRAS);


        //Information that will be displayed
        //Links to 'activity_exercise_details.xml' textview detail_name
        //Carries exercise_name data from 'ExerciseData'
        ((TextView) findViewById(R.id.detail_name)).setText(extras.getString(exercise_name));
        ((TextView) findViewById(R.id.data_type)).setText(extras.getString(exercise_type));
        ((TextView) findViewById(R.id.data_worked)).setText(extras.getString(exercise_worked));
        ((TextView) findViewById(R.id.data_other)).setText(extras.getString(exercise_other));
        ((TextView) findViewById(R.id.data_equipment)).setText(extras.getString(exercise_equipment));
        ((TextView) findViewById(R.id.data_level)).setText(extras.getString(exercise_level));
        ((TextView) findViewById(R.id.data_force)).setText(extras.getString(exercise_force));
        ((ImageView) findViewById(R.id.data_img1)).setImageResource(extras.getInt(exercise_img1));
        ((ImageView) findViewById(R.id.img_2)).setImageResource(extras.getInt(exercise_img2));
        ((TextView) findViewById(R.id.data_info)).setText(extras.getString(exercise_desc));


    }

    //Youtube Methods
    @Override
    public void onInitializationFailure(Provider provider, YouTubeInitializationResult result) {
        Toast.makeText(this, "Failured to Initialize!", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onInitializationSuccess(Provider provider, YouTubePlayer player, boolean wasRestored) {
        player.setPlayerStateChangeListener(playerStateChangeListener);
        player.setPlaybackEventListener(playbackEventListener);
        player.setPlayerStyle(YouTubePlayer.PlayerStyle.CHROMELESS);
        //Start buffering
        if (!wasRestored) {
            player.cueVideo(VIDEO_ID);
        }
    }

    private PlaybackEventListener playbackEventListener = new PlaybackEventListener() {
        @Override
        public void onBuffering(boolean arg0) {
        }

        @Override
        public void onPaused() {
        }

        @Override
        public void onPlaying() {
        }

        @Override
        public void onSeekTo(int arg0) {
        }

        @Override
        public void onStopped() {
        }
    };

    private PlayerStateChangeListener playerStateChangeListener = new PlayerStateChangeListener() {
        @Override
        public void onAdStarted() {
        }

        @Override
        public void onError(ErrorReason arg0) {
        }

        @Override
        public void onLoaded(String arg0) {
        }

        @Override
        public void onLoading() {
        }

        @Override
        public void onVideoEnded() {
        }

        @Override
        public void onVideoStarted() {
        }
    };



}

