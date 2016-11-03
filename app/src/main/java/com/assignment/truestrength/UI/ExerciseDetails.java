package com.assignment.truestrength.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.assignment.truestrength.R;

public class ExerciseDetails extends AppCompatActivity {
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_details);

        Bundle extras = getIntent().getBundleExtra(BUNDLE_EXTRAS);


        //Information that will be displayed

        //Links to 'activity_exercise_details.xml' textview detail_name
        //Carries exercise_name data from 'ExerciseData'
        ((TextView)findViewById(R.id.detail_name)).setText(extras.getString(exercise_name));

        ((TextView)findViewById(R.id.data_type)).setText(extras.getString(exercise_type));
        ((TextView)findViewById(R.id.data_worked)).setText(extras.getString(exercise_worked));
        ((TextView)findViewById(R.id.data_other)).setText(extras.getString(exercise_other));
        ((TextView)findViewById(R.id.data_equipment)).setText(extras.getString(exercise_equipment));
        ((TextView)findViewById(R.id.data_level)).setText(extras.getString(exercise_level));
        ((TextView)findViewById(R.id.data_force)).setText(extras.getString(exercise_force));
        ((ImageView)findViewById(R.id.data_img1)).setImageResource(extras.getInt(exercise_img1));
        ((ImageView)findViewById(R.id.img_2)).setImageResource(extras.getInt(exercise_img2));


    }
}
