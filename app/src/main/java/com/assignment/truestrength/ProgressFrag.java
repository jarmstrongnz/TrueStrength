package com.assignment.truestrength;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ProgressFrag extends AppCompatActivity {

    public static ProgressFrag create() {
        ProgressFrag fragment = new ProgressFrag();
        return fragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frag_progress);
    }

    public void clickToMain(View view)
    {
        Intent mainActivity = new Intent(this, MainActivity.class);
        startActivity(mainActivity);
    }

}