package com.assignment.truestrength;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.assignment.truestrength.Adapter.DeclanExerciseAdapter;
import com.assignment.truestrength.Exercise_InfoClasses.ExerciseData;
import com.assignment.truestrength.Exercise_InfoClasses.ExerciseGetterSetter;
import com.assignment.truestrength.UI.ExerciseDetails;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }

    public static class programmeList_tab_frag extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.frag_programme_list, container, false);

            Button button = (Button) rootView.findViewById(R.id.button);
            Button button6 = (Button) rootView.findViewById(R.id.button6);

            button6.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent programmeActivity = new Intent(getActivity(), Programme.class);
                    startActivity(programmeActivity);
                }
            });

            button.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent programmeActivity = new Intent(getActivity(), Programme.class);
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

            double y, x;
            x = -5.0;

            GraphView testGraph = (GraphView) rootView.findViewById(R.id.testGraph);
            series = new LineGraphSeries<>();
            for (int i = 0; i < 500; i++) {
                x = x + 0.1;
                y = Math.sin(x);
                series.appendData(new DataPoint(x, y), true, 500);
            }
            testGraph.addSeries(series);
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
                    return "Porgrammes";
                case 1:
                    return "Progress";
                case 2:
                    return "Exercises";
            }
            return null;
        }
    }
}