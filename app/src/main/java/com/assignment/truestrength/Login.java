package com.assignment.truestrength;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity
{
//test git123
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void clickToMain(View view)
    {
        Intent mainActivity = new Intent(this, MainActivity.class);
        startActivity(mainActivity);
    }
}
