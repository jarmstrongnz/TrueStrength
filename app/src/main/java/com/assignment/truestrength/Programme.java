package com.assignment.truestrength;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class Programme extends AppCompatActivity
{
    //TODO going to be list of exercises in the workout routine
    private List<MyItems> items;

    public class MyItems
    {
        String exerciseName;
        String reps;
        int photoId;

        MyItems(String exerciseName, String reps, int photoId)
        {
            this.exerciseName = exerciseName;
            this.reps = reps;
            this.photoId = photoId;
        }
    }

    private void createData ()
    {
        items = new ArrayList<>();

        items.add(new MyItems("Bicep Curls", "190", R.drawable.bicepcurl));
        items.add(new MyItems("Sit Ups", "500", R.drawable.sipups));
        items.add(new MyItems("Bench Press", "8000", R.drawable.benchpress));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programme);

        // TODO this is where we get info from database
        createData ();

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.my_recycler_view);

        // performance
        // TODO might delete
        //recyclerView.setHasFixedSize(true);

        // use linear layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter
        // The adapter that i created - Brogan
        ExerciseAdapter adapter = new ExerciseAdapter(items);
        recyclerView.setAdapter(adapter);
    }

    // button listener to go to the progress activity
    public void clickToProgress(View view)
    {
        Intent progressActivity = new Intent(this, Progress.class);
        startActivity(progressActivity);
    }

}
