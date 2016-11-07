package com.assignment.truestrength.Exercise_InfoClasses;

import com.assignment.truestrength.R;

import java.util.ArrayList;
import java.util.List;

//This Class Holds all the Arrays that will hold all the exercise Information
public class ExerciseData {

    //Exercise Names
    private static final String[] exercise_Name = {
            "Barbell Full Squat",
            "Sumo Deadlift",
            "Leg Press",
            "Barbell Bench Press",
            "Butterfly",
            "Dumbbell Curls",
            "Hanging Leg Raise",
            "3/4 Sit-Up",
            "Side Lateral Raise",
            "Straight-Arm Pulldown",
            "Pull Ups",
            "Seated Cable Row",
            "Squat",
            "Tricep Pushdowns",




    };


    //Exercise Type
    private static final String[] exercise_type = {
            "Strength",
            "Powerlifting",
            "Strength",
            "Strength",
            "Strength",
            "Strength",
            "Strength",
            "Strength",
            "Strength",
            "Strength",
            "Strength",
            "Strength",
            "Strength",
            "Strength",



    };

    //Exercise Muscle Worked
    private static final String[] exercise_worked = {
            "Quadriceps",
            "Quadriceps",
            "Hamstrings",
            "Chest",
            "Chest",
            "Biceps",
            "Abdominals",
            "Abdominals",
            "Shoulders",
            "Lats",
            "Lats",
            "Middle Back",
            "Quadriceps",
            "Triceps",


    };

    //Exercise other Muscle Worked
    private static final String[] exercise_other = {
            "Calves, Glutes, Hamstrings, Lower Back",
            "Calves, Glutes, Hamstrings",
            "Adductors, Forearms",
            "Shoulders, Triceps",
            "n/a",
            "Forearms",
            "n/a",
            "n/a",
            "n/a",
            "n/a",
            "Biceps, Middle Back",
            "Biceps, Lats, Shoulders",
            "Calves, Glutes, Hamstrings",
            "n/a",


    };

    //Exercise Equipment used
    private static final String[] exercise_equipment = {
            "Barbell",
            "Barbell",
            "Machine",
            "Barbell",
            "Machine",
            "Dumbbell",
            "Body Only",
            "Body Only",
            "Dumbbell",
            "Machine",
            "Body Only",
            "Cable",
            "Barbell",
            "Cable",


    };

    //Exercise Level
    private static final String[] exercise_level = {
            "Intermediate",
            "Beginner",
            "Intermediate",
            "Beginner",
            "Beginner",
            "Beginner",
            "Expert",
            "Beginner",
            "Beginner",
            "Beginner",
            "Beginner",
            "Beginner",
            "Beginner",
            "Beginner",


    };

    //Exercise Force
    private static final String[] exercise_force = {
            "Push",
            "Push",
            "Pull",
            "Push",
            "Pull",
            "Pull",
            "Pull",
            "Pull",
            "Push",
            "Pull",
            "Pull",
            "Pull",
            "Push",
            "Pull",


    };

    //Exercise First Image
    private static final int[] exercise_img1 = {
            //
            R.drawable.barbellsquat1,
            //
            R.drawable.sumo1,
            //
            R.drawable.legpress1,
            //1
            R.drawable.bench1,
            //2
            R.drawable.butterfly1,
            //3
            R.drawable.curl1,
            //4
            R.drawable.legraise1,
            //5
            R.drawable.situp1,
            //6
            R.drawable.side1,
            //7
            R.drawable.pulldown1,
            //8
            R.drawable.pullup1,
            //9
            R.drawable.cablepull1,
            //10
            R.drawable.barbellsquat1,
            //11
            R.drawable.pulldowncable1,



    };
    //Exercise Second Image
    private static final int[] exercise_img2 = {
            R.drawable.barbellsquat2,
            R.drawable.sumo2,
            //
            R.drawable.legpress2,
            //1
            R.drawable.bench2,
            //2
            R.drawable.butterfly2,
            //3
            R.drawable.curl2,
            //4
            R.drawable.legraise2,
            //5
            R.drawable.situp2,
            //6
            R.drawable.side2,
            //7
            R.drawable.pulldown2,
            //8
            R.drawable.pullup2,
            //9
            R.drawable.cablepull2,
            //10
            R.drawable.barbellsquat2,
            //11
            R.drawable.pulldowncable2,



    };

