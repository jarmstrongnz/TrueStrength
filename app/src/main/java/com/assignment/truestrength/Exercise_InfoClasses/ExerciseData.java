package com.assignment.truestrength.Exercise_InfoClasses;

import java.util.ArrayList;
import java.util.List;
import com.assignment.truestrength.R;

//This Class Holds all the Arrays that will hold all the exercise Information
public class ExerciseData {

    //Exercise Names
    private static final String[] exercise_Name = {
            "Barbell Full Squat",
            "Sumo Deadlift",
            "Leg Press"



    };


    //Exercise Type
    private static final String[] exercise_type = {
            "Strength",
            "Powerlifting",
            "Strength"



    };

    //Exercise Muscle Worked
    private static final String[] exercise_worked = {
            "Quadriceps",
            "Quadriceps",
            "Hamstrings"



    };

    //Exercise other Muscle Worked
    private static final String[] exercise_other = {
            "Calves, Glutes, Hamstrings, Lower Back",
            "Calves, Glutes, Hamstrings",
            "Adductors, Forearms"



    };

    //Exercise Equipment used
    private static final String[] exercise_equipment = {
            "Barbell",
            "Barbell",
            "Machine"



    };

    //Exercise Level
    private static final String[] exercise_level = {
            "Intermediate",
            "Beginner",
            "Intermediate"



    };

    //Exercise Force
    private static final String[] exercise_force = {
            "Push",
            "Push",
            "Pull"



    };

    //Exercise First Image
    private static final int[] exercise_img1 = {
            R.drawable.barbellsquat1,
            R.drawable.sumo1,
            R.drawable.legpress1,



    };
    //Exercise Second Image
    private static final int[] exercise_img2 = {
            R.drawable.barbellsquat2,
            R.drawable.sumo2,
            R.drawable.legpress2,



    };

    //Assigns all the Data to the Arrays and List
    public static List<ExerciseGetterSetter> getListData() {
        List<ExerciseGetterSetter> data = new ArrayList<>();

        //RecyclerView
        //create ListItem with dummy data, then add them to our List
        //Fills the Arrays with the data using a loop
        for (int i = 0; i < exercise_Name.length; i++) {
            ExerciseGetterSetter item = new ExerciseGetterSetter();

            //Assigning data
            item.setExercise_Name(exercise_Name[i]);
            item.setExercise_type(exercise_type[i]);
            item.setExercise_worked(exercise_worked[i]);
            item.setExercise_other(exercise_other[i]);
            item.setExercise_equipment(exercise_equipment[i]);
            item.setExercise_level(exercise_level[i]);
            item.setExercise_force(exercise_force[i]);
            item.setExercise_img1(exercise_img1[i]);
            item.setExercise_img2(exercise_img2[i]);


            data.add(item);
        }
        return data;
    }

}
