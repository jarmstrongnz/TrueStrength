package com.assignment.truestrength;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class Programme extends AppCompatActivity {

    DatabaseHelper myDB;
    String progID;

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
        Button workooutComplete = (Button) findViewById(R.id.workooutComplete);

        workooutComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("Congrats!");
                builder.setMessage("Great Work! You lifted a total of XXXXXXXXXkgs!\n\n Want to share this with your friends?");
                builder.setPositiveButton("Share", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent i = new Intent(Intent.ACTION_SEND);
                        i.setType("text/plain");
                        i.putExtra(Intent.EXTRA_SUBJECT, "Workout Complete!");
                        i.putExtra(Intent.EXTRA_TEXT, "I just lifted a total of XXXXXXX kgs! Thanks to the help of the TrueStrength app!");
                        startActivity(Intent.createChooser(i, "Share URL"));
                    }
                });
                builder.setNegativeButton("No Thanks", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent mainActivity = new Intent(getBaseContext(), MainActivity.class);
                        startActivity(mainActivity);
                    }
                });
                AlertDialog dialog = builder.show();


            }
        });

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