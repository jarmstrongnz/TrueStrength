package com.assignment.truestrength;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import static com.assignment.truestrength.R.id.searchView;

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

    public static class programmes_tab_frag extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.frag_programme_list, container, false);

            Button button = (Button) rootView.findViewById(R.id.button);
            button.setOnClickListener(new OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Intent programmeActivity = new Intent(getActivity(), Programme.class);
                    startActivity(programmeActivity);
                }
            });
            return rootView;
        }
    }

    public static class progress_tab_frag extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.frag_progress, container, false);
            return rootView;
        }
    }

    public static class exercises_tab_frag extends Fragment {

        ListView listView;
        SearchView searchView;

        String[] tempItems = {"Abs", "Back", "Legs", "Arms"};

        ArrayAdapter<String> adapter;


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.frag_search, container, false);

            listView = (ListView) rootView.findViewById(R.id.listView_workouts);
            searchView = (SearchView) rootView.findViewById(R.id.searchView_workouts);

            adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, tempItems);
            listView.setAdapter(adapter);

            // filters the list based on user input
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText){
                    adapter.getFilter().filter(newText);
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

                    Toast.makeText(getActivity(), item, Toast.LENGTH_LONG).show();
                }
            });


            return rootView;
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
                    return new programmes_tab_frag();

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