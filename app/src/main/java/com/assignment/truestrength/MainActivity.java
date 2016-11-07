package com.assignment.truestrength;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.assignment.truestrength.Adapter.DeclanExerciseAdapter;
import com.assignment.truestrength.Exercise_InfoClasses.ExerciseData;
import com.assignment.truestrength.Exercise_InfoClasses.ExerciseGetterSetter;
import com.assignment.truestrength.UI.ExerciseDetails;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;

import static android.R.string.cancel;
import static android.R.string.ok;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.inflateMenu(R.menu.menu_main);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu); // Inflate the menu; this adds items (using menu_main.xml) to the action bar if it is present.
        return super.onCreateOptionsMenu(menu);

    } // end of onCreateOptionsMenu

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.menu_about:

                // load the about page as a alert dialog

                View v = LayoutInflater.from(MainActivity.this).inflate(R.layout.activity_about, null);

                AlertDialog.Builder a_builder = new AlertDialog.Builder(MainActivity.this);
                a_builder.setView(v);
/*                a_builder.setCancelable(false);*/
                final AlertDialog alert = a_builder.create();
                alert.show();

                return true;

            default:
                return super.onOptionsItemSelected(item);
        } // End of menu switch

    } // End of onOptionsItemSelected event

    public static class programmeList_tab_frag extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.frag_programme_list, container, false);

            ImageButton button = (ImageButton) rootView.findViewById(R.id.button);
            ImageButton button6 = (ImageButton) rootView.findViewById(R.id.button6);

            button6.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent programmeActivity = new Intent(getActivity(), Programme.class);
                    programmeActivity.putExtra("progID", "P001");
                    startActivity(programmeActivity);
                }
            });

            button.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent programmeActivity = new Intent(getActivity(), Programme.class);
                    programmeActivity.putExtra("progID", "P000");
                    startActivity(programmeActivity);
                }
            });
            return rootView;
        }
    }

    public static class progress_tab_frag extends Fragment {

        LineGraphSeries<DataPoint> series;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.frag_progress, container, false);

            GraphView graph = (GraphView) rootView.findViewById(R.id.testGraph);
            LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{
                    new DataPoint(0, 1),
                    new DataPoint(1, 5),
                    new DataPoint(2, 3)
            });
            graph.addSeries(series);
            return rootView;
        }
    }

    public static class exercises_tab_frag extends Fragment implements DeclanExerciseAdapter.ItemClickCallBack {

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
        private RecyclerView recView;
        private DeclanExerciseAdapter adapter;
        private ArrayList listData;


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.frag_search, container, false);

            listData = (ArrayList) ExerciseData.getListData();

            recView = (RecyclerView) rootView.findViewById(R.id.rec_list);
            recView.setLayoutManager(new LinearLayoutManager(getActivity()));

            adapter = new DeclanExerciseAdapter(listData, getActivity());
            recView.setAdapter(adapter);

            adapter.setItemClickCallBack(this);

            return rootView;
        }

        @Override
        public void onItemClick(int p) {
            ExerciseGetterSetter item = (ExerciseGetterSetter) listData.get(p);

            Intent i = new Intent(getActivity(), ExerciseDetails.class);
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

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new programmeList_tab_frag();

                case 1:
                    return new progress_tab_frag();

                case 2:
                    return new exercises_tab_frag();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Programmes";
                case 1:
                    return "Progress";
                case 2:
                    return "Exercises";
            }
            return null;
        }
    }
}