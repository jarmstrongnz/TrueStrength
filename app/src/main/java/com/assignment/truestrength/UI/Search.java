package com.assignment.truestrength.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import com.assignment.truestrength.Adapter.ExerciseAdapter;
import com.assignment.truestrength.Exercise_InfoClasses.ExerciseData;
import com.assignment.truestrength.Exercise_InfoClasses.ExerciseGetterSetter;
import com.assignment.truestrength.R;

import java.util.ArrayList;

public class Search extends AppCompatActivity implements ExerciseAdapter.ItemClickCallBack
{
    private RecyclerView recView;
    private ExerciseAdapter adapter;
    private ArrayList listData;

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


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        listData = (ArrayList) ExerciseData.getListData();

        recView = (RecyclerView) findViewById(R.id.rec_list);
        recView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new ExerciseAdapter(listData, this);
        recView.setAdapter(adapter);

        adapter.setItemClickCallBack(this);




        //Search Stuff
        /*
        searchView = (SearchView) findViewById(R.id.searchView_workouts);
        listView.setAdapter(adapter);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText)
            {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        */



    }

    @Override
    public void onItemClick(int p) {
        ExerciseGetterSetter item = (ExerciseGetterSetter) listData.get(p);

        Intent i = new Intent(this, ExerciseDetails.class);
        Bundle extras = new Bundle();

        extras.putString(exercise_name, item.getExercise_Name());
        extras.putString(exercise_type, item.getExercise_type());
        extras.putString(exercise_worked, item.getExercise_worked());
        extras.putString(exercise_other, item.getExercise_other());
        extras.putString(exercise_equipment, item.getExercise_equipment());
        extras.putString(exercise_level, item.getExercise_level());
        extras.putString(exercise_force, item.getExercise_force());
        extras.putInt(exercise_img1, item.getExercise_img1());
        extras.putInt(exercise_img2, item.getExercise_img2());




        i.putExtra(BUNDLE_EXTRAS, extras);
        startActivity(i);
    }
}
