package com.assignment.truestrength;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

public class Search extends AppCompatActivity
{
    ListView listView;
    SearchView searchView;

    String[] tempItems = {"Abs", "Back", "Legs", "Arms"};

    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        listView = (ListView) findViewById(R.id.listView_workouts);
        searchView = (SearchView) findViewById(R.id.searchView_workouts);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tempItems);
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

                Toast.makeText(Search.this, item, Toast.LENGTH_LONG).show();
            }
        });
    }
}
