package com.assignment.truestrength;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import static android.media.CamcorderProfile.get;

public class Programme extends AppCompatActivity {

    DatabaseHelper myDB;
    String progID;

    // this class will be each exercise in the workout program


//    private void createData ()
    //  {
    //    items = new ArrayList<>();
//

    //  }
    Bundle progIDdata;
    //TODO going to be list of exercises in the workout routine
    private List<MyItems> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programme);

        myDB = new DatabaseHelper(this);

        progIDdata = getIntent().getExtras();
        progID = progIDdata.getString("progID");

        items = myDB.getProgExArray(progID);
        String progName = myDB.getProgName(progID);

        // TODO this is where we get info from database
        //createData ();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // performance
        // TODO might delete
        recyclerView.setHasFixedSize(true);

        // use linear layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter
        // The adapter that i created - Brogan
        ExerciseAdapter adapter = new ExerciseAdapter(items);
        recyclerView.setAdapter(adapter);


        String s = "";

        for (int i = 0; i < items.size(); i++) {
            s = s + "<b>" + items.get(i).exerciseName + "</b><br />\n\nSet 1\t\t\t\tSet 2\t\t\t\tSet3<br />" + items.get(i).rep0 + " Reps\t\t\t\t " + items.get(i).rep1 + " Reps\t\t\t\t" + items.get(i).rep2 + " Reps<br /><br /><br />";
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(progName);
        builder.setMessage(Html.fromHtml(s));
        builder.setPositiveButton(Html.fromHtml("<b>START WORKOUT</b>"), null);
        AlertDialog dialog = builder.show();

    }
}