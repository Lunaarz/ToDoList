package com.example.autum.to_dolist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        populateListView();


        //Button & OnClickListener
        Button createNewItemButton = (Button) findViewById(R.id.createNewItemButton);
        createNewItemButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                //On Click, goes to CreateNewItem Page
                Intent listCreatorScreen =
                        new Intent(getApplicationContext(), NewItemCreator.class);
                startActivity(listCreatorScreen);

            }
        });

        //ListView OnItemClickListener
        ListView mainListView = (ListView) findViewById(R.id.mainListView);
        mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

    }

    private void populateListView() {
        //Create Array of Values to feed to list
        //ArrayList<String> myItems = {"red", "orange", "yellow"};
        //myItems.toArray();
        String[] myItems = {"red", "orange", "yellow"};
        //Build Adapter
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, R.layout.list_view_main, myItems);
        // HERE DO THIS Make an Array of strings here to add to display
        //Configure List View
        ListView mainListView = (ListView) findViewById(R.id.mainListView);
        mainListView.setAdapter(adapter);
    }
}
