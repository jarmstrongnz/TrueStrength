package com.assignment.truestrength;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Programme extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programme);
    }

    public void clickToProgress(View view)
    {
        Intent progressActivity = new Intent(this, Progress.class);
        startActivity(progressActivity);
    }
}
