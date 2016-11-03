package com.assignment.truestrength;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.assignment.truestrength.UI.Search;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void clickToProgramme(View view)
    {
        Intent programmeActivity = new Intent(this, Programme.class);
        startActivity(programmeActivity);
    }

    public void clickToSearch(View view)
    {
        Intent searchActivity = new Intent(this, Search.class);
        startActivity(searchActivity);
    }

    public void clickToLogin(View view)
    {
        Intent loginActivity = new Intent(this, Login.class);
        startActivity(loginActivity);
    }
}
