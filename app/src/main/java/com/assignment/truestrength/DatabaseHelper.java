package com.assignment.truestrength;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {


    public static final int DATABASE_VERSION = 1; // version of the products database
    public static final String DATABASE_NAME = "truestrength.db"; // filename of the database

    //Compulsary DatabaseHelper constructor

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        SQLiteDatabase db = this.getWritableDatabase();
    }


    //What happens when the database is created
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE programme (programmeID TEXT PRIMARY KEY , programmeName TEXT);");
        db.execSQL("CREATE TABLE exercise (exerciseID TEXT PRIMARY KEY, exerciseName TEXT, exercisePic TEXT);");
        db.execSQL("CREATE TABLE programmeExercise (programmeExerciseID TEXT PRIMARY KEY, programmeID TEXT REFERENCES programme(programmeID), exerciseID TEXT REFERENCES exercise(exerciseID), sets INTEGER, set1repsDef INTEGER, set2repsDef INTEGER, set3repsDef INTEGER, set1weightDef INTEGER, set2weightDef INTEGER, set3weightDef INTEGER);");
        db.execSQL("CREATE TABLE session (sessionID INTEGER PRIMARY KEY AUTOINCREMENT,programmeID TEXT REFERENCES programme(programmeID),sessionDate DATE);");
        db.execSQL("CREATE TABLE sessionExercise (sessionExerciseID INTEGER PRIMARY KEY AUTOINCREMENT, programmeExerciseID TEXT REFERENCES programme(programmeID), sessionID INTEGER REFERENCES session(sessionID), set1reps INTEGER, set1weight INTEGER, set2reps INTEGER, set2weight INTEGER, set3reps INTEGER, set3weight INTEGER);");
        db.execSQL("INSERT INTO programme (programmeID, programmeName)VALUES ('P000', 'Fat to Fit');");
        db.execSQL("INSERT INTO programme (programmeID, programmeName)VALUES ('P001', 'Fun Fitness');");
        db.execSQL("INSERT INTO exercise (exerciseID, exerciseName, exercisePic)VALUES ('E000', 'Benchpress', 'R.drawable.dbbenchpress');");
        db.execSQL("INSERT INTO exercise (exerciseID, exerciseName, exercisePic)VALUES ('E001', 'Butterflys', 'R.drawable.dbbutterflies');");
        db.execSQL("INSERT INTO exercise (exerciseID, exerciseName, exercisePic)VALUES ('E002', 'Front Raises', 'R.drawable.dbfrontraises');");
        db.execSQL("INSERT INTO exercise (exerciseID, exerciseName, exercisePic)VALUES ('E003', 'Lat Raises', 'R.drawable.dblatraises');");
        db.execSQL("INSERT INTO exercise (exerciseID, exerciseName, exercisePic)VALUES ('E004', 'Tricep Pushdowns', 'R.drawable.dbtriceppushdown');");
        db.execSQL("INSERT INTO exercise (exerciseID, exerciseName, exercisePic)VALUES ('E005', 'Tricep Dips', 'R.drawable.dbtricepdips');");
        db.execSQL("INSERT INTO exercise (exerciseID, exerciseName, exercisePic)VALUES ('E006', 'Incline Situps', 'R.drawable.dbdeclinecrunch');");
        db.execSQL("INSERT INTO exercise (exerciseID, exerciseName, exercisePic)VALUES ('E007', 'Squat', 'R.drawable.dbsquats');");
        db.execSQL("INSERT INTO exercise (exerciseID, exerciseName, exercisePic)VALUES ('E008', 'Pull Ups', 'R.drawable.dbpullups');");
        db.execSQL("INSERT INTO exercise (exerciseID, exerciseName, exercisePic)VALUES ('E009', 'Dumbbell Curls', 'R.drawable.dbbicepcurls');");
        db.execSQL("INSERT INTO exercise (exerciseID, exerciseName, exercisePic)VALUES ('E010', 'Lat Pulldown', 'R.drawable.dblatpulldown');");
        db.execSQL("INSERT INTO exercise (exerciseID, exerciseName, exercisePic)VALUES ('E011', 'Seated Cable Row', 'R.drawable.dbseatedcablerow');");
        db.execSQL("INSERT INTO programmeExercise (programmeExerciseID, programmeID, exerciseID, sets, set1repsDef, set2repsDef, set3repsDef, set1weightDef, set2weightDef, set3weightDef)VALUES ('PE000', 'P000', 'E000', 3, 6, 8, 12, 0, 0, 0);");
        db.execSQL("INSERT INTO programmeExercise (programmeExerciseID, programmeID, exerciseID, sets, set1repsDef, set2repsDef, set3repsDef, set1weightDef, set2weightDef, set3weightDef)VALUES ('PE001', 'P000', 'E001', 3, 6, 8, 12, 0, 0, 0);");
        db.execSQL("INSERT INTO programmeExercise (programmeExerciseID, programmeID, exerciseID, sets, set1repsDef, set2repsDef, set3repsDef, set1weightDef, set2weightDef, set3weightDef)VALUES ('PE002', 'P000', 'E002', 3, 6, 8, 12, 0, 0, 0);");
        db.execSQL("INSERT INTO programmeExercise (programmeExerciseID, programmeID, exerciseID, sets, set1repsDef, set2repsDef, set3repsDef, set1weightDef, set2weightDef, set3weightDef)VALUES ('PE003', 'P000', 'E003', 3, 6, 8, 12, 0, 0, 0);");
        db.execSQL("INSERT INTO programmeExercise (programmeExerciseID, programmeID, exerciseID, sets, set1repsDef, set2repsDef, set3repsDef, set1weightDef, set2weightDef, set3weightDef)VALUES ('PE004', 'P000', 'E004', 3, 6, 8, 12, 0, 0, 0);");
        db.execSQL("INSERT INTO programmeExercise (programmeExerciseID, programmeID, exerciseID, sets, set1repsDef, set2repsDef, set3repsDef, set1weightDef, set2weightDef, set3weightDef)VALUES ('PE005', 'P000', 'E005', 3, 6, 8, 12, 0, 0, 0);");
        db.execSQL("INSERT INTO programmeExercise (programmeExerciseID, programmeID, exerciseID, sets, set1repsDef, set2repsDef, set3repsDef, set1weightDef, set2weightDef, set3weightDef)VALUES ('PE006', 'P000', 'E006', 3, 6, 8, 12, 0, 0, 0);");
        db.execSQL("INSERT INTO programmeExercise (programmeExerciseID, programmeID, exerciseID, sets, set1repsDef, set2repsDef, set3repsDef, set1weightDef, set2weightDef, set3weightDef)VALUES ('PE007', 'P001', 'E007', 3, 6, 8, 12, 0, 0, 0);");
        db.execSQL("INSERT INTO programmeExercise (programmeExerciseID, programmeID, exerciseID, sets, set1repsDef, set2repsDef, set3repsDef, set1weightDef, set2weightDef, set3weightDef)VALUES ('PE008', 'P001', 'E008', 3, 6, 8, 12, 0, 0, 0);");
        db.execSQL("INSERT INTO programmeExercise (programmeExerciseID, programmeID, exerciseID, sets, set1repsDef, set2repsDef, set3repsDef, set1weightDef, set2weightDef, set3weightDef)VALUES ('PE009', 'P001', 'E009', 3, 6, 8, 12, 0, 0, 0);");
        db.execSQL("INSERT INTO programmeExercise (programmeExerciseID, programmeID, exerciseID, sets, set1repsDef, set2repsDef, set3repsDef, set1weightDef, set2weightDef, set3weightDef)VALUES ('PE010', 'P001', 'E010', 3, 6, 8, 12, 0, 0, 0);");
        db.execSQL("INSERT INTO programmeExercise (programmeExerciseID, programmeID, exerciseID, sets, set1repsDef, set2repsDef, set3repsDef, set1weightDef, set2weightDef, set3weightDef)VALUES ('PE011', 'P001', 'E011', 3, 6, 8, 12, 0, 0, 0);");
        db.execSQL("INSERT INTO programmeExercise (programmeExerciseID, programmeID, exerciseID, sets, set1repsDef, set2repsDef, set3repsDef, set1weightDef, set2weightDef, set3weightDef)VALUES ('PE012', 'P001', 'E006', 3, 6, 8, 12, 0, 0, 0);");
    }


    //What happens when the database is upgraded (DATABASE_VERSION is changed)
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS exercises"); // SQL statement to drop table (if it exists)
        onCreate(db); // Calling the onCreate method
    }

    public String getProgName(String progID){
        SQLiteDatabase db = this.getReadableDatabase();

        String progName = "";

        Cursor crs = db.rawQuery("SELECT programmeName FROM programme WHERE programmeID = '" + progID + "'", null);

        int i = 0;
        while (crs.moveToNext()) {
            progName = crs.getString(crs.getColumnIndex("programmeName"));
        }
        crs.close();
        return progName;
    }

    public void setSet1reps (int n, String exName){
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL("UPDATE sessionExercise SET set1reps = " + n + " WHERE sessionExerciseID IN (SELECT MAX(sessionExerciseID) FROM sessionExercise, programmeExercise, exercise WHERE sessionExercise.programmeExerciseID = programmeExercise.programmeExerciseID AND programmeExercise.exerciseID = exercise.exerciseID AND exerciseName = '" + exName + "');");
    }

    public void setSet2reps (int n, String exName){
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL("UPDATE sessionExercise SET set2reps = " + n + " WHERE sessionExerciseID IN (SELECT MAX(sessionExerciseID) FROM sessionExercise, programmeExercise, exercise WHERE sessionExercise.programmeExerciseID = programmeExercise.programmeExerciseID AND programmeExercise.exerciseID = exercise.exerciseID AND exerciseName = '" + exName + "');");
    }

    public void setSet3reps (int n, String exName){
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL("UPDATE sessionExercise SET set3reps = " + n + " WHERE sessionExerciseID IN (SELECT MAX(sessionExerciseID) FROM sessionExercise, programmeExercise, exercise WHERE sessionExercise.programmeExerciseID = programmeExercise.programmeExerciseID AND programmeExercise.exerciseID = exercise.exerciseID AND exerciseName = '" + exName + "');");
    }

    public void setSet1weight (int n, String exName){
        SQLiteDatabase db = this.getReadableDatabase();

        db.execSQL("UPDATE programmeExercise SET set1weightDef = " + n + " WHERE programmeExerciseID IN (SELECT programmeExerciseID FROM programmeExercise, exercise WHERE programmeExercise.exerciseID = exercise.exerciseID AND exerciseName = '" + exName + "');");
        db.execSQL("UPDATE sessionExercise SET set1weight = " + n + " WHERE sessionExerciseID IN (SELECT MAX(sessionExerciseID) FROM sessionExercise, programmeExercise, exercise WHERE sessionExercise.programmeExerciseID = programmeExercise.programmeExerciseID AND programmeExercise.exerciseID = exercise.exerciseID AND exerciseName = '" + exName + "');");
    }

    public void setSet2weight (int n, String exName){
        SQLiteDatabase db = this.getReadableDatabase();

        db.execSQL("UPDATE programmeExercise SET set2weightDef = " + n + " WHERE programmeExerciseID IN (SELECT programmeExerciseID FROM programmeExercise, exercise WHERE programmeExercise.exerciseID = exercise.exerciseID AND exerciseName = '" + exName + "');");
        db.execSQL("UPDATE sessionExercise SET set2weight = " + n + " WHERE sessionExerciseID IN (SELECT MAX(sessionExerciseID) FROM sessionExercise, programmeExercise, exercise WHERE sessionExercise.programmeExerciseID = programmeExercise.programmeExerciseID AND programmeExercise.exerciseID = exercise.exerciseID AND exerciseName = '" + exName + "');");
    }

    public void setSet3weight (int n, String exName){
        SQLiteDatabase db = this.getReadableDatabase();

        db.execSQL("UPDATE programmeExercise SET set3weightDef = " + n + " WHERE programmeExerciseID IN (SELECT programmeExerciseID FROM programmeExercise, exercise WHERE programmeExercise.exerciseID = exercise.exerciseID AND exerciseName = '" + exName + "');");
        db.execSQL("UPDATE sessionExercise SET set3weight = " + n + " WHERE sessionExerciseID IN (SELECT MAX(sessionExerciseID) FROM sessionExercise, programmeExercise, exercise WHERE sessionExercise.programmeExerciseID = programmeExercise.programmeExerciseID AND programmeExercise.exerciseID = exercise.exerciseID AND exerciseName = '" + exName + "');");
    }

    public List<MyItems> getProgExArray(String progID) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor crs = db.rawQuery("SELECT programmeExerciseID FROM programmeExercise WHERE programmeID = '" + progID + "'", null);

        String[] progExIDArr = new String[crs.getCount()];
        List<MyItems> exItems = new ArrayList<>();

        int i = 0;
        while (crs.moveToNext()) {
            String progExID = crs.getString(crs.getColumnIndex("programmeExerciseID"));
            progExIDArr[i] = progExID;
            i++;
        }
        crs.close();

        db.execSQL("INSERT INTO session (programmeID, sessionDate) VALUES ('" + progID + "', datetime());");

        for (i = 0; i < progExIDArr.length; i++) {
            db.execSQL("INSERT INTO sessionExercise (sessionID, programmeExerciseID, set1reps, set2reps, set3reps, set1weight, set2weight, set3weight) VALUES ((SELECT sessionID FROM session ORDER BY sessionID DESC LIMIT 1), '"+ progExIDArr[i] +"', (SELECT set1repsdef FROM programmeExercise WHERE programmeExerciseID = '"+ progExIDArr[i] +"'), (SELECT set2repsdef FROM programmeExercise WHERE programmeExerciseID = '"+ progExIDArr[i] +"'), (SELECT set3repsdef FROM programmeExercise WHERE programmeExerciseID = '"+ progExIDArr[i] +"'), (SELECT set1weightdef FROM programmeExercise WHERE programmeExerciseID = '"+ progExIDArr[i] +"'), (SELECT set2weightdef FROM programmeExercise WHERE programmeExerciseID = '"+ progExIDArr[i] +"'), (SELECT set3weightdef FROM programmeExercise WHERE programmeExerciseID = '"+ progExIDArr[i] +"'));");
        }

        Cursor crs1 = db.rawQuery("SELECT sessionExerciseID FROM sessionExercise WHERE sessionID = (SELECT sessionID FROM session ORDER BY sessionID DESC LIMIT 1);", null);

        Integer[] sessExIDArr = new Integer[crs1.getCount()];

        i = 0;

        while (crs1.moveToNext()) {
            Integer sessExID = crs1.getInt(crs1.getColumnIndex("sessionExerciseID"));
            sessExIDArr[i] = sessExID;
            i++;
        }
        crs1.close();

        Cursor crs_eN;
        Cursor crs_setsreps;

        String exerciseName = null;
        String set1reps = null;
        String set1weight = null;
        String set2reps = null;
        String set2weight = null;
        String set3reps = null;
        String set3weight = null;


        for (i = 0; i < sessExIDArr.length; i++) {
            crs_eN = db.rawQuery("SELECT exerciseName FROM exercise, programmeExercise, sessionExercise WHERE exercise.exerciseID = programmeExercise.exerciseID AND programmeExercise.programmeExerciseID = sessionExercise.programmeExerciseID AND sessionExerciseID = " + sessExIDArr[i] + ";", null);
            crs_setsreps = db.rawQuery("SELECT 	set1reps, set1weight, set2reps, set2weight, set3reps, set3weight FROM sessionExercise WHERE sessionExerciseID = " + sessExIDArr[i] + ";", null);

            while (crs_eN.moveToNext()) {
                exerciseName = crs_eN.getString(crs_eN.getColumnIndex("exerciseName"));
            }

            while (crs_setsreps.moveToNext()) {
                set1reps = crs_setsreps.getString(crs_setsreps.getColumnIndex("set1reps"));
                set1weight = crs_setsreps.getString(crs_setsreps.getColumnIndex("set1weight"));
                set2reps = crs_setsreps.getString(crs_setsreps.getColumnIndex("set2reps"));
                set2weight = crs_setsreps.getString(crs_setsreps.getColumnIndex("set2weight"));
                set3reps = crs_setsreps.getString(crs_setsreps.getColumnIndex("set3reps"));
                set3weight = crs_setsreps.getString(crs_setsreps.getColumnIndex("set3weight"));
            }

            exItems.add(new MyItems(exerciseName, new String[]{set1weight, set2weight, set3weight}, new String[]{set1reps, set2reps, set3reps}));
            crs_eN.close();
            crs_setsreps.close();
        }

        return exItems;
    }
} // end of MyDBHandler class
