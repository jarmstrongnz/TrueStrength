package com.assignment.truestrength;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

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


        getSupportActionBar().getThemedContext();
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorAccent));


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

            DatabaseHelper myDB = new DatabaseHelper(getContext());

            int size = myDB.getNumSessions();
            int[] totalWeight = myDB.getTotalWeight();

            DataPoint[] values = new DataPoint[size];
            for (int i=0; i<size; i++) {
                Integer xi = i;
                Integer yi = totalWeight[i];
                DataPoint v = new DataPoint(xi, yi);
                values[i] = v;
            }
            GraphView graph = (GraphView) rootView.findViewById(R.id.testGraph);
            LineGraphSeries<DataPoint> series = new LineGraphSeries<>(values);
            graph.addSeries(series);
            return rootView;
        }
    }

    public static class exercises_tab_frag extends Fragment// implements DeclanExerciseAdapter.ItemClickCallBack
    {

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
        private static final String exercise_desc = "exercise_desc";

        //private RecyclerView recView;
        private ListView listView;

        private DeclanExerciseAdapter adapter;
        private List<ExerciseGetterSetter> listData;

        private SearchView searchView;
        private ArrayAdapter<String> listAdapter;


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)

        {
            View rootView = inflater.inflate(R.layout.frag_search, container, false);

            listData = ExerciseData.getListData();

            //recView = (RecyclerView) rootView.findViewById(R.id.rec_list);
            //recView.setLayoutManager(new LinearLayoutManager(getActivity()));

            adapter = new DeclanExerciseAdapter(listData, getActivity());
            //recView.setAdapter(adapter);

            // adapter.setItemClickCallBack(this);

            /**
             * START Added by Brogan
             */
            // create search view and list view
            searchView = (SearchView) rootView.findViewById(R.id.searchView_workouts);
            listView = (ListView) rootView.findViewById(R.id.search_listView);

            // create temp array for adapter list
            String[] _listData = new String[listData.size()];

            // assign the temp array
            for(int i = 0; i < _listData.length; i++)
                _listData[i] = adapter.getListData().get(i).getExercise_Name();

            // sort array
            Arrays.sort(_listData);

            // create list adapter for filtering
            listAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, _listData);

            // assign new list adapter to list view
            listView.setAdapter(listAdapter);

            // filters the list based on user input
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener()
            {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText)
                {
                    listAdapter.getFilter().filter(newText);
                    return false;
                }
            });

            // button listeners for list.
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
                {
                    String item = String.valueOf(adapterView.getItemAtPosition(i));

                    // get data based on what item was clicked
                    BundleDataAndSendToNewActivity(item);
                }
            });
            /**
             * END Added by Brogan
             */
            return rootView;
        }




        private void BundleDataAndSendToNewActivity(String name)
        {
            ExerciseGetterSetter item = null;

            for(int j = 0; j < listData.size(); j++)
            {
                String temp = adapter.getListData().get(j).getExercise_Name();
                if(temp.equals(name))
                    item = adapter.getListData().get(j);
            }

            if(item == null)
            {
                Toast.makeText(getActivity(), "Error!", Toast.LENGTH_LONG).show();
                return;
            }

            Intent intent = new Intent(getActivity(), ExerciseDetails.class);
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
            extras.putString(exercise_desc, item.getExercise_desc());

            intent.putExtra(BUNDLE_EXTRAS, extras);
            startActivity(intent);



        }

        /*
        @Override
        public void onItemClick(int p)
        {
        }
        */
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