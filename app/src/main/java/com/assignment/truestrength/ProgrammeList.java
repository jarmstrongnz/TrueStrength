package com.assignment.truestrength;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ProgrammeList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programme_list);
    }

    public void clickToProgramme(View view) {
        Intent programmeActivity = new Intent(this, Programme.class);
        startActivity(programmeActivity);
    }

    public void clickToSearch(View view) {
        Intent searchActivity = new Intent(this, Search.class);
        startActivity(searchActivity);
    }

    public void clickToLogin(View view) {
        Intent loginActivity = new Intent(this, Login.class);
        startActivity(loginActivity);
    }
}