    private static final String[] exercise_vid = {
            "tVB1q8zkP3o",



    };

    //Exercise Force
    private static final String[] exercise_desc = {
            //Exercise Name Here : Description
            "1. Begin with a bar loaded on the ground. Approach the bar so that the bar intersects the middle of the feet. \n\n" +
                    "2. The feet should be set very wide, near the collars. Bend at the hips to grip the bar. \n\n" +
                    "3. The arms should be directly below the shoulders, inside the legs, and you can use a pronated grip, a mixed grip, or hook grip. Relax the shoulders, which in effect lengthens your arms.\n\n" +
                    "4. Take a breath, and then lower your hips, looking forward with your head with your chest up. Drive through the floor, spreading your feet apart, with your weight on the back half of your feet. Extend through the hips and knees.\n\n" +
                    "5. As the bar passes through the knees, lean back and drive the hips into the bar, pulling your shoulder blades together.\n\n" +
                    "6. Return the weight to the ground by bending at the hips and controlling the weight on the way down.",
            //Exercise Name Here : Description
            "1. Begin with a bar loaded on the ground. Approach the bar so that the bar intersects the middle of the feet. \n\n" +
                    "2. The feet should be set very wide, near the collars. Bend at the hips to grip the bar. \n\n" +
                    "3. The arms should be directly below the shoulders, inside the legs, and you can use a pronated grip, a mixed grip, or hook grip. Relax the shoulders, which in effect lengthens your arms.\n\n" +
                    "4. Take a breath, and then lower your hips, looking forward with your head with your chest up. Drive through the floor, spreading your feet apart, with your weight on the back half of your feet. Extend through the hips and knees.\n\n" +
                    "5. As the bar passes through the knees, lean back and drive the hips into the bar, pulling your shoulder blades together.\n\n" +
                    "6. Return the weight to the ground by bending at the hips and controlling the weight on the way down.",
            //Exercise Name Here : Description
            "1. Begin with a bar loaded on the ground. Approach the bar so that the bar intersects the middle of the feet. \n\n" +
                    "2. The feet should be set very wide, near the collars. Bend at the hips to grip the bar. \n\n" +
                    "3. The arms should be directly below the shoulders, inside the legs, and you can use a pronated grip, a mixed grip, or hook grip. Relax the shoulders, which in effect lengthens your arms.\n\n" +
                    "4. Take a breath, and then lower your hips, looking forward with your head with your chest up. Drive through the floor, spreading your feet apart, with your weight on the back half of your feet. Extend through the hips and knees.\n\n" +
                    "5. As the bar passes through the knees, lean back and drive the hips into the bar, pulling your shoulder blades together.\n\n" +
                    "6. Return the weight to the ground by bending at the hips and controlling the weight on the way down.",
            //Bench Press Description
            "1. Lie back on a flat bench. Using a medium width grip (a grip that creates a 90-degree angle in the middle of the movement between the forearms and the upper arms), \n" +
                    "\n" +
                    "2. lift the bar from the rack and hold it straight over you with your arms locked. This will be your starting position.\n" +
                    "\n" +
                    "3. From the starting position, breathe in and begin coming down slowly until the bar touches your middle chest.\n" +
                    "After a brief pause, \n" +
                    "\n" +
                    "4. push the bar back to the starting position as you breathe out. Focus on pushing the bar using your chest muscles. Lock your arms and squeeze your chest in the contracted position at the top of the motion, \n" +
                    "\n" +
                    "5. hold for a second and then start coming down slowly again. \n" +
                    "\n" +
                    "\n" +
                    "6. Repeat the movement for the prescribed amount of repetitions. When you are done, place the bar back in the rack.",
            //
            "1. Sit on the machine with your back flat on the pad.\n" +
                    "\n" +
                    "2. Take hold of the handles. Tip: Your upper arms should be positioned parallel to the floor; adjust the machine \n" +
                    "accordingly. This will be your starting position.\n" +
                    "\n" +
                    "3. Push the handles together slowly as you squeeze your chest in the middle. Breathe out during this part of the motion and hold the contraction for a second.\n" +
                    "\n" +
                    "4. Return back to the starting position slowly as you inhale until your chest muscles are fully stretched.\n" +
                    "5. Repeat for the recommended amount of repetitions.",
            //
            "1. Stand up straight with a dumbbell in each hand at arm's length. Keep your elbows close to your torso and rotate the palms of your hands until they are facing forward. This will be your starting position.\n" +
                    "\n" +
                    "2. Now, keeping the upper arms stationary, exhale and curl the weights while contracting your biceps.\n" +
                    "\n" +
                    "3. Continue to raise the weights until your biceps are fully contracted and the dumbbells are at shoulder level. Hold the contracted position for a brief pause as you squeeze your biceps.\n" +
                    "\n" +
                    "4. Then, inhale and slowly begin to lower the dumbbells back to the starting position.\n" +
                    "5. Repeat for the recommended amount of repetitions.",
            //
            "1. Hang from a chin-up bar with both arms extended at arms length in top of you using either a wide grip or a medium grip. The legs should be straight down with the pelvis rolled slightly backwards. This will be your starting position.\n" +
                    "\n" +
                    "2. Raise your legs until the torso makes a 90-degree angle with the legs. Exhale as you perform this movement and hold the contraction for a second or so.\n" +
                    "\n" +
                    "3. Go back slowly to the starting position as you breathe in.\n" +
                    "\n" +
                    "4. Repeat for the recommended amount of repetitions.",
            //
            "1. Lie down on the floor and secure your feet. Your legs should be bent at the knees.\n" +
                    "\n" +
                    "2. Place your hands behind or to the side of your head. You will begin with your back on the ground. This will be your starting position.\n" +
                    "\n" +
                    "3. Flex your hips and spine to raise your torso toward your knees.\n" +
                    "\n" +
                    "4. At the top of the contraction your torso should be perpendicular to the ground. Reverse the motion, going only ¾ of the way down.\n" +
                    "\n" +
                    "5. Repeat for the recommended amount of repetitions.",
            //
            "1. Pick a couple of dumbbells and stand with a straight torso and the dumbbells by your side at arms length with the palms of the hand facing you. This will be your starting position.\n" +
                    "\n" +
                    "2. While maintaining the torso in a stationary position (no swinging), lift the dumbbells to your side with a slight bend on the elbow and the hands slightly tilted forward as if pouring water in a glass. Continue to go up until you arms are parallel to the floor. \n" +
                    "\n" +
                    "3. Exhale as you execute this movement and pause for a second at the top.\n" +
                    "\n" +
                    "4. Lower the dumbbells back down slowly to the starting position as you inhale.\n" +
                    "\n" +
                    "5. Repeat for the recommended amount of repetitions.",
            //
            "1. You will start by grabbing the wide bar from the top pulley of a pulldown machine and using a wider than shoulder-width pronated (palms down) grip. Step backwards two feet or so.\n" +
                    "\n" +
                    "2. Bend your torso forward at the waist by around 30-degrees with your arms fully extended in front of you and a slight bend at the elbows. If your arms are not fully extended then you need to step a bit more backwards until they are. Once your arms are fully extended and your torso is slightly bent at the waist, tighten the lats and then you are ready to begin.\n" +
                    "\n" +
                    "3. While keeping the arms straight, pull the bar down by contracting the lats until your hands are next to the side of the thighs. Breathe out as you perform this step.\n" +
                    "\n" +
                    "4. While keeping the arms straight, go back to the starting position while breathing in.\n" +
                    "\n" +
                    "1. Repeat for the recommended amount of repetitions.",
            //
            "1. Grab the pull-up bar with the palms facing forward using the prescribed grip. Note on grips: For a wide grip, your hands need to be spaced out at a distance wider than your shoulder width. \n" +
                    "\n" +
                    "2. For a medium grip, your hands need to be spaced out at a distance equal to your shoulder width and for a close grip at a distance smaller than your shoulder width.\n" +
                    "\n" +
                    "3. As you have both arms extended in front of you holding the bar at the chosen grip width, bring your torso back around 30 degrees or so while creating a curvature on your lower back and sticking your chest out. This is your starting position.\n" +
                    "\n" +
                    "4. Pull your torso up until the bar touches your upper chest by drawing the shoulders and the upper arms down and back. Exhale as you perform this portion of the movement. Tip: Concentrate on squeezing the back muscles once you reach the full contracted position. \n" +
                    "\n" +
                    "5.The upper torso should remain stationary as it moves through space and only the arms should move. The forearms should do no other work other than hold the bar.\n" +
                    "\n" +
                    "6. After a second on the contracted position, start to inhale and slowly lower your torso back to the starting position when your arms are fully extended and the lats are fully stretched.\n" +
                    "\n" +
                    "7 Repeat this motion for the prescribed amount of repetitions.",
            //
            "1. For this exercise you will need access to a low pulley row machine with a V-bar. Note: The V-bar will enable you to have a neutral grip where the palms of your hands face each other. To get into the starting position, first sit down on the machine and place your feet on the front platform or crossbar provided making sure that your knees are slightly bent and not locked.\n" +
                    "\n" +
                    "2. Lean over as you keep the natural alignment of your back and grab the V-bar handles.\n" +
                    "\n" +
                    "3. With your arms extended pull back until your torso is at a 90-degree angle from your legs. Your back should be slightly arched and your chest should be sticking out. You should be feeling a nice stretch on your lats as you hold the bar in front of you. This is the starting position of the exercise.\n" +
                    "\n" +
                    "4. Keeping the torso stationary, pull the handles back towards your torso while keeping the arms close to it until you touch the abdominals. Breathe out as you perform that movement. \n" +
                    "\n" +
                    "5. At that point you should be squeezing your back muscles hard. Hold that contraction for a second and slowly go back to the original position while breathing in.\n" +
                    "\n" +
                    "6. Repeat for the recommended amount of repetitions.",
            //
            "1. Begin with a bar loaded on the ground. Approach the bar so that the bar intersects the middle of the feet. \n\n" +
                    "2. The feet should be set very wide, near the collars. Bend at the hips to grip the bar. \n\n" +
                    "3. The arms should be directly below the shoulders, inside the legs, and you can use a pronated grip, a mixed grip, or hook grip. Relax the shoulders, which in effect lengthens your arms.\n\n" +
                    "4. Take a breath, and then lower your hips, looking forward with your head with your chest up. Drive through the floor, spreading your feet apart, with your weight on the back half of your feet. Extend through the hips and knees.\n\n" +
                    "5. As the bar passes through the knees, lean back and drive the hips into the bar, pulling your shoulder blades together.\n\n" +
                    "6. Return the weight to the ground by bending at the hips and controlling the weight on the way down.",
            //
            "1. Attach a straight or angled bar to a high pulley and grab with an overhand grip (palms facing down) at shoulder width.\n" +
                    "\n" +
                    "2. Standing upright with the torso straight and a very small inclination forward, bring the upper arms close to your body and perpendicular to the floor. The forearms should be pointing up towards the pulley as they hold the bar.\n" +
                    "3. This is your starting position.\n" +
                    "\n" +
                    "4. Using the triceps, bring the bar down until it touches the front of your thighs and the arms are fully extended perpendicular to the floor. The upper arms should always remain stationary next to your torso and only the forearms should move. Exhale as you perform this movement.\n" +
                    "\n" +
                    "5. After a second hold at the contracted position, bring the bar slowly up to the starting point. Breathe in as you perform this step.\n" +
                    "\n" +
                    "6 Repeat for the recommended amount of repetitions.",


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
            item.setExercise_desc(exercise_desc[i]);
            item.setExercise_desc(exercise_vid[i]);


            data.add(item);
        }
        return data;
    }

}
