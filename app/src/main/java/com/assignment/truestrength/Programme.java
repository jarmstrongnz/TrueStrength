package com.assignment.truestrength;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Programme extends AppCompatActivity
{

    DatabaseHelper myDB;

    //TODO going to be list of exercises in the workout routine
    private List<MyItems> items;

    // this class will be each exercise in the workout program


//    private void createData ()
  //  {
    //    items = new ArrayList<>();
//

  //  }

    String progID;
    Bundle progIDdata;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programme);

        myDB = new DatabaseHelper(this);

        progIDdata = getIntent().getExtras();
        progID = progIDdata.getString("progID");

        items = myDB.getProgExArray(progID);

              items.add(new MyItems(/*R.drawable.bicepcurl, */"Bicep Curls", new String[] {"10kg", "12kg", "15kg"}, new String[] {"5reps", "10reps", "15reps"}));
           items.add(new MyItems( /*R.drawable.sipups, */"Sit Ups", new String[] {"10kg", "12kg", "15kg"}, new String[] {"5reps", "10reps", "15reps"}));
              items.add(new MyItems(/*R.drawable.benchpress, */"Bench Press", new String[] {"10kg", "12kg", "15kg"}, new String[] {"5reps", "10reps", "15reps"}));

        // TODO this is where we get info from database
        //createData ();

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.my_recycler_view);

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
    }
}