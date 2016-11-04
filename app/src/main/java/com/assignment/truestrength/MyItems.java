package com.assignment.truestrength;

/**
 * Created by jambo on 04-Nov-16.
 */

public class MyItems
{
    //       int photoId;
    String exerciseName;
    String weight0, weight1, weight2;
    String rep0, rep1, rep2;

    MyItems(/*int photoId, */String exerciseName,String[] weights, String[] reps)
    {
//            this.photoId = photoId;
        this.exerciseName = exerciseName;
        this.weight0 = weights[0];
        this.weight1 = weights[1];
        this.weight2 = weights[2];
        this.rep0 = reps[0];
        this.rep1 = reps[1];
        this.rep2 = reps[2];
    }
}